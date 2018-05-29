package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/19.
 */

/**
 * 标的类型
 *
 * @author 刘俊汉
 * @create 2018-04-19 15:21
 **/
public enum  BidTypeEnum {

    /**
     *
     */
    STANDARDPOWDER("散标","STANDARDPOWDER"),
    /**
     *
     */

    ENTRUST_PAY("委托支付标的","ENTRUST_PAY");

    /**
     * 
     */
    private String name;
    private String index;
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param null
     * @date 2018/5/15 10:19
     * @return 
     */
    private BidTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param null
     * @date 2018/5/15 10:19
     * @return 
     */
    public static String getName(String index) {
        for (BidTypeEnum c : BidTypeEnum.values()) {
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
