package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 对账文件类型
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum AccountFileTypeEnum {


    /**
     *
     */
    RECHARGE("充值","RECHARGE"),
    /**
     *
     */
    WITHDRAW("提现","WITHDRAW"),
    /**
     *
     */
    COMMISSION("佣金","COMMISSION"),

    /**
     *
     */
    TRANSACTION("交易","TRANSACTION"),
    /**
     *
     */
    BACKROLL_RECHARGE("资金回退充值","BACKROLL_RECHARGE");



;
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
     * @date 2018/5/15 10:17
     * @return 
     */
    private AccountFileTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param null
     * @date 2018/5/15 10:17
     * @return 
     */
    public static String getName(String index) {
        for (AccountFileTypeEnum c : AccountFileTypeEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param null
     * @date 2018/5/15 10:21
     * @return 
     */
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
