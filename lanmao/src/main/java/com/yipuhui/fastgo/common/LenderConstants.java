/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: LenderConstant.java 
 *
 * Created: [2015年7月15日 下午4:27:55] by cheng 
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
 * Description: 出借人常量
 *
 * @author chengzhichao 
 * @version 1.0
 * <pre>
 * Modification History: 
 *  Date           Author        Version       Description 
 * ------------------------------------------------------------------ 
 * 2015年7月15日      chengzhichao       1.0         1.0 Version 
 * </pre>
 */

public class LenderConstants {


	/**
	 * 证件类型
	 * 身份证号码
	 */
	public static final String ID_CARD = "01";
	

	/**
	 *性别
	 * 男
	 */
	public static final String MAN = "1";

	/**
	 *
	 * 女
	 */
	public static final String WOMEN = "0";
	
	


	/**
	 * 开户状态：
	 * 未处理 1
	 */
	public static final String LENDER_STATUS_NOT_DEAL = "1";

	/**
	 *
	 * 处理中
	 */
	public static final String LENDER_STATUS_DEALING = "2";

	/**
	 *
	 * 开户成功
	 */
	public static final String LENDER_STATUS_SUCCESS = "3";

	/**
	 *
	 *开户失败
	 */
	public static final String LENDER_STATUS_FAIL = "4";

	/**
	 *老用户
	 *
	 */
	public static final String LENDER_STATUS_LYH = "6";
	
	

	/**
	 *实名认证状态：
	 *未认证
	 */
	public static final String CERTIFICATION_STATUS_NO = "1";

	/**
	 *认证通过
	 *
	 */
	public static final String CERTIFICATION_STATUS_PASS = "2";

	/**
	 *
	 * 认证失败
	 */
	public static final String CERTIFICATION_STATUS_FAIL = "3";
	

	/**
	 *验卡状态：
	 *未处理
	 */
	public static final String THIRD_BANK_STATUS_WCL = "1";

	/**
	 *处理中
	 *
	 */
	public static final String THIRD_BANK_STATUS_CLZ = "2";

	/**
	 *
	 *验证通过
	 */
	public static final String THIRD_BANK_STATUS_YZTG = "3";

	/**
	 *
	 *验证失败
	 */
	public static final String THIRD_BANK_STATUS_YZSB = "4";

	/**
	 *
	 *审核中
	 */
	public static final String THIRD_BANK_STATUS_SHZ = "5";

	/**
	 *个人资料所用常量
	 *婚姻状况
	 *已婚
	 */
	public static final String MARTIAL_STATUS_YES = "1";

	/**
	 * 离异
	 *
	 */
	public static final String MARTIAL_STATUS_DIVORCE = "2";

	/**
	 *未婚
	 *
	 */
	public static final String MARTIAL_STATUS_NO = "3";


	/**
	 *工薪阶层
	 * 职业类型
	 */
	public static final String PROFESSION_SALARIAT = "1";

	/**
	 * 私营企业主
	 *
	 */
	public static final String PROFESSION_PRIVATE = "2";

	/**
	 * 自由职业
	 *
	 */
	public static final String PROFESSION_FREE = "3";

	/**
	 * 网络商家
	 *
	 */
	public static final String PROFESSION_INTERNET = "4";

	/**
	 *
	 * 其他
	 */
	public static final String PROFESSION_OTHER = "5";


	/**
	 *1000元以下
	 *月收入
	 */
	public static final String INCOME_1 = "1";

	/**
	 *
	 *1000-2000元
	 */
	public static final String INCOME_1_2 = "2";

	/**
	 * 2000-3000元
	 *
	 */
	public static final String INCOME_2_3 = "3";

	/**
	 *3000-5000元
	 *
	 */
	public static final String INCOME_3_5 = "4";

	/**
	 *
	 *5000-10000元
	 */
	public static final String INCOME_5_10 = "5";

	/**
	 *10000-20000元
	 *
	 */
	public static final String INCOME_10_20 = "6";

	/**
	 * 20000-30000元
	 *
	 */
	public static final String INCOME_20_30 = "7";

	/**
	 *30000-50000元
	 *
	 */
	public static final String INCOME_30_50 = "8";

	/**
	 *
	 * 50000-100000元
	 */
	public static final String INCOME_50_100 = "9";
	

	/**
	 *使用状态
	*不可用
	 *
	 */
	public static final String USE_STATUS_OFF  = "0";

	/**
	 *
	 *可用
	 */
	public static final String USE_STATUS_ON= "1";
}
