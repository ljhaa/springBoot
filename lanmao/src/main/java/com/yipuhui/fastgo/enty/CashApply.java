package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class CashApply {
    private Integer cashApplyId;

    private String serlNum;

    private Integer lenderId;

    private String bankNum;

    private String accountNum;

    private BigDecimal applyCashAmount;

    private BigDecimal realCashAmount;

    private BigDecimal handlingCharge;

    private String auditStatus;

    private String cashStatus;
    
    private String cashWay;

    private String failReason;

    private Date applyTime;

    private Date auditTime;

    private Integer auditor;

    public Integer getCashApplyId() {
        return cashApplyId;
    }

    public void setCashApplyId(Integer cashApplyId) {
        this.cashApplyId = cashApplyId;
    }

    public String getSerlNum() {
        return serlNum;
    }

    public void setSerlNum(String serlNum) {
        this.serlNum = serlNum;
    }

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getApplyCashAmount() {
        return applyCashAmount;
    }

    public void setApplyCashAmount(BigDecimal applyCashAmount) {
        this.applyCashAmount = applyCashAmount;
    }

    public BigDecimal getRealCashAmount() {
        return realCashAmount;
    }

    public void setRealCashAmount(BigDecimal realCashAmount) {
        this.realCashAmount = realCashAmount;
    }

    public BigDecimal getHandlingCharge() {
        return handlingCharge;
    }

    public void setHandlingCharge(BigDecimal handlingCharge) {
        this.handlingCharge = handlingCharge;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(String cashStatus) {
        this.cashStatus = cashStatus;
    }

	public String getCashWay() {
		return cashWay;
	}

	public void setCashWay(String cashWay) {
		this.cashWay = cashWay;
	}

	public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    @Override
    public String toString() {
        return "CashApply{" +
                "cashApplyId=" + cashApplyId +
                ", serlNum='" + serlNum + '\'' +
                ", lenderId=" + lenderId +
                ", bankNum='" + bankNum + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", applyCashAmount=" + applyCashAmount +
                ", realCashAmount=" + realCashAmount +
                ", handlingCharge=" + handlingCharge +
                ", auditStatus='" + auditStatus + '\'' +
                ", cashStatus='" + cashStatus + '\'' +
                ", cashWay='" + cashWay + '\'' +
                ", failReason='" + failReason + '\'' +
                ", applyTime=" + applyTime +
                ", auditTime=" + auditTime +
                ", auditor=" + auditor +
                '}';
    }
}