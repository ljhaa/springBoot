package com.yipuhui.fastgo.dao;

import com.yipuhui.fastgo.enty.LenderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface LenderDetailMapper extends BaseMapper<LenderDetail>{
	



	/**
	 * Description:同步开户状态根据出借人编号
	 *
	 * @author 刘俊汉
	 * @param paramMap
	 * @date 2018/5/14 14:23
	 * @return java.lang.Integer
	 */
	Integer updateLenderStatusByLenderNum(Map<String, Object> paramMap);

	/**
	 *
	 * Description: 根据客户编号 查询理财客户明细信息
	 *
	 * @param lenderNum
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年7月16日 下午4:34:37
	 */

	public LenderDetail findLenderDetailInfoByLenderNum(String lenderNum);


	/**
	 * Description:根据银行卡号查询结果
	 *
	 * @author 刘俊汉
	 * @param cardNum
	 * @date 2018/5/14 14:23
	 * @return com.yipuhui.fastgo.enty.LenderDetail
	 */
	public LenderDetail findLenderDetailInfoByCadeNum(@Param("cardNum")String cardNum);



}