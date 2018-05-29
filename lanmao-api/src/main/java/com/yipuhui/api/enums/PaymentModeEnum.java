package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 支付方式
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum PaymentModeEnum {


    /**
     *
     */
    WEB("网银","WEB"),
    SWIFT("快捷支付","SWIFT"),
    BANK("转账充值，仅适用迁移场景，调用单笔充值订单查询接口返回","BANK"),
    BACKROLL("资金回退充值","BACKROLL"),
    PROXY("自动充值","PROXY"),



;

    private String name;
    private String index;

    private PaymentModeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (PaymentModeEnum c : PaymentModeEnum.values()) {
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
