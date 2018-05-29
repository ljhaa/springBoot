package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 鉴权通过类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum AuthenticationPassTypeEnum {






    /**
     *
     */
    FULL_CHECKED("四要素验证通过","FULL_CHECKED"),
    /**
     *
     */
    NOT_AUTH("未鉴权","NOT_AUTH"),
    /**
     *
     */
    AUDIT_AUTH("特殊用户认证","AUDIT_AUTH"),
    /**
     *
     */
    PART_CHECKED("企业用户认证","PART_CHECKED");






    private String name;
    private String index;

    private AuthenticationPassTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (AuthenticationPassTypeEnum c : AuthenticationPassTypeEnum.values()) {
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
