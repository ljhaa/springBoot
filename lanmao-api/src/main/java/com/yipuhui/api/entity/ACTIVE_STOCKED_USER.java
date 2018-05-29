package com.yipuhui.api.entity;

import java.math.BigDecimal;

/**
 * 
 * @author Admin 迁移用户激活
 */
public class ACTIVE_STOCKED_USER {

	/**
	 * 请求流水号
	 */
	private String requestNo;

	/**
	 * 页面回跳 URL
	 */
	private String redirectUrl;

	/**
	 *平台用户编号
	 */
	private String platformUserNo;
	/**
	 *见【用户授权列表】；此处可传多个值，传多个值用“,”英文半角逗号分隔
	 */
	private String authList;

	/**
	 * 鉴权验证类型，默认填 LIMIT（强制四要素），即四要素完全通过（姓名、身份证号、银行卡号，银行预留手机号） 方可激活成功
	 */
	private String checkType;

	/**
	 * 授权期限
	 */
	private String failTime;

	/**
	 * 授权金额
	 */
	private BigDecimal amount;
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	public String getAuthList() {
		return authList;
	}
	public void setAuthList(String authList) {
		this.authList = authList;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getFailTime() {
		return failTime;
	}
	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
