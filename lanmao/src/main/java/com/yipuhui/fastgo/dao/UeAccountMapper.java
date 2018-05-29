package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.UeAccount;
import com.yipuhui.fastgo.enty.UeAccountExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UeAccountMapper {
    /**
     * 条件统计
     * 参数:查询条件,null为整张表
     * 返回:查询个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int countByExample(UeAccountExample example);

    /**
     * 批量条件删除
     * 参数:删除条件,null为整张表
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int deleteByExample(UeAccountExample example);

    /**
     * 批量条件查询
     * 参数:查询条件,null查整张表
     * 返回:对象集合
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    List<UeAccount> selectByExample(UeAccountExample example);

    /**
     * 批量条件修改，空值条件不修改
     * 参数:1.要修改成的值，2.要修改条件
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int updateByExampleSelective(@Param("record") UeAccount record, @Param("example") UeAccountExample example);

    /**
     * 批量条件修改，空值条件会修改成null
     * 参数:1.要修改成的值，2.要修改条件
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int updateByExample(@Param("record") UeAccount record, @Param("example") UeAccountExample example);

    /**
     * 物理分页条件查询
     * 参数:1.查询条件 2.分页条件 new RowBounds(2,3) 
            从第2条开始显示，显示3条(从0开始编号)
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    List<UeAccount> selectByExampleAndPage(UeAccountExample example, RowBounds rowBound);

    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int deleteByPrimaryKey(Integer ueAccountId);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int insert(UeAccount record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int insertSelective(UeAccount record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    UeAccount selectByPrimaryKey(Integer ueAccountId);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int updateByPrimaryKeySelective(UeAccount record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    int updateByPrimaryKey(UeAccount record);
}