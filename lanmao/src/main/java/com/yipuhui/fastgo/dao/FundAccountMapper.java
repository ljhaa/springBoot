package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.FundAccount;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Map;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:18
 */
@Mapper
public interface FundAccountMapper extends BaseMapper<FundAccount>{
	
	/**
	 * Description:使用红包时，更新账户余额
	 *
	 * @author 刘俊汉
	 * @param paramMap
	 * @date 2018/5/14 14:18
	 * @return void
	 */
	void updateAvailableBalanceForCoupon(Map<String, Object> paramMap);

	/**
	 * Description: 使用红包时，更新账户余额  现金红包
	 *
	 * @author 刘俊汉
	 * @param paramMap
	 * @date 2018/5/14 14:18
	 * @return void
	 */
	void updateAvailableBalanceForCouponX(Map<String, Object> paramMap);
	/**
	 * Description: 体验金，更新账户余额
	 *
	 * @author 刘俊汉
	 * @param paramMap
	 * @date 2018/5/14 14:18
	 * @return void
	 */
	void updateAvailableBalanceForTiyanjin(Map<String, Object> paramMap);

	/**
	 * Description: 查询客户的资金账户信息
	 *
	 * @author 刘俊汉
	 * @param lenderNum
	 * @date 2018/5/14 14:18
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	public Map<String,Object> findFundAccountByLenderNum(String lenderNum);
	
	/**
	 * Description: 更新投资金额
	 *
	 * @author 刘俊汉
	 * @param investNum
	 * @date 2018/5/14 14:19
	 * @return void
	 */
	void updateFreezeAmountByInvestNum(String investNum);
	
	/**
	 * Description: 更新资金账户表可用余额
	 *
	 * @author 刘俊汉
	 * @param paramMap
	 * @date 2018/5/14 14:19
	 * @return void
	 */
	public void updateaVailableBalanceByInvestNum(Map<String, Object> paramMap);
	
	/**
	 * Description:根据lenderId查询客户账户
	 *
	 * @author 刘俊汉
	 * @param lenderId
	 * @date 2018/5/14 14:19
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	public Map<String,Object> findFundAccountInfoByLenderId(Integer lenderId);
	/**
	 * Description: 按条件更新资金账户资金
	 *
	 * @author 刘俊汉
	 * @param conditions
	 * @date 2018/5/14 14:19
	 * @return int
	 */
	public int updateFundAccountInfoByConditions(Map<String, Object> conditions);
	
	/**
	 * Description:根据客户编号查询客户资金账户及明细信息
	 *
	 * @author 刘俊汉
	 * @param lenderNum
	 * @date 2018/5/14 14:20
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	public Map<String,Object> findFundAccountAndDetailInfoByLenderNum(String lenderNum);

	/**
	 * Description:通过lenderNum查询账户可用金额
	 *
	 * @author 刘俊汉
	 * @param lenderNum
	 * @date 2018/5/14 14:20
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getAvailableBalanceByLenderNum(String lenderNum);

	/**
	 * Description: 修改账户可用余额和冻结金额通过lenderNum
	 *
	 * @author 刘俊汉
	 * @param map
	 * @date 2018/5/14 14:20
	 * @return void
	 */
	public void updateFundAccountByLenderNum(Map<String, Object> map);

	/**
	 * Description: 根据证件号码更新冻结金额
	 *
	 * @author 刘俊汉
	 * @param fundAccountMap
	 * @date 2018/5/14 14:20
	 * @return void
	 */
	void updateFreezeAmountByCardCode(Map<String, Object> fundAccountMap);

	/**
	 * Description: 根据证件号码更新可用余额
	 *
	 * @author 刘俊汉
	 * @param fundAccountMap
	 * @date 2018/5/14 14:20
	 * @return void
	 */
	void updateAvailableBalanceByCardCode(Map<String, Object> fundAccountMap);

	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param fundAccountMap
	 * @date 2018/5/14 14:29
	 * @return void
	 */
	void updateFreezeAmountByMap(Map<String, Object> fundAccountMap);
}