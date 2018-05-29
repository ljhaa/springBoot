/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: RedisConstants.java 
 *
 * Created: [2015年5月26日 上午11:32:28] by jie 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: ephwealth-core 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.common;

/** 
 *
 * Description: Redis Key 常量
 *
 * @author lijie 
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年5月26日      lijie       1.0         1.0 Version 
 * </pre>
 */

public class RedisConstants {
	
	/**
	 * 投资人登录信息
	 */
	public static final String KEY_LENDER = "KEY_LENDER_"; 
	
	/**
	 * 重定向URL缓存key
	 */
	public static final String KEY_REDIRECT_URL = "KEY_REDIRECT_URL_";
	
	/**
	 * 出借人银行卡信息
	 */
	public static final String KEY_LENDER_BANK = "KEY_LENDER_BANK_";
	
	/**
	 * 注册未通过的银行卡信息
	 */
	public static final String KEY_TEMP_BANK = "KEY_TEMP_BANK_";
	
	/**
	 * 注册时，所用验证码key值
	 */
	public static final String KEY_REGIST_VERCODE = "KEY_REGIST_VERCODE_";
	
	/**
	 * 注册时，基本信息保存key值
	 */
	public static final String KEY_REGIST_MSG = "KEY_REGIST_MSG_";
	
	/**
	 * 非固定期限产品信息保存key值
	 */
	public static final String KEY_NONPRO_MSG = "nonProMsg";
	
	/**
	 * 忘记交易密码key值
	 */
	public static final String KEY_TRADE_PWD = "KEY_TRADE_PWD_";
	
	/**
	 * 统计交易密码输入错误次数lender:tradepwd:error:count:LenderLoginId
	 */
	public static final String KEY_LENDER_TRADEPWD_ERROR_COUNT = "lender:tradepwd:err:count:";
	
	/**
	 * 忘记交易密码，统计该账户发送短信次数，key值
	 */
	public static final String KEY_TRADEPWD_SENDMSG_COUNT = "KEY_TRADEPWD_SENDMSG_COUNT_";
	
	/**
	 * 忘记登录密码获取验证码key值
	 */
	public static final String KEY_LOGIN_VERCODE = "KEY_FORGET_LOGINPWD_VERCODE_";
	
	
	public static final String KEY_CUSTOMER_CRM_INVEST = "KEY_CUSTOMER_CRM_INVEST_";
	
	public static final int KEY_CUSTOMER_CRM_INVEST_TIME = 2*60*60;
	
	public static final String KEY_CUETOMER_INVEST="KEY_CUETOMER_INVEST_";
	
	/**
	 * 认购用户登陆发送认证码key值
	 */
	public static final String KEY_ORDER_VERCODE = "KEY_ORDER_VERCODE_";
	
	/**
	 * 标详情信息key值
	 */
	public static final String KEY_BID_DETAILS = "lenderBid:details:";
	
}
