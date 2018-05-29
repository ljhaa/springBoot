package com.yipuhui.fastgo.common;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class CouponConstants {
	/**
	 * 有效状态：未启用
	 */
	public static final String VALID_STATUS_NOT_ENABLED = "0";
	/**
	 * 有效状态：无效
	 */
	public static final String VALID_STATUS_DISABLE = "2";
	/**
	 * 有效状态：有效
	 */
	public static final String VALID_STATUS_EFFECTIVE = "1";
	/**
	 * 优惠券类型：抵扣券
	 */
	public static final String COUPON_TYPE_DIKOU = "1";	
	/**
	 * 优惠券类型：现金券
	 */
	public static final String COUPON_TYPE_XIANJIN = "2";
	/**
	 * 优惠券类型：加息券
	 */
	public static final String COUPON_TYPE_JIAXI = "3";
	
	/**
	 * 优惠券类型：抵扣券
	 */
	public static final String COUPON_TYPE_DIKOU_TEXT = "抵扣";	
	/**
	 * 优惠券类型：现金券
	 */
	public static final String COUPON_TYPE_XIANJIN_TEXT = "现金";
	/**
	 * 优惠券类型：加息券
	 */
	public static final String COUPON_TYPE_JIAXI_TEXT = "加息";
	
	/**
	 * 使用状态：未使用
	 */
	public static final String USE_STATUS_UNUSED = "1";
	/**
	 * 使用状态：已使用
	 */
	public static final String USE_STATUS_USED = "2";
	/**
	 * 使用状态：已过期
	 */
	public static final String USE_STATUS_EXPIRED = "3";
	
	/**
	 * 月谱盈
	 */
	public static final String APPLICATION_RANGE_YPY = "1";
	/**
	 * 季谱盈
	 */
	public static final String APPLICATION_RANGE_JPY = "2";
	/**
	 * 陆月盈
	 */
	public static final String APPLICATION_RANGE_LYY = "3";
	/**
	 * 岁岁盈
	 */
	public static final String APPLICATION_RANGE_SSY = "4";
	
	/**
	 * 红包派发类型(红包派发页面展示):  折扣:1, 现金:2,  加息:3
	 */
	public static final int ACTIVITY_COUPON_TYPE_ZHEKOU = 1;
	public static final String ACTIVITY_COUPON_TYPE_ZHEKOU_MSG = "折扣";
	public static final int ACTIVITY_COUPON_TYPE_CASH = 2;
	public static final String ACTIVITY_COUPON_TYPE_CASH_MSG = "现金";
	public static final int ACTIVITY_COUPON_TYPE_JIAXI = 3;
	public static final String ACTIVITY_COUPON_TYPE_JIAXI_MSG = "加息";
	
	//优惠券配置常量(t_open_model_config中字段)

	/**
	 * 注册
 	 */
	public static final String MODEL_TYPE_ZHUCE = "1";
	/**
	 * 实名认证
	 */
	public static final String MODEL_TYPE_RENZHENG = "2";

	/**
	 * // 绑卡
	 */
	public static final String MODEL_TYPE_BANK = "3";

	/**
	 * // 开启
	 */
	public static final String MODEL_IS_OPEN = "1";

	/**
	 * // 关闭
	 */
	public static final String MODEL_IS_CLOSE = "0";
	
}
