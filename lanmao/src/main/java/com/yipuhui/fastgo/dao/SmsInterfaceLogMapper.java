package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.SmsInterfaceLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:47
 */
@Mapper
public interface SmsInterfaceLogMapper extends BaseMapper<SmsInterfaceLog>{
	
	/**
	 * 
	 * Description: 查询需要再次发送的日志记录
	 * @return 
	 *
	 * @Author lijie
	 * @Create Date: 2015年8月5日 下午3:22:14
	 */
	List<SmsInterfaceLog> selectResendSmsInterfaceLog();
}