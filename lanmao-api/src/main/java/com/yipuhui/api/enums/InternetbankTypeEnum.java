package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 网银类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum InternetbankTypeEnum {


    /**
     *
     */
    B2C("个人网银","B2C"),
    B2B("企业网银","B2B");




    private String name;
    private String index;

    private InternetbankTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (InternetbankTypeEnum c : InternetbankTypeEnum.values()) {
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
