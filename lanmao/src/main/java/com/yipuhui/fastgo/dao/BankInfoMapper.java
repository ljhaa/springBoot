package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.BankInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 
 *
 * Description: 银行卡信息
 *
 * @author chengzhichao 
 * @version 1.0
 * <pre>
 * Modification History: 
 *  Date           Author        Version       Description 
 * ------------------------------------------------------------------ 
 * 2015年4月25日      chengzhichao       1.0         1.0 Version 
 * </pre>
 */
@Mapper
public interface BankInfoMapper extends BaseMapper<BankInfo> {
	
	/**
	 * 
	 * Description: 通过lenderNum查询银行卡信息以及身份信息
	 *
	 * @param lenderNum s
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2016年2月4日 下午4:22:27
	 */
	Map<String, Object> getLenderInfoByLenderNum(String lenderNum);
    
	/**
	 * 
	 * Description: 通过出借人lenderNum,查找该出借人银行卡信息
	 *
	 * @param lenderNum s
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年4月25日 上午10:40:21
	 */
	Map<String, Object> getBankInfoByLenderNum(String lenderNum);
	
	/**
	 * 
	 * Description: 验证银行卡号是否存在 
	 *
	 * @param accountNum s
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年8月4日 下午1:57:05
	 */
	int verifyAccountNum(String accountNum);
	
	/**
	 * 
	 * Description: 根据身份证号,显示该出借人的银行卡信息
	 *
	 * @param cardNum s
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年9月6日 下午1:22:04
	 */
	Map<String, Object> getBankInfoByCardNum(String cardNum);
	
	
	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param accountNum 参数
	 * @date 2018/5/14 12:42
	 * @return com.yipuhui.fastgo.enty.BankInfo
	 */
	public BankInfo selectByAccountNum(String accountNum);
	
	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param cardInfo 参数
	 * @date 2018/5/14 12:42
	 * @return com.yipuhui.fastgo.enty.BankInfo
	 */
	public BankInfo  selectByCardInfo(String cardInfo);

	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param bankInfo is BankInfo
	 * @date 2018/5/14 12:43
	 * @return int
	 */
	@Override
    public int updateByPrimaryKeySelective(BankInfo bankInfo);

	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param thirdStatus
 * @param usedStatus
 * @param bankId
	 * @date 2018/5/14 14:16
	 * @return int
	 */
	public int updateChangeCard(@Param("thirdStatus") String thirdStatus, @Param("usedStatus") String usedStatus, @Param("bankId") String bankId);

	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param lenderNum 客户编号
	 * @date 2018/5/14 12:44
	 * @return com.yipuhui.fastgo.enty.BankInfo
	 */
	public BankInfo selectDataByLenderNum(@Param("lenderNum") String lenderNum);



	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param cardNum is 卡号
	 * @date 2018/5/14 12:44
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> getBankInfoByCjCardNum(String cardNum);

	/**
	 *
	 *   根据银行卡号查询银行卡信息包括不可用所有银行卡
	 * @author 刘俊汉
	 * @date 2018/3/14 10:13
	 * @param accountNum is
	 * @return com.ephwealth.core.entity.BankInfo
	 */
	BankInfo fundByAccountNum(String accountNum);

	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param lenderNum is string
	 * @date 2018/5/14 13:27
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> getCompanyBankInfoByLenderNum(String lenderNum);

	/**
	 *
	 * 方法说明:
	 * @author 刘俊汉
	 * @param lenderNum is 参数
	 * @date 2018/5/14 13:28
	 * @return com.yipuhui.fastgo.enty.BankInfo
	 */
	BankInfo getCompanyBankByLenderNum(String lenderNum);
}