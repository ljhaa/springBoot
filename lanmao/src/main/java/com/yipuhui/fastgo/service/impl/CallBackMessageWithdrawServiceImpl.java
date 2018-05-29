package com.yipuhui.fastgo.service.impl;


import com.yipuhui.fastgo.common.MagicParameterConstants;
import com.yipuhui.fastgo.dao.AccountMapper;
import com.yipuhui.fastgo.dao.CashApplyMapper;
import com.yipuhui.fastgo.enty.CashApply;
import com.yipuhui.fastgo.service.CallBackMessageWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
@Service("CallBackMessageWithdrawService")
public class CallBackMessageWithdrawServiceImpl implements
		CallBackMessageWithdrawService {

	@Autowired
	private CashApplyMapper cashApplyMapper;

	@Autowired
	private AccountMapper accountMapper;



	private final static Lock LOCKLOCK = new ReentrantLock();
	/**
	 *
	 * Description: 提现通知处理方法
	 *
	 * @param map
	 * @Author liujunhan
	 * @Create Date: 2017年6月23日 下午2:34:35
	 */
	@Override
	public Boolean messageDispose(Map<String, Object> map) {

		int b=0;

		Boolean  i= false;
         //根据流水号查询日志信息要求日志信息的cashStatus 状态为1.
		Map<String , Object> map2  = new HashMap<String, Object>(16);
		map2.put("serlNum",  map.get("serl_Num")+"");
		map2.put("cashStatus", "1");
		CashApply cashApply = cashApplyMapper.findCashApplyBySerlNum(map2);
		System.out.println("=========cashApply"+cashApply);
		//组装消息，更新提现日志需要
		if (null != cashApply) {
			try {
				//处理结果更新日志信息为成功，并冻结账户余额
				LOCKLOCK.lock();





				if (MagicParameterConstants.ZERO_FOUR.equals(map.get(MagicParameterConstants.RESP_CODE))) {
					logManage( map.get("serl_Num")+"", "1", "2", "2");
						//成功处理状态
					i=true;
				}else{
					logManage((String) map.get("serl_Num"), "1", "4", "4");
						//查询账户账户余额信息
						Map<String , Object>  resultMap = accountMapper.findBidSettledInfoByMobile(cashApply.getLenderId());
						//更新账户余额信息
						if (null == resultMap.get(MagicParameterConstants.FREEZE_AMOUNT)||null == resultMap.get(MagicParameterConstants.AVAILABLE_BALANCE)) {
							throw new Exception("账户余额操作失败");
						}
						map2.clear();
						map2.put("newAvailableBalance", cashApply.getRealCashAmount());
						map2.put("newFreezeAmount", (cashApply.getRealCashAmount().multiply(new BigDecimal("-1"))));
						map2.put("id", resultMap.get("id"));
						 b = accountMapper.updateSettledInfoById(map2);
				i=true;
				}


			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				LOCKLOCK.unlock();
			}
		}

		return i;
		//在账户内扣除相应余额




	}
	/**
	 *
	 * Description: 提现异步通知处理方法
	 *
	 * @param map
	 * @Author liujunhan
	 * @Create Date: 2017年6月23日 下午2:34:35
	 */
	@Override
	public Boolean messageAsyncDispose(Map<String, Object> map) {

		Boolean t = false;
         //根据流水号查询日志信息要求日志信息的cashStatus 状态为2.
		Map<String , Object> map2  = new HashMap<String, Object>(16);
		map2.put("serlNum", map.get("serl_Num")+"");
		map2.put("cashStatus", "2");
		CashApply cashApply = cashApplyMapper.findCashApplyBySerlNum(map2);

		//组装消息，更新提现日志需要
		if (null != cashApply) {
			try {
				//处理结果更新日志信息为成功，并扣除账户冻结金额的相应部分
				LOCKLOCK.lock();


					map2.clear();
					map2.put("SerlNum",  map.get("serl_Num")+"");
					map2.put("cashStatus", "2");
					map2.put("auditStatus", "3");
					map2.put("newCashStatus", "3");
					int	b=	cashApplyMapper.updataCashApplyBySerlNum(map2);
						//成功处理状态

						//查询账户账户余额信息
						Map<String , Object>  resultMap = accountMapper.findBidSettledInfoByMobile(cashApply.getLenderId());
						//更新账户余额信息
						if (null == resultMap.get(MagicParameterConstants.FREEZE_AMOUNT)||null == resultMap.get(MagicParameterConstants.AVAILABLE_BALANCE)||null == cashApply.getApplyCashAmount()) {
							throw new Exception("账户余额操作失败");
						}
						map2.clear();
						map2.put("newFreezeAmount", (cashApply.getApplyCashAmount().multiply(new BigDecimal("-1"))));
						map2.put("id", resultMap.get("id"));
						map2.put("cardCode", resultMap.get("card_code"));
						 int x = accountMapper.updateSettledInfoPayById(map2);

						 accountMapper.updateCoreInfoPayById(map2);
				t=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				LOCKLOCK.unlock();
			}
		}

		return t;


	}
	/**
	 *
	 * Description: 提现失败处理方法
	 *
	 * @param map
	 * @Author liujunhan
	 * @Create Date: 2017年6月23日 下午2:34:35
	 */
	@Override
	public Boolean messageFailureDispose(String serlNum,String respCode) {
		Boolean zzBoolean = false;
		try {
			Map<String , Object> map = new HashMap<String, Object>(16);
			map.put("serl_Num", serlNum);
			map.put("resp_code", respCode);
			zzBoolean =messageDispose(map);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zzBoolean;
	}

	
	
	private  Boolean logManage(
			String serlNum,
			String cashStatus,
			String auditStatus,
			String newCashStatus
			) throws Exception {
		//辅助操作变量
		int condition =0;
		boolean i = false;
		int b = 0;
		Map<String, Object> map2 = new HashMap<String, Object>(16);
		map2.put("SerlNum", serlNum);
		map2.put("cashStatus", cashStatus);
		map2.put("auditStatus", auditStatus);
		map2.put("newCashStatus", newCashStatus);
		do {
			
			b=	cashApplyMapper.updataCashApplyBySerlNum(map2);
		
		if (b==1) {
			i = true;
		}else if(condition>1){
			throw new Exception("账户余额操作失败");
		}
		condition++;
		} while (b == 0&& !i && condition<10); 
			//成功处理状态
		return i;
	}
}
