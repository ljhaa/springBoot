package com.yipuhui.fastgo.common;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class RechargeRecordConstants {
	/**
	 * 充值状态【未支付】
	 */
	public static final String RECHARGE_STATUS_NONE = "0";
	/**
	 * 充值状态【充值中】
	 */
	public static final String RECHARGE_STATUS_DOING = "1";
	/**
	 * 充值状态【支付成功】
	 */
	public static final String RECHARGE_STATUS_SUCCESS = "2";
	/**
	 * 充值状态【支付失败】
	 */
	public static final String RECHARGE_STATUS_FAIL = "3";
	
	
	/**
	 * 充值对账推送状态【未推送】
	 */
	public static final String PUSH_STATUS_NONE = "0";
	/**
	 * 充值对账推送状态【已推送】
	 */
	public static final String PUSH_STATUS_SUCCESS = "1";
	
	/**
	 * 充值方式：PC
	 */
	public static final String RECHARGE_WAY_PC = "1";
	/**
	 * 充值方式：IOS
	 */
	public static final String RECHARGE_WAY_IOS = "2";
	/**
	 * 充值方式：Android
	 */
	public static final String RECHARGE_WAY_ANDROID = "3";
	/**
	 * 充值方式：WeChart
	 */
	public static final String RECHARGE_WAY_WECHART = "4";
	/**
	 * 充值方式：WeChart
	 */
	public static final String RECHARGE_WAY_POS = "6";
}
