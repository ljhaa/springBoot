package com.yipuhui.fastgo.dao;

import com.yipuhui.fastgo.enty.UeWater;
import com.yipuhui.fastgo.enty.UeWaterExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Description:
 *
 * @date 2018/5/28 16:16
 */
@Mapper
public interface UeWaterMapper {
    /**
     * 条件统计
     * 参数:查询条件,null为整张表
     * 返回:查询个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int countByExample(UeWaterExample example);

    /**
     * 批量条件删除
     * 参数:删除条件,null为整张表
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int deleteByExample(UeWaterExample example);

    /**
     * 批量条件查询
     * 参数:查询条件,null查整张表
     * 返回:对象集合
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    List<UeWater> selectByExample(UeWaterExample example);

    /**
     * 批量条件修改，空值条件不修改
     * 参数:1.要修改成的值，2.要修改条件
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int updateByExampleSelective(@Param("record") UeWater record, @Param("example") UeWaterExample example);

    /**
     * 批量条件修改，空值条件会修改成null
     * 参数:1.要修改成的值，2.要修改条件
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int updateByExample(@Param("record") UeWater record, @Param("example") UeWaterExample example);

    /**
     * 物理分页条件查询
     * 参数:1.查询条件 2.分页条件 new RowBounds(2,3) 
            从第2条开始显示，显示3条(从0开始编号)
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    List<UeWater> selectByExampleAndPage(UeWaterExample example, RowBounds rowBound);

    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int deleteByPrimaryKey(Integer ueWaterId);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int insert(UeWater record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int insertSelective(UeWater record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    UeWater selectByPrimaryKey(Integer ueWaterId);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int updateByPrimaryKeySelective(UeWater record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    int updateByPrimaryKey(UeWater record);
}