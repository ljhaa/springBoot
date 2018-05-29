package com.yipuhui.fastgo.service;



import com.yipuhui.fastgo.enty.CashApply;

import java.math.BigDecimal;
import java.util.Map;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public interface CashApplyService {
//	/**
//	 *
//	 * Description: 提现记录
//	 *
//	 * @param conditions
//	 * @return
//	 * @Author xingym
//	 * @Create Date: 2015年7月20日 上午11:41:03
//	 */
//	public PageModel findCashApplyByPage(Map<String, Object> conditions);
//
//	/**
//	 *
//	 * Description: 提现申请
//	 *
//	 * @param lenderNum
//	 * @param amount
//	 * @param poundage
//	 * @param nameString
//	 * @Author xingym
//	 * @Create Date: 2015年7月29日 下午6:34:47
//	 */
//	public void doCashApply(String accountNum, String bankNum, String lenderNum, BigDecimal amount, BigDecimal poundage, String cashWay, String serlNum);


	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param map
	 * @date 2018/5/14 14:13
	 * @return com.yipuhui.fastgo.enty.CashApply
	 */
	CashApply findCashApplyBySerlNum(Map<String,Object> map);


	/**
	 * Description:提现退票处理
	 *
	 * @author 刘俊汉
	 * @param map
	 * @date 2018/5/14 14:13
	 * @return void
	 */
	public void cashRefund(Map<String, Object> map);
}
