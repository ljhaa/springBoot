package com.yipuhui.fastgo.service;/**
 * Created by liujunhan on 2018/4/20.
 */

import com.yipuhui.fastgo.enty.RechargeRecord;

/**
 * chongzhi lilucaozuobiao
 *
 * @author 刘俊汉
 * @create 2018-04-20 16:32
 **/
public interface RechargeRecordService {


    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param r
     * @date 2018/5/14 14:28
     * @return void
     */
    public void insetRechargeRecord(RechargeRecord r);


    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param serlNum
     * @date 2018/5/14 14:28
     * @return com.yipuhui.fastgo.enty.RechargeRecord
     */
    RechargeRecord  selectPayApplyBySul(String serlNum);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param r
     * @date 2018/5/14 14:37
     * @return void
     */
    void updataPayCompany(RechargeRecord r);
}
