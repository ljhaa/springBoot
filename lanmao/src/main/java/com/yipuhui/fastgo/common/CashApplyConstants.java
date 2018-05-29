package com.yipuhui.fastgo.common;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class CashApplyConstants {
	/**
	 * 提现状态:未处理
	 */
	public static final String CASH_STATUS_TODO = "1";
	/**
	 * 提现状态:处理中
	 */
	public static final String CASH_STATUS_DOING = "2";
	/**
	 * 提现状态:提现成功
	 */
	public static final String CASH_STATUS_SUCCESS = "3";
	/**
	 * 提现状态:提现失败
	 */
	public static final String CASH_STATUS_FAIL = "4";
	/**
	 * 审核状态：未处理
	 */
	public static final String AUDIT_STATUS_TODO ="1";
	/**
	 * 审核状态：审核成功
	 */
	public static final String AUDIT_STATUS_SUCCESS ="2";
	/**
	 * 审核状态：审核失败
	 */
	public static final String AUDIT_STATUS_FAIL ="3";
	
	/**
	 * 提现方式：pc
	 */
	public static final String CASH_WAY_PC ="1";
	
	/**
	 * 提现方式：IOS
	 */
	public static final String CASH_WAY_IOS ="2";
	
	/**
	 * 提现方式：Android
	 */
	public static final String CASH_WAY_ANDROID ="3";
	
	/**
	 * 提现方式：WeChat
	 */
	public static final String CASH_WAY_WECHAT ="4";
	
	/**
	 * 提现方式：RenGou
	 */
	public static final String CASH_WAY_RENGOU ="5";
	
}
