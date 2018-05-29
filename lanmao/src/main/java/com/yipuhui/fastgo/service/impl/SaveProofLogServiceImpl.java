package com.yipuhui.fastgo.service.impl;/**
 * Created by liujunhan on 2018/5/21.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.fastgo.controller.SendPrsvController;
import com.yipuhui.fastgo.dao.SaveProofLogMapper;
import com.yipuhui.fastgo.enty.SaveProofLog;
import com.yipuhui.fastgo.service.SaveProofLogService;
import com.yipuhui.fastgo.utils.AppConfig;
import cunzheng.sdk.SdkClient;
import cunzheng.sdk.utils.EncoderUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Map;

/**
 * 存证日志本地保存
 *
 * @author 刘俊汉
 * @create 2018-05-21 15:47
 **/
@Service
public class SaveProofLogServiceImpl implements SaveProofLogService {


    private static AppConfig appConfig = AppConfig.getConfig();

    private static  final Logger LOGG= LoggerFactory.getLogger(SaveProofLogServiceImpl.class);

    @Autowired
    private SaveProofLogMapper saveProofLogMapper;

    /**
     * Description:保存存证日志信息
     *
     * @author 刘俊汉
     * @param saveProofType
     * @param saveProofJson
     * @date 2018/5/21 15:49
     * @return void
     */
    @Override
    public void savaProofLog(String lenderNum,String saveProofType, String saveProofJson) {

        SaveProofLog saveProofLog =  new SaveProofLog();
        saveProofLog.setLenderNum(lenderNum);
        saveProofLog.setSaveProofType(saveProofType);
        saveProofLog.setSaveProofJson(saveProofJson);
        saveProofLog.setSaveProofTime(new Date());
        saveProofLogMapper.insert(saveProofLog);

    }

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param filePath
     * @param bidInvestNum
     * @date 2018/5/22 10:06
     * @return void
     */
    @Override
    public void saveProof(String filePath,String bidInvestNum) {

        //存证信息整理

        Map<String,Object> bidMap = saveProofLogMapper.fundSavaProofDataOne(bidInvestNum);
        //投资信息
        bidMap.putAll(saveProofLogMapper.fundSavaProofDataTwo(bidInvestNum));


        try{


            String host = appConfig.getDataBypro("api.host");
            String method = appConfig.getDataBypro("api.prsv");
            String privateKey = appConfig.getDataBypro("private.key");
            String sdkKey = appConfig.getDataBypro("sdk.key");
            String enterpriseId = appConfig.getDataBypro("enterprise.id");
            //商户共钥 用于密文加密
            String publicKey =appConfig.getDataBypro("prsv.ppublickey");
            LOGG.info(host+"host "+method+"method "+privateKey+"privateKey "+sdkKey+"sdkKey "+enterpriseId+"enterpriseId ");

            /**初始化方法一：无需文档加密**/
            //SdkClient sdkClient = new SdkClient(privateKey,host,enterpriseId,sdkKey);

            /**初始化方法二：使用base64编码后的加密公钥进行文档加密**/

            // 使用base64后的加密公钥实例化
            SdkClient sdkClient = new SdkClient(privateKey, host, enterpriseId, sdkKey, publicKey);

            /**初始化方法三：使用cer公钥文件的二进制流加密公钥进行文档加密**/
            // String cerPath = "d://testPdf/pubkeyNew1c.cer";
            // byte[] cerByte = getFileByte(cerPath);
            // SdkClient cerSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,cerByte);// cerByte 是直接读取的cer公钥文件的二进制流

            /**初始化方法四：使用pfx证书进行文档加密**/
            // File pfxFile = new File("d://testPdf/new1C.pfx");
            // String pfxPassword = "jgt@123";
            // SdkClient pfxSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,pfxFile,pfxPassword);// pfxFile 是pfxFile文件File对象, pfxPassword 是pfx文件的密码

            try {
                JSONObject json = new JSONObject();
                //电子合同pdf文件地址(默认项目resources 下面进行测试)F:\test\prsv\target\classes\test.pdf
//                String filePath = "test.pdf";
                //合同文件的字节流
                byte[] contFileByte = getFileByte(filePath);
                //交易流水号   生成
                String requestNo =bidMap.get("id")+String.valueOf(System.currentTimeMillis());
                //合同文件的base64编码串
                String contFile = EncoderUtils.base64EncodeToString(contFileByte);

                // 渠道用户使用-p2p企业名称  可查
                String enterpriseName="亿谱汇";

                //合同名称   可生成
                String contName =bidMap.get("contName")+ "的借款合同";
                //合同编号  可查
                String contNo =String.valueOf(bidMap.get("contNo")) ;
                //标的名称  可查
                String projectName = String.valueOf(bidMap.get("projectName"));
                //标的编号  可查
                String projectNo = String.valueOf(bidMap.get("projectName"));
                //合同类型:0-普通合同（没有共同借款人信息） 1-共同借款人合同（有共同借款人信息）
                String contType = "0";
                //文档类型pdf,word
                String fileType = "pdf";
                //合同签约完成时间 可查
                String contSignTime = String.valueOf(bidMap.get("contSignTime"));
                //借款人账号  可查
                String borrowerAccount = String.valueOf(bidMap.get("borrowerAccount"));
                //借款人姓名 可查
                String borrowerName = String.valueOf(bidMap.get("borrowerName"));
                //借款人身份证号 可查
                String borrowerCode = String.valueOf(bidMap.get("borrowerCode"));
                //投资人账号 可查
                String investorAccount =String.valueOf(bidMap.get("investorAccount"));
                //投资人名称
                String investorName = String.valueOf(bidMap.get("investorName"));
                //投资人身份证号
                String investorCode = String.valueOf(bidMap.get("investorCode"));

                //担保人信息
                //担保人平台账号
                String guaranteeAccount = "无";
//                //担保人姓名/企业名称
                String guaranteeName = "无";
                //担保人身份证号
                String guaranteeCode = "无";

                JSONObject head = new JSONObject();
                head.put("enterpriseId",enterpriseId);
                json.put("head", head);

                JSONObject jsonDetails = new JSONObject();
                jsonDetails.put("requestNo",requestNo);
//                jsonDetails.put("contFile",contFile);

                JSONObject jsonConInfo = new JSONObject();
                jsonPut(jsonConInfo,"contName",contName);
                jsonPut(jsonConInfo,"contNo",contNo);
                jsonPut(jsonConInfo,"projectNo",projectNo);
                jsonPut(jsonConInfo,"projectName",projectName);
                jsonPut(jsonConInfo,"contType",contType);
                jsonPut(jsonConInfo,"fileType",fileType);
                jsonPut(jsonConInfo,"contSignTime",contSignTime);
                jsonPut(jsonConInfo,"borrowerAccount",borrowerAccount);
                jsonPut(jsonConInfo,"borrowerName",borrowerName);
                jsonPut(jsonConInfo,"borrowerCode",borrowerCode);
                jsonPut(jsonConInfo,"investorAccount",investorAccount);
                jsonPut(jsonConInfo,"investorName",investorName);
                jsonPut(jsonConInfo,"investorCode",investorCode);
                jsonPut(jsonConInfo,"guaranteeAccount",guaranteeAccount);
                jsonPut(jsonConInfo,"guaranteeName",guaranteeName);
//                jsonPut(jsonConInfo,"coBorrower",coBorrowerArray);
                // 渠道用户使用
                jsonPut(jsonConInfo,"enterpriseName",enterpriseName);

                //获取文件的hash组
                String hashs = sdkClient.getHashObject(contFileByte);
                jsonDetails.put("hashs", JSON.parseObject(hashs));
                jsonDetails.put("conInfo",jsonConInfo);
                json.put("details",jsonDetails);

                LOGG.info(json.toJSONString());
                JSONObject response = sdkClient.post(method, json);
                LOGG.info(response.toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据文件路径读取文件
     * @param path 文件路径
     * @return byte[]
     */
    private static byte[] getFileByte(String path) {
        URL url = SendPrsvController.class.getClassLoader().getResource(path);
        assert url != null;
        File file = new File(url.getFile());
        InputStream in;
        //文件流
        byte[] bytes = null;
        try {
            in = new FileInputStream(file);
            // 取得文件大小
            long length = file.length();
            // 根据大小创建字节数组
            bytes = new byte[(int) length];
            // 读取文件内容到字节数组**
            int offset = 0;
            int numRead;
            while (offset < bytes.length
                    && (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            // 读取完毕的校验
            if (offset < bytes.length) {
                System.out.println("不能完全读取的文件："+ file.getName());
            }
            in.close();
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("读取流异常");
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("读取流异常");
        }
        return bytes;
    }

    /**
     * 对json进行封装
     * @param json JsonObject对象
     * @param name 键
     * @param value 值
     */
    private static void jsonPut(JSONObject json, String name, Object value){
        if (value!=null){
            if (value instanceof String){
                if (StringUtils.isNotBlank((String)value)){
                    json.put(name,value);
                }
            }else{
                json.put(name,value);
            }
        }
    }



}
