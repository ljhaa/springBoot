package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 还款方式
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum RepaymentType {


    /**
     *
     */
    ONE_TIME_SERVICING("一次性还本付息","ONE_TIME_SERVICING"),
    FIRSEINTREST_LASTPRICIPAL("先息后本","FIRSEINTREST_LASTPRICIPAL"),
    FIXED_PAYMENT_MORTGAGE("等额本息","FIXED_PAYMENT_MORTGAGE"),
    FIXED_BASIS_MORTGAGE("等额本金","FIXED_BASIS_MORTGAGE"),


;

    private String name;
    private String index;

    private RepaymentType(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (RepaymentType c : RepaymentType.values()) {
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
