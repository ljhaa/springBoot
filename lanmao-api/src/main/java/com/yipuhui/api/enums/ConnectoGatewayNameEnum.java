package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 交易类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum ConnectoGatewayNameEnum {

    //网关模式接口

    PERSONAL_REGISTER_EXPAND("个人绑卡注册","PERSONAL_REGISTER_EXPAND",3),

    ENTERPRISE_REGISTER("企业绑卡注册","ENTERPRISE_REGISTER",3),

    PERSONAL_BIND_BANKCARD_EXPAND("个人换绑卡","PERSONAL_BIND_BANKCARD_EXPAND",3),

    ENTERPRISE_BIND_BANKCARD("企业换绑卡","ENTERPRISE_BIND_BANKCARD",2),

    UNBIND_BANKCARD ("解绑银行卡","UNBIND_BANKCARD",2),

    RESET_PASSWORD("修改密码","RESET_PASSWORD",2),

    CHECK_PASSWORD("验证密码","CHECK_PASSWORD",2),

    MODIFY_MOBILE_EXPAND("预留手机号更新","MODIFY_MOBILE_EXPAND",2),

    ENTERPRISE_INFORMATION_UPDATE("企业信息修改","ENTERPRISE_INFORMATION_UPDATE",3),

    ACTIVATE_STOCKED_USER("会员激活","ACTIVATE_STOCKED_USER",3),

    RECHARGE("充值","RECHARGE",3),

    WITHDRAW("提现","WITHDRAW",3),

    USER_PRE_TRANSACTION("用户预处理","USER_PRE_TRANSACTION",3),

    USER_AUTHORIZATION("用户授权","USER_AUTHORIZATION",2),

    VERIFY_DEDUCT("验密扣费","VERIFY_DEDUCT",2),

    BACKROLL_RECHARGE("提现回充","BACKROLL_RECHARGE",2)
    ;

    private String name;
    private String index;
    private int code;

    private ConnectoGatewayNameEnum(String name, String index,int code) {
        this.name = name;
        this.index = index;
        this.code = code;
    }

    public static String getName(String index) {
        for (ConnectoGatewayNameEnum c : ConnectoGatewayNameEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }

    public static int getCode(String index) {
        for (ConnectoGatewayNameEnum c : ConnectoGatewayNameEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.code;
            }
        }
        return 2;
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
