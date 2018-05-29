package com.yipuhui.fastgo.common;
/**
 * 
 *
 * Description:网关充值常量
 *
 * @author xingym
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年6月18日      xingym       1.0         1.0 Version 
 * </pre>
 */
public class GatewayConstants {
	/**
	 * 分隔字符|_|
	 */
	public static final String SPLIT_STRING = "\\|_\\|";
	
	/**
	 * 表示成功收到支付结果信息
	 */
	public static final String RECEIVE_SUCCESS = "sent";
	/**
	 * 表示接收消息发生错误，如md5校验错
	 */
	public static final String RECEIVE_ERROR = "error";
	/**
	 * 网关充值操作码
	 */
	public static final String OPERATE_CODE = "22001";
	/**
	 * 同步回调充值状态：成功
	 */
	public static final String SYNC_RECHARGE_STATUS_SUCCESS = "20";
	/**
	 * 同步回调充值状态：失败
	 */
	public static final String SYNC_RECHARGE_STATUS_FAIL = "30";
	/**
	 * 异步回调充值状态：成功
	 */
	public static final String ASYNC_RECHARGE_STATUS_SUCCESS = "1";
	/**
	 * 异步回调充值状态：失败
	 */
	public static final String ASYNC_RECHARGE_STATUS_FAIL = "3";
}
