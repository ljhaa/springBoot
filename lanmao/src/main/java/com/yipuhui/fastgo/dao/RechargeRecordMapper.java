package com.yipuhui.fastgo.dao;

import com.yipuhui.fastgo.enty.RechargeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface RechargeRecordMapper {
	/**
	 * Description:
	 *
	 * @author 刘俊汉
	 * @param rechargeId
	 * @date 2018/5/14 14:25
	 * @return int
	 */
    int deleteByPrimaryKey(Integer rechargeId);

	/**
	 * Description:
	 *
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:25
	 * @return int
	 */
    int insert(RechargeRecord record);
	/**
	 * Description:
	 *
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:25
	 * @return int
	 */
    int insertSelective(RechargeRecord record);
	/**
	 * Description:
	 *
	 * @author 刘俊汉
	 * @param rechargeId
	 * @date 2018/5/14 14:25
	 * @return com.yipuhui.fastgo.enty.RechargeRecord
	 */
    RechargeRecord selectByPrimaryKey(Integer rechargeId);
	/**
	 * Description:
	 *
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:25
	 * @return int
	 */
    int updateByPrimaryKeySelective(RechargeRecord record);
	/**
	 * Description:
	 *
	 * @author 刘俊汉
	 * @param record
	 * @date 2018/5/14 14:25
	 * @return int
	 */
    int updateByPrimaryKey(RechargeRecord record);
    
    /**
     * 
     * Description:按条件查询充值记录【数据】 
     *
     * @param conditions
     * @return
     * @Author xingym
     * @Create Date: 2015年7月17日 下午3:48:59
     */
    List<Map<String, Object>>findRechargeRecordData(Map<String, Object> conditions);
    
    /**
     * 
     * Description: 按条件查询充值记录【计数】 
     *
     * @param conditions
     * @return
     * @Author xingym
     * @Create Date: 2015年7月17日 下午3:49:42
     */
    Long findRechargeRecordCount(Map<String, Object> conditions);
    
    /**
     * Description:
     *
     * @author 刘俊汉
     * @param conditions
     * @date 2018/5/14 14:25
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String, Object>>findRechargeRecordForReconciliation(Map<String, Object> conditions);
    
    /**
     * Description:按条件查询充值对账记录【计数】
     *
     * @author 刘俊汉
     * @param conditions
     * @date 2018/5/14 14:26
     * @return java.lang.Long
     */
    Long findRechargeRecordForReconciliationCount(Map<String, Object> conditions);
    
    /**
     * Description: 根据订单编号和状态查询充值记录
     *
     * @author 刘俊汉
     * @param conditions
     * @date 2018/5/14 14:26
     * @return com.yipuhui.fastgo.enty.RechargeRecord
     */
    RechargeRecord findRechargeRecordByOrderNumAndStatus(Map<String, Object> conditions);

    /**
     * Description: 查询过期订单ID集合
     *
     * @author 刘俊汉
     * @param conditions
     * @date 2018/5/14 14:26
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> findExpiredOrderIdSet(Map<String, Object> conditions);

    /**
     * Description: 按条件查询充值成功的记录
     *
     * @author 刘俊汉
     * @param conditions
     * @date 2018/5/14 14:26
     * @return java.util.List<com.yipuhui.fastgo.enty.RechargeRecord>
     */
	List<RechargeRecord> querySuccessRechargeRecordByConditions(Map<String, Object> conditions);

	/**
	 *
	 * Description: 充值导出分页
	 *
	 * @param paramMap
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年11月20日 下午1:45:23
	 */
	List<Map<String, Object>> getRechargeExportList(Map<String, Object> paramMap);

	/**
	 * Description: 充值导出分页总数
	 *
	 * @author 刘俊汉
	 * @param paramMap
	 * @date 2018/5/14 14:26
	 * @return java.lang.Long
	 */
	Long getRechargeExportListCount(Map<String, Object> paramMap);

//	/**
//	 *
//	 * Description: 查询充值导出的excel数据
//	 *
//	 * @param paramMap
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年11月20日 下午5:28:51
//	 */
//	List<RechargeExport> getExcelData(Map<String, Object> paramMap);





	/**
	 * Description: 按时间查询为处理的数据
	 *
	 * @author 刘俊汉
	 * @param date
	 * @param rechargeStatus
	 * @date 2018/5/14 14:27
	 * @return java.util.List<com.yipuhui.fastgo.enty.RechargeRecord>
	 */
	List<RechargeRecord> selectPayApplyByTime(@Param("date") Date date, @Param("rechargeStatus") String rechargeStatus);
	/**
	 * Description: 按照流水号查询结果
	 *
	 * @author 刘俊汉
	 * @param serlNum
	 * @date 2018/5/14 14:27
	 * @return com.yipuhui.fastgo.enty.RechargeRecord
	 */
	RechargeRecord  selectPayApplyBySul(@Param("serlNum") String serlNum);
	/**
	 *
	 * @Title: findRechargeRecordReconciliationByPage
	 * @Description: TODO()
	 * @param conditions
	 * @return
	 * @author      
	 * @date 2017年10月31日 下午2:42:04
	 */
	/*List<Map<String, Object>> findRechargeRecordReconciliationByPage(Map<String,Object> conditions);*/
	/**
	 * Description:充值对账总金额   可删除
	 *
	 * @author 刘俊汉
	 * @param null
	 * @date 2018/5/14 14:27
	 * @return
	 */
	/*BigDecimal findRechargeRecordForReconciliationAmount(Map<String,Object> conditions);*/


	   /**
	    * Description: 条件查询总金额
	    *
	    * @author 刘俊汉
	    * @param conditions
	    * @date 2018/5/14 14:28
	    * @return java.math.BigDecimal
	    */
	   BigDecimal findAmountSum(Map<String, Object> conditions);
	   
	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param date
	 * @param rechargeStatus
	 * @date 2018/5/14 14:28
	 * @return java.util.List<com.yipuhui.fastgo.enty.RechargeRecord>
	 */
	List<RechargeRecord> selectPayApplyByTimeAndStatus(@Param("date") Date date, @Param("rechargeStatus") String rechargeStatus);



	/**
	 * Description:
	 * 
	 * @author 刘俊汉
	 * @param date
 * @param rechargeWay
	 * @date 2018/5/14 14:35
	 * @return java.util.List<com.yipuhui.fastgo.enty.RechargeRecord>
	 */
	List<RechargeRecord> selectPayApplyByTimeAndRechagerWay(@Param("date") Date date, @Param("rechargeWay") String rechargeWay);
}