package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 终端类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:30
 **/
public enum TerminalTypeEnum {



    //终端类型
    PC("PC端", "PC"),
    MOBILE("移动端", "MOBILE"),


    ;

    private String name;
    private String index;

    private TerminalTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (TerminalTypeEnum c : TerminalTypeEnum.values()) {
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
