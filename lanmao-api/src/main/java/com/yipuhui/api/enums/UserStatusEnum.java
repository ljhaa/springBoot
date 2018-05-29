package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 用户状态
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum UserStatusEnum {


    /**
     *
     */
    ACTIVATED("可用","ACTIVATED"),
    DEACTIVATED("不可用","DEACTIVATED")


;

    private String name;
    private String index;

    private UserStatusEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (UserStatusEnum c : UserStatusEnum.values()) {
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
