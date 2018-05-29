/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: LenderSession.java 
 *
 * Created: [2015年4月27日 下午2:23:20] by jie 
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
 * ProjectName: ephwealth-core 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.enty;

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
 * 2015年4月27日      lijie       1.0         1.0 Version 
 * </pre>
 */

public class LenderLoginVo {
	
	private LenderLogin lenderLogin;
	
	/**
	 * 出借人编号
	 */
	private String lenderNum;

	public LenderLogin getLenderLogin() {
		return lenderLogin;
	}

	public void setLenderLogin(LenderLogin lenderLogin) {
		this.lenderLogin = lenderLogin;
	}

	public String getLenderNum() {
		return lenderNum;
	}

	public void setLenderNum(String lenderNum) {
		this.lenderNum = lenderNum;
	}

}
