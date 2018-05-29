package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.SettleZz;
import com.yipuhui.fastgo.enty.SettleZzExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * 
 * @author 刘俊汉
 * @date 2018/5/14 14:32
 */
@Mapper
public interface SettleZzMapper extends BaseMapper<SettleZz>{
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:32
     * @return int
     */
    int countByExample(SettleZzExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:32
     * @return int
     */
    int deleteByExample(SettleZzExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param id
     * @date 2018/5/14 14:33
     * @return int
     */
    @Override
    int deleteByPrimaryKey(Integer id);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:33
     * @return int
     */
    @Override
    int insert(SettleZz record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:33
     * @return int
     */
    @Override
    int insertSelective(SettleZz record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:33
     * @return java.util.List<com.yipuhui.fastgo.enty.SettleZz>
     */
    List<SettleZz> selectByExample(SettleZzExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param id
     * @date 2018/5/14 14:33
     * @return com.yipuhui.fastgo.enty.SettleZz
     */
    @Override
    SettleZz selectByPrimaryKey(Integer id);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:33
     * @return int
     */
    int updateByExampleSelective(@Param("record") SettleZz record, @Param("example") SettleZzExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:33
     * @return int
     */
    int updateByExample(@Param("record") SettleZz record, @Param("example") SettleZzExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:33
     * @return int
     */
    @Override
    int updateByPrimaryKeySelective(SettleZz record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:33
     * @return int
     */
    @Override
    int updateByPrimaryKey(SettleZz record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:33
     * @return int
     */
    int updataStatusByRequstNo(SettleZz record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:34
     * @return com.yipuhui.fastgo.enty.SettleZz
     */
   List<SettleZz>  selectByRequstNo(SettleZz record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param addTime
 * @param status
     * @date 2018/5/14 14:39
     * @return java.util.List<com.yipuhui.fastgo.enty.SettleZz>
     */
    List<SettleZz> fundSettleZzByTimeAndStatus(@Param("addTime")Date addTime,@Param("status")String status);
}