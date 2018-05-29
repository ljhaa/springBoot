/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: SmsInterfaceLogServiceImpl.java 
 *
 * Created: [2015年7月15日 下午6:59:35] by jie 
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

import com.yipuhui.fastgo.dao.SmsInterfaceLogMapper;
import com.yipuhui.fastgo.enty.SmsInterfaceLog;
import com.yipuhui.fastgo.service.SmsInterfaceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 *
 * Description:
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

@Service("smsInterfaceLogService")
public class SmsInterfaceLogServiceImpl implements SmsInterfaceLogService {
	
	@Autowired
	private SmsInterfaceLogMapper smsInterfaceLogMapper;

	@Override
	public void addSmsInterfaceLog(SmsInterfaceLog smsInterfaceLog) {
		smsInterfaceLogMapper.insertSelective(smsInterfaceLog);
	}

	@Override
	public List<SmsInterfaceLog> selectResendSmsInterfaceLog() {
		return smsInterfaceLogMapper.selectResendSmsInterfaceLog();
	}

	@Override
	public void deleteCrmInterfaceLog(Integer id) {
		smsInterfaceLogMapper.deleteByPrimaryKey(id);
	}

}
