/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: LenderService.java 
 *
 * Created: [2015年4月21日 下午9:24:30] by jie 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: ephwealth-online 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.service;


import com.yipuhui.fastgo.enty.LenderLogin;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author lijie
 * @version 1.0
 *          <pre>
 *          Modification History:
 *          Date         Author      Version     Description
 *          ------------------------------------------------------------------
 *          2015年4月21日      lijie       1.0         1.0 Version
 *          </pre>
 */

public interface LenderLoginService {

//	/**
//	 *
//	 * Description: 通过lenderLoginId获取用户名和密码（积分商城用）
//	 *
//	 * @param lenderLoginId
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2016年3月25日 上午10:44:39
//	 */
//	Map<String, Object> selectPwd(int lenderLoginId);
//
//	/**
//	 *
//	 * Description: 注册成功插入用户，并保存商户编号
//	 *
//	 * @param lenderLogin
//	 * @param channelNum
//	 * @Author chengzhichao
//	 * @Create Date: 2016年3月14日 上午10:32:35
//	 */
//	void insertLenderWidthChannel(LenderLogin lenderLogin, String channelNum);
//
//	/**
//	 *
//	 * Description: 认购-->通过手机号获得系统编码
//	 *
//	 * @param mobile
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2016年2月3日 下午3:48:38
//	 */
//	String getSystemCodeByMob(String mobile);
//
//	/**
//	 *
//	 * Description: 通过id查询lenderLogin表内容
//	 *
//	 * @param id
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年7月22日 下午10:15:41
//	 */
//	Map<String, Object> findMobById(Integer id);
//
//	/**
//	 *
//	 * Description: 注册--->插入用户基本注册信息，并且发送优惠券不发送短信，如需发送短信，需要传入手机号
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年7月13日 下午1:52:00
//	 */
//	Integer insertLender(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 同步插入crm客户
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2016年1月12日 下午2:47:20
//	 */
//	Integer insertSynLener(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 查询手机号是否存在
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年7月9日 上午11:36:05
//	 */
//	Integer checkMobileIsExist(String mobile);
//
//	/**
//	 *
//	 * Description: 查询邮件是否在"已绑定状态"列表里面
//	 *
//	 * @param email
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年5月12日 上午9:55:46
//	 */
//	Integer checkEmailIsExist(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 验证用户登录
//	 *
//	 * @param lender
//	 * @Author lijie
//	 * @Create Date: 2015年4月22日 下午1:39:53
//	 */
//	LenderLogin checkLenderLogin(String account);
//
//	List<Map<String,Object>> selectPwdDefaultAccount();
//
//	void initDefultPwd(Map<String, Object> map);
//
//	/**
//	 *
//	 * Description: 更新用户(用户名和密码)
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年4月28日 下午1:17:44
//	 */
//	int updateByPrimaryKeySelective(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 判断昵称是否重复
//	 *
//	 * @param nickName
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年4月28日 下午2:48:14
//	 */
//	public Long findLenderLoginByNickName(String nickName);
//
//	/**
//	 *
//	 * Description: crm客户首次登录，判断用户名是否唯一
//	 *
//	 * @param map
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年10月30日 下午5:12:25
//	 */
//	public int chkNickNameByCrm(Map<String, Object> map);
//

    /**
     * Description:
     *
     * @param id
     * @return com.yipuhui.fastgo.enty.LenderLogin
     * @author 刘俊汉
     * @date 2018/5/14 14:24
     */
    LenderLogin selectByPrimaryKey(Integer id);
//
//	/**
//	 * 根据旧密码修改为新密码
//	 * Description:
//	 *
//	 * @Author guoxl
//	 * @Create Date: 2015年5月6日 下午2:42:11
//	 */
//	public int updateNewTelephoneByOldTel(String jsonStr);
//
//	/**
//	 *
//	 * Description: 根据用户名（昵称）判断用户是否存在
//	 *
//	 * @param account
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年5月7日 下午3:04:21
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
//	 * @Create Date: 2015年5月7日 下午6:18:52
//	 */
//	Integer checkMobOrEmaIsMatch(Map<String, Object> conditions);
//
//	/**
//	 *
//	 * Description: 通过邮件和激活码查询数据库是否存在
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年5月12日 上午9:33:32
//	 */
//	public LenderLogin selectByEmail(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 邮件激活成功后，更新lenderLogin相关信息
//	 *
//	 * @param lenderLogin
//	 * @return
//	 * @Author chengzhichao
//	 * @Create Date: 2015年5月12日 上午9:34:01
//	 */
//	public Integer updateByEmail(LenderLogin lenderLogin);
//
//	/**
//	 *
//	 * Description: 修改登录密码
//	 *
//	 * @param conditions
//	 * @Author lijie
//	 * @Create Date: 2015年5月8日 下午8:52:41
//	 */
//	void updateLoginPwd(Map<String, Object> conditions);
//
//	/**
//	 *
//	 * Description: 查询客户总数【线上数据源】
//	 *
//	 * @param
//	 * @return Long
//	 * @throws
//	 * @Author xingym
//	 * Create Date: 2015年4月24日 下午5:04:52
//	 */
//	public Long queryCustomerCount();
//
//	/**
//	 *
//	 * Description: 查询交易密码
//	 *
//	 * @param id
//	 * @return
//	 * @Author lijie
//	 * @Create Date: 2015年8月14日 上午11:38:02
//	 */
//	String selectTradePwdById(Integer id);
//
//	/**
//	 *
//	 * Description: 根据手机号删除
//	 *
//	 * @param mobile
//	 * @Author lijie
//	 * @Create Date: 2015年8月20日 上午9:37:01
//	 */
//	void deleteByMobile(String mobile);

    /**
     * Description:
     *
     * @param lenderNum
     * @return com.yipuhui.fastgo.enty.LenderLogin
     * @author 刘俊汉
     * @date 2018/5/14 14:24
     */
    LenderLogin fundObjectByUserNum(String lenderNum);
}
