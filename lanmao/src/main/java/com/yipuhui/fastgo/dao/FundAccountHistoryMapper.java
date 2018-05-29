package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.FundAccountHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface FundAccountHistoryMapper extends BaseMapper<FundAccountHistory>{
	
	/**
	 * 
	 * Description: 资金账户流水列表
	 *
	 * @param paramMap
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年8月19日 下午2:52:01
	 */
	List<Map<String, Object>> findAllByPage(Map<String, Object> paramMap);
	
	/**
	 * 
	 * Description: 资金账户流水列表总数
	 *
	 * @param paramMap
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年8月19日 下午2:53:29
	 */
	Long findAllByCount(Map<String, Object> paramMap);
}