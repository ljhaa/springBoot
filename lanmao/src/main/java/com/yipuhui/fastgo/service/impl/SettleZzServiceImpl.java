package com.yipuhui.fastgo.service.impl;/**
 * Created by liujunhan on 2018/4/16.
 */

import com.yipuhui.fastgo.dao.SettleZzMapper;
import com.yipuhui.fastgo.enty.SettleZz;
import com.yipuhui.fastgo.service.SettleZzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 转账服务
 *
 * @author 刘俊汉
 * @create 2018-04-16 14:56
 **/
@Service
public class SettleZzServiceImpl implements SettleZzService {


    @Autowired
    private SettleZzMapper settleZzMapper;

    @Override
    public void updataStatusByRequstNo(SettleZz settleZz) {
        settleZzMapper.updataStatusByRequstNo(settleZz);
    }

    @Override
    public List<SettleZz> selectByRequstNo(SettleZz settleZz) {
        return settleZzMapper.selectByRequstNo(settleZz);
    }
}
