package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.Date;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class RechargeRecord {
    private Integer rechargeId;

    private String serlNum;

    private String orderNum;

    private String payMethod;

    private BigDecimal rechargeAmount;

    private Integer lenderId;

   

	private String rechargeStatus;
    /**
     * 充值方式
     */
    private String rechargeWay;

    private Date rechargeTime;

    private String pushStatus;

    private Date pushTime;

    private String remark;
    
    private String payType;
    
    private String payCompany;

    public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public String getSerlNum() {
        return serlNum;
    }

    public void setSerlNum(String serlNum) {
        this.serlNum = serlNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }

    public String getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(String rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }
    
	public String getRechargeWay() {
		return rechargeWay;
	}

	public void setRechargeWay(String rechargeWay) {
		this.rechargeWay = rechargeWay;
	}

	public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getPayCompany() {
        return payCompany;
    }

    public void setPayCompany(String payCompany) {
        this.payCompany = payCompany;
    }

    @Override
    public String toString() {
        return "RechargeRecord{" +
                "rechargeId=" + rechargeId +
                ", serlNum='" + serlNum + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", rechargeAmount=" + rechargeAmount +
                ", lenderId=" + lenderId +
                ", rechargeStatus='" + rechargeStatus + '\'' +
                ", rechargeWay='" + rechargeWay + '\'' +
                ", rechargeTime=" + rechargeTime +
                ", pushStatus='" + pushStatus + '\'' +
                ", pushTime=" + pushTime +
                ", remark='" + remark + '\'' +
                ", payType='" + payType + '\'' +
                ", payCompany='" + payCompany + '\'' +
                '}';
    }
}