package com.yipuhui.fastgo.service.impl;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.fastgo.common.LenderConstants;
import com.yipuhui.fastgo.common.MagicParameterConstants;
import com.yipuhui.fastgo.common.RedisConstants;
import com.yipuhui.fastgo.common.SystemConstants;
import com.yipuhui.fastgo.dao.*;
import com.yipuhui.fastgo.enty.*;
import com.yipuhui.fastgo.service.LenderDetailService;
import com.yipuhui.fastgo.service.LenderLoginService;
import com.yipuhui.fastgo.service.RedisUtilService;
import com.yipuhui.fastgo.service.RegisterService;
import com.yipuhui.fastgo.utils.yphutil.Md5Util;
import com.yph.toolcenter.util.DateTimeUtil;
import com.yph.toolcenter.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:开户方法 1,富友开户接口。 2,数据保存到CRM---创建用户信息 3,数据保存到CORE---创建账号和用户信息和银行卡信息
 * 4,数据保存到paycenter---创建三方对应的账户信息 5,数据保存到online---创建账号和用户信息
 *
 * @author kRain
 * @version 1.0
 *          <p>
 *          <pre>
 *          Modification History:
 *          Date         Author      Version     Description
 *          ------------------------------------------------------------------
 *          2017年9月28日      kRain       1.0         1.0 Version
 *          </pre>
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    private static final Logger logger = LoggerFactory
            .getLogger(RegisterServiceImpl.class);

    public static final String CUSTOMER_COUNTRY_CHINA = "86";
    public static final int CUSTOMER_CODE_NUM = 7;
    public static final int CUSTOMER_CODE_LENGTH = 15;
    /**
     *  线上推送信息次数
     */
    public static final Integer SYN_ONLINE_TIMES = 3;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private LenderDetailService lenderDetailService;


    @Autowired
    private BankInfoMapper bankInfoMapper;

    @Autowired
    private RedisUtilService redisUtilService;

    @Autowired
    private SystemDictMapper systemDictMapper;

    @Autowired
    private LenderLoginMapper lenderLoginMapper;

    @Override
    public void fyRegist(Map<String, Object> paramMap) {

        doFyRegist(paramMap);

    }


    private void doFyRegist(Map<String, Object> bankMapS) {
        // 组装参数 真实姓名 身份证号 银行卡号 预留手机号 开户行 开户省 开户支行 支付密码
        Map<String, Object> bankMap = loadDate(bankMapS);


        try {

            // 认证通过保存信息
            // CRM保存信息
            crmSaveInfo(bankMap);
            // ONLINE保存信息
            onlineSaveInfo(bankMap);
            // CORE保存信息
            coreSaveInfo(bankMap);
            // PAYCENTER保存信息
            paycenterSaveInfo(bankMap);
            // 创建账户
            openAccount(bankMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(">>>>>>>>>>>>>>>>新用户更新保存异常>>>>>>>>>>>>>>>>>>>>");

        }


    }


    @Autowired
    private LenderLoginService lenderLoginService;

    /**
     * 装载数据
     */

    private Map<String, Object> loadDate(Map<String, Object> paramMap) {

        logger.info("整理参数map=" + paramMap);

        Map<String, Object> bankMap = new HashMap<String, Object>(16);
        bankMap.put("loginId", paramMap.get("loginId"));
        bankMap.put("systemcode", "SYSTEM_ONLINE");
        bankMap.put("customercode", paramMap.get("customercode"));
        String idNumber = paramMap.get("idNumber") + "";
        // 真实姓名
        bankMap.put("realName", paramMap.get("realName"));
        // 银行卡号
        bankMap.put("accountNum", paramMap.get("accountNum"));
        // 身份证号
        bankMap.put("idNumber", idNumber);
        String referralCode = paramMap.get("referralCode") + "";
        String dataSource = null;
        if (bankMap.get(MagicParameterConstants.LOGINID) != null) {
            LenderLogin lenderLogin = lenderLoginService
                    .selectByPrimaryKey(Integer.parseInt(bankMap.get("loginId")
                            + ""));
            if (StringUtil.notBlank(lenderLogin.getReferralCode())
                    && !"000000".equals(lenderLogin.getReferralCode())) {
                referralCode = lenderLogin.getReferralCode();
            }
        } else {
            dataSource = String.valueOf(paramMap.get("dataSource"));
            if (dataSource == null) {
                dataSource = "WeChat";
            }
        }
        // 推荐码
        bankMap.put("referralCode", referralCode);
        //注册来源
        bankMap.put("dataSource", dataSource);
        String bankNum = paramMap.get("bankNum") + "";
        if (bankNum.length() == MagicParameterConstants.THREE_INT) {
            bankNum = "0" + bankNum;
        }
        // 发卡银行编码
        bankMap.put("bankNum", bankNum);
        // 开户省份
        bankMap.put("province", paramMap.get("province"));
        // 开户城市
        bankMap.put("city", paramMap.get("city"));
        // 支行信息
        bankMap.put("bankNumText", paramMap.get("bankInfo"));
        // 交易密码
        bankMap.put("password", Md5Util.md5(paramMap.get("password") + ""));
        bankMap.put("mobile", paramMap.get("mobile"));
        // 根据身份证解析性别，生日
        int cardLen = idNumber.length();
        int sex = 0;
        String year = null;
        String month = null;
        String day = null;
        String birth = null;
        if (cardLen == MagicParameterConstants.FIFTEEN_INT) {
            sex = Integer.parseInt(idNumber.substring(cardLen - 1, cardLen));
            year = idNumber.substring(6, 8);
            month = idNumber.substring(8, 10);
            day = idNumber.substring(10, 12);
            birth = "19" + year + "-" + month + "-" + day;
        } else if (cardLen == MagicParameterConstants.EIGHTEEN_INT) {
            sex = Integer
                    .parseInt(idNumber.substring(cardLen - 2, cardLen - 1));
            year = idNumber.substring(6, 10);
            month = idNumber.substring(10, 12);
            day = idNumber.substring(12, 14);
            birth = year + "-" + month + "-" + day;
        }
        bankMap.put("sex", sex % 2);
        bankMap.put("birth", birth);
        // 根据身份证解析性别，生日 --end
        return bankMap;
    }


    /**
     * Description: 开户操作 涉及系统：线上和核心
     *
     * @param bankMap
     * @Author kRain
     * @Create Date: 2017年10月10日 上午8:55:48
     */
    private void openAccount(Map<String, Object> bankMap) {

        if (bankMap.get(MagicParameterConstants.LOGINID) != null) {
            StringBuilder tFundAccountSql = new StringBuilder();
            tFundAccountSql.append("INSERT INTO `online`.`t_fund_account` (");
            tFundAccountSql
                    .append("`account_type`,`account_name`,`card_type`,`card_code`,`available_balance`,");
            tFundAccountSql
                    .append(" `freeze_amount`,`account_status`,`open_date`,`operate_time`");
            tFundAccountSql.append(") VALUES(");
            tFundAccountSql.append("'1','" + bankMap.get("realName")
                    + "','01','" + bankMap.get("idNumber") + "','0',");
            tFundAccountSql.append(" '0','1',now(),now());");
            commonMapper.insertBySql(tFundAccountSql.toString());
        }
        StringBuilder zwAccountSql = new StringBuilder();
        zwAccountSql.append("INSERT INTO `core`.`zw_account` (");
        zwAccountSql
                .append(" `account_name`,`card_type`,`card_code`,`third_pay_name`,`third_pay_code`,");
        zwAccountSql
                .append(" `account_type`,`account_status`,`open_date`,`create_time`");
        zwAccountSql.append(") VALUES(");
        zwAccountSql.append(" '" + bankMap.get("realName") + "','01','"
                + bankMap.get("idNumber") + "','首信易支付','1001',");
        zwAccountSql.append("'1','1',now(),now())");
        commonMapper.insertBySql(zwAccountSql.toString());
        StringBuilder zwBorrowAccountSql = new StringBuilder();
        zwBorrowAccountSql.append("INSERT INTO `core`.`zw_borrow_account` (");
        zwBorrowAccountSql
                .append("`account_num`,`card_code`,`third_pay_code`,`money`,`create_time`,`oper_time`");
        zwBorrowAccountSql.append(") VALUES(");
        zwBorrowAccountSql.append("'DK1001" + bankMap.get("idNumber") + "','"
                + bankMap.get("idNumber") + "','1001',0,now(),now());");

        commonMapper.insertBySql(zwBorrowAccountSql.toString());

        StringBuilder zwCurrentAccountSql = new StringBuilder();
        zwCurrentAccountSql
                .append("INSERT INTO `core`.`zw_current_account` (");
        zwCurrentAccountSql
                .append("`account_num`,`card_code`,`third_pay_code`,`money`,`create_time`,`oper_time`");
        zwCurrentAccountSql.append(") VALUES(");
        zwCurrentAccountSql.append("'HQ1001" + bankMap.get("idNumber")
                + "','" + bankMap.get("idNumber") + "','1001',0,now(),now());");
        commonMapper.insertBySql(zwCurrentAccountSql.toString());
        StringBuilder zwLendAccountSql = new StringBuilder();
        zwLendAccountSql.append("INSERT INTO `core`.`zw_lend_account` (");
        zwLendAccountSql
                .append("`account_num`,`card_code`,`third_pay_code`,`money`,`create_time`,`oper_time`");
        zwLendAccountSql.append(") VALUES(");
        zwLendAccountSql.append("'TZ1001" + bankMap.get("idNumber") + "','"
                + bankMap.get("idNumber") + "','1001',0,now(),now());");
        commonMapper.insertBySql(zwLendAccountSql.toString());
    }

    /**
     * Description: ONLINE保存信息
     *
     * @param bankMap
     * @Author kRain
     * @Create Date: 2017年10月9日 下午5:42:51
     */
    private void onlineSaveInfo(Map<String, Object> bankMap) {

        if (bankMap.get(MagicParameterConstants.LOGINID) == null) {
            return;
        }
        LenderDetail lenderDetail = new LenderDetail();
        lenderDetail.setLenderLoginId(Integer.parseInt(bankMap.get("loginId")
                + ""));
        lenderDetail.setRealName(bankMap.get("realName") + "");
        lenderDetail.setSex(bankMap.get("sex") + "");
        lenderDetail.setMobile(bankMap.get("mobile") + "");
        lenderDetail.setCardType(LenderConstants.ID_CARD);
        lenderDetail.setCardNum(bankMap.get("idNumber") + "");
        String birth = bankMap.get("birth") + "";
        lenderDetail.setBirthDate(DateTimeUtil.convertAsDate(birth));
        lenderDetail.setLenderStatus(LenderConstants.LENDER_STATUS_SUCCESS);
        lenderDetail
                .setCertificationStatus(LenderConstants.CERTIFICATION_STATUS_PASS);
        lenderDetail.setSystemCode(SystemConstants.SYSTEM_CODE_ONLINE);
        lenderDetail.setCreateTime(new Date());
        lenderDetail.setLenderNum(bankMap.get("customercode") + "");
        lenderDetailService.insertLenderDetail(lenderDetail);

        String key = RedisConstants.KEY_TEMP_BANK + bankMap.get("loginId");

        logger.info("redisKey=" + key);
        if (redisUtilService.chekHashkey(key)) {

            redisUtilService.delet(key);
//			LenderLoginVo llv = FastJsonUtil.toAnyType(redisUtilService.getValue(key),
//					new TypeReference<LenderLoginVo>() {
//					});
//			llv.setLenderNum(lenderDetail.getLenderNum());
//			redisUtilService.setValue(key, FastJsonUtil.toJSONString(llv));
//			redisUtilService.expire(key, 24 * 60 * 60);
        }

    }

    /**
     * Description: PAYCENTER保存信息
     *
     * @param bankMap
     * @Author kRain
     * @Create Date: 2017年10月9日 下午5:34:14
     */
    private void paycenterSaveInfo(Map<String, Object> bankMap) {
        StringBuilder payCusSql = new StringBuilder();
        payCusSql.append("INSERT INTO `paycenter`.`settle_customer` (");
        payCusSql
                .append("  `userName`,`idNo`,`realName`,`mobile`,`operTime`,`idType`");
        payCusSql.append(") VALUES(");
        payCusSql.append("  '" + bankMap.get("idNumber") + "','"
                + bankMap.get("idNumber") + "','" + bankMap.get("realName")
                + "','" + bankMap.get("mobile") + "',now(),'01')");
        commonMapper.insertBySql(payCusSql.toString());
    }

    /**
     * Description:CORE保存信息
     *
     * @param bankMap
     * @Author kRain
     * @Create Date: 2017年10月9日 下午4:04:22
     */
    private void coreSaveInfo(Map<String, Object> bankMap) {

        StringBuilder coreLenderSql = new StringBuilder();
        coreLenderSql.append("INSERT INTO `core`.`tz_lender` (");
        coreLenderSql
                .append("`system_code`,`lender_name`,`lender_num`,`card_type`,");
        coreLenderSql
                .append("`card_code`,`lender_status`,`create_time`,`flag`");
        coreLenderSql.append(") VALUES(");
        coreLenderSql.append("'" + bankMap.get("systemcode") + "','"
                + bankMap.get("realName") + "','" + bankMap.get("customercode")
                + "','01',");
        coreLenderSql.append("'" + bankMap.get("idNumber") + "','3',now(),'1'");
        coreLenderSql.append(") ;");
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("id", 0);
        map.put("sql", coreLenderSql);
        commonMapper.insertByMapReturnId(map);
        int lenderid = (Integer) map.get("id");

        StringBuilder coreBankSql = new StringBuilder();
        coreBankSql.append("INSERT INTO `core`.`jy_bank_info` (");
        coreBankSql
                .append("`province`,`city`,`real_name`,`bank_num`,`account_type`,`account_num`,`bank_info`,");
        coreBankSql
                .append("`third_status`,`verify_date`,`used_status`,`lender_id`,`system_code`,`change_flag`");
        coreBankSql.append(") VALUES(");
        coreBankSql.append("'" + bankMap.get("province") + "','"
                + bankMap.get("city") + "','" + bankMap.get("realName") + "','"
                + bankMap.get("bankNum") + "','1','"
                + bankMap.get("accountNum") + "','"
                + bankMap.get("bankNumText") + "',");
        coreBankSql.append("'3',now(),'1','" + lenderid + "','"
                + bankMap.get("systemcode") + "','0'");
        coreBankSql.append(") ;");
        commonMapper.insertBySql(coreBankSql.toString());
    }

    /**
     * Description: CRM保存信息
     *
     * @param bankMap
     * @Author kRain
     * @Create Date: 2017年10月9日 下午4:03:00
     */
    private void crmSaveInfo(Map<String, Object> bankMap) {
        String referralCode = bankMap.get("referralCode") + "";
        String salesInfo = null;
        String employeeId = null;
        String employeeName = null;
        // 客户经理团队

        //去除六个“0”的id
        if (!MagicParameterConstants.ZERO_SIX.equals(referralCode)) {

            final String deptSql = "SELECT f_ret_dept_name(t.dept_id) dept_name,employee_id employeeId,name employeeName"
                    + " from crm.ssm_employee t where t.employee_no="
                    + referralCode;
            Map<String, Object> deptMap = commonMapper
                    .findBySql(deptSql.toString());

            if (deptMap != null && !"".equals(deptMap)) {
                salesInfo = "'" + deptMap.get("dept_name") + "'";
                employeeId = deptMap.get("employeeId") + "";
                employeeName = "'" + deptMap.get("employeeName") + "'";
            }

        }
        StringBuilder crmsql = new StringBuilder();
        crmsql.append("INSERT INTO `crm`.`crm_customer` (`name`,`customer_code`,`sex`,");
        crmsql.append(" `certificate_code`,`certificate_num`,`birthday`,`tel`,");
        crmsql.append("`account_time`,`origine`,`origine_remark`,`state_name`,");
        crmsql.append("  `state_code`,`referrer_id`,`referrer_name`,`sales_info`,");
        crmsql.append("  `employee_id`,`employee_name`,`remark`,`create_time`,`data_source`");
        crmsql.append(") VALUES(");
        crmsql.append("'" + bankMap.get("realName") + "','"
                + bankMap.get("customercode") + "','" + bankMap.get("sex")
                + "',");
        crmsql.append(" '01','" + bankMap.get("idNumber") + "','"
                + bankMap.get("birth") + "','" + bankMap.get("mobile") + "',");
        crmsql.append("now(),'" + bankMap.get("") + "','" + bankMap.get("")
                + "','成功',");
        crmsql.append(" '12'," + employeeId + "," + employeeName + ","
                + salesInfo + ",");
        crmsql.append("  " + employeeId + "," + employeeName + ",'"
                + bankMap.get("") + "',now(),'" + bankMap.get("dataSource") + "'");
        crmsql.append(" ) ;");
        commonMapper.insertBySql(crmsql.toString());
    }



    @Autowired
    private LenderDetailMapper lenderDetailMapper;

    /**
     * 会员激活
     *
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/16 19:18
     */
    @Override
    public void updataBankInfo(Map<String, Object> bankMap) {


        LenderDetail detail = lenderDetailMapper.findLenderDetailInfoByLenderNum(String.valueOf(bankMap.get("lenderNum")));

        LenderLogin login = lenderLoginMapper.fundObjectByUserNum(String.valueOf(bankMap.get("lenderNum")));

        Map<String, Object> bankInfoMap = null;
        if(login != null && MagicParameterConstants.ONE.equals(login.getIscompany())){
            //企业用户激活

            bankInfoMap  = bankInfoMapper
                    .getCompanyBankInfoByLenderNum(detail.getLenderNum());

        }else {
            bankInfoMap  = bankInfoMapper
                    .getLenderInfoByLenderNum(detail.getLenderNum());

        }
            try {

                logger.info(">>>>>>>>>>>>>>>>[getLenderNum={}]",
                        detail.getLenderNum());

                logger.info(">>>>>>>>>>>>>>>>[bankinfoMap={}]", bankInfoMap);

                // 判断银行卡是否更换
                if (((String) bankMap.get(MagicParameterConstants.ACCOUNTNUM))
                        .equals((String) bankInfoMap.get("accountNum"))) {
                    BankInfo bankIn = new BankInfo();
                    bankIn.setBankId((Integer) bankInfoMap.get("bankId"));
                    // 修改银行卡可用
                    bankIn.setThirdStatus("3");
                    bankInfoMapper.updateByPrimaryKeySelective(bankIn);
                    // 未更换修改用户状态
                    Map<String, Object> paramMap = new HashMap<String, Object>(16);
                    paramMap.put("lenderStatus", "3");

                    paramMap.put("certificationStatus", "2");
                    paramMap.put("lenderNum", detail.getLenderNum());

                    lenderDetailService.updateUserInfo(paramMap);



                } else {

                    SystemDict systemDict = new SystemDict();
                    systemDict.setDictType("THIRD_BANK_KH");
                    systemDict.setRemark(String.valueOf(bankMap.get("bankcode")));
                    systemDict = systemDictMapper.selectDictByremak(systemDict);

                    if(systemDict == null){

                        logger.info("=================会员激活失败，字典表没有查询到对应的开户行信息===========");


                    }

                    // 更换，更新账户银行卡号和类型
                    BankInfo bankIn = new BankInfo();
                    bankIn.setBankId((Integer) bankInfoMap.get("bankId"));
                    // 银行卡号
                    bankIn.setAccountNum((String) bankMap.get("accountNum"));
                    // 账户类型(1、卡；2、折)
                    bankIn.setAccountType("1");
                    // 支行信息
                    bankIn.setBankInfo((String) bankMap.get("bankInfo"));
                    // 银行代码
                    bankIn.setBankNum(systemDict.getDictCode());
                    // 开户行所在城市
                    bankIn.setCity((String) bankMap.get("city"));
                    // 修改银行卡可用
                    bankIn.setThirdStatus("3");
// 开户行所在省份
                    bankIn.setProvince((String) bankMap.get("province"));
                    // 真实姓名
                    bankIn.setRealName(detail.getRealName());
                    bankInfoMapper.updateByPrimaryKeySelective(bankIn);
                    // 修改银行卡信息完毕，修改用户状态
                    Map<String, Object> paramMap = new HashMap<String, Object>(16);
                    paramMap.put("lenderStatus", "3");

                    paramMap.put("certificationStatus", "2");
                    paramMap.put("lenderNum", detail.getLenderNum());
                    lenderDetailService.updateUserInfo(paramMap);


                }

            } catch (Exception e) {

                e.printStackTrace();
            }







        // 删除redis数据
        // bank json

        try {

            if (bankMap != null && null != detail) {
                String key = RedisConstants.KEY_LENDER_BANK
                        + String.valueOf(detail.getLenderNum());
                redisUtilService.delet(key);
            }
        } catch (Exception e) {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>redis异常》》》》》》》》》》》》》》》》");
        }


    }


    /**
     * Description: 老用户更新信息方法
     *
     * @return
     * @Author liujunhan
     * @Create Date: 2017年7月17日 下午5:13:14
     */
    private boolean updataBankInfo(LenderDetail detail,
                                   Map<String, Object> bankMap) {
        // 查询银行卡信息

        boolean a = false;

        try {

            logger.info(">>>>>>>>>>>>>>>>[getLenderNum={}]",
                    detail.getLenderNum());
            Map<String, Object> bankInfoMap = bankInfoMapper
                    .getLenderInfoByLenderNum(detail.getLenderNum());

            logger.info(">>>>>>>>>>>>>>>>[bankinfoMap={}]", bankInfoMap);

            // 判断银行卡是否更换
            if (((String) bankMap.get(MagicParameterConstants.ACCOUNTNUM))
                    .equals((String) bankInfoMap.get("accountNum"))) {
                BankInfo bankIn = new BankInfo();
                bankIn.setBankId((Integer) bankInfoMap.get("bankId"));
                // 修改银行卡可用
                bankIn.setThirdStatus("3");
                bankInfoMapper.updateByPrimaryKeySelective(bankIn);
                // 未更换修改用户状态
                Map<String, Object> paramMap = new HashMap<String, Object>(16);
                paramMap.put("lenderStatus", "3");

                paramMap.put("certificationStatus", "2");
                paramMap.put("lenderNum", detail.getLenderNum());

                lenderDetailService.updateUserInfo(paramMap);

                a = true;

            } else {
                // 更换，更新账户银行卡号和类型
                BankInfo bankIn = new BankInfo();
                bankIn.setBankId((Integer) bankInfoMap.get("bankId"));
                // 银行卡号
                bankIn.setAccountNum((String) bankMap.get("accountNum"));
                // 账户类型(1、卡；2、折)
                bankIn.setAccountType((String) bankMap.get("accountType"));
                // 支行信息
                bankIn.setBankInfo((String) bankMap.get("bankInfo"));
                // 银行代码
                bankIn.setBankNum((String) bankMap.get("bankNum"));
                // 开户行所在城市
                bankIn.setCity((String) bankMap.get("city"));
                // 修改银行卡可用
                bankIn.setThirdStatus("3");
                // 开户行所在省份
                bankIn.setProvince((String) bankMap.get("province"));
                // 真实姓名
                bankIn.setRealName((String) bankMap.get("realName"));
                bankInfoMapper.updateByPrimaryKeySelective(bankIn);
                // 修改银行卡信息完毕，修改用户状态
                Map<String, Object> paramMap = new HashMap<String, Object>(16);
                paramMap.put("lenderStatus", "3");

                paramMap.put("certificationStatus", "2");
                paramMap.put("lenderNum", detail.getLenderNum());
                lenderDetailService.updateUserInfo(paramMap);

                a = true;
            }

        } catch (Exception e) {
            a = false;
            e.printStackTrace();
        } finally {

        }

        // 删除redis数据
        // bank json

        try {

            if (bankMap != null && null != detail) {
                String key = RedisConstants.KEY_LENDER_BANK
                        + String.valueOf(detail.getLenderNum());
                redisUtilService.delet(key);
            }
        } catch (Exception e) {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>redis异常》》》》》》》》》》》》》》》》");
        }
        return a;

    }


    @Override
    public void doLmRegist(Map<String, Object> bankMapS) {
        // 组装参数 真实姓名 身份证号 银行卡号 预留手机号 开户行 开户省 开户支行 支付密码

        LenderDetail lenderDetail = lenderDetailMapper.findLenderDetailInfoByLenderNum(String.valueOf(bankMapS.get("lenderNum")));

        if (lenderDetail != null && MagicParameterConstants.TWO.equals(lenderDetail.getCertificationStatus())) {
            return;
        }

        Map<String, Object> bankMap = loadLmDate(bankMapS);
        ResponsEntity ent = new ResponsEntity();
        logger.info("===================>懒猫认证成功");

        // 判断老用户
        if (lenderDetail == null
                || !"6".equals(lenderDetail.getLenderStatus())) {

            try {

                // 认证通过保存信息
                // CRM保存信息
                crmSaveInfo(bankMap);
                // ONLINE保存信息
                onlineSaveInfo(bankMap);
                // CORE保存信息
                coreSaveInfo(bankMap);
                // PAYCENTER保存信息
                paycenterSaveInfo(bankMap);
                // 创建账户
                openAccount(bankMap);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info(">>>>>>>>>>>>>>>>新用户更新保存异常>>>>>>>>>>>>>>>>>>>>");
                ent.setRespCode("1111");
                ent.setRespDesc("操作失败请联系客服！");
            }

        } else {
            // 是老用户
            logger.info(">>>>>>>>>>>>>>>>老用户更新开始>>>>>>>>>>>>>>>>>>>>");
            updataBankInfo(lenderDetail, bankMapS);
        }
    }


    /**
     * Description:装载数据
     *
     * @author 刘俊汉
     * @param null
     * @date 2018/5/14 15:48
     * @return
     */
    private Map<String, Object> loadLmDate(Map<String, Object> paramMap) {
        JSONObject jsonObject = JSON.parseObject(String.valueOf(paramMap.get("respData")));
        System.out.println(JSON.toJSONString(jsonObject));
        Map<String, Object> jsonMap = JSON.parseObject(JSON.toJSONString(jsonObject), Map.class);
        Map<String, Object> bankMap = jsonMap;
        bankMap.put("loginId", paramMap.get("loginId"));
        bankMap.put("systemcode", "SYSTEM_ONLINE");
        String idNumber = jsonMap.get("idCardNo") + "";
        // 真实姓名
        bankMap.put("realName", jsonMap.get("realName"));
        if (JSON.toJSONString(jsonMap.get(MagicParameterConstants.BANKCARDNO)).contains(MagicParameterConstants.ASTERISK)) {
            String bankString = JSON.toJSONString(jsonMap.get("bankcardNo"));
            bankMap.put("accountNum", "111122223333" + bankString.substring(bankString.length() - 5, bankString.length()));
        } else {
            // 银行卡号
            bankMap.put("accountNum", jsonMap.get("bankcardNo"));
        }
        //142329********1849
        if (idNumber.contains(MagicParameterConstants.ASTERISK)) {
            bankMap.put("idNumber", idNumber.substring(0, 6) + "00000000" + idNumber.substring(idNumber.length() - 5, idNumber.length()));
        } else {
            // 身份证号
            bankMap.put("idNumber", idNumber);
        }
        String referralCode = paramMap.get("referralCode") + "";
        String dataSource = null;
        if (bankMap.get(MagicParameterConstants.LOGINID) != null) {
            LenderLogin lenderLogin = lenderLoginService
                    .selectByPrimaryKey(Integer.parseInt(bankMap.get("loginId")
                            + ""));
            if (StringUtil.notBlank(lenderLogin.getReferralCode())
                    && !"000000".equals(lenderLogin.getReferralCode())) {
                referralCode = lenderLogin.getReferralCode();
            }
            bankMap.put("customercode", lenderLogin.getLenderNum());
        } else {
            dataSource = String.valueOf(bankMap.get("dataSource"));
            if (dataSource == null) {
                dataSource = "WeChat";
            }
        }
        // 推荐码
        bankMap.put("referralCode", referralCode);
        //注册来源
        bankMap.put("dataSource", dataSource);


        String bankNum = paramMap.get("bankNum") + "";


        //转换银行编码
        SystemDict systemDict = new SystemDict();
        systemDict.setRemark(bankNum);
        systemDict.setDictType("THIRD_BANK_KH");
        systemDict = systemDictMapper.selectDictByremak(systemDict);
        if(null != systemDict){
            // 发卡银行编码
            bankMap.put("bankNum", systemDict.getDictCode());
        }
// 开户省份
        bankMap.put("province", paramMap.get("province"));
        // 开户城市
        bankMap.put("city", paramMap.get("city"));
        // 支行信息
        bankMap.put("bankNumText", paramMap.get("bankNumText"));
        //bankMap.put("password", Md5Util.md5(bankMap.get("password") + "")); // 交易密码
        bankMap.put("mobile", jsonMap.get("mobile"));
        // 根据身份证解析性别，生日
        int cardLen = idNumber.length();
        int sex = 0;
        String year = null;
        String month = null;
        String day = null;
        String birth = null;
        if (cardLen == MagicParameterConstants.FIFTEEN_INT) {
            if (idNumber.contains(MagicParameterConstants.ASTERISK)) {
                sex = 2;
                birth = "2018-4-20";
            } else {
                sex = Integer.parseInt(idNumber.substring(cardLen - 1, cardLen));
                year = idNumber.substring(6, 8);
                month = idNumber.substring(8, 10);
                day = idNumber.substring(10, 12);
                birth = "19" + year + "-" + month + "-" + day;
            }
        } else if (cardLen == MagicParameterConstants.EIGHTEEN_INT) {
            if (idNumber.contains(MagicParameterConstants.ASTERISK)) {
                sex = 2;
                birth = "2018-4-20";
            } else {
                sex = Integer
                        .parseInt(idNumber.substring(cardLen - 2, cardLen - 1));
                year = idNumber.substring(6, 10);
                month = idNumber.substring(10, 12);
                day = idNumber.substring(12, 14);
                birth = year + "-" + month + "-" + day;
            }
        }
        bankMap.put("sex", sex % 2);
        bankMap.put("birth", birth);
        // 根据身份证解析性别，生日 --end
        return bankMap;
    }



    @Override
    public void updataBank(String lenderNum,String thirdStatus,String errorMessage){

        Map<String, Object> bankInfoMap = bankInfoMapper
                .getLenderInfoByLenderNum(lenderNum);
if(null == bankInfoMap){

    bankInfoMap= bankInfoMapper.getCompanyBankInfoByLenderNum(lenderNum);
}

        logger.info(">>>>>>>>>>>>>>>>[bankinfoMap={}]", bankInfoMap);

        BankInfo bankIn = new BankInfo();
        bankIn.setBankId((Integer) bankInfoMap.get("bankId"));
        // 修改银行卡可用
        bankIn.setThirdStatus(thirdStatus);

        if(null != errorMessage){
            bankIn.setFailReason(errorMessage);

        }

        bankInfoMapper.updateByPrimaryKeySelective(bankIn);

    }
}
