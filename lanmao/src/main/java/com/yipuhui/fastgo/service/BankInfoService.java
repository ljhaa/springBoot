/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: BankInfoService.java 
 *
 * Created: [2015年4月25日 上午10:45:54] by cheng 
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
 * ProjectName: ephwealth-online 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.service;



import com.yipuhui.fastgo.enty.BankInfo;

import java.util.Map;

/** 
 *
 * Description: 银行卡详情service
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

public interface BankInfoService {
	
	/**
	 * 
	 * Description: 根据出借人编号,显示该出借人信息以及银行卡信息
	 *
	 * @param lenderNum
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2016年2月18日 下午3:11:24
	 */
	public Map<String, Object> getLenderInfoByLenderNum(String lenderNum);

	/**
	 * 
	 * Description: 根据出借人编号,显示该出借人的银行卡信息
	 *
	 * @param lenderNum
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年4月25日 上午11:48:19
	 */
	Map<String, Object> getBankInfoByLenderNum(String lenderNum);
	
	/**
	 * 
	 * Description: 通过银行卡id,查找详细信息
	 *
	 * @param bankId
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年4月25日 上午11:50:56
	 */
	BankInfo selectByPrimaryKey(Integer bankId);
	
	/**
	 * 
	 * Description: 验证银行卡号是否存在 
	 *
	 * @param accountNum
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年8月4日 下午1:56:03
	 */
	int verifyAccountNum(String accountNum);
	
	/**
	 * 
	 * Description: 根据身份证号,显示该出借人的银行卡信息
	 *
	 * @param cardNum
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年9月6日 下午1:21:00
	 */
	Map<String, Object> getBankInfoByCardNum(String cardNum);
	
	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param accountNum
	 * @date 2018/5/14 14:05
	 * @return com.yipuhui.fastgo.enty.BankInfo
	 */
	public BankInfo selectByAccountNum(String accountNum);
	
	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param info
	 * @date 2018/5/14 14:05
	 * @return int
	 */
	public int updateByPrimaryKeySelective(BankInfo info);

	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param bankId
	 * @param bankStatus
	 * @param useStatus
	 * @date 2018/5/14 14:05
	 * @return java.lang.Integer
	 */
	public Integer changeCard(String bankId, String bankStatus, String useStatus);
	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param lenderNum
	 * @date 2018/5/14 14:05
	 * @return com.yipuhui.fastgo.enty.BankInfo
	 */
	public BankInfo selectDataByLenderNum(String lenderNum);
	
	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param bankInfo
	 * @date 2018/5/14 14:05
	 * @return int
	 */
	public int insetBankInfo(BankInfo bankInfo);

	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param cardNum
	 * @date 2018/5/14 14:05
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	Map<String, Object> getBankInfoByCjCardNum(String cardNum);

	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param accountNum
	 * @date 2018/5/14 14:05
	 * @return com.yipuhui.fastgo.enty.BankInfo
	 */
	BankInfo fundByAccountNum(String accountNum);


	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param reqData
 * @param mobile
 * @param lenderNum
 * @param selNum
	 * @date 2018/5/14 14:16
	 * @return void
	 */
	void updataBankInfoCardById(String reqData,String mobile,String lenderNum,String selNum);
}
