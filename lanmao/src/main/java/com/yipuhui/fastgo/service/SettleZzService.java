package com.yipuhui.fastgo.service;/**
 * Created by liujunhan on 2018/4/16.
 */

import com.yipuhui.fastgo.enty.SettleZz;

import java.util.List;

/**
 * 转账服务
 *
 * @author 刘俊汉
 * @create 2018-04-16 14:55
 **/
public interface SettleZzService {

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param settleZz
     * @date 2018/5/14 14:34
     * @return void
     */
public void updataStatusByRequstNo(SettleZz settleZz);
/**
 * Description:
 * 
 * @author 刘俊汉
 * @param settleZz
 * @date 2018/5/14 14:39
 * @return com.yipuhui.fastgo.enty.SettleZz
 */
public List<SettleZz> selectByRequstNo(SettleZz settleZz);
}
