package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.UpdateCard;
import com.yipuhui.fastgo.enty.UpdateCardExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface UpdateCardMapper {
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:36
     * @return int
     */
    int countByExample(UpdateCardExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:36
     * @return int
     */
    int deleteByExample(UpdateCardExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param id
     * @date 2018/5/14 14:36
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:36
     * @return int
     */
    int insert(UpdateCard record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:36
     * @return int
     */
    int insertSelective(UpdateCard record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:36
     * @return java.util.List<com.yipuhui.fastgo.enty.UpdateCard>
     */
    List<UpdateCard> selectByExample(UpdateCardExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param id
     * @date 2018/5/14 14:36
     * @return com.yipuhui.fastgo.enty.UpdateCard
     */
    UpdateCard selectByPrimaryKey(Integer id);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:36
     * @return int
     */
    int updateByExampleSelective(@Param("record") UpdateCard record, @Param("example") UpdateCardExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:36
     * @return int
     */
    int updateByExample(@Param("record") UpdateCard record, @Param("example") UpdateCardExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:36
     * @return int
     */
    int updateByPrimaryKeySelective(UpdateCard record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:39
     * @return int
     */
    int updateByPrimaryKey(UpdateCard record);

}