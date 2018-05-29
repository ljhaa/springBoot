package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 提现方式
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum WithdrawTypeEnum {

    /**
     *
     */
    NORMAL("提现T1","NORMAL"),
    URGENT("加急T0","URGENT"),
    NORMAL_URGENT("智能T0","NORMAL_URGENT")




;

    private String name;
    private String index;

    private WithdrawTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (WithdrawTypeEnum c : WithdrawTypeEnum.values()) {
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
