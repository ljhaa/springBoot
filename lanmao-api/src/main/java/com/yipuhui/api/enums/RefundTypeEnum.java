package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 用户角色
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum RefundTypeEnum {


    /**
     *
     */
    GUARANTEECORP("担保机构","GUARANTEECORP"),
    INVESTOR("投资人","INVESTOR"),
    BORROWERS("借款人","BORROWERS"),
    COLLABORATOR("合作机构","COLLABORATOR"),
    SUPPLIER("供应商","SUPPLIER"),
    PLATFORM_MARKETING("平台营销款账户","PLATFORM_MARKETING"),
    PLATFORM_PROFIT("平台分润账户","PLATFORM_PROFIT"),
    PLATFORM_INCOME("平台收入账户","PLATFORM_INCOME"),
    PLATFORM_INTEREST("平台派息账户","PLATFORM_INTEREST"),
    PLATFORM_ALTERNATIVE_RECHARGE("平台代充值账户","PLATFORM_ALTERNATIVE_RECHARGE"),
    PLATFORM_FUNDS_TRANSFER("平台总账户","PLATFORM_FUNDS_TRANSFER"),
    PLATFORM_URGENT("垫资账户","PLATFORM_URGENT"),



;

    private String name;
    private String index;

    private RefundTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (RefundTypeEnum c : RefundTypeEnum.values()) {
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
