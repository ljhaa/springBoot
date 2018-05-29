package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.SettleNotice;
import com.yipuhui.fastgo.enty.SettleNoticeExample;
import com.yipuhui.fastgo.enty.SettleNoticeWithBlobs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Description:
 * 
 * @author 刘俊汉
 * @date 2018/5/14 14:30
 */
@Mapper
public interface SettleNoticeMapper {
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:30
     * @return int
     */
    int countByExample(SettleNoticeExample example);
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:30
     * @return int
     */
    int deleteByExample(SettleNoticeExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param id
     * @date 2018/5/14 14:30
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:30
     * @return int
     */
    int insert(SettleNoticeWithBlobs record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:31
     * @return int
     */
    int insertSelective(SettleNoticeWithBlobs record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:31
     * @return java.util.List<com.yipuhui.fastgo.enty.SettleNoticeWithBlobs>
     */
    List<SettleNoticeWithBlobs> selectByExampleWithBLOBs(SettleNoticeExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param example
     * @date 2018/5/14 14:31
     * @return java.util.List<com.yipuhui.fastgo.enty.SettleNotice>
     */
    List<SettleNotice> selectByExample(SettleNoticeExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param id
     * @date 2018/5/14 14:31
     * @return com.yipuhui.fastgo.enty.SettleNoticeWithBlobs
     */
    SettleNoticeWithBlobs selectByPrimaryKey(Integer id);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:31
     * @return int
     */
    int updateByExampleSelective(@Param("record") SettleNoticeWithBlobs record, @Param("example") SettleNoticeExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:31
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") SettleNoticeWithBlobs record, @Param("example") SettleNoticeExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/14 14:32
     * @return int
     */
    int updateByExample(@Param("record") SettleNotice record, @Param("example") SettleNoticeExample example);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:32
     * @return int
     */
    int updateByPrimaryKeySelective(SettleNoticeWithBlobs record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:32
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(SettleNoticeWithBlobs record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:39
     * @return int
     */
    int updateByPrimaryKey(SettleNotice record);
}