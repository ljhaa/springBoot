package com.yipuhui.api.entity;

import java.math.BigDecimal;

/**
 * 
 * @author suxuqiang
 * 充值 接口参数实体类
 */
public class RechargeData {

	/**
	 *平台用户编号
	 */
	private String platformUserNo;
	/**
	 *请求流水号
	 */
	private String requestNo;
	/**
	 *充值金额
	 */
	private BigDecimal amount;
	/**
	 *平台佣金
	 */
	private BigDecimal commission;
	/**
	 *偏好支付公司
	 */
	private String expectPayCompany;
	/**
	 *支付方式；支持网银（WEB）、快捷支付（SWIFT）
	 */
	private String rechargeWay;
	/**
	 *银行编码；若支付方式为快捷支付，此处必传；若支付方式为网银且传了payType 则此处必传，不传 payTyp 则此处传了也不生效；
	 */
	private String bankcode;
	/**
	 *网银类型；网银支付方式下，若此处传值则直接跳转至银行页面，不传则跳转至支付公司收银台页面；
	 */
	private String payType;
	/**
	 *授权交易类型；若想实现充值+单次授权，则此参数必传
	 */
	private String authtradeType;
	/**
	 *授权金额；充值成功后可操作对应金额范围内的授权预处理；若传入了【授权交易类型】，则此参数必传；
	 */
	private BigDecimal authtenderAmount;
	/**
	 *标的号；若传入了【授权交易类型】，则此参数必传。
	 */
	private String projectNo;
	/**
	 *页面回跳 URL
	 */
	private String redirectUrl;
	/**
	 *超过此时间即页面过期
	 */
	private String expired;
	/**
	 *快捷充值回调模式，如传入 DIRECT_CALLBACK，则订单支付不论成功、失败、处理中均直接同步、异步通知商户；不传则仅支付成功时候返回异步通知。
	 */
	private String callbackMode;

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
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

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public String getExpectPayCompany() {
		return expectPayCompany;
	}

	public void setExpectPayCompany(String expectPayCompany) {
		this.expectPayCompany = expectPayCompany;
	}

	public String getRechargeWay() {
		return rechargeWay;
	}

	public void setRechargeWay(String rechargeWay) {
		this.rechargeWay = rechargeWay;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAuthtradeType() {
		return authtradeType;
	}

	public void setAuthtradeType(String authtradeType) {
		this.authtradeType = authtradeType;
	}

	public BigDecimal getAuthtenderAmount() {
		return authtenderAmount;
	}

	public void setAuthtenderAmount(BigDecimal authtenderAmount) {
		this.authtenderAmount = authtenderAmount;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	public String getCallbackMode() {
		return callbackMode;
	}

	public void setCallbackMode(String callbackMode) {
		this.callbackMode = callbackMode;
	}
	
	
	
}
