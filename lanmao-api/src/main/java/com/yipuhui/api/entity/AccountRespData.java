package com.yipuhui.api.entity;
/**
 * 
 * @author suxuqiang
 * 开户  同步回调接收的参数主体
 */
public class AccountRespData {

	/**
	 * 	//请求流水号
	 */
	private String requestNo;
	/**
	 *调用状态（0 为调用成功、1 为失败，返回 1 时请看【调用失败错误码】及错误码描述）
	 */

	private String code;
	/**
	 *业务处理状态（处理失败 INIT；处理成功 SUCCESS），平台可根据非 SUCCESS状态做相应处理，处理失败时可参考错误码及描述
	 */
	private String status;
	/**
	 *错误码
	 */
	private String errorCode;
	/**
	 *错误码描述
	 */
	private String errorMessage;
	/**
	 *平台用户编号
	 */
	private String platformUserNo;
	/**
	 *用户真实姓名
	 */
	private String realName;
	/**
	 *见【证件类型】
	 */
	private String idCardType;
	/**
	 *见【用户角色】
	 */
	private String userRole;
	/**
	 *用户证件号
	 */
	private String idCardNo;
	/**
	 *银行预留手机号
	 */
	private String mobile;
	/**
	 *银行卡号
	 */
	private String bankcardNo;
	/**
	 *见【银行编码】
	 */
	private String bankcode;
	/**
	 *见【鉴权通过类型】
	 */
	private String accessType;
	/**
	 *见【审核状态】
	 */
	private String auditStatus;
	/**
	 *授权期限
	 */
	private String failTime;
	/**
	 *授权金额
	 */
	private String amount;

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

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

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getFailTime() {
		return failTime;
	}

	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	

}
