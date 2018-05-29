package com.yipuhui.fastgo.service.impl;

import com.dafy.sms.service.SendMessageService;
import com.dafy.sms.service.impl.SendMessageServiceImpl;
import com.yipuhui.fastgo.common.*;
import com.yipuhui.fastgo.dao.CashApplyMapper;
import com.yipuhui.fastgo.dao.FundAccountHistoryMapper;
import com.yipuhui.fastgo.dao.FundAccountMapper;
import com.yipuhui.fastgo.dao.LenderDetailMapper;
import com.yipuhui.fastgo.enty.CashApply;
import com.yipuhui.fastgo.enty.FundAccountHistory;
import com.yipuhui.fastgo.enty.LenderDetail;
import com.yipuhui.fastgo.service.CashApplyService;
import com.yipuhui.fastgo.utils.AppConfig;
import com.yipuhui.fastgo.utils.yphutil.AccountUtil;
import com.yipuhui.fastgo.utils.yphutil.RandomNumUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Service("cashApplyService")
public class CashApplyServiceImpl implements CashApplyService {
	private static final Log logger = LogFactory.getLog(CashApplyServiceImpl.class);
	private static Lock lock = new ReentrantLock();
	@Autowired
	private CashApplyMapper cashApplyMapper;
	
	@Autowired
	private FundAccountMapper fundAccountMapper;

	
	@Autowired
	private LenderDetailMapper lenderDetailMapper;
	
	@Autowired
	private FundAccountHistoryMapper fundAccountHistoryMapper;


	@Override
	public CashApply findCashApplyBySerlNum(Map<String, Object> map) {
		return cashApplyMapper.findCashApplyBySerlNum(map);
	}

	/**
	 * 
	 * Description: 提现退票处理
	 *
	 * @Author liujunhan
	 * @Create Date: 2017年10月31日 上午11:11:56
	 */
	@Override
	public void cashRefund(Map<String, Object> map) {
		// TODO Auto-generated method stub
		//查询用户信息
		Map<String, Object> map2 = new HashMap<String, Object>(1);

		
		map2.put("serlNum", map.get("withdrawRequestNo"));
		//查询提现记录状态
		CashApply cashApply = cashApplyMapper.cashApplyBySerlNum(map2);

		logger.info("cashApply="+cashApply);

		LenderDetail lenderDetail = lenderDetailMapper.selectByPrimaryKey(cashApply.getLenderId());



			

			try{
				lock.lock();
				logger.info("==========提现资金退票开始============");
				//1.查询客户信息
				Map<String,Object> fundAccountInfo = fundAccountMapper.findFundAccountInfoByLenderId(lenderDetail.getId());
				//2.资金账户加钱
				Map<String,Object> conditions = new HashMap<String, Object>(3);
				conditions.put("id", fundAccountInfo.get("id"));
				conditions.put("availableBalance",map.get("rollbackAmount"));
				
				conditions.put("operateTime", new Date());
				fundAccountMapper.updateFundAccountInfoByConditions(conditions);
				//提现记录状态改为失败
				CashApply cashApply2 = new CashApply();
				cashApply2.setCashApplyId(cashApply.getCashApplyId());
				cashApply2.setCashStatus(CashApplyConstants.CASH_STATUS_FAIL);
				cashApplyMapper.updateByPrimaryKeySelective(cashApply2);
				try {
					sendMobVerCode( lenderDetail.getMobile(),new SimpleDateFormat("yyyy-MM-dd").format(cashApply.getApplyTime())  ,cashApply.getApplyCashAmount().toString());
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("==========提现退票短信发送失败============");
				}
				
				//3.资金账户流水
				FundAccountHistory fundAccountHistory = new FundAccountHistory();
				fundAccountHistory.setCardCode(lenderDetail.getCardNum());
				//生成流水号
				String serlNum = AccountUtil.serlNum();
				fundAccountHistory.setSerlNum(serlNum);
				fundAccountHistory.setTradeMoney( new BigDecimal(String.valueOf(map.get("rollbackAmount"))).setScale(2));
				fundAccountHistory.setSystemCode(SystemConstants.SYSTEM_CODE_ONLINE);
				fundAccountHistory.setTradeSubject(FundAccountHistoryConstants.TRADE_TYPE_IN);
				fundAccountHistory.setTradeTime(new Date());
				fundAccountHistory.setRemark("提现失败退票：提现失败，退票金额"+map.get("rollbackAmount")+"元。");
				fundAccountHistoryMapper.insertSelective(fundAccountHistory);
			}finally{
				logger.info("==========提现资金退票结束============");
				lock.unlock();
			}

		
		
		
		
		
	}


	private AppConfig appConfig = AppConfig.getConfig();
	/**
	 * 
	 * Description: 向该手机号发送验证码
	 *
	 * @param mobile
	 * @Author liujunhan
	 * @Create Date: 2015年10月21日 上午11:30:40
	 */
	private boolean sendMobVerCode(String mobile, String dateString ,String amount){
		String mobVerCode = null;
		try {
			mobVerCode = RandomNumUtil.getRandomNum("6");
			String msg = SmsConstants.SMS_CASH_NONEYBACK_MSG.replaceFirst("#date#", dateString);
			msg = msg.replaceFirst("#amount#", amount);
			SendMessageService sms = new SendMessageServiceImpl();
			String rtnMsg = sms.sendMessage(mobile+"|", msg, SmsConstants.SMS_COMPANY, SmsConstants.SMS_LEVEL_FIVE);

			boolean bolen = (appConfig.getDataBypro(MagicParameterConstants.SENDMSG)!=null&&MagicParameterConstants.FALSE.equals(appConfig.getDataBypro(MagicParameterConstants.SENDMSG)))|| SmsConstants.SMS_RTN_SUCCESS_MSG.equals(rtnMsg);
			if(bolen) {
//			if(true){
				logger.info("向手机号"+mobile+"发送短信成功。短信内容："+msg);
				
				return true;
			} else {
				logger.info("提现退票短信发送失败");
			
				return false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}
	
}
