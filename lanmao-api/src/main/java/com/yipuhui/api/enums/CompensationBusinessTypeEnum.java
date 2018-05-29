package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 代偿业务类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum CompensationBusinessTypeEnum {


    /**
     *
     */
    COMPENSATORY("普通代偿","COMPENSATORY");




    private String name;
    private String index;

    private CompensationBusinessTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (CompensationBusinessTypeEnum c : CompensationBusinessTypeEnum.values()) {
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
