package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.CashApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:12
 */
@Mapper
public interface CashApplyMapper {
    
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param cashApplyId
     * @date 2018/5/14 14:08
     * @return int
     */
    int deleteByPrimaryKey(Integer cashApplyId);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:08
     * @return int
     */
    int insert(CashApply record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:08
     * @return int
     */
    int insertSelective(CashApply record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param cashApplyId
     * @date 2018/5/14 14:09
     * @return com.yipuhui.fastgo.enty.CashApply
     */
    CashApply selectByPrimaryKey(Integer cashApplyId);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:09
     * @return int
     */
    int updateByPrimaryKeySelective(CashApply record);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param record
     * @date 2018/5/14 14:09
     * @return int
     */
    int updateByPrimaryKey(CashApply record);
    
    /**
     * 
     * Description: 分页查询提现记录【数据】
     *
     * @param conditions
     * @return
     * @Author xingym
     * @Create Date: 2015年7月20日 下午2:23:21
     */
    List<Map<String,Object>>findCashApplyData(Map<String, Object> conditions);
    /**
     *
     * Description: 分页查询提现记录【计数】
     *
     * @param conditions
     * @return
     * @Author xingym
     * @Create Date: 2015年7月20日 下午2:24:04
     */
    Long findCashApplyCount(Map<String, Object> conditions);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param map
     * @date 2018/5/14 14:09
     * @return com.yipuhui.fastgo.enty.CashApply
     */
    CashApply findCashApplyBySerlNum(Map<String, Object> map);

    /**
     * Description:根据提现状态
     *
     * @author 刘俊汉
     * @param map
     * @date 2018/5/14 14:12
     * @return com.yipuhui.fastgo.enty.CashApply
     */
    CashApply cashApplyBySerlNum(Map<String, Object> map);
    /**
     * Description:更新流水记录
     *
     * @author 刘俊汉
     * @param map
     * @date 2018/5/14 14:12
     * @return java.lang.Integer
     */
    Integer updataCashApplyBySerlNum(Map<String, Object> map);
   /**
    * Description:
    * 
    * @author 刘俊汉
    * @param date
    * @param cashStatus
    * @date 2018/5/14 14:11
    * @return java.util.List<com.yipuhui.fastgo.enty.CashApply>
    */
   List<CashApply>  findCashApplyByTime(@Param("date") Date date, @Param("cashStatus") String cashStatus);
   /**
    * Description:充值对账分页查询
    *
    * @author 刘俊汉
    * @param conditions
    * @date 2018/5/14 14:13
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
   List<Map<String,Object>> findCashReconciliation(Map<String, Object> conditions);
   /**
    * Description:(充值对账分页查询 计数）
    *
    * @author 刘俊汉
    * @param conditions
    * @date 2018/5/14 14:10
    * @return java.lang.Long
    */
   Long findCashReconciliationCount(Map<String, Object> conditions);


  /**
   * Description:条件查询总金额
   *
   * @author 刘俊汉
   * @param conditions
   * @date 2018/5/14 14:10
   * @return java.math.BigDecimal
   */
   BigDecimal findAmountSum(Map<String, Object> conditions);
   

   /**
    * Description:根据时间和状态查询记录
    *
    * @author 刘俊汉
    * @param date
    * @date 2018/5/14 14:11
    * @return java.util.List<com.yipuhui.fastgo.enty.CashApply>
    */
   List<CashApply> fundCashApplyByTimeAndStatus(@Param("date") Date date);

}