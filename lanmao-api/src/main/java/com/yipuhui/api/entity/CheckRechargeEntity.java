package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/4/19.
 */

import java.io.Serializable;

/**
 * 充值对账文件实体
 *
 * @author 刘俊汉
 * @create 2018-04-19 20:08
 **/
public class CheckRechargeEntity implements Serializable {


    /**
     *充值时间
     */
    private String   payTime;
    /**
     *平台商编
     */
    private String   platformNo;
    /**
     *支付公司代码
     */
    private String   payCompanyCode;
    /**
     *平台请求流水号
     */
    private String   platformRequestsNo;
    /**
     *充值订单编号
     */
    private String   rechargeNumber;
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
     *支付方式
     */
    private String   paymentMode;
    /**
     *到账金额
     */
    private String   arrivalAmount;
    /**
     *备注
     */
    private String   remark;
    /**
     *支付公司订单号
     */
    private String   orderNumberPayCompany;


    public CheckRechargeEntity() {
    }


    public CheckRechargeEntity(String payTime, String platformNo, String payCompanyCode, String platformRequestsNo, String rechargeNumber, String businessType, String amount, String currency, String memberNO, String platformUserNumber, String cardCode, String bankCode, String paymentMode, String arrivalAmount, String remark, String orderNumberPayCompany) {
        this.payTime = payTime;
        this.platformNo = platformNo;
        this.payCompanyCode = payCompanyCode;
        this.platformRequestsNo = platformRequestsNo;
        this.rechargeNumber = rechargeNumber;
        this.businessType = businessType;
        this.amount = amount;
        this.currency = currency;
        this.memberNO = memberNO;
        this.platformUserNumber = platformUserNumber;
        this.cardCode = cardCode;
        this.bankCode = bankCode;
        this.paymentMode = paymentMode;
        this.arrivalAmount = arrivalAmount;
        this.remark = remark;
        this.orderNumberPayCompany = orderNumberPayCompany;
    }

    public CheckRechargeEntity(String [] str) {
        this.payTime = str[0];
        this.platformNo = str[1];
        this.payCompanyCode = str[2];
        this.platformRequestsNo = str[3];
        this.rechargeNumber = str[4];
        this.businessType = str[5];
        this.amount = str[6];
        this.currency = str[7];
        this.memberNO = str[8];
        this.platformUserNumber = str[9];
        this.cardCode = str[10];
        this.bankCode = str[11];
        this.paymentMode = str[12];
        this.arrivalAmount = str[13];
        this.remark = str[14];
        this.orderNumberPayCompany = str[15];
    }

    @Override
    public String toString() {
        return "CheckRechargeEntity{" +
                "payTime='" + payTime + '\'' +
                ", platformNo='" + platformNo + '\'' +
                ", payCompanyCode='" + payCompanyCode + '\'' +
                ", platformRequestsNo='" + platformRequestsNo + '\'' +
                ", rechargeNumber='" + rechargeNumber + '\'' +
                ", businessType='" + businessType + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", memberNO='" + memberNO + '\'' +
                ", platformUserNumber='" + platformUserNumber + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", arrivalAmount='" + arrivalAmount + '\'' +
                ", remark='" + remark + '\'' +
                ", orderNumberPayCompany='" + orderNumberPayCompany + '\'' +
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

    public String getPlatformRequestsNo() {
        return platformRequestsNo;
    }

    public void setPlatformRequestsNo(String platformRequestsNo) {
        this.platformRequestsNo = platformRequestsNo;
    }

    public String getRechargeNumber() {
        return rechargeNumber;
    }

    public void setRechargeNumber(String rechargeNumber) {
        this.rechargeNumber = rechargeNumber;
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

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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

    public String getOrderNumberPayCompany() {
        return orderNumberPayCompany;
    }

    public void setOrderNumberPayCompany(String orderNumberPayCompany) {
        this.orderNumberPayCompany = orderNumberPayCompany;
    }
}
