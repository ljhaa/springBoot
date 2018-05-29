package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.Date;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class FundAccountHistory {
	
	/**
	 * 主键
	 */
    private Integer id;

    /**
	 * 流水号
	 */
    private String serlNum;

    /**
	 * 证件号码
	 */
    private String cardCode;
    
    /**
     * 账户类型:  1:个人账户,  2:红包账户
     */
    private String accountType;

    /**
	 * 交易类型 ：线下充值:1,网关充值:2,投标冻结:3,放款:4,回收利息:5,回收本息:6,提现冻结:7,提现:8
	 */
    private String tradeSubject;

    /**
	 * 收支类型：(收入:A,支出:B)
	 */
    private String tradeType;

    /**
	 * 交易金额(元)
	 */
    private BigDecimal tradeMoney;

    /**
	 * 交易时间
	 */
    private Date tradeTime;
    
    /**
     * 系统编码标示
     */
    private String systemCode;

    /**
	 * 摘要
	 */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerlNum() {
        return serlNum;
    }

    public void setSerlNum(String serlNum) {
        this.serlNum = serlNum;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getTradeSubject() {
        return tradeSubject;
    }

    public void setTradeSubject(String tradeSubject) {
        this.tradeSubject = tradeSubject;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public BigDecimal getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(BigDecimal tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}