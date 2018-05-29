package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * 提现交易状态
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum WithdrawalTransactionStatusEnum {


    // 待确认
    CONFIRMING("2","CONFIRMING","待确认"),
    // 已受理
    ACCEPT("2","ACCEPT","已受理"),
    // 出款中
    REMITING("2","REMITING","出款中"),
    // 提现成功
    SUCCESS("3","SUCCESS","提现成功"),
    // 提现失败
    FAIL("4","FAIL","提现失败"),
    // 受理失败
    ACCEPT_FAIL("4","ACCEPT_FAIL","受理失败"),
;

    private String name;
    private String index;
    private String remark;

    private WithdrawalTransactionStatusEnum(String name, String index,String remark) {
        this.name = name;
        this.index = index;
        this.remark = remark;
    }

    public static String getName(String index) {
        for (WithdrawalTransactionStatusEnum c : WithdrawalTransactionStatusEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
    
    public static String getRemark(String index) {
        for (WithdrawalTransactionStatusEnum c : WithdrawalTransactionStatusEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.remark;
            }
        }
        return null;
    }
    
    

    public static WithdrawalTransactionStatusEnum getEnum(String index) {
        for (WithdrawalTransactionStatusEnum c : WithdrawalTransactionStatusEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    

}
