package com.yipuhui.fastgo.service.impl;/**
 * Created by liujunhan on 2018/4/16.
 */

import com.yipuhui.fastgo.dao.SettleNoticeMapper;
import com.yipuhui.fastgo.enty.SettleNoticeWithBlobs;
import com.yipuhui.fastgo.service.SettleNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通知日志服务
 *
 * @author 刘俊汉
 * @create 2018-04-16 17:13
 **/
@Service
public class SettleNoticeServiceImpl implements SettleNoticeService {

    @Autowired
    private SettleNoticeMapper settleNoticeMapper;

    @Override
    public void sevaSettleNotice(SettleNoticeWithBlobs settleNoticeWithBlobs){


        settleNoticeMapper.insert(settleNoticeWithBlobs);

    }

}
