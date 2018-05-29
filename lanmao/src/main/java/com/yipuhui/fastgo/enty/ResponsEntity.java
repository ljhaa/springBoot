package com.yipuhui.fastgo.enty;
/**
 * 
 *
 * Description:第三方返回数据封装类
 *
 * @author liujunhan
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2017年6月14日      liujunhan    1.0        1.0 Version 
 * </pre>
 */
public class ResponsEntity {
	

	/**
	 * 响应码
	 */
	private String respCode = "";

	/**
	 *响应消息
	 */
	private String respDesc= "";

	/**
	 *商户代码
	 */
	private String mchntCd = "";

	/**
	 *请求流水号
	 */
	private String mchntTxnSsn= "";

	/**
	 *签名数据
	 */
	private String signature = "";

	/**
	 *状态
	 */
	private Boolean status = null ;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getMchntCd() {
		return mchntCd;
	}

	public void setMchntCd(String mchntCd) {
		this.mchntCd = mchntCd;
	}

	public String getMchntTxnSsn() {
		return mchntTxnSsn;
	}

	public void setMchntTxnSsn(String mchntTxnSsn) {
		this.mchntTxnSsn = mchntTxnSsn;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
