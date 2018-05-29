package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 交易类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum ConnectorDirectNameEnum {



    //直连接口

    AUDIT_BIND_CARD("换卡审核","AUDIT_BIND_CARD",2),

    DIRECT_RECHARGE("自动充值","DIRECT_RECHARGE",2),

    CONFIRM_WITHDRAW("提现确认","CONFIRM_WITHDRAW",2),

    CANCEL_WITHDRAW("取消提现","CANCEL_WITHDRAW",2),

    AUTO_WITHDRAW("自动提现","AUTO_WITHDRAW",2),

    INTERCEPT_WITHDRAW("提现拦截","INTERCEPT_WITHDRAW",2),

    ESTABLISH_PROJECT("创建标的","ESTABLISH_PROJECT",2),

    MODIFY_PROJECT("变更标的","MODIFY_PROJECT",2),

    FREEZE_PRE_TRANSACTION("冻结预处理","FREEZE_PRE_TRANSACTION",2),


    CANCEL_PRE_TRANSACTION("预处理取消","CANCEL_PRE_TRANSACTION",2),

    ASYNC_TRANSACTION("批量交易","ASYNC_TRANSACTION",3),

    DEBENTURE_SALE("单笔债权出让","DEBENTURE_SALE",2),

    CANCEL_DEBENTURE_SALE ("取消债权出让","CANCEL_DEBENTURE_SALE",2),


    AUTHORIZATION_ENTRUST_PAY("委托支付授权","AUTHORIZATION_ENTRUST_PAY",2),

    CANCEL_USER_AUTHORIZATION("取消用户授权","CANCEL_USER_AUTHORIZATION",2),

    USER_AUTO_PRE_TRANSACTION("授权预处理","USER_AUTO_PRE_TRANSACTION",2),


    FREEZE("资金冻结","FREEZE",2),

    UNFREEZE ("资金解冻","UNFREEZE",2),

    DOWNLOAD_CHECKFILE("对账文件下载","DOWNLOAD_CHECKFILE",2),

    CONFIRM_CHECKFILE("对账文件确认","CONFIRM_CHECKFILE",2),

    UNFREEZE_TRADE_PASSWORD("交易密码解冻","UNFREEZE_TRADE_PASSWORD",2),

    QUERY_USER_INFORMATION("用户信息查询","QUERY_USER_INFORMATION",2),

    QUERY_TRANSACTION("单笔交易查询","QUERY_TRANSACTION",2),

    QUERY_AUTHORIZATION_ENTRUST_PAY_RECORD("委托支付授权记录查询","QUERY_AUTHORIZATION_ENTRUST_PAY_RECORD",2),

    QUERY_PROJECT_INFORMATION("标的信息查询","QUERY_PROJECT_INFORMATION",2)

    ;

    private String name;
    private String index;
    private int code;

    private ConnectorDirectNameEnum(String name, String index,int code) {
        this.name = name;
        this.index = index;
        this.code = code;
    }

    public static String getName(String index) {
        for (ConnectorDirectNameEnum c : ConnectorDirectNameEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }


    public static int getCode(String index) {
        for (ConnectorDirectNameEnum c : ConnectorDirectNameEnum.values()) {
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
