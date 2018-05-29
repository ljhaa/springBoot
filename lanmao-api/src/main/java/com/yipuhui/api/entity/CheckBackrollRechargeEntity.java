package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/4/19.
 */

import java.io.Serializable;

/**
 * 提现失败回充值对账实体
 *
 * @author 刘俊汉
 * @create 2018-04-19 20:53
 **/
public class CheckBackrollRechargeEntity implements Serializable {

    /**
     * 充值时间
     */
    private String  payTime;
    /**
     *平台商编
     */
    private String  platformNo;
    /**
     *支付公司代码
     */
    private String  payCompanyCode;
    /**
     *回充请求流水号
     */
    private String  rechargeRequestsNo;
    /**
     *回充订单编号
     */
    private String  rechargeOrderNumber;
    /**
     *业务类型
     */
    private String  businessType;
    /**
     *金额
     */
    private String  amount;
    /**
     *币种
     */
    private String  currency;
    /**
     *会员编号
     */
    private String  memberNO;
    /**
     *平台用户编号
     */
    private String  platformUserNumber;
    /**
     *支付方式
     */
    private String  paymentMode;
    /**
     *提现到账金额
     */
    private String  withdrawalArrivalAmount;
    /**
     *提现佣金
     */
    private String  withdrawalBrokerage;
    /**
     *备注
     */
    private String  remark;
    /**
     *提现请求流水号
     */
    private String  withdrawalRequestsNo;


    public CheckBackrollRechargeEntity() {
    }

    public CheckBackrollRechargeEntity(String payTime, String platformNo, String payCompanyCode, String rechargeRequestsNo, String rechargeOrderNumber, String businessType, String amount, String currency, String memberNO, String platformUserNumber, String paymentMode, String withdrawalArrivalAmount, String withdrawalBrokerage, String remark, String withdrawalRequestsNo) {
        this.payTime = payTime;
        this.platformNo = platformNo;
        this.payCompanyCode = payCompanyCode;
        this.rechargeRequestsNo = rechargeRequestsNo;
        this.rechargeOrderNumber = rechargeOrderNumber;
        this.businessType = businessType;
        this.amount = amount;
        this.currency = currency;
        this.memberNO = memberNO;
        this.platformUserNumber = platformUserNumber;
        this.paymentMode = paymentMode;
        this.withdrawalArrivalAmount = withdrawalArrivalAmount;
        this.withdrawalBrokerage = withdrawalBrokerage;
        this.remark = remark;
        this.withdrawalRequestsNo = withdrawalRequestsNo;
    }


    public CheckBackrollRechargeEntity(String [] str) {
        this.payTime = str[0];
        this.platformNo = str[1];
        this.payCompanyCode = str[2];
        this.rechargeRequestsNo = str[3];
        this.rechargeOrderNumber = str[4];
        this.businessType = str[5];
        this.amount = str[6];
        this.currency = str[7];
        this.memberNO = str[8];
        this.platformUserNumber = str[9];
        this.paymentMode = str[10];
        this.withdrawalArrivalAmount = str[11];
        this.withdrawalBrokerage = str[12];
        this.remark = str[13];
        this.withdrawalRequestsNo =str[14];
    }

    @Override
    public String toString() {
        return "CheckBackrollRechargeEntity{" +
                "payTime='" + payTime + '\'' +
                ", platformNo='" + platformNo + '\'' +
                ", payCompanyCode='" + payCompanyCode + '\'' +
                ", rechargeRequestsNo='" + rechargeRequestsNo + '\'' +
                ", rechargeOrderNumber='" + rechargeOrderNumber + '\'' +
                ", businessType='" + businessType + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", memberNO='" + memberNO + '\'' +
                ", platformUserNumber='" + platformUserNumber + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", withdrawalArrivalAmount='" + withdrawalArrivalAmount + '\'' +
                ", withdrawalBrokerage='" + withdrawalBrokerage + '\'' +
                ", remark='" + remark + '\'' +
                ", withdrawalRequestsNo='" + withdrawalRequestsNo + '\'' +
                '}';
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getPayCompanyCode() {
        return payCompanyCode;
    }

    public void setPayCompanyCode(String payCompanyCode) {
        this.payCompanyCode = payCompanyCode;
    }

    public String getRechargeRequestsNo() {
        return rechargeRequestsNo;
    }

    public void setRechargeRequestsNo(String rechargeRequestsNo) {
        this.rechargeRequestsNo = rechargeRequestsNo;
    }

    public String getRechargeOrderNumber() {
        return rechargeOrderNumber;
    }

    public void setRechargeOrderNumber(String rechargeOrderNumber) {
        this.rechargeOrderNumber = rechargeOrderNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMemberNO() {
        return memberNO;
    }

    public void setMemberNO(String memberNO) {
        this.memberNO = memberNO;
    }

    public String getPlatformUserNumber() {
        return platformUserNumber;
    }

    public void setPlatformUserNumber(String platformUserNumber) {
        this.platformUserNumber = platformUserNumber;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getWithdrawalArrivalAmount() {
        return withdrawalArrivalAmount;
    }

    public void setWithdrawalArrivalAmount(String withdrawalArrivalAmount) {
        this.withdrawalArrivalAmount = withdrawalArrivalAmount;
    }

    public String getWithdrawalBrokerage() {
        return withdrawalBrokerage;
    }

    public void setWithdrawalBrokerage(String withdrawalBrokerage) {
        this.withdrawalBrokerage = withdrawalBrokerage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWithdrawalRequestsNo() {
        return withdrawalRequestsNo;
    }

    public void setWithdrawalRequestsNo(String withdrawalRequestsNo) {
        this.withdrawalRequestsNo = withdrawalRequestsNo;
    }
}
