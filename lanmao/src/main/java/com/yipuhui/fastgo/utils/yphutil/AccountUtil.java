/* 
 * Copyright (C) 2006-2015 亿谱汇财富投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: PlatformAccountServiceImpl.java 
 *
 * Created: [2015年1月10日 下午4:34:24] by bin 
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
 * ProjectName: yph-core 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.utils.yphutil;

import com.yph.toolcenter.util.DateTimeUtil;

import java.util.Random;

/** 
 *
 * Description:账务工具类
 *
 * @author yubin
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年1月10日      yubin       1.0         1.0 Version 
 * </pre>
 */

public class AccountUtil {
	
	/**
	 * 
	 * Description: 生成交易流水号
	 *
	 * @return
	 * @Author yubin
	 * @Create Date: 2015年1月10日 下午4:35:18
	 */
	public static String serlNum(){
		 Random random = new Random();
		 String a = DateTimeUtil.getNowDateShortString();
		 return a + String.valueOf((random.nextInt(999999999)%(999999999-100000000+1) + 100000000)) + String.valueOf((random.nextInt(9999)%(9999-1000+1) + 1000));
	}

	
	public static void main(String[] args) {
//		for (int i = 0; i < 5; i++) {
//
//			System.out.println(serlNum());
//		}
	}

}
