package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 交易类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum TradeTypeEnum {


    /**
     *
     */
    TENDER("放款","TENDER"),
    REPAYMENT("还款","REPAYMENT"),
    CREDIT_ASSIGNMENT("债权认购","CREDIT_ASSIGNMENT"),
    COMPENSATORY("直接代偿","COMPENSATORY"),
    INDIRECT_COMPENSATORY("间接代偿","INDIRECT_COMPENSATORY"),
    PLATFORM_INDEPENDENT_PROFIT("独立分润","PLATFORM_INDEPENDENT_PROFIT"),
    MARKETING("平台营销款","MARKETING"),
    PLATFORM_SERVICE_DEDUCT("收费","PLATFORM_SERVICE_DEDUCT"),
    FUNDS_TRANSFER("平台资金划拨","FUNDS_TRANSFER"),
    APPEND_FREEZE("追加冻结","APPEND_FREEZE"),


;

    private String name;
    private String index;

    private TradeTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (TradeTypeEnum c : TradeTypeEnum.values()) {
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
