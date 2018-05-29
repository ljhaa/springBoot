package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/4/19.
 */

import java.io.Serializable;

/**
 * 交易对账实体
 *
 * @author 刘俊汉
 * @create 2018-04-19 20:38
 **/
public class CheckTransactionEntity implements Serializable {


    /**
     * 发生时间
     */
    private String  occurrenceTime;
    /**
     *平台商编
     */
    private String  platformNo;
    /**
     *平台请求流水号
     */
    private String  platformRequestsNo;
    /**
     *订单号
     */
    private String  orderNumber;
    /**
     *业务类型
     */
    private String  businessType;
    /**
     *金额
     */
    private String  amount;
    /**
     *利息金额
     */
    private String  interestAmount;
    /**
     *币种
     */
    private String  currency;
    /**
     *发起方会员编号
     */
    private String  initiatorMemberNo;
    /**
     *发起方平台用户编号
     */
    private String  initiatorPlatformUserNumber;
    /**
     *接收方会员编号
     */
    private String  recipientMemberNo ;
    /**
     *接收方平台用户编号
     */
    private String  recipientPlatformUserNumber;
    /**
     *标的号
     */
    private String  loanAgreementNumber;
    /**
     *原订单号
     */
    private String  originalOrderNumber;
    /**
     *备注
     */
    private String  remark;
    /**
     *债权份额
     */
    private String  shareNumber;
    /**
     *商户自定义参数
     */
    private String  definedParameter;

    public CheckTransactionEntity() {
    }

    public CheckTransactionEntity(String occurrenceTime, String platformNo, String platformRequestsNo, String orderNumber, String businessType, String amount, String interestAmount, String currency, String initiatorMemberNo, String initiatorPlatformUserNumber, String recipientMemberNo, String recipientPlatformUserNumber, String loanAgreementNumber, String originalOrderNumber, String remark, String shareNumber, String definedParameter) {
        this.occurrenceTime = occurrenceTime;
        this.platformNo = platformNo;
        this.platformRequestsNo = platformRequestsNo;
        this.orderNumber = orderNumber;
        this.businessType = businessType;
        this.amount = amount;
        this.interestAmount = interestAmount;
        this.currency = currency;
        this.initiatorMemberNo = initiatorMemberNo;
        this.initiatorPlatformUserNumber = initiatorPlatformUserNumber;
        this.recipientMemberNo = recipientMemberNo;
        this.recipientPlatformUserNumber = recipientPlatformUserNumber;
        this.loanAgreementNumber = loanAgreementNumber;
        this.originalOrderNumber = originalOrderNumber;
        this.remark = remark;
        this.shareNumber = shareNumber;
        this.definedParameter = definedParameter;
    }


    public CheckTransactionEntity(String[] str) {

        System.out.println(str.length);
        this.occurrenceTime = str[0];
        this.platformNo = str[1];
        this.platformRequestsNo = str[2];
        this.orderNumber = str[3];
        this.businessType = str[4];
        this.amount = str[5];
        this.interestAmount = str[6];
        this.currency = str[7];
        this.initiatorMemberNo = str[8];
        this.initiatorPlatformUserNumber = str[9];
        this.recipientMemberNo = str[10];
        this.recipientPlatformUserNumber = str[11];
        this.loanAgreementNumber = str[12];
        this.originalOrderNumber = str[13];
        this.remark = str[14];
        this.shareNumber = str[15];
        this.definedParameter = str[16];
    }

    @Override
    public String toString() {
        return "CheckTransactionEntity{" +
                "occurrenceTime='" + occurrenceTime + '\'' +
                ", platformNo='" + platformNo + '\'' +
                ", platformRequestsNo='" + platformRequestsNo + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", businessType='" + businessType + '\'' +
                ", amount='" + amount + '\'' +
                ", interestAmount='" + interestAmount + '\'' +
                ", currency='" + currency + '\'' +
                ", initiatorMemberNo='" + initiatorMemberNo + '\'' +
                ", initiatorPlatformUserNumber='" + initiatorPlatformUserNumber + '\'' +
                ", recipientMemberNo='" + recipientMemberNo + '\'' +
                ", recipientPlatformUserNumber='" + recipientPlatformUserNumber + '\'' +
                ", loanAgreementNumber='" + loanAgreementNumber + '\'' +
                ", originalOrderNumber='" + originalOrderNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", shareNumber='" + shareNumber + '\'' +
                ", definedParameter='" + definedParameter + '\'' +
                '}';
    }

    public String getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
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

    public String getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(String interestAmount) {
        this.interestAmount = interestAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInitiatorMemberNo() {
        return initiatorMemberNo;
    }

    public void setInitiatorMemberNo(String initiatorMemberNo) {
        this.initiatorMemberNo = initiatorMemberNo;
    }

    public String getInitiatorPlatformUserNumber() {
        return initiatorPlatformUserNumber;
    }

    public void setInitiatorPlatformUserNumber(String initiatorPlatformUserNumber) {
        this.initiatorPlatformUserNumber = initiatorPlatformUserNumber;
    }

    public String getRecipientMemberNo() {
        return recipientMemberNo;
    }

    public void setRecipientMemberNo(String recipientMemberNo) {
        this.recipientMemberNo = recipientMemberNo;
    }

    public String getRecipientPlatformUserNumber() {
        return recipientPlatformUserNumber;
    }

    public void setRecipientPlatformUserNumber(String recipientPlatformUserNumber) {
        this.recipientPlatformUserNumber = recipientPlatformUserNumber;
    }

    public String getLoanAgreementNumber() {
        return loanAgreementNumber;
    }

    public void setLoanAgreementNumber(String loanAgreementNumber) {
        this.loanAgreementNumber = loanAgreementNumber;
    }

    public String getOriginalOrderNumber() {
        return originalOrderNumber;
    }

    public void setOriginalOrderNumber(String originalOrderNumber) {
        this.originalOrderNumber = originalOrderNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(String shareNumber) {
        this.shareNumber = shareNumber;
    }

    public String getDefinedParameter() {
        return definedParameter;
    }

    public void setDefinedParameter(String definedParameter) {
        this.definedParameter = definedParameter;
    }
}
