package com.yipuhui.fastgo.service.impl;/**
 * Created by liujunhan on 2018/4/13.
 */

import com.yipuhui.fastgo.common.CouponConstants;
import com.yipuhui.fastgo.dao.LenderDetailMapper;
import com.yipuhui.fastgo.enty.LenderDetail;
import com.yipuhui.fastgo.service.LenderDetailService;
import com.yipuhui.fastgo.service.OpenModelConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 个人  企业用户注册回调
 *
 * @author 刘俊汉
 * @create 2018-04-13 10:55
 **/
@Service
public class LenderDetailServiceImpl implements LenderDetailService {

    @Autowired
    private OpenModelConfigService openModelConfigService;

    @Autowired
        private LenderDetailMapper lenderDetailMapper;



    @Override
    public void insertLenderDetail(LenderDetail lenderDetail) {
        String mobile = lenderDetail.getMobile();
        lenderDetailMapper.insertSelective(lenderDetail);
        Integer lenderLoginId = lenderDetail.getLenderLoginId();
        // pc端发送优惠券
        openModelConfigService.doSendCoupon(lenderLoginId, CouponConstants.MODEL_TYPE_RENZHENG, mobile);
    }

    /**
     *    根据用户编号修改状态
     *
     * @author 刘俊汉
     * @date 2018/4/13 10:56
     * @param [lenderDetail]
     * @return java.lang.Integer
     */

    @Override
    public Integer updataByLenderNum(Map<String,Object> map) {
        return lenderDetailMapper.updateLenderStatusByLenderNum(map);
    }



    @Override
    public void updateUserInfo(Map<String, Object> paramMap) {

        // 同步开户状态根据出借人编号
        lenderDetailMapper.updateLenderStatusByLenderNum(paramMap);


    }

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param lenderNum
     * @date 2018/5/28 16:04
     * @return
     */
    @Override
    public LenderDetail findLenderDetailInfoByLenderNum(String lenderNum) {
        return lenderDetailMapper.findLenderDetailInfoByLenderNum(lenderNum);
    }
}
