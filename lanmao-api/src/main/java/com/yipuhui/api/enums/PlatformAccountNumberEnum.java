package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 平台账户编号
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum PlatformAccountNumberEnum {

    /**
     * // 平台总账户（系统自动生成平台用户编号）
     */
    SYS_GENERATE_000("平台总账户","SYS_GENERATE_000"),
    // 营销款账户（系统自动生成平台用户编号）
    SYS_GENERATE_002("营销款账户","SYS_GENERATE_002"),
    // 分润账户（系统自动生成平台用户编号）
    SYS_GENERATE_003("分润账户","SYS_GENERATE_003"),
    // 收入账户（系统自动生成平台用户编号）
    SYS_GENERATE_004("收入账户","SYS_GENERATE_004"),
    // 派息账户（系统自动生成平台用户编号）
    SYS_GENERATE_005("派息账户","SYS_GENERATE_005"),
    // 代充值账户（系统自动生成平台用户编号）
    SYS_GENERATE_006("代充值账户","SYS_GENERATE_006"),
    // 平台垫资账户（系统自动生成平台用户编号）
    SYS_GENERATE_007("平台垫资账户","SYS_GENERATE_007");





    private String name;
    private String index;

    private PlatformAccountNumberEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (PlatformAccountNumberEnum c : PlatformAccountNumberEnum.values()) {
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
