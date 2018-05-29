/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: SmsService.java 
 *
 * Created: [2015年7月15日 下午5:53:19] by jie 
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

/** 
 *
 * Description: 发送短信Service
 *
 * @author lijie 
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年7月15日      lijie       1.0         1.0 Version 
 * </pre>
 */

public interface SmsService {
	
	/**
	 * 
	 * Description: 发送短信
	 *
	 * @param mobile    手机号
	 * @param msg		消息内容
	 * @param level		短信等级
	 * @param smsType   短信业务类型
	 * @Author lijie
	 * @Create Date: 2015年7月15日 下午6:52:56
	 */
	public void sendMsg(String mobile, String msg, int level, String smsType);
}
