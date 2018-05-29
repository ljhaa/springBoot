package com.yipuhui.fastgo.dao;

import com.yipuhui.fastgo.enty.LenderDetail;
import com.yipuhui.fastgo.enty.SaveProofLog;
import com.yipuhui.fastgo.enty.SaveProofLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/21 15:50
 */
@Mapper
public interface SaveProofLogMapper{

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param example
     * @date 2018/5/21 15:50
     * @return
     */
    int countByExample(SaveProofLogExample example);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param example
     * @date 2018/5/21 15:51
     * @return
     */
    int deleteByExample(SaveProofLogExample example);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param id
     * @date 2018/5/21 15:50
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param record
     * @date 2018/5/21 15:51
     * @return
     */
    int insert(SaveProofLog record);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param record
     * @date 2018/5/21 15:51
     * @return
     */
    int insertSelective(SaveProofLog record);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param example
     * @date 2018/5/21 15:51
     * @return
     */
    List<SaveProofLog> selectByExample(SaveProofLogExample example);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param id
     * @date 2018/5/21 15:51
     * @return
     */
    SaveProofLog selectByPrimaryKey(Integer id);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/21 15:52
     * @return
     */
    int updateByExampleSelective(@Param("record") SaveProofLog record, @Param("example") SaveProofLogExample example);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param record
     * @param example
     * @date 2018/5/21 15:52
     * @return
     */
    int updateByExample(@Param("record") SaveProofLog record, @Param("example") SaveProofLogExample example);
    /**
     * Description:
     *
     * @author 刘俊汉
     * @param record
     * @date 2018/5/21 15:52
     * @return
     */
    int updateByPrimaryKeySelective(SaveProofLog record);
    /**
     * Description:
     *
     * @author 刘俊汉
     * @param record
     * @date 2018/5/21 15:53
     * @return
     */
    int updateByPrimaryKey(SaveProofLog record);

    /**
     * Description:根据银行卡号查询结果
     *
     * @author 刘俊汉
     * @param bidInvestNum
     * @date 2018/5/14 14:23
     * @return com.yipuhui.fastgo.enty.LenderDetail
     */
    public Map<String,Object> fundSavaProofDataOne(@Param("bidInvestNum")String bidInvestNum);

    /**
     * Description:根据银行卡号查询结果
     *
     * @author 刘俊汉
     * @param bidInvestNum
     * @date 2018/5/14 14:23
     * @return com.yipuhui.fastgo.enty.LenderDetail
     */
    public Map<String,Object> fundSavaProofDataTwo(@Param("bidInvestNum")String bidInvestNum);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param saveProofTime
     * @date 2018/5/22 12:12
     * @return
     */
    public List<SaveProofLog> selectSaveProofLogByTime(@Param("saveProofTime")Date saveProofTime);
}