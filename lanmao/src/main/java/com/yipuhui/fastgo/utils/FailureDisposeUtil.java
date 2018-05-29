package com.yipuhui.fastgo.utils;/**
 * Created by liujunhan on 2018/5/9.
 */

import com.yipuhui.fastgo.utils.factory.AsyncMsgFailureManage;

/**
 * 异步通知未收到时处理方法
 *
 * @author 刘俊汉
 * @create 2018-05-09 14:57
 **/
public class FailureDisposeUtil {


    public static void failureDispose(String serviceName){

        BeanGetFactory ba = BeanGetFactory.getInstance();

        AsyncMsgFailureManage asyncMsgFailureManage = ba.ceretBean(serviceName);
        asyncMsgFailureManage.asyncMsgFailureManage();


    }



}
