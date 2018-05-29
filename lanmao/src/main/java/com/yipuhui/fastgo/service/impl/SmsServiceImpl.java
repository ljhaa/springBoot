/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: SmsServiceImpl.java 
 *
 * Created: [2015年7月15日 下午5:54:33] by jie 
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

package com.yipuhui.fastgo.service.impl;

import com.dafy.sms.service.SendMessageService;
import com.dafy.sms.service.impl.SendMessageServiceImpl;
import com.yipuhui.fastgo.common.InterfaceConstants;
import com.yipuhui.fastgo.common.SmsConstants;
import com.yipuhui.fastgo.enty.SmsInterfaceLog;
import com.yipuhui.fastgo.service.SmsInterfaceLogService;
import com.yipuhui.fastgo.service.SmsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/** 
 *
 * Description: 发送短信Service实现类
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
@Service("smsService")
public class SmsServiceImpl implements SmsService {
	
	private static final Log LOG = LogFactory.getLog(SmsServiceImpl.class);
	
	@Autowired
	private SmsInterfaceLogService smsInterfaceLogService;
	
	@Override
	public void sendMsg(String mobile, String msg, int level, String smsType) {
		LOG.info("*** 发送短信  ***  开始");
		String operState = null;
		try {
			// 调用短信接口
			SendMessageService sendMessageService = new SendMessageServiceImpl();
			sendMessageService.sendMessage(mobile+"|", msg, SmsConstants.SMS_COMPANY, level);
			
			operState = InterfaceConstants.OPER_STATE_TRUE;
		} catch (Exception e) {
			LOG.error("*** 发送短信  ***  出错");
			LOG.error(e.getMessage(), e);
			operState = InterfaceConstants.OPER_STATE_FALSE;
		} finally {
			LOG.info("*** 发送短信  ***  结束");
			this.handleSmsInterfaceLog(new SmsInterfaceLog(smsType, mobile, msg, SmsConstants.SMS_COMPANY, level, operState, new Date()));
		}
	}
	
	/**
	 * 
	 * Description: 写入日志
	 *
	 * @param smsInterfaceLog
	 * @Author lijie
	 * @Create Date: 2015年7月15日 下午7:25:49
	 */
	private void handleSmsInterfaceLog(SmsInterfaceLog smsInterfaceLog){
		try {
			smsInterfaceLogService.addSmsInterfaceLog(smsInterfaceLog);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
}
