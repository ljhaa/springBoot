package com.yipuhui.fastgo.common;
/**
 * 
 *
 * Description:网关充值回调传参接收类【同步】
 *
 * @author xingym
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年6月16日      xingym       1.0         1.0 Version 
 * </pre>
 */
public class GatewaySyncCallbackInfo {
	/**
	 * 商户发送的v_oid定单编号
	 */
	private String vOid;
	/**
	 * 支付方式（字符串）
	 */
	private String vPmode;
	/**
	 * 20（支付成功，对使用实时银行卡进行扣款的订单）；
	 * 30（支付失败，对使用实时银行卡进行扣款的订单）；
	 */
	private String vPstatus;
	/**
	 * 支付结果信息：
	 * 已提交（当v_pstatus=1时）；
	 * 支付完成（当v_pstatus=20时）；
	 */
	private String vPstring;
	
	/**
	 * 订单实际支付金额
	 */
	private String vAmount;
	/**
	 * 订单实际支付币种
	 */
	private String vMoneytype;
	/**
	 * char* hmac_md5(char* text, char* key)
	 * char* text     拼串结果
	 * char* key     对称密钥
	 * v_md5money效验两个参数，拼接字符串的顺序为：v_amount，v_moneytype
	 */
	private String vMd5money;
	/**
	 * 商城数据签名，参与签名的数据（v_oid+v_pstatus+v_amount+v_moneytype）
	 * RSA_MD5 myRSA=new RSA_MD5();
	 * String source=v_oid + v_pstatus + v_amount + v_moneytype;
	 * int verifyStatus = myRSA.PublicVerifyMD5("D:\Public1024.key" ,v_sign ,source);
	 * (verifyStatus：0 验证成功)
	 */
	private String vSign;


	public String getvOid() {
		return vOid;
	}

	public void setvOid(String vOid) {
		this.vOid = vOid;
	}

	public String getvPmode() {
		return vPmode;
	}

	public void setvPmode(String vPmode) {
		this.vPmode = vPmode;
	}

	public String getvPstatus() {
		return vPstatus;
	}

	public void setvPstatus(String vPstatus) {
		this.vPstatus = vPstatus;
	}

	public String getvPstring() {
		return vPstring;
	}

	public void setvPstring(String vPstring) {
		this.vPstring = vPstring;
	}

	public String getvAmount() {
		return vAmount;
	}

	public void setvAmount(String vAmount) {
		this.vAmount = vAmount;
	}

	public String getvMoneytype() {
		return vMoneytype;
	}

	public void setvMoneytype(String vMoneytype) {
		this.vMoneytype = vMoneytype;
	}

	public String getvMd5money() {
		return vMd5money;
	}

	public void setvMd5money(String vMd5money) {
		this.vMd5money = vMd5money;
	}

	public String getvSign() {
		return vSign;
	}

	public void setvSign(String vSign) {
		this.vSign = vSign;
	}
}
