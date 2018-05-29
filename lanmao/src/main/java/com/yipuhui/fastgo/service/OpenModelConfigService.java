/* 
 * Copyright (C) 2014-2016 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: OpenModelConfigService.java 
 *
 * Created: [2016年1月7日 下午4:50:43] by cheng 
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
 * ProjectName: ephwealth-service 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.service;

import java.util.Map;

/** 
 *
 * Description: 开启模式配置
 *
 * @author chengzhichao 
 * @version 1.0
 * <pre>
 * Modification History: 
 *  Date           Author        Version       Description 
 * ------------------------------------------------------------------ 
 * 2016年1月7日      chengzhichao       1.0         1.0 Version 
 * </pre>
 */

public interface OpenModelConfigService {
	
	/**
	 * 
	 * Description: 根据模块信息，获取开关配置信息
	 *
	 * @param modelType
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2016年1月12日 下午3:33:49
	 */
	Map<String, Object> getByModelType(String modelType);

	/**
	 * Description:向用户发送优惠券，当不需要发送短信的时候，mobile传值为null或者""就行了
	 *
	 * @author 刘俊汉
	 * @param lenderLoginId
	 * @param modelType
	 * @param mobile
	 * @date 2018/5/14 14:25
	 * @return void
	 */
	void doSendCoupon(Integer lenderLoginId, String modelType, String mobile);
}
