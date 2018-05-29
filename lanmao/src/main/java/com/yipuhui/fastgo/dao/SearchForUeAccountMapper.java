package com.yipuhui.fastgo.dao;



import com.yipuhui.fastgo.enty.UeAccount;
import com.yipuhui.fastgo.enty.UeInvest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchForUeAccountMapper {
	
	/**
	 * 查询体验金账号分页数据
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> findAccountPageListByMap(Map<String, Object> paramMap);

	/**
	 * 查询体验金账号查询数据总数
	 * @param paramMap
	 * @return
	 */
	Long findAccountCountByMap(Map<String, Object> paramMap);
	
	/**
	 * 投资到期后更新体验金账号金额
	 * 增加体验金：在用户注册或者实名时赠送体验金
	 * 体验经投资到期：更改体验金账户金额，从预收益（expected）减少，增加到体验金收益（money）中
	 * 体验投资销毁：更改体验金账户金额，减少到体验金收益（money）
	 * @param record
	 * @return
	 */
	int updateAccountForInvest(UeAccount record);

	/**
	 * 通过个人登录ID体验金账号
	 * @param loginId
	 * @return
	 */
	UeAccount getUeAcountByLoginId(Integer loginId);
	
	/**
	 * 查询体验金账号对应的投资记录
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> findUeInvestPageListByMap(Map<String, Object> paramMap);

	/**
	 * 查询体验金账号对应的投资记录总数
	 * @param paramMap
	 * @return
	 */
	Long findUeInvestCountByMap(Map<String, Object> paramMap);

	/**
	 * 根据条件查询出指定的体验金投资记录
	 * investStatus  投资状态
  	 * investStatusList  投资状态集合
	 * validDayCount 有效天数
	 * currDate      当前系统时间
	 * isCanTakeCash 该投资是否可提现（yes是，其他不检查）
	 * @param paramsCondition
	 * @return
	 */
	List<UeInvest> getUeInvestList(Map<String, Object> paramsCondition);
	List<UeAccount> getUeAcountList(Map<String, Object> paramsCondition);

	/**
	 * 根据投资编号得到对应的投资
	 * @param serlNum
	 */
	UeInvest getUeInvestBySerlNum(String serlNum);
	
	/**
	 * 根据loginId得到符合条件的体验金投资记录
	 * @param loginId
	 */
	List<UeInvest> getUeInvestListByLoginId(Integer loginId);

	/**
	 * 查询体验金流水记录
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> findUeWaterPageListByMap(Map<String, Object> paramMap);

	/**
	 * 查询体验金流水记录总数
	 * @param paramMap
	 * @return
	 */
	Long findUeWaterCountByMap(Map<String, Object> paramMap);
	
	/**
	 * 
	 * @Title: getUeAcountWater
	 * @Description: TODO(查询注册、开户体验金记录)
	 * @param conditions
	 * @return
	 * @author      
	 * @date 2017年12月27日 下午4:54:53
	 */
	List<Map<String,Object>> getUeAcountWater(Map<String, Object> conditions);
	
}