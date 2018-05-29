package com.yipuhui.fastgo.utils.factory;/**
 * Created by liujunhan on 2018/5/9.
 */

import com.yipuhui.fastgo.service.CashApplyService;
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
@ServiceName(serviceName = "WITHDRAW")
public class WithdrawAsyncMsgFailureManage implements AsyncMsgFailureManage {



    @Autowired
    private CashApplyService cashApplyService;

    /**
     *
     *   提现未接受到异步通知时的处理方法
     * @author 刘俊汉
     * @date 2018/5/9 10:42
     * @param []
     * @return void
     */
    @Override
    public void asyncMsgFailureManage() {


        System.out.println("===============我是提现处理方法================");

    }
}
