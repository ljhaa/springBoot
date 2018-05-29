package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/17.
 */

/**
 * 支付公司
 *
 * @author 刘俊汉
 * @create 2018-04-17 10:58
 **/
public enum PayCompany {

    /**
     *
     */
    YEEPAY("易宝支付","YEEPAY"),
    FUIOU("富友支付","FUIOU"),
    ALLINPAY("通联支付","ALLINPAY"),
    UCFPAY ("先锋支付","UCFPAY"),
    BAOFOO("宝付","BAOFOO"),
    REAPAL("融宝支付","REAPAL"),
    BILL99 ("快钱支付","BILL99"),
    LIANLIAN("连连支付","LIANLIAN"),
    SUMAPAY("丰付","SUMAPAY"),
    NEWPAY ("新生支付","NEWPAY"),
    BFBPAY ("邦付宝","BFBPAY"),
    UMPAY("联动优势","UMPAY"),

    ;

    private String name;
    private String index;

    private PayCompany(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (PayCompany c : PayCompany.values()) {
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
