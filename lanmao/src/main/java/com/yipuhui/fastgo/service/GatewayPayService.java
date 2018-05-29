package com.yipuhui.fastgo.service;

import com.yipuhui.fastgo.common.GatewaySyncCallbackInfo;

import java.util.Date;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public interface GatewayPayService {
	/**
	 *
	 * Description: 实时回调:同步回调
	 *
	 * @param info :
	 *  v_oid 订单编号
	 *  v_pmode 支付方式，银行编号
	 *  v_pstatus 支付状态
	 *  v_pstring 支付结果信息
	 *  v_md5info v_md5info校验四个参数，拼接字符串的顺序为：v_oid，v_pstatus，v_pstring和v_pmode
	 *  v_amount 订单实际支付金额
	 *  v_moneytype 币种
	 *  v_md5money v_md5money效验两个参数，拼接字符串的顺序为：v_amount，v_moneytype
	 *  v_sign 商城数据签名，参与签名的数据（v_oid+v_pstatus+v_amount+v_moneytype）
	 * @param currentDate
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年7月22日 下午8:23:03
	 */
	public Boolean doSyncPayResultCallBack(GatewaySyncCallbackInfo info, Date currentDate);
//	/**
//	 *
//	 * Description: 延时回调：异步回调
//	 *
//	 * @param info
//	 * @return
//	 * @Author xingym
//	 * @Create Date: 2015年7月23日 下午2:17:07
//	 */
//	public Boolean doAsyncPayResultCallBack(GatewayAsyncCallbackInfo info, Date currentDate);
//
//	/**
//	 *
//	 * Description: pos机返回信息生成充值记录
//	 *
//	 * @return
//	 * @Author liujunhan
//	 * @Create Date: 2017年9月7日 上午10:04:26
//	 */
//	public Boolean doPayPosLog(LenderDetail lenderDetail, Map<String, Object> map);
	
}
