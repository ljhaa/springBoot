package com.yipuhui.fastgo.controller;/**
 * Created by liujunhan on 2018/4/10.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.api.enums.*;
import com.yipuhui.api.utils.LanMaoConstant;
import com.yipuhui.fastgo.common.GatewaySyncCallbackInfo;
import com.yipuhui.fastgo.common.MagicParameterConstants;
import com.yipuhui.fastgo.common.RedisConstants;
import com.yipuhui.fastgo.enty.*;
import com.yipuhui.fastgo.service.*;
import com.yipuhui.fastgo.utils.AppConfig;
import com.yipuhui.fastgo.utils.ConnectingToLanmaoUtil;
import com.yipuhui.fastgo.utils.yphutil.AccountUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 接受懒猫异步通知接口
 * 回调测试外网网址     http://xwww.yipuhui.com:8092/fast/async/infrom
 *
 * @author 刘俊汉
 * @create 2018-04-10 15:30
 **/
@Controller
@RequestMapping("/async")
public class LanmoAsyncInformController {

    private final static Lock LOCKLOCK = new ReentrantLock();


    private static AppConfig config = AppConfig.getConfig();

    private final static Logger logg = LoggerFactory.getLogger(LanmoAsyncInformController.class);
    @Autowired
    private LenderDetailService lenderDetailService;

    @Autowired
    private LenderLoginService lenderLoginService;

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @Autowired
    private GatewayPayService gatewayPayService;

    @Autowired
    private ToLanmaoService toLanmaoService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private CashApplyService cashApplyService;

    @Autowired
    private CallBackMessageWithdrawService callBackMessageWithdrawService;

    @Autowired
    private SettleZzService settleZzService;

    @Autowired
    private SettleNoticeService settleNoticeService;

    @Autowired
    private RedisUtilService redisUtilService;


    @Autowired
    private BankInfoService bankInfoService;

    @Autowired
    private UeAccountService ueAccountService;


    @RequestMapping("/infrom")
    @ResponseBody
    public String asyncInform(@RequestParam("serviceName") String serviceName,//接口名称
                              @RequestParam("platformNo") String platformNo,//平台编号
                              @RequestParam("respData") String respData,//业务数据报文，JSON 格式，具体见各接口定义
                              @RequestParam("keySerial") String keySerial,//证书序号，用于多证书密钥切换，默认值为 1
                              @RequestParam("responseType") String responseType,//回调类型，见枚举“回调类型“，用来区分是浏览器返回还是服务端异步通知
                              @RequestParam("sign") String sign //对 reqData 参数的签名

    ) {


        logg.info(">>>>>三方异步返回参数[serviceName={}],[platformNo={}],[reqData={}]", serviceName, platformNo, respData);

        try {
            paramProcessing(serviceName, respData);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String result = "SUCCESS";

        //验证平台编号和签名是否正确

        if (respData == null || respData.length() == 0 || !responseType.equals(CallbackTypeEnum.NOTIFY.getIndex())) {

            return "INIT";
        }


        try {


            if (config.getPlatformNo().equals(platformNo)) {

                //验签
                ConnectingToLanmaoUtil.verifyAsyncSign(respData, sign);


                //通过后则正常处理逻辑

                switch (serviceName) {
                    case "ENTERPRISE_REGISTER":
                        logg.info("===========企业注册开户=========");


                        //企业注册开户 1
                        businessRegistration(respData);


                        break;
                    case "PERSONAL_REGISTER_EXPAND":
                        //个人注册开户 2
                        logg.info("===========个人注册开户=========");
                        personalRegistration(respData);

                        break;
                    case "RECHARGE":
                        //充值异步通知
                        logg.info("===========充值异步通知=========");
                        recharge(respData);

                        break;
                    case "WITHDRAW":
                        //提现异步通知
                        logg.info("===========提现异步通知=========");
                        withdraw(respData);
                        break;
                    case "BACKROLL_RECHARGE":
                        //提现失败资金回退充值
                        logg.info("===========提现失败资金回退充值=========");
                        backrollRecharge(respData);
                        break;
                    case "ENTERPRISE_INFORMATION_UPDATE":
                        //企业信息修改

                        break;
                    case "USER_PRE_TRANSACTION":
                        //用户预处理

                        break;
                    case "ASYNC_TRANSACTION":
                        //批量交易
                        logg.info("===========批量交易=========");
                        asyncTransaction(respData);

                        break;
                    case "USER_AUTHORIZATION":
                        //用户授权


                        break;
                    case "VERIFY_DEDUCT":
                        //验密扣费


                        break;
                    case "ACTIVATE_STOCKED_USER":
                        //会员激活接口
                        logg.info("===========会员激活接口=========");
                        activateStockedUser(respData);
                        break;
                    case "PERSONAL_BIND_BANKCARD_EXPAND":
                        //个人换卡
                        logg.info("===========个人换卡=========");
                        personalBineBankcardExpand(respData);
                        break;

                    default:


                }


            }

        } catch (Exception e) {
            e.printStackTrace();

            result = "INIT";

        }


        logg.info(">>>>>三方异步本地处理结果[result={}]", result);


        return result;
    }


    /**
     * 企业注册返回接口
     *
     * @param
     * @return void
     * @author 刘俊汉
     * @date 2018/4/10 16:12
     */
    private void businessRegistration(String reqData) {

        JSONObject jsonObject = JSONObject.parseObject(reqData);

//        String  requestNo=jsonObject.getString("requestNo"); // 请求流水号
//        String  code=jsonObject.getString("code"); // 调用状态（0 为调用成功、1 为失败，返回 1 时请看【调用失败错误码】及错误码描 述）
        // 业务处理状态（处理失败 INIT；处理成功 SUCCESS），平台可根据非 SUCCESS 状 态做相应处理，处理失败时可参考错误码及描述
        String status = jsonObject.getString("status");
//        String  errorCode=jsonObject.getString("errorCode"); // 错误码
        // 错误码描述
        String errorMessage = jsonObject.getString("errorMessage");
        // 平台用户编号
        String platformUserNo = jsonObject.getString("platformUserNo");
        // 见【审核状态】 PASSED
        String auditStatus = jsonObject.getString("auditStatus");
//      String  userRole=jsonObject.getString("userRole"); // 见【用户角色】
//      String  bankcardNo=jsonObject.getString("bankcardNo"); // 银行对公账户
//      String  bankcode=jsonObject.getString("bankcode"); // 银行编码
//      String  remark=jsonObject.getString("remark"); // 备注


        if (LanMaoConstant.SUCCESS.equals(status)) {
            if (CheckStatusEnum.PASSED.getIndex().equals(auditStatus)) {

//============================业务代码===============================================================
                Map<String, Object> map = new HashMap<>(16);

                map.put("lenderNum", platformUserNo);
                map.put("certificationStatus", CheckStatusEnum.getName(auditStatus));
                logg.info("map=============={}", map);

                lenderDetailService.updataByLenderNum(map);

                registerService.updataBank(platformUserNo, "3", null);

            } else if (CheckStatusEnum.BACK.getIndex().equals(auditStatus) || CheckStatusEnum.REFUSED.getIndex().equals(auditStatus)) {
                String cardStatus = null;

                Map<String, Object> map = new HashMap<>(16);

                map.put("lenderNum", platformUserNo);

                String certificationStatus = null;
                if (CheckStatusEnum.BACK.getIndex().equals(auditStatus)) {
                    certificationStatus = "6";
                    cardStatus = "6";
                } else if (CheckStatusEnum.REFUSED.getIndex().equals(auditStatus)) {
                    certificationStatus = "3";
                    cardStatus = "4";

                }
                map.put("certificationStatus", certificationStatus);
                logg.info("map=============={}", map);

                lenderDetailService.updataByLenderNum(map);

                registerService.updataBank(platformUserNo, cardStatus, errorMessage);

            }
        }


        // 删除redis数据
        // bank json

        try {


            String key = RedisConstants.KEY_LENDER_BANK
                    + platformUserNo;
            if (redisUtilService.chekHashkey(key)) {
                redisUtilService.delet(key);
            }


        } catch (Exception e) {
            logg.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>redis异常》》》》》》》》》》》》》》》》");
        }

    }


    /**
     * 个人注册回调
     *
     * @param [reqData]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/13 17:29
     */
    private void personalRegistration(String reqData) {
        JSONObject jsonObject = JSONObject.parseObject(reqData);


        String requestNo = jsonObject.getString("requestNo");
        // 调用状态（0 为调用成功、1 为失败，返回 1 时请看【调用失败错误码】及错误码描述）
        String code = jsonObject.getString("code");
        // 业务处理状态（处理失败 INIT；处理成功 SUCCESS），平台可根据非 SUCCESS 状态做相应处理，处理失败时可参考错误码及描述
        String status = jsonObject.getString("status");
        // 错误码描述
        String errorMessage = jsonObject.getString("errorMessage");
        // 平台用户编号
        String platformUserNo = jsonObject.getString("platformUserNo");
        //【银行编码】
        String bankcode = jsonObject.getString("bankcode");
        //【审核状态】
        String auditStatus = jsonObject.getString("auditStatus");


        //检查是否已经生成信息
        if (null == lenderDetailService.findLenderDetailInfoByLenderNum(platformUserNo)) {
            return;
        }


        if (LanMaoConstant.SUCCESS.equals(status)) {
            if (CheckStatusEnum.PASSED.getIndex().equals(auditStatus)) {

                LenderLogin lenderLogin = lenderLoginService.fundObjectByUserNum(platformUserNo);


                //return new HashMap<String, Object>();
                Map<String, Object> paramMap1 = new HashMap<String, Object>(16);
                paramMap1.put("lenderNum", platformUserNo);
                paramMap1.put("loginId", lenderLogin.getId());
                paramMap1.put("respData", reqData);
                paramMap1.put("referralCode", lenderLogin.getReferralCode());
                paramMap1.put("bankNum", bankcode);
                // 开户省份
                paramMap1.put("province", "1100000");
                // 开户城市
                paramMap1.put("city", "1101000");
                // 支行信息
                paramMap1.put("bankNumText", "光华路支行");
                registerService.doLmRegist(paramMap1);
// 开户成功赠送体验金 8000
                logg.info("======>开户成功赠送体检金8000");
                ueAccountService.doAddUeMoney(lenderLogin.getId(), 2);
                logg.info("======>开户成功赠送体检金8000");
            } else if (CheckStatusEnum.BACK.getIndex().equals(auditStatus) || CheckStatusEnum.REFUSED.getIndex().equals(auditStatus)) {


                String key = RedisConstants.KEY_LENDER_BANK
                        + String.valueOf(platformUserNo);

                if (redisUtilService.chekHashkey(key)) {
                    String jsonBank = redisUtilService.getValue(key);
                    JSONObject jsonObject1 = JSON.parseObject(jsonBank);
                    jsonObject1.put("cardStatus", 4);
                    jsonObject1.put("errorMessage", errorMessage);
                }


            }
        }


    }


    /**
     * 请求文件三方访问接口下载文件
     *
     * @param [map, url]
     * @return java.lang.String
     * @author 刘俊汉
     * @date 2018/4/18 16:22
     */
    protected String httpPost(Map<String, String> map, String url) throws Exception {
        Map<String, String> personMap = map;

        StringBuffer buffer = new StringBuffer();
        List<NameValuePair> list = new LinkedList<NameValuePair>();
        for (Map.Entry<String, String> entry : personMap.entrySet()) {
            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        HttpPost httpPost = new HttpPost(url);
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list, "utf-8");
        httpPost.setEntity(formEntity);
        CloseableHttpClient httpCient = HttpClients.createDefault();
        HttpResponse httpresponse = null;
        try {
            httpresponse = httpCient.execute(httpPost);
            HttpEntity httpEntity = httpresponse.getEntity();
            InputStream inputStream = httpEntity.getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            //释放资源
            inputStream.close();


        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return buffer.toString();

    }


    /**
     * 修改redis
     *
     * @param [map, errorMessage]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/17 16:26
     */
    private void updateRedis(Map<String, Object> map, String errorMessage) {

        //开户失败需要修改redis缓存中的记录
        String key = RedisConstants.KEY_TEMP_BANK + map.get("loginId");

        if (redisUtilService.chekHashkey(key)) {

            String jsonMap = redisUtilService.getValue(key);

            Map<String, Object> mapBank = ConnectingToLanmaoUtil.jsonToMap(jsonMap);
            mapBank.put("cardStatus", 4);
            mapBank.put("errorMessage", errorMessage);
            redisUtilService.setValue(key, ConnectingToLanmaoUtil.mapTojson(mapBank));

        }


    }

    /**
     * 充值流水号
     *
     * @param [reqData]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/17 10:28
     */
    private void recharge(String reqData) {
        JSONObject jsonObject = JSONObject.parseObject(reqData);
// 请求流水号
        String requestNo = jsonObject.getString("requestNo");
        //  调用状态（0 为调用成功、1 为失败，返回 1 时请看【调用失败错误码】及错误码描述）
        String code = jsonObject.getString("code");
        // 业务处理状态（处理失败 INIT；处理成功 SUCCESS），平台可根据非 SUCCESS状态做相应处理，处理失败时可参考错误码及描述
        String status = jsonObject.getString("status");
//        String errorCode = jsonObject.getString("errorCode"); //  错误码、若支付失败时，显示存管错误码信息
        //  错误码描述，若支付失败时，显示存管错误码描述
        String errorMessage = jsonObject.getString("errorMessage");
        //  充值状态；SUCCESS 支付成功、FAIL 支付失败、PENDDING 支付中（充值结果以此状态为准）
        String rechargeStatus = jsonObject.getString("rechargeStatus");
//        String platformUserNo = jsonObject.getString("platformUserNo"); // 平台用户编号
        // 充值金额
        String amount = jsonObject.getString("amount");
//        String commission = jsonObject.getString("commission"); //平台佣金
        // 见【支付公司】
        String payCompany = jsonObject.getString("payCompany");
//        String rechargeWay = jsonObject.getString("rechargeWay"); // 见【支付方式】
//        String bankcode = jsonObject.getString("bankcode"); //见【银行编码】（只有快捷会返回）
//        String payMobile = jsonObject.getString("payMobile"); // 本次充值手机号，网银为空
//        String transactionTime = jsonObject.getString("transactionTime"); // 交易完成时间
//        String channelErrorCode = jsonObject.getString("channelErrorCode"); // 见【支付通道错误码】（若快捷充值回调方式传入 DIRECT_CALLBACK，则返回此参数）技术支持单独提供
//        String channelErrorMessage = jsonObject.getString("channelErrorMessage"); // 见【支付通道返回错误消息】（若快捷充值回调方式传入 DIRECT_CALLBACK，则返回此参数）技术支持单独提供

//======================================业务====================================================


        if (MagicParameterConstants.ZERO.equals(code) && MagicParameterConstants.SUCCESS.equals(status)) {
            RechargeRecord rechargeRecord = null;
            GatewaySyncCallbackInfo gatewaySyncCallbackInfo = null;
            if (MagicParameterConstants.SUCCESS.equals(rechargeStatus)) {

                rechargeRecord = rechargeRecordService.selectPayApplyBySul(requestNo);

                logg.info("+++++++++++++++充值查询结果rechargeRecord={}", rechargeRecord);

                if (!MagicParameterConstants.ONE.equals(rechargeRecord.getRechargeStatus())) {

                    return;

                }


                gatewaySyncCallbackInfo = new GatewaySyncCallbackInfo();
                gatewaySyncCallbackInfo.setvOid(requestNo);
                gatewaySyncCallbackInfo.setvPmode("网银");
                gatewaySyncCallbackInfo.setvPstatus("20");
                gatewaySyncCallbackInfo.setvPstring("支付完成");
                gatewaySyncCallbackInfo.setvAmount(amount);
                gatewaySyncCallbackInfo.setvMoneytype("人民币");
            } else if (MagicParameterConstants.FAIL.equals(rechargeStatus)) {
                gatewaySyncCallbackInfo = new GatewaySyncCallbackInfo();
                gatewaySyncCallbackInfo.setvOid(requestNo);
                gatewaySyncCallbackInfo.setvPmode("网银");
                gatewaySyncCallbackInfo.setvPstatus("30");
                gatewaySyncCallbackInfo.setvPstring("支付失败");
                gatewaySyncCallbackInfo.setvAmount(amount);
                gatewaySyncCallbackInfo.setvMoneytype("人民币");
            }

            try {
                LOCKLOCK.lock();
                gatewayPayService.doSyncPayResultCallBack(
                        gatewaySyncCallbackInfo, new Date());

                //更新支付公司
                RechargeRecord rechargeRecords = new RechargeRecord();
                rechargeRecords.setRechargeId(rechargeRecord.getRechargeId());
                rechargeRecords.setPayCompany(PayCompany.getName(payCompany));
                rechargeRecordService.updataPayCompany(rechargeRecords);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCKLOCK.unlock();

            }


        } else {

            logg.info("交易处理失败：[信息={" + errorMessage + "}]");


        }


    }


    /**
     * 提现异步回调
     *
     * @param [reqData]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/16 11:31
     */
    private void withdraw(String reqData) {
        JSONObject jsonObject = JSONObject.parseObject(reqData);
// 错误码描述
        String errorMessage = jsonObject.getString("errorMessage");
        // 见【提现交易状态】
        String withdrawStatus = jsonObject.getString("withdrawStatus");
        // 50 请求流水号
        String requestNo = jsonObject.getString("requestNo");
        // 0 为调用成功、1 为调用失败，返回 1 时请看【调用失败错误码】及错误码描述
        String code = jsonObject.getString("code");
        // 业务处理状态（处理失败 INIT；处理成功 SUCCESS），平台可根据非 SUCCESS 状态做相应处理，处理失败时可参考错误码及描述
        String status = jsonObject.getString("status");
//        String errorCode=jsonObject.getString("");// 错误码
//
//        String amount =jsonObject.getString("");// 提现金额
//        String  commission=jsonObject.getString("");// 提现分佣
//        String  platformUserNo =jsonObject.getString("");// 平台用户编号
//        String  createTime =jsonObject.getString("");// 交易发起时间
//        String  transactionTime =jsonObject.getString("");// 交易完成时间
//        String  remitTime =jsonObject.getString("");// 出款时间
//        String  completedTime =jsonObject.getString("");//T 到账时间
//        String  bankcardNo =jsonObject.getString("");// 提现银行卡号
//
//        String  remitType =jsonObject.getString("");// 出款类型；NORMAL：T1 出款；NORMAL_URGENT：普通 T0 出款；URGENT：实时 T0 出款；
//        String  withdrawWay =jsonObject.getString("");// 见【提现方式】,有传入则返回
//        String  withdrawForm =jsonObject.getString("");// 提现类型：IMMEDIATE 为直接提现，CONFIRMED 为待确认提现
//        String  floatAmount =jsonObject.getString("");// 垫资金额
//=============================业务逻辑=========================================


        Map<String, Object> parass = new HashMap<>(16);
        parass.put("serlNum", requestNo);
        CashApply cashApply = cashApplyService.findCashApplyBySerlNum(parass);

        logg.info("+++++++++++++++提现查询结果cashApply={}", cashApply);

        if (!MagicParameterConstants.TWO.equals(cashApply.getCashStatus())) {
            return;
        }
        if (MagicParameterConstants.ZERO.equals(code) && MagicParameterConstants.SUCCESS.equals(status)) {

            //根据返回的验证txn_rsp_cd判断是否成功
            if (MagicParameterConstants.SUCCESS.equals(withdrawStatus)) {
                Map<String, Object> map3 = new HashMap<String, Object>(16);
                logg.info(">>>>>>>>>>>>>>>出入参数》》》》[流水号={" + requestNo + "}]");
                map3.put("serl_Num", requestNo);
                map3.put("resp_code", "0000");
                //调用同步方法将状态改为处理中
                callBackMessageWithdrawService.messageDispose(map3);
                //调用异步方法将状态改为已完成
                callBackMessageWithdrawService.messageAsyncDispose(map3);

            } else if (MagicParameterConstants.FAIL.equals(withdrawStatus) || MagicParameterConstants.ACCEPT_FAIL.equals(withdrawStatus)) {
                callBackMessageWithdrawService.messageFailureDispose(requestNo, "1111");
            }


        } else {

            logg.info("交易处理失败：[信息={" + errorMessage + "}]");

        }

    }


    /**
     * 资金回退充值异步通知
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/16 13:12
     */
    private void backrollRecharge(String reqData) {

        JSONObject jsonObject = JSONObject.parseObject(reqData);
        // 回退到账金额（提现实际入账金额）
        String rollbackAmount = jsonObject.getString("rollbackAmount");
        //提现请求流水号（提现失败对应的提现请求流水号）
        String withdrawRequestNo = jsonObject.getString("withdrawRequestNo");
        // 回退充值请求流水号
        String requestNo = jsonObject.getString("requestNo");
//// 回退佣金（提现佣金）
        String rollbackCommissio = jsonObject.getString("rollbackCommissio");
//
//        String completedTime=jsonObject.getString("completedTime");// 回退充值完成时间
//        String  status =jsonObject.getString("status");// 回退充值状态 ：SUCCESS
//        String  rollbackType =jsonObject.getString("rollbackType");// 资金回充类型：INTERCEPT（表示提现拦截以后系统发起的回充）、REMITFAIL（表示提现出款失败后系统发起的回充）

        //==============================业务逻辑==================================


        //提现回退充值
        Map<String, Object> map = new HashMap<>(16);

        map.put("withdrawRequestNo", withdrawRequestNo);
        map.put("rollbackAmount", rollbackAmount);


        // 执行相应的逻辑处理
        cashApplyService.cashRefund(map);

        //增加充值记录
        Map<String, Object> param = new HashMap<>(16);
        param.put("serlNum", withdrawRequestNo);

        CashApply cashApply = cashApplyService.findCashApplyBySerlNum(param);
        RechargeRecord rechargeRecord = new RechargeRecord();
        rechargeRecord.setLenderId(cashApply.getLenderId());
        rechargeRecord.setPayType("1");
        rechargeRecord.setRechargeAmount(new BigDecimal(rollbackAmount).add(new BigDecimal(rollbackCommissio)));
        rechargeRecord.setRechargeStatus("2");
        rechargeRecord.setRechargeTime(new Date());
        rechargeRecord.setRechargeWay("7");
        rechargeRecord.setSerlNum(AccountUtil.serlNum());
        rechargeRecord.setRemark(requestNo);
        rechargeRecordService.insetRechargeRecord(rechargeRecord);

    }


    /**
     * 批量交易接口异步回调
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/16 14:07
     */
    private void asyncTransaction(String reqData) {
        JSONObject jsonObject = JSONObject.parseObject(reqData);
        //复杂类型，数组形式，数组内对象见下方“异步通知明细”
        String details = jsonObject.getString("details");
        JSONArray jsonArray = jsonObject.getJSONArray("details");
        //上边字段包含以下内容

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

// 交易明细订单号
            String asyncRequestNo = jsonObject1.getString("asyncRequestNo");
            // 见【交易类型】，对应请求参数里的 tradeType
            String bizType = jsonObject1.getString("bizType");
            // 见【业务来源】
            String bizOrigin = jsonObject1.getString("bizOrigin");
            // 交易发起时间
            String createTime = jsonObject1.getString("createTime");
            // 交易完成时间
            String transactionTime = jsonObject1.getString("transactionTime");
            // 交易状态，SUCCESS 表示成功，FAIL 表示失败
            String status = jsonObject1.getString("status");
            // 50 错误码
            String errorCode = jsonObject1.getString("errorCode");
            // 错误码描述
            String errorMessage = jsonObject1.getString("errorMessage");


            //修改交易结果
            SettleZz settleZz = new SettleZz();
            settleZz.setRealserlnum(asyncRequestNo);
            if ("SUCCESS".equals(status)) {
                settleZz.setStatus("2");
                settleZz.setMsg("成功");

            } else if ("FAIL".equals(status)) {
                settleZz.setStatus("1");
                settleZz.setMsg("失败");
            }
            settleZz.setOvertime(new Date());
            List<SettleZz> settleZzs = settleZzService.selectByRequstNo(settleZz);

            for (SettleZz settleZz1 : settleZzs) {


                logg.info("+++++++++++++++批量查询结果settleZz1={}", settleZz1);

                boolean booa = settleZz1 == null || (!"3".equals(settleZz1.getStatus()) && !"0".equals(settleZz1.getStatus()));
                if (booa) {
                    return;
                }
                settleZz.setRealserlnum(settleZz1.getRealserlnum());
                logg.info("+++++++++++++++批量交易处理开始====================");
                settleZzService.updataStatusByRequstNo(settleZz);
                //===================生成通知记录===========================

                //根据流水号查询settleZz信息


                SettleNoticeWithBlobs settleNoticeWithBlobs = new SettleNoticeWithBlobs();

                String statusThis = null;
                String reason = null;
                if ("SUCCESS".equals(status)) {
                    statusThis = "3";
                    reason = "成功";
                } else if ("FAIL".equals(status)) {
                    reason = errorMessage;
                    statusThis = "4";
                }

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dataStr = dztNoticeUtil(settleZz1.getSerlnum(), statusThis, reason, simpleDateFormat.format(new Date()), null, "Z");
                settleNoticeWithBlobs.setNoticedata(dataStr);
                settleNoticeWithBlobs.setSerlnum(settleZz1.getSerlnum());
                settleNoticeWithBlobs.setStatus("0");
                settleNoticeWithBlobs.setClientcode(settleZz1.getBusplatform());
                settleNoticeWithBlobs.setServicetype(settleZz1.getServicetype());
                settleNoticeService.sevaSettleNotice(settleNoticeWithBlobs);

            }
        }

    }

    /**
     * 批量交易接口组参数工具
     *
     * @param [serlNum, status, reason, oDate, busPlatform, opCode]
     * @return java.lang.String
     * @author 刘俊汉
     * @date 2018/4/16 18:10
     */
    private String dztNoticeUtil(String serlNum, String status, String reason, String oDate, String busPlatform, String opCode) {
        Map<String, String> map = new HashMap<>(16);
        map.put("serlNum", serlNum);
        if (MagicParameterConstants.D_CHAR.equals(opCode)) {
            map.put("deductStatus", status);
        } else if (MagicParameterConstants.Z_CHAR.equals(opCode)) {
            map.put("transferStatus", status);
        } else if (MagicParameterConstants.T_CHAR.equals(opCode)) {
            map.put("cashStatus", status);
        }
        map.put("failReason", reason);
        map.put("tradeTime", oDate);
        return JSON.toJSONString(map);
    }


    /**
     * 会员激活信息
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/16 19:03
     */
    private void activateStockedUser(String reqData) {
        JSONObject jsonObject = JSONObject.parseObject(reqData);

// 请求流水号
        String requestNo = jsonObject.getString("requestNo");
        // 调用状态（0 为调用成功、1 为失败，返回 1 时请看【调用失败错误码】及错误码描述）
        String code = jsonObject.getString("code");
        // 业务处理状态（处理失败 INIT；处理成功 SUCCESS），平台可根据非 SUCCESS状态做相应处理，处理失败时可参考错误码及描述
        String status = jsonObject.getString("status");
        // 错误码
        String errorCode = jsonObject.getString("errorCode");
        // 错误码描述
        String errorMessage = jsonObject.getString("errorMessage");
        // 平台用户编号
        String platformUserNo = jsonObject.getString("platformUserNo");
        // 银行卡号或企业对公账户
        String bankcardNo = jsonObject.getString("bankcardNo");
        // 见【银行编码】
        String bankcode = jsonObject.getString("bankcode");
        // 50 手机号
        String mobile = jsonObject.getString("mobile");
        // 见【鉴权通过类型】
        String accessType = jsonObject.getString("accessType");
        //见【用户角色】
        String userRole = jsonObject.getString("userRole");
        // 见【审核状态】，该接口会发送多次不同审核状态的回调
        String auditStatus = jsonObject.getString("auditStatus");
        // 主动换卡标识；TRUE 表示个人用户在页面上修改过已经导入的卡号，FALSE 表示个人用户是主动填写或没有在页面上修改过卡号；企业用户激活时不可修改对公账号故不返回
        String cardNolsChange = jsonObject.getString("cardNolsChange");
        // 授权期限
        String failTime = jsonObject.getString("failTime");
        // 授权金额
        String amount = jsonObject.getString("amount");


        if (LanMaoConstant.SUCCESS.equals(status)) {
            if (CheckStatusEnum.PASSED.getIndex().equals(auditStatus)) {


//======================================业务逻辑=============================
                LenderLogin lenderLogin = lenderLoginService.fundObjectByUserNum(platformUserNo);

//        //查询请求日志中的信息
                Map<String, Object> map = new HashMap<>(16);
                map.put("lenderNum", platformUserNo);
                map.put("accountNum", bankcardNo);
                map.put("bankcode", bankcode);
                map.put("bankInfo", "北京某支行");
                map.put("city", "北京");
                map.put("province", "北京");

                registerService.updataBankInfo(map);


            } else if (CheckStatusEnum.BACK.getIndex().equals(auditStatus) || CheckStatusEnum.REFUSED.getIndex().equals(auditStatus)) {
                String cardStatus = "6";

                registerService.updataBank(platformUserNo, cardStatus, errorMessage);

            }
        }


    }


    /**
     * 换卡异步回调
     *
     * @param [reqData]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/27 13:18
     */
    private void personalBineBankcardExpand(String reqData) {

        JSONObject jsonObject = JSONObject.parseObject(reqData);
        // 请求流水号
        String requestNo = jsonObject.getString("requestNo");
        // 调用状态（0 为调用成功、1 为失败，返回 1 时请看【调用失败错误码】及错误码 描述）
        String code = jsonObject.getString("code");
        //业务处理状态（处理失败 INIT；处理成功 SUCCESS），平台可根据非 SUCCESS 状态做相应处理，处理失败时可参考错误码及描述
        String status = jsonObject.getString("status");
        // 错误码
        String errorCode = jsonObject.getString("errorCode");
        // 错误码描述
        String errorMessage = jsonObject.getString("errorMessage");
        // 平台用户编号
        String platformUserNo = jsonObject.getString("platformUserNo");
        // 银行卡号
        String bankcardNo = jsonObject.getString("bankcardNo");
        // 见【银行编码】
        String bankcode = jsonObject.getString("bankcode");
        // 银行预留手机号
        String mobile = jsonObject.getString("mobile");
        // 见【鉴权通过类型】
        String accessType = jsonObject.getString("accessType");
        //换卡状态，固定值：AUDIT（审核中）
        String auditStatus = jsonObject.getString("auditStatus");


        if (MagicParameterConstants.ZERO.equals(code) && MagicParameterConstants.SUCCESS.equals(status)) {

            //换卡成功
            if (MagicParameterConstants.AUDIT.equals(auditStatus)) {


                bankInfoService.updataBankInfoCardById(reqData, mobile, platformUserNo, requestNo);


            }


        } else {


            logg.info("==============换卡异步回调失败========[errorMessage={}]", errorMessage);
        }

    }


    /**
     * 参数整理加工保存
     *
     * @param [requstData]
     * @return java.lang.String
     * @author 刘俊汉
     * @date 2018/4/13 13:10
     */
    public void paramProcessing(String serviceName,
                                String respData
    ) {

        if (null != respData) {

            //获取流水号
            String sul = JSON.parseObject(respData).getString("requestNo");


            LanmaoServiceLogWithBlobs lanmaoServiceLog = new LanmaoServiceLogWithBlobs();
            lanmaoServiceLog.setReqData(respData);
            lanmaoServiceLog.setRequestNo(sul);
            lanmaoServiceLog.setSaveData(null);
            lanmaoServiceLog.setReqOrRes(5);
            lanmaoServiceLog.setServiceName(serviceName);
            lanmaoServiceLog.setServiceNameZh("异步_" + (ConnectorDirectNameEnum.getName(serviceName) == null ? ConnectoGatewayNameEnum.getName(serviceName) : ConnectorDirectNameEnum.getName(serviceName)));
            lanmaoServiceLog.setTime(new Date());

            toLanmaoService.localRequestDataSave(lanmaoServiceLog);


            //修改需要异步信息的数据状态为：异步已返回状态
            lanmaoServiceLog = new LanmaoServiceLogWithBlobs();

            lanmaoServiceLog.setRequestNo(sul);
            lanmaoServiceLog.setReqOrRes(3);
            lanmaoServiceLog = toLanmaoService.selectObjectByRequestNo(lanmaoServiceLog);

            if (lanmaoServiceLog != null) {
                lanmaoServiceLog.setReqOrRes(4);
                toLanmaoService.updataObjectByRequestNo(lanmaoServiceLog);

            }

        }


    }

}



