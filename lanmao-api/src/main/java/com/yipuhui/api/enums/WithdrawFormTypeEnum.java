package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 提现方式
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum WithdrawFormTypeEnum {

    /**
     *
     */
	IMMEDIATE("为直接提现","IMMEDIATE"),
	CONFIRMED("待确认提现","CONFIRMED")
    

;

    public final String name;
    public final String index;

    private WithdrawFormTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (WithdrawFormTypeEnum c : WithdrawFormTypeEnum.values()) {
            if (c.index.equals(index)) {
                return c.name;
            }
        }
        return null;
    }


}
