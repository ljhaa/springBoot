package com.yipuhui.fastgo.service.impl;/**
 * Created by liujunhan on 2018/4/20.
 */

import com.yipuhui.fastgo.dao.RechargeRecordMapper;
import com.yipuhui.fastgo.enty.RechargeRecord;
import com.yipuhui.fastgo.service.RechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 充值记录操作
 *
 * @author 刘俊汉
 * @create 2018-04-20 16:33
 **/
@Service
public class RechargeRecordServiceImpl implements RechargeRecordService {

    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    @Override
    public void insetRechargeRecord(RechargeRecord r) {
        rechargeRecordMapper.insert(r);
    }

    @Override
    public RechargeRecord selectPayApplyBySul(String serlNum) {
        return rechargeRecordMapper.selectPayApplyBySul(serlNum);
    }

    @Override
    public void updataPayCompany(RechargeRecord r) {
        rechargeRecordMapper.updateByPrimaryKeySelective(r);
    }
}
