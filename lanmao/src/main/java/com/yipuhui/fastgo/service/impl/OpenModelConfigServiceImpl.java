/* 
 * Copyright (C) 2014-2016 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: OpenModelConfigServiceImpl.java 
 *
 * Created: [2016年1月7日 下午5:10:21] by cheng 
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

package com.yipuhui.fastgo.service.impl;
import com.yipuhui.fastgo.common.CouponConstants;
import com.yipuhui.fastgo.common.SmsConstants;
import com.yipuhui.fastgo.dao.LenderCouponRelationMapper;
import com.yipuhui.fastgo.dao.OpenModelConfigMapper;
import com.yipuhui.fastgo.enty.LenderCouponRelation;
import com.yipuhui.fastgo.service.OpenModelConfigService;
import com.yipuhui.fastgo.service.SmsService;
import com.yipuhui.fastgo.utils.YphThreadPool;
import com.yipuhui.fastgo.utils.yphutil.CouponUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/** 
 *
 * Description:
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
@Service
public class OpenModelConfigServiceImpl implements OpenModelConfigService {
	
	@Autowired
	private OpenModelConfigMapper openModelConfigMapper;
	
	@Autowired
	private LenderCouponRelationMapper lenderCouponRelationMapper;
	
	@Autowired
	private SmsService smsService;

	private static final Log logger = LogFactory.getLog(OpenModelConfigServiceImpl.class);
	
	@Override
	public void doSendCoupon(Integer lenderLoginId, final String modelType, final String mobile) {
		Map<String, Object> params = openModelConfigMapper.getByModelType(modelType);
		String isOpen = String.valueOf(params.get("isOpen"));
		if(CouponConstants.MODEL_IS_OPEN.equals(isOpen)) {
			try {
				final LenderCouponRelation lcr = new LenderCouponRelation();
				lcr.setLenderLoginId(lenderLoginId);
				lcr.setCouponName(String.valueOf(params.get("modelDescription")));
				// 设置优惠券编号
				lcr.setCouponNum(CouponUtil.getCouponNum());
				// 设置优惠券类型
				String couponType = String.valueOf(params.get("couponType"));
				lcr.setCouponType(couponType);
				// 红包使用限制条件(抵扣)
				String useLintLimit = String.valueOf(params.get("useLintLimit"));
				// 现金红包金额
				String couponLimit = String.valueOf(params.get("couponLimit"));
				// 判断是 抵扣还是 现金
				if(CouponConstants.COUPON_TYPE_DIKOU.equals(couponType)) {
					lcr.setUseLineLimit(new BigDecimal(useLintLimit));
				} 
				lcr.setCouponLimit(new BigDecimal(couponLimit));
				// 设置适用范围
				lcr.setApplicationRange("1,2,3");
				// 设置使用状态
				lcr.setUseStatus(CouponConstants.USE_STATUS_UNUSED);
				// 设置有效开始日期
				lcr.setValidStartDate(new Date());
				// 设置失效日期
				Calendar calendar = Calendar.getInstance();
				Integer couponValidDays = (Integer)params.get("couponValidDays"); 
				calendar.add(Calendar.DATE, couponValidDays); 
				Date validEndDate = calendar.getTime();
				lcr.setValidEndDate(validEndDate);
				// 设置创建日期
				lcr.setCreateTime(new Date());
				lenderCouponRelationMapper.insertSelective(lcr);
				// 是否发送短信
				if(mobile != null) {


					YphThreadPool.runThread(new Runnable() {
						@Override
						public void run() {
							sendMsg(mobile, modelType, lcr);
						}
					});

				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				logger.error("用户lenderLoginId为："+lenderLoginId+"发送优惠券失败");
				throw e;
			}
		}
	}

	private void sendMsg(String mobile, String modelType, LenderCouponRelation lcr) {
		String msg = null;
		int couponLimit = lcr.getCouponLimit().intValue();
		if(modelType.equals(CouponConstants.MODEL_TYPE_ZHUCE)) {
			msg = SmsConstants.SMS_ZHUCE_MSG.replaceFirst("#cash#", String.valueOf(couponLimit));
		} else if(modelType.equals(CouponConstants.MODEL_TYPE_RENZHENG)){
			msg = SmsConstants.SMS_SHIMING_MSG.replaceFirst("#cash#", String.valueOf(couponLimit));
		} else if(modelType.equals(CouponConstants.MODEL_TYPE_BANK)){
			msg = SmsConstants.SMS_BANK_MSG.replaceFirst("#cash#", String.valueOf(couponLimit));
		}
		smsService.sendMsg(mobile, msg, SmsConstants.SMS_LEVEL_FIVE, SmsConstants.SMS_TYPE_7);
	}

	@Override
	public Map<String, Object> getByModelType(String modelType) {
		return openModelConfigMapper.getByModelType(modelType);
	}
	
}
