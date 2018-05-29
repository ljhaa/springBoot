package com.yipuhui.fastgo.service;/**
 * Created by liujunhan on 2018/4/13.
 */

import com.yipuhui.fastgo.enty.LenderDetail;

import java.util.Map;

/**
 * 个人 企业 用户注册
 *
 * @author 刘俊汉
 * @create 2018-04-13 10:53
 **/
public interface LenderDetailService {


    /**
     *
     * Description: 实名认证成功后，向t_lender_detail表插入数据，同时发送优惠券
     *
     * @param lenderDetail
     * @return
     * @Author chengzhichao
     * @Create Date: 2015年7月15日 下午4:44:54
     */
    void insertLenderDetail(LenderDetail lenderDetail);


    /**
     * Description:根据用户平台编号修改用户信息
     *
     * @author 刘俊汉
     * @param map
     * @date 2018/5/14 14:23
     * @return java.lang.Integer
     */
   Integer updataByLenderNum(Map<String,Object> map);


    /**
     *
     * Description: 修改老用户信息
     *
     * @param paramMap
     * @Author liujunhan
     * @Create Date: 2017年7月17日 下午7:12:20
     */
    public void updateUserInfo(Map<String, Object> paramMap);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param lenderNum
     * @date 2018/5/28 16:03
     * @return
     */
    public LenderDetail findLenderDetailInfoByLenderNum(String lenderNum);

}
