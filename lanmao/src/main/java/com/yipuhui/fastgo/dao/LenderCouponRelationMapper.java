package com.yipuhui.fastgo.dao;

import com.yipuhui.fastgo.enty.LenderCouponRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface LenderCouponRelationMapper extends BaseMapper<LenderCouponRelation> {
	
	/**
	 * 
	 * Description: 获取该用户所有优惠券数量
	 *
	 * @param lenderLoginId
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2016年1月12日 下午3:05:29
	 */
	public int getCoupomNumByLenderLoginId(Integer lenderLoginId);
	
	/**
	 * 
	 * Description: 通过主键Id查询使用状态
	 *
	 * @param id
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年12月16日 上午10:08:29
	 */
	public String selectUseStatusById(Integer id);
	
	/**
	 * 
	 * Description: 更新获取未使用但使用时间已经过期的红包状态
	 *
	 * @param currentTime
	 * @Author chengzhichao
	 * @Create Date: 2015年12月4日 上午11:30:21
	 */
	public void updateCouponStatus(String currentTime);
	
	/**
	 * 
	 * Description: 分页查询优惠券数据  for mobile
	 *
	 * @param conditions
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年12月1日 下午4:58:57
	 */
	public List<Map<String,Object>> findMyCouponsForMobileByPage(Map<String, Object> conditions);

	/**
	 *
	 * Description: 分页查询我的优惠券计数
	 *
	 * @param conditions
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年11月5日 下午2:34:46
	 */
	public Long findMyCouponsForMobileCountByPage(Map<String, Object> conditions);

	/**
	 *
	 * Description: 查看某一个用户优惠券状态数量
	 *
	 * @param lenderLoginId
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年11月26日 下午1:53:32
	 */
	public List<Map<String, Object>> getCouponUseStatusNum(Integer lenderLoginId);

	/**
	 *
	 * Description: 分页查询我的优惠券数据
	 *
	 * @param conditions
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年11月5日 下午2:34:20
	 */
	public List<Map<String,Object>> findMyCouponsDataByPage(Map<String, Object> conditions);

	/**
	 *
	 * Description: 分页查询我的优惠券计数
	 *
	 * @param conditions
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年11月5日 下午2:34:46
	 */
	public Long findMyCouponsCountByPage(Map<String, Object> conditions);

	/**
	 *
	 * Description: 批量插入
	 *
	 * @param lcrs
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年11月5日 下午5:39:59
	 */
	public int batchInsert(List<LenderCouponRelation> lcrs);

	/**
	 *
	 * Description: 查询优惠券根据lenderNum和couponNum
	 *
	 * @param paramMap
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年11月11日 下午3:35:06
	 */
	public Map<String, Object> selectLenderCouponByMap(Map<String, Object> paramMap);

	/**
	 *
	 * Description: 查询投资时可用优惠券
	 *
	 * @param paramMap
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年11月12日 下午2:32:07
	 */
	public List<Map<String, Object>> selectInvestUsableCoupon(Map<String, Object> paramMap);

	/**
	 *
	 * Description: 根据登录ID和优惠券编码查询优惠券信息
	 *
	 * @param lenderLoginId 登录人ID
	 * @param couponNum 优惠券编号
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年11月16日 下午1:29:59
	 */
	Map<String, Object> findCouponByLenderLoginIdAndCouponNum(@Param("lenderLoginId") Integer lenderLoginId, @Param("couponNum") String couponNum);
	
	/**
	 * 
	 * Description: 可用优惠券
	 *
	 * @param paramsData
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年12月7日 下午1:55:37
	 */
	public List<Map<String, Object>> selectInvestUsableCouponForMobile(Map<String, Object> paramsData);
	
	/**
	 * 
	 * Description: 可用优惠券个数
	 *
	 * @param paramsData
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年12月7日 下午2:11:10
	 */
	public int selectCountForMobile(Map<String, Object> paramsData);
	
	/**
	 * 
	 * Description: 查询优惠券根据lenderLoginId和couponNum
	 *
	 * @param paramMap
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年12月7日 下午5:00:22
	 */
	public Map<String, Object> selectLenderCouponByMapForMobile(Map<String, Object> paramMap);

/**
 * Description:
 * 
 * @author 刘俊汉
 * @param lcr
 * @date 2018/5/14 14:30
 * @return void
 */
	public void updateUseSatusById(LenderCouponRelation lcr);

}