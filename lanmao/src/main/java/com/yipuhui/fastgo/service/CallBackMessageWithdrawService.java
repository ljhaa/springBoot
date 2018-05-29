package com.yipuhui.fastgo.service;

import java.util.Map;


/**
 * 
 *
 * Description:提现回调服务类
 *
 * @author liujunhan
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2017年6月23日      liujunhan    1.0        1.0 Version 
 * </pre>
 */
public interface CallBackMessageWithdrawService {

	/**
	 * 
	 * Description: 提现通知处理方法
	 *
	 * @param map
	 * @return 
	 * @Author liujunhan
	 * @Create Date: 2017年6月23日 下午2:34:35
	 */
	public Boolean messageDispose(Map<String, Object> map);
	
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param map
	 * @date 2018/5/14 14:08
	 * @return java.lang.Boolean
	 */
	public Boolean messageAsyncDispose(Map<String, Object> map);
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param serlNum
 * @param respCode
	 * @date 2018/5/14 14:16
	 * @return java.lang.Boolean
	 */
	Boolean messageFailureDispose(String serlNum, String respCode);

	
	
}
