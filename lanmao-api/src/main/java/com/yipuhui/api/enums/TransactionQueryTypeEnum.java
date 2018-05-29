package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 交易查询类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum TransactionQueryTypeEnum {

    /**
     *
     */
    RECHARGE("充值","RECHARGE"),
    WITHDRAW("提现","WITHDRAW"),
    PRETRANSACTION("交易预处理","PRETRANSACTION"),
    TRANSACTION("交易确认","TRANSACTION"),
    FREEZE("冻结","FREEZE"),
    DEBENTURE_SALE("债权出让","DEBENTURE_SALE"),
    CANCEL_PRETRANSACTION("取消预处理","CANCEL_PRETRANSACTION"),
    UNFREEZE("解冻","UNFREEZE"),
    INTERCEPT_WITHDRAW("提现拦截","INTERCEPT_WITHDRAW"),
    GENERAL_FREEZE("通用冻结","GENERAL_FREEZE"),
    UPDATE_BANKCARD_AUDIT("换卡记录","UPDATE_BANKCARD_AUDIT");

    private String name;
    private String index;

    private TransactionQueryTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (TransactionQueryTypeEnum c : TransactionQueryTypeEnum.values()) {
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
