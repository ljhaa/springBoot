package com.yipuhui.fastgo.enty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UeAccount implements Serializable {
    /**
     * ue_account.ue_account_id (主键)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Integer ueAccountId;

    /**
     * ue_account.available (可用体验金)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private BigDecimal available;

    /**
     * ue_account.money (体验金收益)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private BigDecimal money;

    /**
     * ue_account.lender_login_id (用户主键)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Integer lenderLoginId;

    /**
     * ue_account.expected (预收益)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private BigDecimal expected;

    /**
     * ue_account.create_time (创建时间)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Date createTime;

    public Integer getUeAccountId() {
        return ueAccountId;
    }

    public void setUeAccountId(Integer ueAccountId) {
        this.ueAccountId = ueAccountId;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getLenderLoginId() {
        return lenderLoginId;
    }

    public void setLenderLoginId(Integer lenderLoginId) {
        this.lenderLoginId = lenderLoginId;
    }

    public BigDecimal getExpected() {
        return expected;
    }

    public void setExpected(BigDecimal expected) {
        this.expected = expected;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}