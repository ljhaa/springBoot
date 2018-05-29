package com.yipuhui.fastgo.service;/**
 * Created by liujunhan on 2018/4/13.
 */

import com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs;

/**
 * 请求懒猫三方交互数据处理
 *
 * @author 刘俊汉
 * @create 2018-04-13 16:25
 **/
public interface ToLanmaoService {



    /**
     * Description:本地请求数据保存及梳理
     *
     * @author 刘俊汉
     * @param lanmaoServiceLogWithBlobs
     * @date 2018/5/14 14:35
     * @return void
     */
    public void localRequestDataSave(LanmaoServiceLogWithBlobs lanmaoServiceLogWithBlobs);


    /**
     * Description: 根据请求号和查询请求时对象信息
     *
     * @author 刘俊汉
     * @param lanmaoServiceLogWithBlobs
     * @date 2018/5/14 14:35
     * @return com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs
     */
    LanmaoServiceLogWithBlobs selectObjectByRequestNo(LanmaoServiceLogWithBlobs lanmaoServiceLogWithBlobs);

    /**
     * Description:根据请求号和查询请求修改状态
     *
     * @author 刘俊汉
     * @param lanmaoServiceLogWithBlobs
     * @date 2018/5/14 14:35
     * @return int
     */
    int updataObjectByRequestNo(LanmaoServiceLogWithBlobs lanmaoServiceLogWithBlobs);
}
