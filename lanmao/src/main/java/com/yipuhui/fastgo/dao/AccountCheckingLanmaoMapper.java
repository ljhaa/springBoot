package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.AccountCheckingLanmao;
import com.yipuhui.fastgo.enty.AccountCheckingLanmaoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *
 *
 * @author 刘俊汉
 * @create 2018-04-13 16:25
 **/
@Mapper
public interface AccountCheckingLanmaoMapper {
    /**
     * fetch data by rule id
     *
     * @author 刘俊汉
     * @param example is AccountCheckingLanmaoExample
     * @date 2018/5/14 11:35
     * @return int
     */
    int countByExample(AccountCheckingLanmaoExample example);
   /**
    *
    * 方法说明:
    * @author 刘俊汉
    * @param example is AccountCheckingLanmaoExample
    * @date 2018/5/14 11:35
    * @return int
    */
    int deleteByExample(AccountCheckingLanmaoExample example);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param id is Data id
     * @date 2018/5/14 11:47
     * @return int
     */
    int deleteByPrimaryKey(Integer id);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param record is AccountCheckingLanmao
     * @date 2018/5/14 11:50
     * @return int
     */
    int insert(AccountCheckingLanmao record);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param record is AccountCheckingLanmao
     * @date 2018/5/14 11:51
     * @return int
     */
    int insertSelective(AccountCheckingLanmao record);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param example is AccountCheckingLanmaoExample
     * @date 2018/5/14 11:51
     * @return java.util.List<com.yipuhui.fastgo.enty.AccountCheckingLanmao>
     */
    List<AccountCheckingLanmao> selectByExampleWithBLOBs(AccountCheckingLanmaoExample example);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param example is AccountCheckingLanmaoExample
     * @date 2018/5/14 11:51
     * @return java.util.List<com.yipuhui.fastgo.enty.AccountCheckingLanmao>
     */
    List<AccountCheckingLanmao> selectByExample(AccountCheckingLanmaoExample example);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param id is AccountCheckingLanmao id
     * @date 2018/5/14 11:52
     * @return com.yipuhui.fastgo.enty.AccountCheckingLanmao
     */
    AccountCheckingLanmao selectByPrimaryKey(Integer id);
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:37
     * @return int
     */
    int updateByExampleSelective(@Param("record") AccountCheckingLanmao record, @Param("example") AccountCheckingLanmaoExample example);
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:37
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") AccountCheckingLanmao record, @Param("example") AccountCheckingLanmaoExample example);
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
 * @param example
     * @date 2018/5/14 14:39
     * @return int
     */
    int updateByExample(@Param("record") AccountCheckingLanmao record, @Param("example") AccountCheckingLanmaoExample example);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param record is AccountCheckingLanmao
     * @date 2018/5/14 11:53
     * @return int
     */
    int updateByPrimaryKeySelective(AccountCheckingLanmao record);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param record is AccountCheckingLanmao
     * @date 2018/5/14 11:54
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(AccountCheckingLanmao record);
    /**
     *
     * 方法说明:
     * @author 刘俊汉
     * @param record is AccountCheckingLanmao
     * @date 2018/5/14 11:55
     * @return int
     */
    int updateByPrimaryKey(AccountCheckingLanmao record);
}