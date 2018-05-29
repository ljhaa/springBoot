package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.LanmaoServiceLog;
import com.yipuhui.fastgo.enty.LanmaoServiceLogExample;
import com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:21
 */
@Mapper
public interface LanmaoServiceLogMapper {
    /**
     * Description:
     *
     * @param example
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:21
     */
    int countByExample(LanmaoServiceLogExample example);

    /**
     * Description:
     *
     * @param example
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:21
     */
    int deleteByExample(LanmaoServiceLogExample example);

    /**
     * Description:
     *
     * @param id
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:21
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Description:
     *
     * @param record
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:21
     */
    int insert(LanmaoServiceLogWithBlobs record);

    /**
     * Description:
     *
     * @param record
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    int insertSelective(LanmaoServiceLogWithBlobs record);

    /**
     * Description:
     *
     * @param example
     * @return java.util.List<com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs>
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    List<LanmaoServiceLogWithBlobs> selectByExampleWithBLOBs(LanmaoServiceLogExample example);

    /**
     * Description:
     *
     * @param example
     * @return java.util.List<com.yipuhui.fastgo.enty.LanmaoServiceLog>
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    List<LanmaoServiceLog> selectByExample(LanmaoServiceLogExample example);

    /**
     * Description:
     *
     * @param id
     * @return com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    LanmaoServiceLogWithBlobs selectByPrimaryKey(Integer id);

    /**
     * Description:
     *
     * @param record
     * @param example
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    int updateByExampleSelective(@Param("record") LanmaoServiceLogWithBlobs record, @Param("example") LanmaoServiceLogExample example);

    /**
     * Description:
     *
     * @param record
     * @param example
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    int updateByExampleWithBLOBs(@Param("record") LanmaoServiceLogWithBlobs record, @Param("example") LanmaoServiceLogExample example);

    /**
     * Description:
     *
     * @param record
     * @param example
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    int updateByExample(@Param("record") LanmaoServiceLog record, @Param("example") LanmaoServiceLogExample example);

    /**
     * Description:
     *
     * @param record
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    int updateByPrimaryKeySelective(LanmaoServiceLogWithBlobs record);

    /**
     * Description:
     *
     * @param record
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    int updateByPrimaryKeyWithBLOBs(LanmaoServiceLogWithBlobs record);

    /**
     * Description:
     *
     * @param record
     * @return int
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    int updateByPrimaryKey(LanmaoServiceLog record);

    /**
     * Description:
     *
     * @param record
     * @return com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs
     * @author 刘俊汉
     * @date 2018/5/14 14:22
     */
    LanmaoServiceLogWithBlobs selectObjectByRequestNo(LanmaoServiceLogWithBlobs record);


}