/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InterfaceLogConstants.java 
 *
 * Created: [2015年7月14日 下午3:19:21] by jie 
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
 * Description: 接口描述常量
 *
 * @author lijie 
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年7月14日      lijie       1.0         1.0 Version 
 * </pre>
 */

public class InterfaceConstants {
	/** 系统编码标识   **/
	public static final String SYSTEM_CODE = "SYSTEM_ONLINE";
	
	/**   crm 接口描述           **/
	public static final String CRM_OPEN_ACCOUNT = "crm开户接口";
	
	public static final String CRM_VERIFY_BANK = "crm验卡接口";
	
	public static final String CRM_ADD_INVEST = "同步online投资到crm接口";
	
	public static final String CRM_ADD_SB = "散标投资同步";
	
	public static final String CRM_MODIFY_SB_STATE = "散标投资同步(关单)";
	
	
	/**   online 接口描述           **/
	public static final String ONLINE_SYN_ADD_CUSTOMER_INFO = "同步crm客户到online接口";
	
	public static final String ONLINE_SYN_CHANGE_MOBILE_INFO = "crm客户手机号变更同步到onlie接口";
	
	public static final String ONLINE_CALL_BACK_OPEN_ACCOUNT = "online客户开户回调接口";
	
	public static final String ONLINE_CALL_BACK_VALIDATE_BANK = "online客户验卡回调接口";
	
	public static final String ONLINE_CALL_BACK_LEND_SUCCESS = "online投资出借回调接口";
	
	public static final String ONLINE_CALL_BACK_DUE_REDEEM = "online投资到期自动赎回回调接口";
	
	public static final String ONLINE_CALL_BACK_CASH_APPLY = "online提现回调接口";
	
	public static final String ONLINE_SYN_ACCOUNT_WATER = "同步账户流水到online接口";
	
	public static final String ONLINE_SYN_OFFLINE_ADD_INVEST_INFO = "线下投资代扣成功同步投资到online";
	
	public static final String ONLINE_CALL_BACK_TRANSFER = "online划拨回调接口";
	
	public static final String ONLINE_CALL_BACK_DEDUCT = "online代扣回调接口";
	
	public static final String ONLINE_CALL_CREDITOR_IMPORT = "散标债权导入";
	
	public static final String ONLINE_CALL_BACK_LOAN = "散标放款回调更新投资信息";
	
	public static final String ONLINE_CALL_BACK_UPDATE_BID_STATUS = "回调更新散标状态";
	
	public static final String ONLINE_CALL_BACK_UPDATE_CURRENT_ACCOUNT = "散标回款更新回款状态以及活期账户";
	
	public static final String ONLINE_CALL_SYN_RETURN_SCHEDULE = "放款后同步回款计划";

	public static final String ONLINE_CALL_SYN_REPAYMENT_SCHEDULE = "放款后同步还款计划";
	
	public static final String ONLINE_CALL_BACK_UPDATE_REPAY_STATUS = "更新还款状态";
	
	/**   core 接口描述           **/
	public static final String ONLINE_CASH_APPLY = "online提现申请接口";
	
	public static final String ONLINE_CALL_CORE_ADD_RECHARGE_INFO = "线上充值记录同步到核心";
	
	public static final String TRANSFER = "核心系统账户划拨接口";
	
	public static final String DEDUCT = "核心系统账户代扣接口";
	
	public static final String CREDITOR_CREATE = "线上债权成立接口";
	
	public static final String ONLINE_CALL_BACK_UPDATE_ACCOUNT = "散标放款更新借款人活期账户";
	
	/**   Integral 接口描述           **/
	public static final String POINTS_SYNC_I01 = "线上系统用户注册积分变更";
	public static final String POINTS_SYNC_I02 = "线上系统用户实名认证积分变更";
	public static final String POINTS_SYNC_I03 = "线上系统用户绑卡成功积分变更";
	public static final String POINTS_SYNC_I06 = "线上系统用户投资积分变更";
	
	

	/**
	 * 接口操作状态 -true
	 */
	public static final String OPER_STATE_TRUE = "true"; 
	

	/**
	 * 接口操作状态 -false
	 */
	public static final String OPER_STATE_FALSE = "false";
	

	/**
	 * 接口类型-回调接口
	 */
	public static final String TYPE_SERVICE = "1";
	

	/**
	 * 接口类型-非回调接口
	 */
	public static final String TYPE_CLIENT = "0";
	

	/**
	 *接口调用成功代码
	 */
	public static final String SUCCESS = "200";
	
	

	/**
	 *
	 *  同步账户流水参数常量
	 * 代扣成功回调
	 *
	 */
	public static final String DKCZ = "DKCZ";

	/**
	 *已出借
	 */
	public static final String LCHB = "LCHB";

	/**
	 * 返息成功
	 */
	public static final String LCFX = "LCFX";

	/**
	 *赎回成功
	 */
	public static final String LCSH = "LCSH";
	
}
