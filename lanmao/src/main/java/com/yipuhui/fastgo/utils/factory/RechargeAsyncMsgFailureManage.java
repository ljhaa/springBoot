package com.yipuhui.fastgo.utils.factory;/**
 * Created by liujunhan on 2018/5/9.
 */

import com.yipuhui.fastgo.service.RechargeRecordService;
import com.yipuhui.fastgo.interf.ServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 提现接收异步回调失败时处理方法
 *
 * @author 刘俊汉
 * @create 2018-05-09 10:41
 **/
@Component
@ServiceName(serviceName = "RECHARGE")
public class RechargeAsyncMsgFailureManage implements AsyncMsgFailureManage {



    @Autowired
    private RechargeRecordService rechargeRecordService;

    /**
     *
     *   充值未接受到异步通知时的处理方法
     * @author 刘俊汉
     * @date 2018/5/9 10:42
     * @param []
     * @return void
     */
    @Override
    public void asyncMsgFailureManage() {

        System.out.println(rechargeRecordService.selectPayApplyBySul("201805092292844011555"));
        System.out.println("===============我是充值处理方法================");

    }
}
