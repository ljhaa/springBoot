package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 回调类型枚举
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:49
 **/
public enum CallbackTypeEnum{

    //回调类型
    CALLBACK("浏览器返回", "CALLBACK"),
    NOTIFY("服务器异步通知", "NOTIFY");


    private String name;
    private String index;

    private CallbackTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (CallbackTypeEnum c : CallbackTypeEnum.values()) {
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
