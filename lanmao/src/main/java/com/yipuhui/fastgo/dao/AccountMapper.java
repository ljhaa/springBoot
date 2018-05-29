package com.yipuhui.fastgo.dao;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 
 *
 * Description: 账户管理Mapper
 *
 * @author xingym
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年4月24日    xingym       1.0        1.0 Version 
 * </pre>
 */
@Mapper
public interface AccountMapper {
	/**
	 * 
	 * Description: 根据 客户编号查询可用余额
	 *
	 * @param lenderNum：客户编号
	 * @return BigDecimal
	 * @throws 
	 * @Author xingym
	 * Create Date: 2015年4月27日 下午3:16:16
	 */
	BigDecimal findAvailableBalanceByLenderNum(String lenderNum);
	
	/**
	 * 
	 * Description: 根据出借人ID查询待收本金
	 *
	 * @param lenderNum ： 客户编号
	 * @return BigDecimal
	 * @throws 
	 * @Author xingym
	 * Create Date: 2015年4月27日 下午3:15:54
	 */
	BigDecimal findCollectPrincipalByLenderNum(String lenderNum);
	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param conditions is map
	 * @date 2018/5/14 12:39
	 * @return java.math.BigDecimal
	 */
	BigDecimal findCollectInterestByLenderNum(Map<String, Object> conditions);

	/**
	 *
	 * Description: 根据出借人ID查询投资中
	 *
	 * @param  lenderNum ： 客户编号
	 * @return Map<String,Object> 【count , money】
	 * @throws
	 * @Author xingym
	 * Create Date: 2015年4月27日 下午3:15:32
	 */
	Map<String,Object> findInvestingInfoByLenderNum(String lenderNum);
	/**
	 *
	 * Description:  根据出借人ID查询已结算
	 *
	 * @param lenderNum ： 客户编号
	 * @return Map<String,Object>【count , money】
	 * @throws
	 * @Author xingym
	 * Create Date: 2015年4月27日 下午3:15:22
	 */
	Map<String,Object> findSettledInfoByLenderNum(String lenderNum);

	/**
	 *
	 * Description: 查询客户投资信息
	 *
	 * @param conditions 【lenderNum ： 客户编号,productType:产品类型；{0：固定期限，1：非固定期限},investDate:投资日期】
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年5月11日 上午10:38:00
	 */
	Map<String,Object> findInvestStatistics(Map<String, Object> conditions);

	/**
	 *
	 * Description: 散标直投账户统计
	 *
	 * @param conditions
	 * @return
	 * @Author lijie
	 * @Create Date: 2016年3月3日 下午5:42:10
	 */
	Map<String, Object> findBidInvestStatistics(Map<String, Object> conditions);

	/**
	 *
	 * Description: 体验标账户统计
	 *
	 * @param conditions
	 * @return
	 * @Author QBH
	 * @Create Date: 2016年5月5日 下午1:55:28
	 */
	Map<String, Object>  findUeInvestStatistics(Map<String, Object> conditions);

	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param lenderNum is 客户编码
	 * @date 2018/5/14 12:39
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> findBidInvestingInfoByLenderNum(String lenderNum);

	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param lenderNum is 客户编码
	 * @date 2018/5/14 12:40
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> findBidSettledInfoByLenderNum(String lenderNum);
	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param lenderId is 客户id
	 * @date 2018/5/14 12:40
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String , Object> findBidSettledInfoByMobile(Integer lenderId);

	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param map 参数
	 * @date 2018/5/14 12:40
	 * @return java.lang.Integer
	 */
	Integer updateSettledInfoById(Map<String, Object> map);
	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param map 参数
	 * @date 2018/5/14 12:40
	 * @return java.lang.Integer
	 */
	Integer updateSettledInfoPayById(Map<String, Object> map);


	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param map 参数
	 * @date 2018/5/14 12:41
	 * @return java.lang.Integer
	 */
	Integer updateCoreInfoPayById(Map<String, Object> map);
}
