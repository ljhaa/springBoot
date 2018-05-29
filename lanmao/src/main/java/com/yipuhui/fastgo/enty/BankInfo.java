package com.yipuhui.fastgo.enty;

import java.util.Date;

/**
 * 
 *
 * Description: 银行卡信息model
 *
 * @author chengzhichao 
 * @version 1.0
 * <pre>
 * Modification History: 
 *  Date           Author        Version       Description 
 * ------------------------------------------------------------------ 
 * 2015年4月25日      chengzhichao       1.0         1.0 Version 
 * </pre>
 */
public class BankInfo {
	
	/**
	 * 主键id
	 */
    private Integer bankId;

    /**
	 * 开户行所在省份
	 */
    private String province;

    /**
	 * 开户行所在城市
	 */
    private String city;

    /**
	 * 真实姓名
	 */
    private String realName;

    /**
	 * 银行代码
	 */
    private String bankNum;

    /**
	 * 账户类型(1、卡；2、折)
	 */
    private String accountType;

    /**
	 * 银行卡号
	 */
    private String accountNum;

    /**
	 * 支行信息
	 */
    private String bankInfo;

    /**
	 * 三方验证银行卡状态（未处理1\处理中2\验证通过3\验证失败4）
	 */
    private String thirdStatus;

    /**
	 * 验卡时间
	 */
    private Date verifyDate;

    /**
	 * 使用状态(参照字典0不可用/1可用)
	 */
    private String usedStatus;

    /**
	 * 验卡失败原因
	 */
    private String failReason;

    /**
	 * 外键,参照tz_lender表主键
	 */
    private Integer lenderId;

    /**
	 * 外键,参照qd_channel表主键
	 */
    private Integer channelId;
    /**
     * 系统编码提示
     */
    private String systemCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    public String getThirdStatus() {
        return thirdStatus;
    }

    public void setThirdStatus(String thirdStatus) {
        this.thirdStatus = thirdStatus;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getUsedStatus() {
        return usedStatus;
    }

    public void setUsedStatus(String usedStatus) {
        this.usedStatus = usedStatus;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "BankInfo{" +
                "bankId=" + bankId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", realName='" + realName + '\'' +
                ", bankNum='" + bankNum + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", bankInfo='" + bankInfo + '\'' +
                ", thirdStatus='" + thirdStatus + '\'' +
                ", verifyDate=" + verifyDate +
                ", usedStatus='" + usedStatus + '\'' +
                ", failReason='" + failReason + '\'' +
                ", lenderId=" + lenderId +
                ", channelId=" + channelId +
                ", systemCode='" + systemCode + '\'' +
                '}';
    }
}