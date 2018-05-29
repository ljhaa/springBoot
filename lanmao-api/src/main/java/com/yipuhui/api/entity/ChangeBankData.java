package com.yipuhui.api.entity;

import java.io.Serializable;
/**
 * 个人换绑卡参数实体
 * @author suxuqiang
 *
 */
public class ChangeBankData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *银行账户号
	 */
	private String bankcardNo;
	/**
	 *银行编号
	 */
	private String bankcode;

	public String getBankcardNo() {
		return bankcardNo;
	}

	public void setBankcardNo(String bankcardNo) {
		this.bankcardNo = bankcardNo;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	
	/**
	 *请求流水号
	 */
	private String requestNo;
	/**
	 * 页面回跳 URL
	 */
	private String redirectUrl;
	/**
	 * 平台用户编号
	 */
	private String platformUserNo;
	/**
	 * 鉴权验证类型，默认填 LIMIT（强制四要素）
	 */
	private String checkType;
	/**
	 * 【固定值】UPDATE_BANKCARD
	 */
	private String bindType;

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

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getBindType() {
		return bindType;
	}

	public void setBindType(String bindType) {
		this.bindType = bindType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
