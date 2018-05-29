/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: LenderServiceImpl.java 
 *
 * Created: [2015年4月22日 上午10:13:05] by jie 
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

import com.yipuhui.fastgo.dao.LenderLoginMapper;
import com.yipuhui.fastgo.enty.LenderLogin;
import com.yipuhui.fastgo.service.LenderLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
 * 2015年4月22日      lijie       1.0         1.0 Version 
 * </pre>
 */

@Service("lenderLoginService")
public class LenderLoginServiceImpl implements LenderLoginService {
	
	@Autowired
	private LenderLoginMapper lenderLoginMapper;
	@Override
	public LenderLogin selectByPrimaryKey(Integer id) {
		return lenderLoginMapper.selectByPrimaryKey(id);
	}

	@Override
	public LenderLogin fundObjectByUserNum(String lenderNum) {
		return lenderLoginMapper.fundObjectByUserNum(lenderNum);
	}
}
