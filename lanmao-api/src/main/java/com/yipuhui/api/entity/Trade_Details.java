package com.yipuhui.api.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author Admin
 * @see 批量划拨接口
 */
public class Trade_Details {

	/**
	 *业务类型#
	 */
	private String bizType;

	/**
	 *预处理流水号#
	 */
	private String freezeRequestNo;

	/**
	 *交易明细订单号#
	 */
	private String requestNo;

	/**
	 *出借方用户编号#
	 */
	private String  sourcePlatformUserNo;

	/**
	 *收款方用户编号#
	 */
	private String targetPlatformUserNo;

	/**
	 *交易金额#
	 */
	private BigDecimal amount;

	/**
	 *利息
	 */
	private BigDecimal income;

	/**
	 *债权份额
	 */
	private BigDecimal share;

	/**
	 *平台商户自定义参数
	 */
	private String customDefine;

	/**
	 *备注
	 */
	private String remark;
	
	
	public Trade_Details() {
		
	}
	
	
	
	public Trade_Details(String bizType, String sourcePlatformUser,
			String targetPlatformUser, BigDecimal amount, String customDefine) {
		super();
		this.bizType = bizType;
		this.sourcePlatformUserNo = sourcePlatformUser;
		this.targetPlatformUserNo = targetPlatformUser;
		this.amount = amount;
		this.customDefine = customDefine;
	}




	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getFreezeRequestNo() {
		return freezeRequestNo;
	}
	public void setFreezeRequestNo(String freezeRequestNo) {
		this.freezeRequestNo = freezeRequestNo;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getShare() {
		return share;
	}
	public void setShare(BigDecimal share) {
		this.share = share;
	}
	public String getCustomDefine() {
		return customDefine;
	}
	public void setCustomDefine(String customDefine) {
		this.customDefine = customDefine;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getSourcePlatformUserNo() {
		return sourcePlatformUserNo;
	}



	public void setSourcePlatformUserNo(String sourcePlatformUserNo) {
		this.sourcePlatformUserNo = sourcePlatformUserNo;
	}



	public String getTargetPlatformUserNo() {
		return targetPlatformUserNo;
	}



	public void setTargetPlatformUserNo(String targetPlatformUserNo) {
		this.targetPlatformUserNo = targetPlatformUserNo;
	}

}

