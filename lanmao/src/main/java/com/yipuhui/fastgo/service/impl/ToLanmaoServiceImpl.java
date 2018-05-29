package com.yipuhui.fastgo.service.impl;/**
 * Created by liujunhan on 2018/4/13.
 */

import com.yipuhui.fastgo.dao.LanmaoServiceLogMapper;

import com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs;
import com.yipuhui.fastgo.service.ToLanmaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 三方交互数据
 *
 * @author 刘俊汉
 * @create 2018-04-13 16:30
 **/
@Service
public class ToLanmaoServiceImpl implements ToLanmaoService {


    @Autowired
    private LanmaoServiceLogMapper lanmaoServiceLogMapper;


    @Override
    public void localRequestDataSave(LanmaoServiceLogWithBlobs lanmaoServiceLogWithBlobs) {

        lanmaoServiceLogMapper.insert(lanmaoServiceLogWithBlobs);


    }


    @Override
    public LanmaoServiceLogWithBlobs selectObjectByRequestNo(LanmaoServiceLogWithBlobs lanmaoServiceLogWithBlobs) {
        return lanmaoServiceLogMapper.selectObjectByRequestNo(lanmaoServiceLogWithBlobs);
    }

    @Override
    public int updataObjectByRequestNo(LanmaoServiceLogWithBlobs lanmaoServiceLogWithBlobs) {
        return lanmaoServiceLogMapper.updateByPrimaryKeySelective(lanmaoServiceLogWithBlobs);
    }


}
