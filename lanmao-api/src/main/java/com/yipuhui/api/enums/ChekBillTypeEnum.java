package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/20.
 */

/**
 * 对账账单类型
 *
 * @author 刘俊汉
 * @create 2018-04-20 11:23
 **/
public enum ChekBillTypeEnum {


    /**
     *
     */
    RECHARGE("充值","RECHARGE"),
    WITHDRAW("提现","WITHDRAW"),
    COMMISSION("佣金","COMMISSION"),
    TRANSACTION("交易","TRANSACTION"),
    BACKROLL_RECHARGE("资金回退充值","BACKROLL_RECHARGE");


    private String name;
    private String index;

    private ChekBillTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (ChekBillTypeEnum c : ChekBillTypeEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }

}
