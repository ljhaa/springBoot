package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.Date;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class FundAccount {
	/**
	 * 主键
	 */
    private Integer id;
    
    /**
     * 账户类型:  1:个人账户,  2:红包账户
     */
    private String accountType;

    /**
     * 客户真实姓名
     */
    private String accountName;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号码
     */
    private String cardCode;

    /**
     * 可用余额(元)
     */
    private BigDecimal availableBalance;

    /**
     * 冻结金额(元)
     */
    private BigDecimal freezeAmount;

    /**
     * 账户状态（已启用1\已注销2\已停用3
     */
    private String accountStatus;

    /**
     * 开户日期
     */
    private Date openDate;

    /**
     * 操作日期
     */
    private Date operateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}