/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: CouponUtil.java 
 *
 * Created: [2015年11月5日 下午4:36:18] by jie 
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

package com.yipuhui.fastgo.utils.yphutil;

import com.yph.toolcenter.util.DateTimeUtil;

import java.util.Random;

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
 * 2015年11月5日      lijie       1.0         1.0 Version 
 * </pre>
 */

public class CouponUtil {
	
	/**
	 * 
	 * Description: 生成优惠券编号 (yyyyMMdd+九位随机数)
	 *
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年11月5日 下午4:38:05
	 */
	public static String getCouponNum(){
		Random random = new Random();
		String a = DateTimeUtil.getNowDateShortString();
		return "YHQ" + a + String.valueOf((random.nextInt(999999999)%(999999999-100000000+1) + 100000000));
	}
	
	
	public static void main(String[] args) {
		int lenth =50;
		for (int i = 0; i < lenth; i++) {
			System.out.println(getCouponNum());
		}
	}
}
