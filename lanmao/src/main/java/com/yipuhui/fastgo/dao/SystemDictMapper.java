package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.SystemDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface SystemDictMapper extends BaseMapper<SystemDict>{
	
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param bankCode
	 * @date 2018/5/14 14:34
	 * @return com.yipuhui.fastgo.enty.SystemDict
	 */
	public SystemDict findSystemDictBycode(String bankCode);
	
	/**
	 * Description:根据条件获取字典表信息
	 *
	 * @author 刘俊汉
	 * @param conMap
	 * @date 2018/5/14 14:34
	 * @return com.yipuhui.fastgo.enty.SystemDict
	 */
	public SystemDict findByCon(Map<String, Object> conMap);


	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param dictType
	 * @date 2018/5/14 14:35
	 * @return java.util.List<com.yipuhui.fastgo.enty.SystemDict>
	 */
	public List<SystemDict> selectBidName(String dictType);

	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param sc
	 * @date 2018/5/14 14:39
	 * @return com.yipuhui.fastgo.enty.SystemDict
	 */
	SystemDict selectDictByremak(SystemDict sc);
}