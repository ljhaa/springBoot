package com.yipuhui.fastgo.service;



/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/28 16:21
 */
public interface UeAccountService {

	/**
	 * 为用户注册或者实名为用户增加体验金
	 * @param loginId 用户登录的ID
	 * @param type 类型1注册，2实名
	 */
	void doAddUeMoney(Integer loginId, int type);
	

}
