package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 标的状态
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum ObjectStatusEnum {

    /**
     *
     */
    COLLECTING("募集中","COLLECTING"),
    REPAYING("还款中","REPAYING"),
    FINISH("已截标","FINISH"),
    MISCARRY("流标","MISCARRY");


    private String name;
    private String index;

    private ObjectStatusEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (ObjectStatusEnum c : ObjectStatusEnum.values()) {
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
