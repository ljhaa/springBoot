package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/4/19.
 */

import java.io.Serializable;

/**
 * 提现对账实体
 *
 * @author 刘俊汉
 * @create 2018-04-19 20:21
 **/
public class CheckWithdrawEntity implements Serializable{


    /**
     * 提现时间
     */
    private String   withdrawalTime;
    /**
     *平台商编
     */
    private String   platformNo;
    /**
     *平台请求流水号
     */
    private String   platformRequestsNo;
    /**
     *订单号
     */
    private String   orderNumber;
    /**
     *业务类型
     */
    private String   businessType;
    /**
     *金额
     */
    private String   amount;
    /**
     *币种
     */
    private String   currency;
    /**
     *会员编号
     */
    private String   memberNO;
    /**
     *平台用户编号
     */
    private String   platformUserNumber;
    /**
     *银行卡号
     */
    private String   cardCode;
    /**
     *银行编码
     */
    private String   bankCode;
    /**
     *到账金额
     */
    private String   arrivalAmount;
    /**
     *备注
     */
    private String   remark;
    /**
     *提现状态
     */
    private String   withdrawalStatus;
    /**
     *提现方式
     */
    private String   withdrawalWay;
    /**
     *垫资金额
     */
    private String   amountMat;
    /**
     *出款类型
     */
    private String   moneyType;
    /**
     *提现类型
     */
    private String   withdrawalType;


    public CheckWithdrawEntity() {
    }


    public CheckWithdrawEntity(String withdrawalTime, String platformNo, String platformRequestsNo, String orderNumber, String businessType, String amount, String currency, String memberNO, String platformUserNumber, String cardCode, String bankCode, String arrivalAmount, String remark, String withdrawalStatus, String withdrawalWay, String amountMat, String moneyType, String withdrawalType) {
        this.withdrawalTime = withdrawalTime;
        this.platformNo = platformNo;
        this.platformRequestsNo = platformRequestsNo;
        this.orderNumber = orderNumber;
        this.businessType = businessType;
        this.amount = amount;
        this.currency = currency;
        this.memberNO = memberNO;
        this.platformUserNumber = platformUserNumber;
        this.cardCode = cardCode;
        this.bankCode = bankCode;
        this.arrivalAmount = arrivalAmount;
        this.remark = remark;
        this.withdrawalStatus = withdrawalStatus;
        this.withdrawalWay = withdrawalWay;
        this.amountMat = amountMat;
        this.moneyType = moneyType;
        this.withdrawalType = withdrawalType;
    }

    public CheckWithdrawEntity(String[] str) {
        this.withdrawalTime = str[0];
        this.platformNo = str[1];
        this.platformRequestsNo = str[2];
        this.orderNumber = str[3];
        this.businessType = str[4];
        this.amount = str[5];
        this.currency = str[6];
        this.memberNO = str[7];
        this.platformUserNumber = str[8];
        this.cardCode = str[9];
        this.bankCode = str[10];
        this.arrivalAmount = str[11];
        this.remark = str[12];
        this.withdrawalStatus = str[13];
        this.withdrawalWay = str[14];
        this.amountMat = str[15];
        this.moneyType = str[16];
        this.withdrawalType = str[17];
    }

    @Override
    public String toString() {
        return "CheckWithdrawEntity{" +
                "withdrawalTime='" + withdrawalTime + '\'' +
                ", platformNo='" + platformNo + '\'' +
                ", platformRequestsNo='" + platformRequestsNo + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", businessType='" + businessType + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", memberNO='" + memberNO + '\'' +
                ", platformUserNumber='" + platformUserNumber + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", arrivalAmount='" + arrivalAmount + '\'' +
                ", remark='" + remark + '\'' +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                ", withdrawalWay='" + withdrawalWay + '\'' +
                ", amountMat='" + amountMat + '\'' +
                ", moneyType='" + moneyType + '\'' +
                ", withdrawalType='" + withdrawalType + '\'' +
                '}';
    }

    public String getWithdrawalTime() {
        return withdrawalTime;
    }

    public void setWithdrawalTime(String withdrawalTime) {
        this.withdrawalTime = withdrawalTime;
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getPlatformRequestsNo() {
        return platformRequestsNo;
    }

    public void setPlatformRequestsNo(String platformRequestsNo) {
        this.platformRequestsNo = platformRequestsNo;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(String arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(String withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public String getWithdrawalWay() {
        return withdrawalWay;
    }

    public void setWithdrawalWay(String withdrawalWay) {
        this.withdrawalWay = withdrawalWay;
    }

    public String getAmountMat() {
        return amountMat;
    }

    public void setAmountMat(String amountMat) {
        this.amountMat = amountMat;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }
}
