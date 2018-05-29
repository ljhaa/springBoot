/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: BaseMapper.java 
 *
 * Created: [2014-11-24 下午07:13:50] by ydw 
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
 * ProjectName: sping-mvc 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.dao;

import java.util.List;
import java.util.Map;


/**
 *
 * Description: BaseMapper基本实现方法
 *
 * @author ydw
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-11-24    ydw       1.0        1.0 Version 
 * </pre>
 */

public interface BaseMapper<T> {
	
	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:06
	 * @return int
	 */
	public int insert(T record);

	/**
	 * 
	 * 方法说明:
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:06
	 * @return int
	 */
	public int insertSelective(T record);
	
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:07
	 * @return int
	 */
	public int updateByPrimaryKeySelective(T record);

	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:07
	 * @return int
	 */
	public int updateByPrimaryKey(T record);
	
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param primaryKey
	 * @date 2018/5/14 14:07
	 * @return int
	 */
	public int deleteByPrimaryKey(Integer primaryKey);
	
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param primaryKey
	 * @date 2018/5/14 14:07
	 * @return T
	 */
	public T selectByPrimaryKey(Integer primaryKey);
	
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param paramsCondition
	 * @date 2018/5/14 14:07
	 * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 */
	public List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);
    
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param paramsCondition
	 * @date 2018/5/14 14:07
	 * @return java.lang.Long
	 */
    public Long findAllByPageCount(Map<String, Object> paramsCondition);
    
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param paramsCondition
     * @date 2018/5/14 14:07
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> findAllRetMapNoPage(Map<String, Object> paramsCondition);
    
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param paramsCondition
     * @date 2018/5/14 14:07
     * @return java.util.List<T>
     */
    public List<T> findAllRetEntityNoPage(Map<String, Object> paramsCondition);
    
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param objId
     * @date 2018/5/14 14:07
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> selectRetMapByPrimaryKey(Integer objId);
    
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param paramsCondition
     * @date 2018/5/14 14:16
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> selectRetMapByParamsCondition(Map<String, Object> paramsCondition);
}
