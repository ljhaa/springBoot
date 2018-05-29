package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 业务类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum BusinessTypeEnum {


    /**
     *
     */
    TENDER("投标","TENDER"),
    REPAYMENT("还款","REPAYMENT"),
    CREDIT_ASSIGNMENT("债权认购","CREDIT_ASSIGNMENT"),
    COMPENSATORY("代偿","COMPENSATORY"),
    COMPENSATORY_REPAYMENT("还代偿款","COMPENSATORY_REPAYMENT"),
    PLATFORM_INDEPENDENT_PROFIT("独立分润","PLATFORM_INDEPENDENT_PROFIT"),
    MARKETING("营销红包","MARKETING"),
    INTEREST("派息","INTEREST"),
    ALTERNATIVE_RECHARGE("代充值","ALTERNATIVE_RECHARGE"),
    INTEREST_REPAYMENT("还派息款","INTEREST_REPAYMENT"),
    COMMISSION("佣金","COMMISSION"),
    PROFIT("关联分润","PROFIT"),
    DEDUCT("平台服务费","DEDUCT"),
    FUNDS_TRANSFER("平台资金划拨","FUNDS_TRANSFER"),
    APPEND_FREEZE("追加冻结","APPEND_FREEZE");




    private String name;
    private String index;

    private BusinessTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (BusinessTypeEnum c : BusinessTypeEnum.values()) {
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
