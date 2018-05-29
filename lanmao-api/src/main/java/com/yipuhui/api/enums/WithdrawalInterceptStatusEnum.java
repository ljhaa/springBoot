package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 提现拦截状态
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum WithdrawalInterceptStatusEnum {

    /**
     *
     */
    SUCCESS("拦截成功","SUCCESS"),
    FAIL("拦截失败","FAIL"),



;

    private String name;
    private String index;

    private WithdrawalInterceptStatusEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (WithdrawalInterceptStatusEnum c : WithdrawalInterceptStatusEnum.values()) {
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
