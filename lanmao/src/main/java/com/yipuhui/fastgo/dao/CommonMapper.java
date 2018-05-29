package com.yipuhui.fastgo.dao;

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
public interface CommonMapper {
	/**
	 * Description:根据sql查询，返还单条数据
	 *
	 * @author 刘俊汉
	 * @param sql
	 * @date 2018/5/14 14:16
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
    public Map<String,Object> findBySql(String sql);
    
    /**
     * Description:根据sql查询，返还list
     *
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:16
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String,Object>> findListBySql(String sql);
    
    /**
     * Description:根据sql查询，返还数据条数
     *
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:16
     * @return java.lang.Integer
     */
    public Integer findCountBySql(String sql);
    
    /**
     * Description:根据sql查询，返回单一字段
     *
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:16
     * @return java.util.List<java.lang.String>
     */
    public List<String> findFieldsBySql(String sql);
    
    /**
     * Description:根据sql查询，返回唯一string属性
     *
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:17
     * @return java.lang.String
     */
    public String findSingleField(String sql);
    
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:38
     * @return java.lang.Integer
     */
    public Integer insertBySql(String sql);
    
    /**
     * Description:根据sql插入，返还id
     *
     * @author 刘俊汉
     * @param map
     * @date 2018/5/14 14:17
     * @return java.lang.Integer
     */
    public Integer insertByMapReturnId(Map<String, Object> map);
    /**
     * Description:
     *
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:17
     * @return void
     */
    public void updateBySql(String sql);
    
    /**
     * Description:根据sql查询数据条数（例：select count(*) as counts from ..）
     *
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:17
     * @return java.lang.Long
     */
    public Long getCountsBySql(String sql);
    
    /**
     * Description:删除记录
     *
     * @author 刘俊汉
     * @param sql
     * @date 2018/5/14 14:17
     * @return java.lang.Integer
     */
    public Integer deleteBySql(String sql);
    
}
