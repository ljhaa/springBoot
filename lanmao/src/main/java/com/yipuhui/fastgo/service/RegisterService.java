package com.yipuhui.fastgo.service;



import com.yipuhui.fastgo.enty.LenderDetail;

import java.util.Map;

/**
 * 
 *
 * Description:开户接口
 *
 * @author kRain
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2017年10月9日      kRain       1.0         1.0 Version 
 * </pre>
 */
public interface RegisterService {
	
	

	/**
	 * 
	 * Description: 回调后开户
	 *
	 * @param paramMap
	 * @return
	 * @Author kRain
	 * @Create Date: 2017年10月9日 下午1:43:28
	 */
	void fyRegist(Map<String, Object> paramMap);
	


	/**
	 * Description: 会员激活
	 *
	 * @author 刘俊汉
	 * @param bankMap
	 * @date 2018/5/14 14:29
	 * @return void
	 */
	void updataBankInfo(Map<String, Object> bankMap);


	/**
	 * Description: 懒猫开户接口回调存入开户数据
	 *
	 * @author 刘俊汉
	 * @param paramMap1
	 * @date 2018/5/14 14:30
	 * @return void
	 */
	void doLmRegist(Map<String, Object> paramMap1);


	/**
	 * Description:修改银行卡状态
	 *
	 * @author 刘俊汉
	 * @param lenderNum
	 * @param thirdStatus
	 * @param errorMessage
	 * @date 2018/5/14 14:30
	 * @return void
	 */
	void updataBank(String lenderNum,String thirdStatus,String errorMessage);
}
