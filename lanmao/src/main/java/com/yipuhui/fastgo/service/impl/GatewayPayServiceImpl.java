package com.yipuhui.fastgo.service.impl;
import com.yipuhui.fastgo.common.*;
import com.yipuhui.fastgo.dao.*;
import com.yipuhui.fastgo.enty.FundAccountHistory;
import com.yipuhui.fastgo.enty.RechargeRecord;
import com.yipuhui.fastgo.service.GatewayPayService;
import com.yipuhui.fastgo.utils.yphutil.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Service("gatewayPayService")
public class GatewayPayServiceImpl  implements GatewayPayService {
	

	
	@Resource
	private Map<String, Object> payMap;
	
	@Autowired
	private RechargeRecordMapper rechargeRecordMapper;


	@Autowired
	private FundAccountMapper fundAccountMapper;

	@Autowired
	private FundAccountHistoryMapper fundAccountHistoryMapper;
	
	@Override
	public Boolean doSyncPayResultCallBack(GatewaySyncCallbackInfo info, Date currentDate) {
		boolean flag = true;
		doRechargeCallBackBiz(info.getvOid(), info.getvPstring(), info.getvPstatus(), currentDate);

		return flag;
	}
	/**
	 * 
	 * Description: 充值回调处理业务
	 *
	 * @param v_oid 订单编号
	 * @param v_pstring 返回信息
	 * @param v_pstatus 订单状态
	 * @param currentDate 当前时间
	 * @Author xingym
	 * @Create Date: 2015年7月23日 下午4:44:48
	 */
	private void doRechargeCallBackBiz(String vOid,String vPstring ,String vPstatus ,Date currentDate){
		//1.根据订单编号查询，判断是否是重复回调
		Map<String,Object> rechargeParam = new HashMap<String, Object>(16);
		rechargeParam.put("orderNum", vOid);
		//实际查询是非成功的数据
		rechargeParam.put("rechargeStatus", RechargeRecordConstants.RECHARGE_STATUS_SUCCESS);
		
		
		//根据订单号和充值状态查询，充值状态为失败或者充值中的数据
		RechargeRecord rechargeRecord = rechargeRecordMapper.findRechargeRecordByOrderNumAndStatus(rechargeParam);
		System.out.println(">>>>>>>>>>>>>>>>>》》》》》》》"+rechargeRecord);
		//充值成功
		boolean loob =null != rechargeRecord&&(GatewayConstants.SYNC_RECHARGE_STATUS_SUCCESS.equals(vPstatus)||GatewayConstants.ASYNC_RECHARGE_STATUS_SUCCESS.equals(vPstatus));
		boolean  looc =null != rechargeRecord&&(GatewayConstants.SYNC_RECHARGE_STATUS_FAIL.equals(vPstatus)||GatewayConstants.ASYNC_RECHARGE_STATUS_FAIL.equals(vPstatus));
		if(loob){
			//2.更新充值记录
			rechargeRecord.setRechargeStatus(RechargeRecordConstants.RECHARGE_STATUS_SUCCESS);
			rechargeRecord.setPushStatus(RechargeRecordConstants.PUSH_STATUS_SUCCESS);
			rechargeRecord.setRemark(vPstring);
			rechargeRecord.setPushTime(currentDate);
			rechargeRecordMapper.updateByPrimaryKeySelective(rechargeRecord);
			
			//3.账户操作
			//3.1.查询客户信息
			Map<String,Object> fundAccountInfo = fundAccountMapper.findFundAccountInfoByLenderId(rechargeRecord.getLenderId());
			//3.2.账户处理
			updateFundAccountRecord(rechargeRecord.getRechargeAmount(),fundAccountInfo,currentDate,rechargeRecord);
		}else if(looc){
			//充值失败
			rechargeRecord.setRechargeStatus(RechargeRecordConstants.RECHARGE_STATUS_FAIL);
			//充值失败原因
			rechargeRecord.setRemark(vPstring);
			//推送状态
			rechargeRecord.setPushStatus(RechargeRecordConstants.PUSH_STATUS_SUCCESS);
			//推送时间，即回调时间
			rechargeRecord.setPushTime(currentDate);
			rechargeRecordMapper.updateByPrimaryKeySelective(rechargeRecord);
		}
	}
	
	
	/**
	 * 
	 * Description: 查询客户信息
	 *
	 * @param lenderDetailId
	 * @param serlNum 流水
	 * @param amount 金额
	 * @Author xingym
	 * @Create Date: 2015年7月24日 下午4:10:37
	 */
	private void updateFundAccountRecord(BigDecimal amount,Map<String,Object> fundAccountInfo,Date currentDate,RechargeRecord record){
		
		//1.资金账户加钱
		Map<String,Object> conditions = new HashMap<String, Object>(16);
		conditions.put("id", fundAccountInfo.get("id"));
		conditions.put("availableBalance", amount);
		conditions.put("operateTime", currentDate);
		fundAccountMapper.updateFundAccountInfoByConditions(conditions);
		//2.资金账户流水
		FundAccountHistory fundAccountHistory = new FundAccountHistory();
		fundAccountHistory.setCardCode((String)fundAccountInfo.get("card_code"));
		//3.生成流水号
		String serlNum = AccountUtil.serlNum();
		fundAccountHistory.setSerlNum(serlNum);
		fundAccountHistory.setSystemCode(SystemConstants.SYSTEM_CODE_ONLINE);
		fundAccountHistory.setTradeMoney(amount);
		fundAccountHistory.setTradeTime(currentDate);
		fundAccountHistory.setTradeType(FundAccountHistoryConstants.TRADE_TYPE_IN);

		if(RechargeRecordConstants.RECHARGE_WAY_PC.equals(record.getRechargeWay())){
			fundAccountHistory.setTradeSubject(FundAccountHistoryConstants.TRADE_SUBJECT_ONLINE_RECHARGE);
			fundAccountHistory.setRemark("网关充值：在线充值金额"+amount.setScale(2, BigDecimal.ROUND_HALF_UP)+"元。");
		}else if(RechargeRecordConstants.RECHARGE_WAY_IOS.equals(record.getRechargeWay())||RechargeRecordConstants.RECHARGE_WAY_ANDROID.equals(record.getRechargeWay())){
			//IOS Android 
			fundAccountHistory.setTradeSubject(FundAccountHistoryConstants.TRADE_SUBJECT_MOBILE_RECHARGE);
			fundAccountHistory.setRemark("手机充值：在线充值金额"+amount.setScale(2, BigDecimal.ROUND_HALF_UP)+"元。");
		}else if(RechargeRecordConstants.RECHARGE_WAY_WECHART.equals(record.getRechargeWay())){
			fundAccountHistory.setTradeSubject(FundAccountHistoryConstants.TRADE_SUBJECT_WECHART_RECHARGE);
			fundAccountHistory.setRemark("微信充值：在线充值金额"+amount.setScale(2, BigDecimal.ROUND_HALF_UP)+"元。");
		} else if(RechargeRecordConstants.RECHARGE_WAY_POS.equals(record.getRechargeWay())){
			fundAccountHistory.setTradeSubject(FundAccountHistoryConstants.TRADE_SUBJECT_WECHART_RECHARGE);
			fundAccountHistory.setRemark("POS充值：充值金额"+amount.setScale(2, BigDecimal.ROUND_HALF_UP)+"元。");
		}


		fundAccountHistoryMapper.insertSelective(fundAccountHistory);
	}
	
//	/**
//	 *
//	 * Description: pos机返回信息生成充值记录
//	 *
//	 * @return
//	 * @Author liujunhan
//	 * @Create Date: 2017年9月7日 上午10:04:26
//	 */
//	@Override
//	public Boolean doPayPosLog(LenderDetail lenderDetail,Map<String, Object> map) {
//		//post机充值生成充值记录
//		if (lenderDetail == null) {
//			logger.info(">>>>>>>>>>>>>>>>>>>>lenderDetail是空的>>>>>>>>>>>>>>>>>>>>>>");
//			return false;
//		}
//
//
//
//
//		//1.生成订单编号
//		Date date = new Date();
//		String datenow = DateTimeUtil.getDateShortString(date);//当前时间
//				String v_oid = genOrderNumSign((String)payMap.get("v_mid"), datenow);
//				//根据流水号查询是否有充值记录
//				if (rechargeRecordMapper.selectPayApplyBySul(map.get("mchnt_txn_ssn")+"") == null) {
//					//3.插入充值记录充值记录
//					RechargeRecord record = new RechargeRecord();
//					record.setLenderId(lenderDetail.getId());
//					record.setSerlNum( map.get("mchnt_txn_ssn")+"");
//					record.setOrderNum(v_oid);
//					record.setPayMethod("POS");//支付方式
//					record.setRechargeAmount(new BigDecimal(map.get("amt")+""));
//					record.setRechargeStatus(RechargeRecordConstants.RECHARGE_STATUS_DOING);
//					record.setRechargeWay(RegisterWayConstants.REGISTER_WAY_POS);
//					record.setRechargeTime(new Date());
//					record.setPayType("3");
//					rechargeRecordMapper.insertSelective(record);
//				}
//
//
//
//
//		//跟据流水号查询第三方充值结果
//				payResultQuery(lenderDetail, map.get("mchnt_txn_ssn")+"");
//
//
//
//		return false;
//	}
//	/**
//	 *
//	 * Description: pos充值结果查询
//	 *
//	 * @return
//	 * @Author liujunhan
//	 * @Create Date: 2017年9月7日 上午11:13:58
//	 */
//	protected boolean payResultQuery(LenderDetail lenderDetail,String mchnt_txn_ssn){
//
//		Map<String, Object> map = null;
//					Calendar calendara=Calendar.getInstance();
//					calendara.setTime(new Date());
//					calendara.set(Calendar.DAY_OF_MONTH, calendara.get(Calendar.DAY_OF_MONTH)-4);
//					// 生成流水号
//					String serlNum = AccountUtil.serlNum();
//					PayWithdrawQueryEntity payWithdrawQueryEntity = new PayWithdrawQueryEntity();
//
//					payWithdrawQueryEntity.setBusi_tp("PW11");
//					payWithdrawQueryEntity.setCust_no(lenderDetail.getMobile());
//					payWithdrawQueryEntity.setEnd_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//					payWithdrawQueryEntity.setMchnt_cd(PropertyUtil.getUrl("mchnt_cd"));
//					payWithdrawQueryEntity.setPage_no("");
//					payWithdrawQueryEntity.setMchnt_txn_ssn(serlNum);
//					payWithdrawQueryEntity.setPage_size("");
//					payWithdrawQueryEntity.setStart_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendara.getTime()));
//					payWithdrawQueryEntity.setTxn_ssn(mchnt_txn_ssn);
//					payWithdrawQueryEntity.setTxn_st("");
//					payWithdrawQueryEntity.setVer("0.44");
//
//					try {
//
//						payWithdrawQueryEntity.setSignature(RequestData
//								.createSignValueForReg(payWithdrawQueryEntity));
//						//订单插入日志
//							try {
//									logInsert(payWithdrawQueryEntity, null,"1");
//								} catch (Exception e) {
//									e.printStackTrace();
//							}
//						// 调用第三方接口
//						 map = WebUtils.doSelectHttpPost(payWithdrawQueryEntity,PropertyUtil.getUrl("paywithdraw_query_url"));
//						//订单插入日志
//							try {
//									logInsert(null, map,"1");
//								} catch (Exception e) {
//									e.printStackTrace();
//							}
//					} catch (IllegalArgumentException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (InvocationTargetException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//					//根据查询结果处理申请记录
//					logger.info(">>>>>>>>>>>>>>>>>>>>>>[((String)map.get(resp_code)).equals(0000)={}]",(map.get("resp_code")+"").equals("0000"));
//					if ((map.get("resp_code")+"").equals("0000")) {
//						doReslutModify(map);
//					}
//
//		return true;
//
//	}
//private void doReslutModify(Map<String , Object> map ){
//
//		Boolean  operateStatus = false;
//		if (map == null || !(Boolean)map.get("status")) {
//			return ;
//		}
//		Map<String , Object> results = null;
//		List<Map<String , Object>> result = null;
//
//		//整理结果，根据结果返回状态修改
//		results = (Map<String, Object>) map.get("results");
//		if (null == results) {
//
////			callBackMessageWithdrawService.messageFailureDispose(cashApply.getSerlNum(), "5000");
//			return;
//		}
//		result = (List<Map<String , Object>>) results.get("result");
//
//		if (result == null) {
//
////			callBackMessageWithdrawService.messageFailureDispose(cashApply.getSerlNum(), "5000");
//			return;
//		}
//		for (Map<String , Object> map2: result) {
//			//根据返回的验证txn_rsp_cd判断是否成功
//			if ((map2.get("txn_rsp_cd")+"").equals("0000")) {
//				Map<String , Object> map3 = new HashMap<String , Object>();
//				logger.info(">>>>>>>>>>>>>>>出入参数>>>>>>[ser_num={}]",map2.get("mchnt_ssn"));
//				//签名正确则进行相应的逻辑处理
//				GatewaySyncCallbackInfo gatewaySyncCallbackInfo = new GatewaySyncCallbackInfo();
//
//				gatewaySyncCallbackInfo.setV_oid(map2.get("mchnt_ssn")+"");
//				gatewaySyncCallbackInfo.setV_pmode(map2.get("ext_tp")+"");
//				gatewaySyncCallbackInfo.setV_pstatus("20");
//				gatewaySyncCallbackInfo.setV_pstring("支付完成");
//				gatewaySyncCallbackInfo.setV_amount(new BigDecimal(map2.get("txn_amt")+"").divide(new BigDecimal("100")).toString());
//				gatewaySyncCallbackInfo.setV_moneytype("人民币");
//				try {
//					lock.lock();
//					doSyncPayResultCallBack(gatewaySyncCallbackInfo, new Date());
//				} catch (Exception e) {
//				    e.printStackTrace();
//				}finally{
//					lock.unlock();
//				}
//				operateStatus = true;
//
//			}else {
//
//				//签名错误则进行相应的逻辑处理
//				GatewaySyncCallbackInfo gatewaySyncCallbackInfo = new GatewaySyncCallbackInfo();
//
//				gatewaySyncCallbackInfo.setV_oid( map2.get("mchnt_ssn")+"");
//				gatewaySyncCallbackInfo.setV_pmode("网银");
//				gatewaySyncCallbackInfo.setV_pstatus("30");
//				gatewaySyncCallbackInfo.setV_pstring("支付失败");
//				gatewaySyncCallbackInfo.setV_amount(new BigDecimal(map2.get("txn_amt")+"").divide(new BigDecimal("100")).toString());
//				gatewaySyncCallbackInfo.setV_moneytype("人民币");
//				try {
//					lock.lock();
//					doSyncPayResultCallBack(gatewaySyncCallbackInfo, new Date());
//				} catch (Exception e) {
//				    e.printStackTrace();
//				}finally{
//					lock.unlock();
//				}
//				logger.info("==================调用CallBackMessageController.messagePay方法   ==  充值失败！");
//				operateStatus = false;
//
//			}
//			RechargeCallbackLog record = new RechargeCallbackLog();
//			record.setInterfaceData(JSONObject.toJSONString(map));
//			record.setInterfaceDesc(RechargeCallBackLogConstants.JOB_QUERY);
//			record.setIsCallBack(RechargeCallBackLogConstants.IS_CALL_BACK_FALSE);
//			record.setOperateTime(new Date());
//			record.setOperState(operateStatus==true?"成功":"失败");
//			record.setResponseMsg(null);
//			rechargeCallBackLogService.insertCallBackLog(record);
//
//			logger.info("==================调用CallBackMessageController.messagePay方法结束！");
//		}
//
//
//	}
//
//	private void logInsert(PayWithdrawQueryEntity payWithdrawQueryEntity,Map<String , Object> map,String returnOrSend){
//
//		FyToYphLog  fyToYphLog = new FyToYphLog();
//
//		String json ="{ }";
//		if (payWithdrawQueryEntity != null) {
//			json = JSONObject.toJSONString(payWithdrawQueryEntity);
//		}else if (map != null && map.size() != 0) {
//			json = JSONObject.toJSONString(map);
//		}
//		fyToYphLog.setData(json);
//		fyToYphLog.setReturnOrSend(returnOrSend);
//		fyToYphLog.setSubmitTime(new Date());
//
//		if (payWithdrawQueryEntity != null) {
//			fyToYphLog.setSuml(payWithdrawQueryEntity.getMchnt_txn_ssn());
//		}else if (map != null && map.size() != 0) {
//			fyToYphLog.setSuml(map.get("mchnt_txn_ssn")+"");
//		}
//
//
//		fyToYphLogService.insertLog(fyToYphLog);
//
//	}

}
