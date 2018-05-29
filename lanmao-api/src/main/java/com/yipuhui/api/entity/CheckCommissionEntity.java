package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/5/22.
 */

import java.io.Serializable;

/**
 * 分佣对账实体类
 *
 * @author 刘俊汉
 * @create 2018-05-22 15:56
 **/
public class CheckCommissionEntity implements Serializable{



    /**
     * 扣款时间
     */
    private String  occurrenceTime;
    /**
     * 平台商编
     */
    private String  platformNo;
    /**
     * 订单号
     */
    private String  orderNumber;
    /**
     * 业务类型
     */
    private String  businessType;
    /**
     *发起方平台用户编号
     */
    private String  initiatorPlatformUserNumber;
    /**
     * 接收方平台用户编号
     */
    private String  recipientPlatformUserNumber;
    /**
     * 金额
     */
    private String  amount;
    /**
     * 币种
     */
    private String  currency;
    /**
     * 标的号
     */
    private String  loanAgreementNumber;
    /**
     * 备注
     */
    private String  remark;
    /**
     * 请求流水号
     */
    private String  platformRequestsNo;

    public CheckCommissionEntity() {
    }


    public CheckCommissionEntity(String [] str) {
        this.occurrenceTime = str[0];
        this.platformNo = str[1];
        this.orderNumber = str[2];
        this.businessType = str[3];
        this.initiatorPlatformUserNumber = str[4];
        this.recipientPlatformUserNumber = str[5];
        this.amount = str[6];
        this.currency = str[7];
        this.loanAgreementNumber = str[8];
        this.remark = str[9];
        this.platformRequestsNo = str[10];
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

    public String getInitiatorPlatformUserNumber() {
        return initiatorPlatformUserNumber;
    }

    public void setInitiatorPlatformUserNumber(String initiatorPlatformUserNumber) {
        this.initiatorPlatformUserNumber = initiatorPlatformUserNumber;
    }

    public String getRecipientPlatformUserNumber() {
        return recipientPlatformUserNumber;
    }

    public void setRecipientPlatformUserNumber(String recipientPlatformUserNumber) {
        this.recipientPlatformUserNumber = recipientPlatformUserNumber;
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

    public String getLoanAgreementNumber() {
        return loanAgreementNumber;
    }

    public void setLoanAgreementNumber(String loanAgreementNumber) {
        this.loanAgreementNumber = loanAgreementNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPlatformRequestsNo() {
        return platformRequestsNo;
    }

    public void setPlatformRequestsNo(String platformRequestsNo) {
        this.platformRequestsNo = platformRequestsNo;
    }
}
