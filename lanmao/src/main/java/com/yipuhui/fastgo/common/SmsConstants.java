/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: SMSConstants.java 
 *
 * Created: [2015年5月8日 下午12:10:34] by jie 
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

package com.yipuhui.fastgo.common;

import com.dafy.sms.service.SendMessageService;
import com.dafy.sms.service.impl.SendMessageServiceImpl;
import com.yipuhui.fastgo.utils.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 *
 * Description: 短信内容常量
 *
 * @author lijie
 * @version 1.0
 * 
 *          <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年5月8日      lijie       1.0         1.0 Version
 * </pre>
 */

public class SmsConstants {


	private  static AppConfig appconfig= AppConfig.getConfig();

	private final static Logger logger = LoggerFactory
			.getLogger(SmsConstants.class);

	/**
	 * 短信title
	 */
	public static final String SMS_COMPANY = "【亿谱汇】";

	/**
	 *  短信等级（1-5） 数值越高优先级越高
	 */
	public static final Integer SMS_LEVEL_ONE = 1;
	public static final Integer SMS_LEVEL_TWO = 2;
	public static final Integer SMS_LEVEL_THREE = 3;
	public static final Integer SMS_LEVEL_FOUR = 4;
	public static final Integer SMS_LEVEL_FIVE = 5;

	/**
	 *  执行成功 返回的信息
	 */
	public static final String SMS_RTN_SUCCESS_MSG = "执行成功";

	//****************** 短信类型 ******************
	/**
	 *  开通账户
	 */
	public static final String SMS_TYPE_1 = "1";
	/**
	 *  放款
	 */
	public static final String SMS_TYPE_2 = "2";
	/**
	 *  赎回
	 */
	public static final String SMS_TYPE_3 = "3";
	/**
	 *  提现申请
	 */
	public static final String SMS_TYPE_4 = "4";
	/**
	 *  分配预约客户
	 */
	public static final String SMS_TYPE_5 = "5";
	/**
	 *  提现成功
	 */
	public static final String SMS_TYPE_6 = "6";
	/**
	 *  红包派发
	 */
	public static final String SMS_TYPE_7 = "7";
	/**
	 *  活动通知
	 */
	public static final String SMS_TYPE_8 = "8";
	/**
	 *  认购通知
	 */
	public static final String SMS_TYPE_9 = "9";
	//****************** 短信类型 ******************

	//****************** 短信类型 ******************
	/**
	 *  未发送
	 */
	public static final String SMS_SEND_STATUS_UNSENT = "0";
	/**
	 *  已发送
	 */
	public static final String SMS_SEND_STATUS_SENT = "1";
	//****************** 短信类型 ******************

	//****************** 短信内容 ******************/
	/**
	 *  找回密码
	 */
	public static final String SMS_FORGET_PWD_MSG = "验证码：#code# （2分钟内输入有效），您正在进行找回密码操作，如需帮助请联系4008706058。";

	/**
	 * 找回支付密码
	 */
	public static final String SMS_FORGET_TRADE_PWD_MSG = "验证码：#code# （2分钟内输入有效），您正在进行找回支付密码操作，如需帮助请联系4008706058。";

	/**
	 *  初始化密码内容
	 */
	public static final String SMS_SEND_MSG = "尊敬的客户:#name#，您的平台账户已开通，用户名：#mobile#，初始密码：#pwd#，请登录 ephwealth.com 后进行修改。";

	/**
	 *  注册短信
	 */
	public static final String SMS_REGIST_MSG = "验证码：#code#（2分钟内有效），欢迎注册亿谱汇。任何向您索要验证码的都是骗子，如需帮助请联系4008706058。";

	/**
	 *  出借短信
	 */
	public static final String SMS_LEND_SUCCESS_MSG = "您投资的“#product#”项目已经成立，投资金额：#investAmount#元，合同编号：#contractNum#，计息日期为#interestAccrualDate#，详情请登录 http://www.ephwealth.com 查看。";

	/**
	 *  赎回短信
	 */
	public static final String SMS_DUE_REDEEM_MSG = "您投资的“#product#”项目已经到期，合同编号：#contractNum#，回款金额#redemptionMoney#元已放入您的账户，可登录 http://www.ephwealth.com 申请提现。";

	/**
	 *  投资预约
	 */
	public static final String SMS_INVEST_APPLY_MSG = "已分配预约客户：#name#，手机号：#mobile#，请及时联系。";

	/**
	 *  提现申请
	 */
	public static final String SMS_CASH_APPLY_MSG = "您的申请提交成功，提现金额为#applyCashAmount#元，手续费为#handlingCharge#元,实际到账为#realCashAmount#元，将于1-2个工作日到账，请注意查收。如有疑问请致电4008706058。";

	/**
	 *  提现成功
	 */
	public static final String SMS_CASH_SUCCESS_MSG = "您于#date#申请提现成功，提现金额为#applyCashAmount#元，手续费为#handlingCharge#元,实际到账为#realCashAmount#元，请及时查看银行卡变动，如有疑问请致电4008706058。";

	/**
	 *  成立短信
	 */
	public static final String SMS_INVEST_ESTABLISH_MSG = "尊敬的客户，您投资的#product#标的已经成立，投资金额：#amt#元，计息日：#date#，详情请登录 ephwealth.com 查看。";


	/**
	 *  借款到账短信
	 */
	public static final String SMS_BWRROW_SUCCESS_MSG = "尊敬的客户，“产品名称”标的已经成立，可提现金额：#amount#元，借款总额：#amountAll#元，下次还款日期为#date#，详情请登录 ephwealth.com 查看。";

	/**
	 * 新增借款人开户短信
	 */
	public static final String SMS_BWRROW_ACCOUNT_MSG = "尊敬的客户，已为您开通亿谱汇线上借款账户，登录名：#user#密码：#password#，同时已开通富友支付金账户，提现密码：#passwordT#，详情咨询客服4008706058。";

	/**
	 *  每月还本付息短信
	 */
	public static final String SMS_REPAY_MSG = "尊敬的客户，您#investDate#投资的#prodactName#标的今日回款：#amountAll#元，详情请登录 ephwealth.com 查看。";

	/**
	 *  借款人还款提醒短信
	 */
	public static final String SMS_BWRROW_REPAY_MSG = "尊敬的客户，您有#amount#元借款本息于#date#到期，请提前一天登录 ephwealth.com 充值还款，谢谢合作。";

	/**
	 *  散标流标信息
	 */
	public static final String SMS_INVEST_FAILURE_BID_MSG = "尊敬的客户，您#date#投资的#productname#标的因募集期结束未满标而流标，投资金额#amount#元已返还您账户的可用余额。";

	/**
	 *  提现退票通知短信
	 */
	public static final String SMS_CASH_NONEYBACK_MSG = "尊敬的客户，您#date#申请提现#amount#元未成功，请登录 ephwealth.com 重新提现，如需帮助请联系4008706058。";
	/**
	 *
	 * 红包派发
	 *现金红包 恭喜您获得#cash#元现金红包，请登录 ephwealth.com 查看，领取成功后可提现。
	 *public static final String SMS_XIANJIN_MSG =
	 *"尊敬的客户，#activityName#已结束，恭喜您获得#cash#元现金红包，请登录网站平台点击红包领取，现金将存进您的可用余额。";
	 */
	public static final String SMS_XIANJIN_MSG = "恭喜您获得#cash#元现金红包，请登录 ephwealth.com 查看，领取成功后可提现。";
	/**
	 *  折扣
	 */
	public static final String SMS_DIKOU_MSG = "尊敬的客户，亿谱汇赠送你一个大额抵扣红包，已悄悄放入你的账户，请登录网站平台查看。";
	/**
	 *  加息
	 */
	public static final String SMS_JIAXI_MSG = "尊敬的客户，亿谱汇赠送你一个加息红包，已悄悄放入你的账户，请登录网站平台查看。";

	/**
	 *  认购
	 */
	public static final String SMS_ORDER_MSG = "尊敬的亿谱汇用户，您的认购申请已提交成功，请确保银行卡账户余额充足。";

	/*** 用户注册奖励红包 ***/
	public static final String SMS_ZHUCE_MSG = "尊敬的客户，感谢您注册亿谱汇平台，首次注册，赠送您#cash#元红包。关注微信服务号：yipuhuicaifu，轻松变投资达人。";

	/*** 用户实名认证奖励红包 ***/
	public static final String SMS_SHIMING_MSG = "尊敬的客户，恭喜您完成实名认证，认证成功赠送您#cash#元红包，进入我的账户，点击优惠券查看详情。";

	/*** 用户绑卡成功奖励红包 ***/
	public static final String SMS_BANK_MSG = "尊敬的客户，恭喜您完成绑卡，绑卡成功赠送您#cash#元红包，进入我的账户，点击优惠券查看详情。";

	
	/**********************修改银行卡失败****************/
	public static final String SMS_BANK_FAILURE_MSG = "尊敬的客户，您申请变更银行卡未成功，请检查您的资料并重新提交，如需帮助请联系4008706058 。";
	
	/****************** 短信内容 ******************/

	public static boolean sendMobVerCode(String mobile, String msg,
			Map<String, Object> params) {

		try {

			if (params.size() > 0) {
				for (String key : params.keySet()) {

					msg = msg
							.replaceFirst(key, String.valueOf(params.get(key)));

				}

			}

			SendMessageService sms = new SendMessageServiceImpl();
			String rtnMsg = sms.sendMessage(mobile + "|", msg,
					SmsConstants.SMS_COMPANY, SmsConstants.SMS_LEVEL_FIVE);

			boolean bole = (appconfig.getDataBypro(MagicParameterConstants.SENDMSG) != null && MagicParameterConstants.FALSE
					.equals(appconfig.getDataBypro("sendmsg")))
					|| SmsConstants.SMS_RTN_SUCCESS_MSG.equals(rtnMsg);
			if (bole) {
				// if(true){
				logger.info("向手机号" + mobile + "发送短信成功。短信内容：" + msg);

				return true;
			} else {
				logger.info("还本付息短信发送失败");

				return false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}

	}

}
