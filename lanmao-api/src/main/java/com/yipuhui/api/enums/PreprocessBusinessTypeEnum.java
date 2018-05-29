package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 预先处理业务类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum PreprocessBusinessTypeEnum {


    /**
     *
     */
    TENDER("投标","TENDER"),
    REPAYMENT("还款","REPAYMENT"),
    CREDIT_ASSIGNMENT("债权认购","CREDIT_ASSIGNMENT"),
    COMPENSATORY("代偿","COMPENSATORY"),
    PRETRANSACTION("交易预处理","PRETRANSACTION"),

;

    private String name;
    private String index;

    private PreprocessBusinessTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (PreprocessBusinessTypeEnum c : PreprocessBusinessTypeEnum.values()) {
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
