package com.yipuhui.fastgo.common;

import java.io.Serializable;

/**
 * 
 *
 * Description:网关充值回调传参接收类【异步】
 *
 * @author xingym
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年6月17日      xingym       1.0         1.0 Version 
 * </pre>
 */
public class GatewayAsyncCallbackInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5615718882559565335L;
	/**
	 * 订单个数：本次发送的订单个数；（最少为1，最大为4）
	 */
	private String vCount;
	/**
	 * 订单编号组：定义同商户提交待付款订单接口中的订单编号定义，用 |_| 分隔
	 */
	private String vOid;
	/**
	 * 支付方式组：支付方式中文说明，如“中行长城信用卡”。
	 */
	private String vPmode;
	/**
	 * 支付状态组：支付结果  1支付完成；3支付被拒绝
	 */
	private String vPstatus;
	/**
	 * 支付结果说明:对支付结果的说明，成功时（v_pstatus=1）为“支付成功”，支付被拒绝时（v_pstatus=3）为失败原因。
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
	 * 数字指纹（v_mac）：防篡改信息，v_mac=hmac_md5(text , key)；其中text是表单中各项的value按如下顺序拼串的结果：v_oid+v_pmode+v_pstatus+v_pstring+v_count，key为双方约定的密钥。例如一次发送两笔订单：
20001124-888-test002|_|20001124-888-test003招商银行一网通|_|招商银行一网通3|_|1支付被拒绝|_|支付完成2
	 */
	private String vMac;
	/**
	 * 数字指纹（v_md5money）：防篡改信息，v_md5money=hmac_md5(text , key)；其中text是表单中各项的value按如下顺序拼串的结果：v_amount +v_moneytype，key为双方约定的密钥。
	 */
	private String vMd5money;
	/**
	 * 商城数据签名，参与签名的数据（v_oid+v_pstatus+v_amount+v_moneytype+v_count）
	 */
	private String vSign;


	public static long getSerialVersionUID() {

		return serialVersionUID;
	}

	public String getvCount() {
		return vCount;
	}

	public void setvCount(String vCount) {
		this.vCount = vCount;
	}

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

	public String getvMac() {
		return vMac;
	}

	public void setvMac(String vMac) {
		this.vMac = vMac;
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
