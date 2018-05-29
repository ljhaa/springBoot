package com.yipuhui.fastgo.utils;/**
 * Created by liujunhan on 2018/4/4.
 */

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.yipuhui.api.entity.RequstData;
import com.yipuhui.api.entity.RespData;
import com.yipuhui.api.enums.ConnectoGatewayNameEnum;
import com.yipuhui.api.enums.ConnectorDirectNameEnum;


import com.yipuhui.fastgo.common.MagicParameterConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 三方访问，网关直连
 *
 * @author 刘俊汉
 * @create 2018-04-04 15:57
 **/

public class ConnectingToLanmaoUtil {


    /**
     * 直连接口后缀
     */
    private final static String SERVICE = "/service";

    /**
     * 网关接口后缀
     */
    private final static String GATEWAY = "/gateway";

    private final static Logger logger = LoggerFactory
            .getLogger(ConnectingToLanmaoUtil.class);

    private static final DateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    private static AppConfig config = AppConfig.getConfig();


    /**
     * 访问三方接口全部通过此方法调用，网关接口返回组装后的参数，直连接口返回查询结果
     * <p>
     * 传参数时，按照接口需要数据将数据以map形式传入，返回时以map的形式返回处理结果
     * 第二个参数为需要访问接口的名字（参见枚举类：ConnectoGatewayNameEnum和ConnectorDirectNameEnum）
     *
     *
     * 返回map中存在yphCode参数，-1：链接失败(yphMessage字段解释错误信息描述)   ，0 网关参数返回， 1 直连结果返回
     *
     *
     * @param
     * @return
     * @author 刘俊汉
     * @date 2018/4/4 16:16
     */

    public static Map<String, Object> connectingToLanmao(Map<String, Object> map, String serviceName) {

        Map<String, Object> result = new HashMap<>(16);

        String resultStr = "";

        String url = config.getUrl();

        String timestamp = config.getDataBypro("timestamp");
        logger.info("==============请求时间=======================timestamp={}",timestamp);
        try {


            //判断访问类型  网关or直连
            if (null != ConnectoGatewayNameEnum.getName(serviceName) && ConnectoGatewayNameEnum.getName(serviceName).length() > 0) {

                logger.info("==============进入网关接口=======================参数"+map);


                // 后台生成   必须添加的参数



                if(timestamp == null || "".equals(timestamp)){
                    timestamp = FORMAT.format(new Date());
                }


                // 计算页面过期时间 当前时间增加30分钟
                DateTime dateTime = new DateTime();
                map.put("expired",
                        dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
                // 必须添加的参数
                map.put("timestamp", timestamp);

                map = AppUtil.createPostParam(serviceName, map);
                url += GATEWAY;
                result.put("reqData",mapTojson(map));
                result.put("url",url);
                result.put("yphCode",0);
            } else if (null != ConnectorDirectNameEnum.getName(serviceName) && ConnectorDirectNameEnum.getName(serviceName).length() > 0) {
                logger.info("==============进入直连接口=======================参数"+map);
                if(timestamp == null || "".equals(timestamp)){
                    timestamp = FORMAT.format(new Date());
                }

                map.put("timestamp", timestamp);
                map = AppUtil.createPostParam(serviceName, map);
                url += SERVICE;
                resultStr= serviceRequest(map, url);
                result.put("reqData",resultStr);
                result.put("yphCode",0);
            } else {

                result.put("yphCode", -1);
                result.put("yphMessage", "三方不存在此接口");

            }
        } catch (Exception e) {
e.printStackTrace();

            result.put("yphCode", -1);
            result.put("yphMessage", "操作异常请联系管理员");
        }

logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>resultttttt={}",result);
        return result;
    }







    private static String serviceRequest(Map<String, Object> map, String url) {
        String result = "";
        CloseableHttpResponse response = null;


        try {
            List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
            BasicNameValuePair bn2 = new BasicNameValuePair("serviceName", String.valueOf(map.get("serviceName")));
            BasicNameValuePair bn5 = new BasicNameValuePair("platformNo", config.getPlatformNo());
            BasicNameValuePair bn3 = new BasicNameValuePair("reqData", String.valueOf(map.get("reqData")));
            BasicNameValuePair bn = new BasicNameValuePair("keySerial", config.getKeySerial());
            BasicNameValuePair bn4 = new BasicNameValuePair("sign", String.valueOf(map.get("sign")));
            formparams.add(bn);
            formparams.add(bn2);
            formparams.add(bn3);
            formparams.add(bn4);
            formparams.add(bn5);

            response = HttpUtils.httpPostWithPAaram(url, formparams);
            result = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
            logger.info("response : " + result);

        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(response);
        }

        try {
            verifySign(response, result);
            //平台业务处理逻辑，此处省略。。。。。。


        } catch (Exception e) {
            logger.error("sign fail..... " + e.getMessage());
            //异常处理
            result = null;
        }
        return result;
    }

    /**
     *
     *   直连返回验签
     * @author 刘俊汉
     * @date 2018/4/10 15:40
     * @param [response, responseData]
     * @return void
     */
    private static void verifySign(CloseableHttpResponse response, String responseData) throws Exception {

        Map<String, Object> respMap = JSON.parseObject(responseData);
        //接口返回code!=0 || status!=SUCCESS时，不做验签处理
        if (!MagicParameterConstants.ZERO.equals(respMap.get(MagicParameterConstants.CODE)) ||
                !"SUCCESS".equals(respMap.get("status"))) {
            return;
        }

        //校验返回报文
        String returnSign = "";
        Header[] headers = response.getHeaders("sign");
        if (headers != null && headers.length > 0) {
            Header header = headers[0];
            returnSign = header.getValue();
        }

        byte[] keyByte = Base64.decodeBase64(config.getLmPublicKey());
        byte[] signByte = Base64.decodeBase64(returnSign);
        try {
            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(keyByte);

            boolean b = SignatureUtils.verify(SignatureAlgorithm.SHA1WithRSA, publicKey, responseData, signByte);
            if (!b) {
                throw new Exception("验签失败，sign与respData不匹配");
            }

            logger.info("sign success ...");
        } catch (InvalidKeySpecException e) {
            throw new InvalidKeySpecException("验签错误，生成商户公钥失败", e);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("验签错误" + e.getMessage(), e);
        } catch (GeneralSecurityException e) {
            throw new GeneralSecurityException("验签错误" + e.getMessage(), e);
        }

    }


    /**
     *
     *   网关异步通知验签
     * @author 刘俊汉
     * @date 2018/4/10 15:40
     * @param []
     * @return void
     */
    public static void verifyAsyncSign(String responseData,String returnSign) throws Exception {






        byte[] keyByte = Base64.decodeBase64(config.getLmPublicKey());
        byte[] signByte = Base64.decodeBase64(returnSign);
        try {
            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(keyByte);

            boolean b = SignatureUtils.verify(SignatureAlgorithm.SHA1WithRSA, publicKey, responseData, signByte);
            if (!b) {
                throw new Exception("验签失败，sign与respData不匹配");
            }

            logger.info("sign success ...");
        } catch (InvalidKeySpecException e) {
            throw new InvalidKeySpecException("验签错误，生成商户公钥失败", e);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("验签错误" + e.getMessage(), e);
        } catch (GeneralSecurityException e) {
            throw new GeneralSecurityException("验签错误" + e.getMessage(), e);
        }

    }


    /**
     *将请求的json字符传整理成javaBean
     * @param params
     * @return
     */
    public static RequstData jsonToBean(String params) {

        JSONObject jsongo = (JSONObject) JSON.parse(params);
        RequstData requstData =  JSONObject.toJavaObject(jsongo,RequstData.class);

        return  requstData;
    }

    /**
     *
     *   将javabean转换成json字符串
     * @author 刘俊汉
     * @date 2018/4/10 12:01
     * @param [respData]
     * @return java.lang.String
     */
    public static String beanToJson(RespData respData) {

        JSONObject jsonObject=  (JSONObject)JSON.toJSON(respData);

        return  jsonObject.toString();
    }


    /**
     *    json转map
     *
     * @author 刘俊汉
     * @date 2018/4/10 12:01
     * @param [params]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String,Object> jsonToMap(String params) {

        JSONObject jsongo = (JSONObject) JSON.parse(params);
        Map<String,Object> map =  JSONObject.toJavaObject(jsongo,Map.class);

        return  map;
    }

    /**
     *
     *   将map转json字符串
     * @author 刘俊汉
     * @date 2018/4/10 12:02
     * @param [map]
     * @return java.lang.String
     */
    public static String mapTojson(Map<String ,Object> map){

        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);

return jsonObject.toString();
    }

    public static void main(String[] args) {


        Map<String, Object> rspo = new HashMap<>(16);
        String requestNo = FORMAT.format(new Date());
        Map<String, Object> reqData = new HashMap<String, Object>(16);
        //请求流水号
        reqData.put("requestNo",requestNo);
        //页面回跳
        reqData.put("redirectUrl","www.baidu.com");
        //平台用户编号
        reqData.put("platformUserNo","861888880000285");
        //见【用户授权列表】；此处可传多个值，传多个值用“,”英文半角逗号分隔
        reqData.put("authList","TENDER,CREDIT_ASSIGNMENT");
        //鉴权验证类型，默认填 LIMIT（强制四要素），即四要素完全通过（姓名、身份证号、银行卡号，银行预留手机号） 方可激活成功
        reqData.put("checkType","LIMIT");
        //授权期限
        reqData.put("failTime","20190101");
        //授权金额
        reqData.put("amount","1000000.00");
        rspo = connectingToLanmao(reqData,ConnectoGatewayNameEnum.ACTIVATE_STOCKED_USER.getIndex());






        logger.info(String.valueOf(rspo.get("reqData")));
        JSONObject jsonObject = JSON.parseObject(String.valueOf(rspo.get("reqData")));

        logger.info("url="+rspo.get("url"));
        logger.info("reqdata="+jsonObject.getString("reqData"));
        logger.info("sign="+jsonObject.getString("sign"));

        logger.info("platformNo="+jsonObject.getString("platformNo"));
        logger.info("keySerial="+jsonObject.getString("keySerial"));
        logger.info("serviceName="+jsonObject.getString("serviceName"));

    }

}
