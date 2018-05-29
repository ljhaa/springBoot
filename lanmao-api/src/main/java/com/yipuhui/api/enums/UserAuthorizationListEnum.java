package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 用户授权列表
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum UserAuthorizationListEnum {


    /**
     *
     */
    TENDER("自动投标","TENDER"),
    REPAYMENT("自动还款","REPAYMENT"),
    CREDIT_ASSIGNMENT("自动债权认购","CREDIT_ASSIGNMENT"),
    COMPENSATORY("自动代偿","COMPENSATORY"),
    WITHDRAW("自动提现","WITHDRAW"),
    RECHARGE("自动充值","RECHARGE");




    private String name;
    private String index;

    private UserAuthorizationListEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (UserAuthorizationListEnum c : UserAuthorizationListEnum.values()) {
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
