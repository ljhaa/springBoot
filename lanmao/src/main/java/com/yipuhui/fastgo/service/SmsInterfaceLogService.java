/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: SmsInterfaceLogService.java 
 *
 * Created: [2015年7月15日 下午6:58:51] by jie 
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


import com.yipuhui.fastgo.enty.SmsInterfaceLog;

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

public interface SmsInterfaceLogService {
	
	/**
	 * 
	 * Description: 写入日志
	 *
	 * @param smsInterfaceLog
	 * @Author lijie
	 * @Create Date: 2015年7月15日 下午7:09:24
	 */
	void addSmsInterfaceLog(SmsInterfaceLog smsInterfaceLog);
	
	/**
	 * 
	 * Description: 查询需要再次发送的日志记录
	 *
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年8月5日 下午3:20:48
	 */
	List<SmsInterfaceLog> selectResendSmsInterfaceLog();
	
	/**
	 * 
	 * Description: 删除没有操作成功的接口日志
	 *
	 * @param id
	 * @Author lijie
	 * @Create Date: 2015年8月5日 下午4:47:19
	 */
	void deleteCrmInterfaceLog(Integer id);

}
