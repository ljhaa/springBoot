package com.yipuhui.fastgo.timing;/**
 * Created by liujunhan on 2018/4/18.
 */


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.api.entity.*;
import com.yipuhui.api.enums.ChekBillTypeEnum;
import com.yipuhui.api.enums.ConnectoGatewayNameEnum;
import com.yipuhui.api.enums.ConnectorDirectNameEnum;
import com.yipuhui.api.enums.WithdrawalTransactionStatusEnum;
import com.yipuhui.fastgo.common.MagicParameterConstants;
import com.yipuhui.fastgo.dao.*;
import com.yipuhui.fastgo.enty.*;
import com.yipuhui.fastgo.utils.AppConfig;
import com.yipuhui.fastgo.utils.AppUtil;
import com.yipuhui.fastgo.utils.ConnectingToLanmaoUtil;
import com.yipuhui.fastgo.utils.yphutil.FastJsonUtil;
import com.yipuhui.fastgo.utils.yphutil.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 对账文件操作
 *
 * @author 刘俊汉
 * @create 2018-04-18 13:40
 **/
@Component
public class CheckBillJob extends CheckBillJobSupper {

    private static AppConfig config = AppConfig.getConfig();

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckBillJob.class);
    private static final DateFormat FORMAT1 = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private AccountCheckingLanmaoMapper accountCheckingLanmaoMapper;

    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    @Autowired
    private CashApplyMapper cashApplyMapper;

    @Autowired
    private SettleZzMapper settleZzMapper;

    @Autowired
    private LenderDetailMapper lenderDetailMapper;

    @Autowired
    private BankInfoMapper bankInfoMapper;

    /**
     * Description:
     *
     * @param null
     * @return
     * @author 刘俊汉
     * @date 2018/5/14 15:36
     */
    @Scheduled(cron = "0 30 1 * * ?")
    public void checkBill() {
        LOGGER.info("=================================对账开始==========================================");
        //获取昨天的日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - Integer.valueOf(config.getDataBypro("checkDate")));
        try {


            Map<String, Object> map = new HashMap<>(16), mapre = null;
            map.put("fileDate", FORMAT.format(calendar.getTime()));
            map.put("timestamp", FORMAT1.format(new Date()));


            mapre = AppUtil.createPostParam("DOWNLOAD_CHECKFILE", map);
            Map<String, String> param = new HashMap<>(16);

            param.put("serviceName", String.valueOf(mapre.get("serviceName")));
            param.put("platformNo", config.getPlatformNo());
            param.put("reqData", String.valueOf(mapre.get("reqData")));
            param.put("keySerial", config.getKeySerial());
            param.put("sign", String.valueOf(mapre.get("sign")));

            //保存三方文件成功返回uri文件路径
            String uri = httpPost(param, config.getDataBypro("doloadFileUrl"));

            //解压
            unZipUtil(uri);


            //充值对账
            List<String> recharges = checkRecharge(calendar, uri);

            //提现对账
            List<String> withdraws = checkWithdraw(calendar, uri);

            //转账对账
            List<String> transaction = checkTransaction(calendar, uri);


            //提现失败回退充值对账
            List<String> backrollrecharge = checkBackrollrecharge(calendar, uri);


            sendEmail(calendar, recharges, withdraws, transaction, backrollrecharge);

            LOGGER.info("=================================对账结束==========================================");
        } catch (Exception e) {

            e.printStackTrace();
            LOGGER.info("=================================对账失败==========================================");
        }


    }


    /**
     * 进入充值对账
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/19 13:16
     */
    private List<String> checkRecharge(Calendar calendar, String uri) {


        List<String> resultList = new ArrayList<>();
        //查询充值记录比对失败的记录结果
        Map<String, Object> localMap = new HashMap<>(16);


        //
        Map<String, Object> recharges = new HashMap<>(16);
        //读取充值对账文件
        lodFileUtil(CheckRechargeEntity.class, recharges, uri, ConnectoGatewayNameEnum.RECHARGE.getIndex(), 16, 3);

        List<RechargeRecord> rechargeRecords = rechargeRecordMapper.selectPayApplyByTimeAndStatus(calendar.getTime(), "2");


        for (RechargeRecord rechargeRecord : rechargeRecords) {

            if (recharges.get(rechargeRecord.getSerlNum()) != null) {
                //有记录比对充值结果
                CheckRechargeEntity checkRechargeEntity = (CheckRechargeEntity) recharges.get(rechargeRecord.getSerlNum());


                LenderDetail lenderDetail = lenderDetailMapper.selectByPrimaryKey(rechargeRecord.getLenderId());

                if (rechargeRecord.getRechargeAmount().compareTo(new BigDecimal(checkRechargeEntity.getAmount())) == 0 && lenderDetail.getLenderNum().equals(checkRechargeEntity.getPlatformUserNumber())) {
                    //对账成功=======执行逻辑
                    insetResult("RECHARGE", FastJsonUtil.toJSONString(checkRechargeEntity), checkRechargeEntity.getPayTime(), checkRechargeEntity.getPlatformRequestsNo(), rechargeRecord.getSerlNum(), 0);
                } else {
                    //对账不一致===========执行逻辑

                    resultList.add(rechargeRecord.getSerlNum());
                    insetResult("RECHARGE", FastJsonUtil.toJSONString(checkRechargeEntity), checkRechargeEntity.getPayTime(), checkRechargeEntity.getPlatformRequestsNo(), rechargeRecord.getSerlNum(), 2);
                }

                recharges.remove(rechargeRecord.getSerlNum());

            } else {
                //三方不存在我们存在的记录=====

                insetResult("RECHARGE", null, rechargeRecord.getPushTime().toString(), null, rechargeRecord.getSerlNum(), 4);

                resultList.add(rechargeRecord.getSerlNum());
            }

        }

        if (recharges.size() > 0) {
            Iterator<Map.Entry<String, Object>> iterator = recharges.entrySet().iterator();

            while (iterator.hasNext()) {

                Map.Entry<String, Object> entry = iterator.next();
                CheckRechargeEntity checkRechargeEntity = (CheckRechargeEntity) entry.getValue();
                LOGGER.info("checkRechargeEntity={}", checkRechargeEntity);
                //三方存在我们不存在的数据====

                resultList.add(checkRechargeEntity.getPlatformRequestsNo());
                insetResult("RECHARGE", FastJsonUtil.toJSONString(checkRechargeEntity), checkRechargeEntity.getPayTime(), checkRechargeEntity.getPlatformRequestsNo(), null, 3);
            }

        }


        return resultList;
    }

    /**
     * 进入提现对账
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/19 13:16
     */
    private List<String> checkWithdraw(Calendar calendar, String uri) {


        List<String> resultList = new ArrayList<>();
        //提现记录比对结果
        Map<String, Object> localMap = new HashMap<>(16);

        //
        Map<String, Object> withdraw = new HashMap<>(16);
        //读取提现对账文件
        lodFileUtil(CheckWithdrawEntity.class, withdraw, uri, ConnectoGatewayNameEnum.WITHDRAW.getIndex(), 18, 2);

        List<CashApply> cashApplies = cashApplyMapper.fundCashApplyByTimeAndStatus(calendar.getTime());


        for (CashApply cashApplie : cashApplies) {

            if (withdraw.get(cashApplie.getSerlNum()) != null && withdraw.get(cashApplie.getSerlNum()) != "") {

                LenderDetail lenderDetail = lenderDetailMapper.selectByPrimaryKey(cashApplie.getLenderId());

                //有记录比对提现结果
                CheckWithdrawEntity checkWithdrawEntity = (CheckWithdrawEntity) withdraw.get(cashApplie.getSerlNum());


                if (cashApplie.getApplyCashAmount().compareTo(new BigDecimal(checkWithdrawEntity.getAmount())) == 0
                        && lenderDetail.getLenderNum().equals(checkWithdrawEntity.getPlatformUserNumber())
                        && checkWithdrawEntity.getCardCode().equals(cashApplie.getAccountNum())
                        && new BigDecimal(checkWithdrawEntity.getArrivalAmount()).compareTo(cashApplie.getRealCashAmount()) == 0
                        && WithdrawalTransactionStatusEnum.getName(checkWithdrawEntity.getWithdrawalStatus()).equals(cashApplie.getCashStatus())
                        ) {
                    //对账成功=======执行逻辑
                    insetResult("WITHDRAW", FastJsonUtil.toJSONString(checkWithdrawEntity), checkWithdrawEntity.getWithdrawalTime(), checkWithdrawEntity.getPlatformRequestsNo(), cashApplie.getSerlNum(), 0);

                } else {
                    //对账不一致===========执行逻辑

                    resultList.add(cashApplie.getSerlNum());
                    insetResult("WITHDRAW", FastJsonUtil.toJSONString(checkWithdrawEntity), checkWithdrawEntity.getWithdrawalTime(), checkWithdrawEntity.getPlatformRequestsNo(), cashApplie.getSerlNum(), 2);

                }
                withdraw.remove(cashApplie.getSerlNum());

            } else {
                //三方不存在我们存在的记录=====

                resultList.add(cashApplie.getSerlNum());
                insetResult("WITHDRAW", null, cashApplie.getApplyTime().toString(), null, cashApplie.getSerlNum(), 4);

            }


        }

        if (withdraw.size() > 0) {
            Iterator<Map.Entry<String, Object>> iterator = withdraw.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                //三方存在我们不存在的数据====

                CheckWithdrawEntity checkWithdrawEntity = (CheckWithdrawEntity) entry.getValue();
                resultList.add(checkWithdrawEntity.getPlatformRequestsNo());
                insetResult("WITHDRAW", FastJsonUtil.toJSONString(checkWithdrawEntity), checkWithdrawEntity.getWithdrawalTime(), checkWithdrawEntity.getPlatformRequestsNo(), null, 3);
            }

        }


        return resultList;
    }


    /**
     * 进入债转对账对账
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/19 13:16
     */
    private List<String> checkTransaction(Calendar calendar, String uri) {

        List<String> resultList = new ArrayList<>();
        //转账记录比对结果
        Map<String, Object> localMap = new HashMap<>(16);

        //转账和分润
        Map<String, Object> transaction = new HashMap<>(16);
        //分佣金
        Map<String, Object> shareCommission = new HashMap<>(16);
        //读取转账对账文件
        lodFileUtil(CheckTransactionEntity.class, transaction, uri, "TRANSACTION", 17, 16);
        //读取分佣文件
        lodFileUtil(CheckCommissionEntity.class, shareCommission, uri, "COMMISSION", 11, 10);
        //查询转账记录
        List<SettleZz> settleZzes = settleZzMapper.fundSettleZzByTimeAndStatus(calendar.getTime(), "2");


        for (SettleZz settleZze : settleZzes) {

            if (transaction.get(settleZze.getRealserlnum()) != null) {


                LenderDetail payLender = lenderDetailMapper.findLenderDetailInfoByCadeNum(settleZze.getOutuser());
                LenderDetail collectMoneyLender = lenderDetailMapper.findLenderDetailInfoByCadeNum(settleZze.getInuser());

                //有记录比对提现结果
                CheckTransactionEntity checkTransactionEntity = (CheckTransactionEntity) transaction.get(settleZze.getRealserlnum());
                if (settleZze.getAmount().compareTo(new BigDecimal(checkTransactionEntity.getAmount())) == 0
                        && checkTransactionEntity.getInitiatorPlatformUserNumber().equals(payLender.getLenderNum())
                        && checkTransactionEntity.getRecipientPlatformUserNumber().equals(collectMoneyLender.getLenderNum())


                        ) {
                    //对账成功=======执行逻辑
                    insetResult("TRANSACTION", FastJsonUtil.toJSONString(checkTransactionEntity), checkTransactionEntity.getOccurrenceTime(), checkTransactionEntity.getPlatformRequestsNo(), settleZze.getRealserlnum(), 0);

                } else {
                    //对账不一致===========执行逻辑
                    resultList.add(settleZze.getRealserlnum());
                    insetResult("TRANSACTION", FastJsonUtil.toJSONString(checkTransactionEntity), checkTransactionEntity.getOccurrenceTime(), checkTransactionEntity.getPlatformRequestsNo(), settleZze.getRealserlnum(), 2);

                }
                transaction.remove(settleZze.getRealserlnum());

            } else {

                //不是转账和分润的进入分佣对账
                String checkNum = settleZze.getRealserlnum().split("_")[0];

                System.out.println(checkNum);
                if (shareCommission.get(checkNum) != null) {

                    CheckCommissionEntity checkCommissionEntity = (CheckCommissionEntity) shareCommission.get(checkNum);

                    LenderDetail payLender = lenderDetailMapper.findLenderDetailInfoByCadeNum(settleZze.getOutuser());
                    LenderDetail collectMoneyLender = lenderDetailMapper.findLenderDetailInfoByCadeNum(settleZze.getInuser());


                    if (settleZze.getAmount().compareTo(new BigDecimal(checkCommissionEntity.getAmount())) == 0
                            && checkCommissionEntity.getInitiatorPlatformUserNumber().equals(payLender.getLenderNum())
                            && checkCommissionEntity.getRecipientPlatformUserNumber().equals(collectMoneyLender.getLenderNum())) {

                        //对账成功=======执行逻辑
                        insetResult("TRANSACTION", FastJsonUtil.toJSONString(checkCommissionEntity), checkCommissionEntity.getOccurrenceTime(), checkCommissionEntity.getPlatformRequestsNo(), settleZze.getRealserlnum(), 0);

                    } else {
                        //对账不一致===========执行逻辑
                        resultList.add(settleZze.getRealserlnum());
                        insetResult("TRANSACTION", FastJsonUtil.toJSONString(checkCommissionEntity), checkCommissionEntity.getOccurrenceTime(), checkCommissionEntity.getPlatformRequestsNo(), settleZze.getRealserlnum(), 2);

                    }
                    transaction.remove(settleZze.getRealserlnum());


                }


            }


        }
        if (transaction.size() > 0) {
            Iterator<Map.Entry<String, Object>> iterator = transaction.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                //三方存在我们不存在的数据====
                CheckTransactionEntity checkTransactionEntity = (CheckTransactionEntity) entry.getValue();
                resultList.add(checkTransactionEntity.getPlatformRequestsNo());
                insetResult("TRANSACTION", FastJsonUtil.toJSONString(checkTransactionEntity), checkTransactionEntity.getOccurrenceTime(), checkTransactionEntity.getPlatformRequestsNo(), null, 3);
            }

        }

        return resultList;
    }

    /**
     * 进入提现回退对账对账
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/19 13:16
     */
    private List<String> checkBackrollrecharge(Calendar calendar, String uri) {

        List<String> resultList = new ArrayList<>();
        //转账记录比对结果
        Map<String, Object> localMap = new HashMap<>(16);

        //
        Map<String, Object> backrollRecharge = new HashMap<>(16);
        //读取转账对账文件
        lodFileUtil(CheckBackrollRechargeEntity.class, backrollRecharge, uri, "BACKROLL_RECHARGE", 15, 3);

        //查询转账记录
        List<RechargeRecord> rechargeRecords = rechargeRecordMapper.selectPayApplyByTimeAndRechagerWay(calendar.getTime(), "7");


        for (RechargeRecord rechargeRecord : rechargeRecords) {

            if (backrollRecharge.get(rechargeRecord.getRemark()) != null) {

                LenderDetail lenderDetail = lenderDetailMapper.selectByPrimaryKey(rechargeRecord.getLenderId());
                //有记录比对提现结果
                CheckBackrollRechargeEntity checkBackrollRechargeEntity = (CheckBackrollRechargeEntity) backrollRecharge.get(rechargeRecord.getRemark());
                if (rechargeRecord.getRechargeAmount().compareTo(new BigDecimal(checkBackrollRechargeEntity.getAmount())) == 0
                        && lenderDetail.getLenderNum().equals(checkBackrollRechargeEntity.getAmount())
                        ) {
                    //对账成功=======执行逻辑
                    insetResult("BACKROLL_RECHARGE", FastJsonUtil.toJSONString(checkBackrollRechargeEntity), checkBackrollRechargeEntity.getPayTime(), checkBackrollRechargeEntity.getRechargeRequestsNo(), rechargeRecord.getSerlNum(), 0);

                } else {
                    //对账不一致===========执行逻辑
                    resultList.add(rechargeRecord.getSerlNum());
                    insetResult("BACKROLL_RECHARGE", FastJsonUtil.toJSONString(checkBackrollRechargeEntity), checkBackrollRechargeEntity.getPayTime(), checkBackrollRechargeEntity.getRechargeRequestsNo(), rechargeRecord.getSerlNum(), 2);

                }
                backrollRecharge.remove(rechargeRecord.getRemark());

            } else {
                //三方不存在我们存在的记录=====
                resultList.add(rechargeRecord.getRemark());
                insetResult("BACKROLL_RECHARGE", null, rechargeRecord.getRechargeTime().toString(), null, rechargeRecord.getSerlNum(), 4);
            }


        }
        if (backrollRecharge.size() > 0) {
            Iterator<Map.Entry<String, Object>> iterator = backrollRecharge.entrySet().iterator();

            while (iterator.hasNext()) {

                Map.Entry<String, Object> entry = iterator.next();
                //三方存在我们不存在的数据====
                CheckBackrollRechargeEntity checkBackrollRechargeEntity = (CheckBackrollRechargeEntity) entry.getValue();
                resultList.add(checkBackrollRechargeEntity.getRechargeRequestsNo());
                insetResult("BACKROLL_RECHARGE", FastJsonUtil.toJSONString(checkBackrollRechargeEntity), checkBackrollRechargeEntity.getPayTime(), checkBackrollRechargeEntity.getRechargeRequestsNo(), null, 3);
            }

        }

        return resultList;
    }


    /**
     * 对账确认
     *
     * @param
     * @return
     * @author 刘俊汉
     * @date 2018/4/19 14:30
     */
    private void checkConfirm() {
        Map<String, Object> param = new HashMap<>(16);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);

        String[] fileType = new String[]{ChekBillTypeEnum.RECHARGE.getIndex(),
                ChekBillTypeEnum.BACKROLL_RECHARGE.getIndex(),
                ChekBillTypeEnum.WITHDRAW.getIndex(),
                ChekBillTypeEnum.TRANSACTION.getIndex(),
                ChekBillTypeEnum.COMMISSION.getIndex()
        };
        JSONObject js = null;
        JSONArray jsonArray = new JSONArray();
        int forInt = 5;

        for (int i = 0; i < forInt; i++) {
            js = new JSONObject();
            js.put("fileType", fileType[i]);
            jsonArray.add(js);
        }

        param.put("requestNo", String.valueOf(System.currentTimeMillis()));
        param.put("fileDate", FORMAT.format(calendar.getTime()));
        param.put("detail", jsonArray);


        Map<String, Object> map = ConnectingToLanmaoUtil.connectingToLanmao(param, ConnectorDirectNameEnum.CONFIRM_CHECKFILE.getIndex());

        String respData = (String) map.get("reqData");

        Map<String, Object> mapreusl = ConnectingToLanmaoUtil.jsonToMap(respData);


        if (MagicParameterConstants.SUCCESS.equals(mapreusl.get(MagicParameterConstants.STATUS)) && MagicParameterConstants.ZERO.equals(mapreusl.get(MagicParameterConstants.CODE))) {

            //全部确认成功则发送邮件给负责人


        }

    }


    /**
     * 插入比对结果到表中
     *
     * @param [businessType, lanmaoDataJson, pushDate, lanmaoRequNo, localSel, status]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/20 18:51
     */
    private void insetResult(String businessType, String lanmaoDataJson, String pushDate, String lanmaoRequNo, String localSel, int status) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");

        LOGGER.info(">>>>>>>>>>>>>>>>>账单日期pushDate={}", pushDate);
        String dateString = null;
        try {
            dateString = sdf2.format(sdf1.parse(pushDate));
        } catch (ParseException e) {

            try {
                dateString = FORMAT1.format(FORMAT1.parse(pushDate));
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }

        LOGGER.info(">>>>>>>>>>>>>>>>>账单日期dateString={}", dateString);
        AccountCheckingLanmao accountCheckingLanmao = new AccountCheckingLanmao();
        Calendar calendars = Calendar.getInstance();

        calendars.set(Integer.valueOf(dateString.substring(0, 4)), Integer.valueOf(dateString.substring(4, 6)) - 1, Integer.valueOf(dateString.substring(6, 8)), Integer.valueOf(dateString.substring(8, 10)), Integer.valueOf(dateString.substring(10, 12)), Integer.valueOf(dateString.substring(12, 14)));


        accountCheckingLanmao.setBillCreatTime(calendars.getTime());

        accountCheckingLanmao.setBusinessType(businessType);
        accountCheckingLanmao.setCheckStatus(status);
        accountCheckingLanmao.setCreatTime(new Date());
        accountCheckingLanmao.setLanmaoData(lanmaoDataJson);
        accountCheckingLanmao.setLanmaoRelevancePlatform(status == 3 ? lanmaoRequNo : localSel);


        accountCheckingLanmaoMapper.insert(accountCheckingLanmao);
    }


    /**
     * 发送邮件
     *
     * @param [calendar, recharges, withdraws, transaction, backrollrecharge]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/20 19:44
     */
    private void sendEmail(Calendar calendar, List<String> recharges, List<String> withdraws, List<String> transaction, List<String> backrollrecharge) {

        LOGGER.info("=====================邮件发送=====================");
        StringBuffer text = new StringBuffer();
        if (recharges.size() == 0 && withdraws.size() == 0 && transaction.size() == 0 && backrollrecharge.size() == 0) {
            //向三方发送确认信息
            checkConfirm();
            text.append(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "（账单日期）对账无误。");

        } else {


            text.append(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "（账单日期）对账不符：\r\n");
            if (recharges.size() > 0) {
                text.append("充值：");
                for (String sul : recharges) {
                    text.append(sul + ";");
                }
                text.append("\r\n");
            }
            if (withdraws.size() > 0) {
                text.append("提现：");
                for (String sul : withdraws) {
                    text.append(sul + ";");
                }
                text.append("\r\n");
            }
            if (transaction.size() > 0) {
                text.append("交易：");
                for (String sul : transaction) {
                    text.append(sul + ";");
                }
                text.append("\r\n");
            }
            if (backrollrecharge.size() > 0) {
                text.append("资金回退：");
                for (String sul : backrollrecharge) {
                    text.append(sul + ";");
                }
                text.append("\r\n");
            }
        }


        //初始化邮件
        MailUtil mailUtil = null;

        String emais = config.getDataBypro("email_no");
        String[] emaist = emais.split(";");


        for (int i = 0; i < emaist.length; i++) {


            if (!MailUtil.checkEmail(emaist[i])) {
                continue;
            }
            mailUtil = new MailUtil(text.toString(), emaist[i]);
            LOGGER.info("=====================邮件发送=====================emaist[i]=" + emaist[i]);
            if (mailUtil.sendFileMail()) {
                LOGGER.info("====================邮件发送成功=============================");
            }
        }


    }

    public static void main(String[] args) {
        String fff = "20180424101456";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println("sdf2=" + sdf2.format(fff));

    }


    //    /**
//     * 查询本地交易记录
//     *
//     * @param []
//     * @return void
//     * @author 刘俊汉
//     * @date 2018/4/18 16:24
//     */
//    private Map<String, Object> selectJiaoyi() {
//
//
//        Map<String, Object> localMap = new HashMap<>();
//        //查询充值记录
//        List<RechargeRecord> rechargeRecords = rechargeRecordMapper.selectPayApplyByTimeAndStatus(new Date(), null);
//
//        localMap.put("rechargeRecords", rechargeRecords);
//
//        //查询提现记录
//        List<CashApply> cashApplies = cashApplyMapper.fundCashApplyByTimeAndStatus(new Date(), null);
//        localMap.put("cashApplies", cashApplies);
//        //查询转账记录
//        List<SettleZz> settleZzes = settleZzMapper.fundSettleZzByTimeAndStatus(new Date(), null);
//        localMap.put("settleZzes", settleZzes);
//
//        return localMap;
//    }
//
//
//    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
//
////       Map<String ,Object> map =  new CheckBillJob().lodDataToSys(config.getDataBypro("localFileUri")+format.format(calendar.getTime())+".zip");
//        new CheckBillJob().checkBill();
////
////      List<String []> RECHARGE = (List<String[]>) map.get("RECHARGE");
////      List<String []> WITHDRAW = (List<String[]>) map.get("WITHDRAW");
////        List<String []> TRANSACTION = (List<String[]>) map.get("TRANSACTION");
////
////
////        for(String [] str : RECHARGE)
////            System.out.println("RECHARGE  "+str[0]+"_"+str[1]+"_"+str[2]+"_"+str[15]);
////        for(String [] str : WITHDRAW)
////            System.out.println("WITHDRAW  "+str[0]+"_"+str[1]+"_"+str[2]+"_"+str[17]);
////        for(String [] str : TRANSACTION)
////            System.out.println("TRANSACTION  "+str[0]+"_"+str[1]+"_"+str[2]+"_"+str[16]);
////
//    }


}
