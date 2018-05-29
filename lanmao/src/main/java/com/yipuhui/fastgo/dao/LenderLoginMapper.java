package com.yipuhui.fastgo.dao;



import com.yipuhui.fastgo.enty.LenderLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface LenderLoginMapper extends BaseMapper<LenderLogin>{
	
//	/**
//	 *
//	 * Description: 通过lenderLoginId获取用户名和密码（积分商城用）
//	 *
//	 * @param lenderLoginId
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2016年3月25日 上午10:43:34
//	 */
//	Map<String, Object> selectPwd(int lenderLoginId);
//
//	/**
//	 *
//	 * Description: 认购-->通过手机号获得系统编码
//	 *
//	 * @param mobile
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2016年2月3日 下午3:46:55
//	 */
//	String getOrderLenderLogin(String mobile);
//
//	/**
//	 *
//	 * Description: 通过系统编码查询所有手机号
//	 *
//	 * @param map
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年11月22日 下午3:53:52
//	 */
//	List<String> getMobileBySystemCode(Map<String, Object> map);
//
//	/**
//	 *
//	 * Description: crm首次登录检测用户名是否存在
//	 *
//	 * @param map
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年10月30日 下午5:06:52
//	 */
//	Integer chkNickNameByCrm(Map<String, Object> map);
//
//	/**
//	 *
//	 * Description: 通过主键id查找手机号，此方法主要用于安全中心手机号显示。方便以后安全中心统一查询，所以返回值设置为map
//	 *
//	 * @param id
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年7月22日 下午10:12:59
//	 */
//	Map<String,Object> findMobById(Integer id);
//
//	/**
//	 *
//	 * Description: 查询手机号，是否存在，用于注册
//	 *
//	 * @param mobile
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年7月9日 上午11:40:27
//	 */
//	Integer checkMobileIsExist(String mobile);
//
//	/**
//	 *
//	 * Description: 查询邮件是否在"已绑定状态"列表里面
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年5月12日 上午9:51:37
//	 */
//	Integer checkEmailIsExist(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 通过邮件查找出借人信息
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年5月7日 下午1:49:20
//	 */
//	LenderLogin selectByEmail(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 通过邮件更新出借人信息
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年5月7日 下午1:49:47
//	 */
//	Integer updateByEmail(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 验证用户登录
//	 *
//	 * @param lender
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年4月23日 下午2:30:41
//	 */
//	LenderLogin checkLenderLogin(String account);
//
//	/**
//	 *
//	 * Description: 查询密码为空账户
//	 *
//	 * @return
//	 * @Author yubin
//	 * @Create Date: 2015年4月27日 下午5:19:59
//	 */
//	List<Map<String,Object>> selectPwdDefaultAccount();
//
//	void initDefultPwd(Map<String, Object> map);
//	/**
//	 *
//	 * Description: 查询昵称，判断昵称唯一性
//	 *
//	 * @param nickName
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年4月28日 下午2:49:42
//	 */
//	Long findLenderLoginByNickName(String nickName);
//
//	/**
//	 * Description:  根据旧密码修改为新密码
//	 *
//	 * @param newTel 新密码
//	 * @param oldTel 旧密码
//	 * @return
//	 * @Author guoxl
//	 * @Create Date: 2015年5月6日 下午2:42:11
//	 */
//	int updateNewTelephoneByOldTel(Map<String, String> map);
//
//	/**
//	 *
//	 * Description: 根据用户名（昵称）判断用户是否存在
//	 *
//	 * @param account
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年5月7日 下午3:05:18
//	 */
//	int checkAccountIsExist(String account);
//
//	/**
//	 *
//	 * Description: 判断用户名和手机号或邮箱是否匹配
//	 *
//	 * @param conditions
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年5月7日 下午6:21:52
//	 */
//	Integer checkMobOrEmaIsMatch(Map<String, Object> conditions);
//
//	/**
//	 *
//	 * Description: 修改登录密码
//	 *
//	 * @param conditions
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年5月8日 下午8:53:56
//	 */
//	Object updateLoginPwd(Map<String, Object> conditions);
//
//	/**
//	 * 根据老手机号查找记录
//	 */
//	int findLenderLoginByMobile(String oldTel);
//
//	/**
//	 * 插入修改密码日志
//	 */
//	int insertPasswordLog(ModifyPasswordLog modifyPasswordLog);
//
//	/**
//	 *
//	 * Description: 查询注册客户总数
//	 *
//	 * @param
//	 * @return Long
//	 * @throws
//	 * @Author xingym
//	 * Create Date: 2015年4月24日 下午4:04:07
//	 */
//	Long findCustomerCount();
//
//	/**
//	 *
//	 * Description: 查询交易密码
//	 *
//	 * @param id
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年8月14日 上午11:38:45
//	 */
//	String selectTradePwdById(Integer id);
//
//	/**
//	 *
//	 * Description: 根据手机号删除
//	 *
//	 * @param mobile
//	 * @Author lijie
//	 * @Create Date: 2015年8月20日 上午9:44:13
//	 */
//	void deleteByMobile(String mobile);
//
//	/**
//	 *
//	 * Description: 加入黑名单
//	 *
//	 * @param id
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2016年2月26日 上午11:34:50
//	 */
//	Object doJoinBlacklist(Integer id);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param lenderNum
     * @date 2018/5/14 14:34
     * @return com.yipuhui.fastgo.enty.LenderLogin
     */
    LenderLogin fundObjectByUserNum(@Param("lenderNum") String lenderNum);
	
}