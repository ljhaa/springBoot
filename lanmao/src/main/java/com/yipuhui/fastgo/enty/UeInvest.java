package com.yipuhui.fastgo.enty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UeInvest implements Serializable {
    /**
     * ue_invest.ue_invest_id (主键)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Integer ueInvestId;

    /**
     * ue_invest.ue_bid_id (体验标id)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Integer ueBidId;

    /**
     * ue_invest.invest_amount (投资金额)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private BigDecimal investAmount;

    /**
     * ue_invest.invest_time (购买日期)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Date investTime;

    /**
     * ue_invest.due_date (到期日期)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Date dueDate;

    /**
     * ue_invest.redemption_money (收益金额)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private BigDecimal redemptionMoney;

    /**
     * ue_invest.invest_status (投资状态1,投资中,2未提现,3已销毁,4提现中，5已提现，6提现失败)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private String investStatus;

    /**
     * ue_invest.lender_login_id (投资人id)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Integer lenderLoginId;

    /**
     * ue_invest.destroy_date (销毁日期)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Date destroyDate;

    /**
     * ue_invest.sel_num (提取收益流水号)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private String selNum;

    /**
     * ue_invest.rate (预期年化收益率)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private BigDecimal rate;

    /**
     * ue_invest.term (投资期限(天))
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private Integer term;

    /**
     * ue_invest.invest_num (体验标编号)
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    private String investNum;

    public Integer getUeInvestId() {
        return ueInvestId;
    }

    public void setUeInvestId(Integer ueInvestId) {
        this.ueInvestId = ueInvestId;
    }

    public Integer getUeBidId() {
        return ueBidId;
    }

    public void setUeBidId(Integer ueBidId) {
        this.ueBidId = ueBidId;
    }

    public BigDecimal getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    public Date getInvestTime() {
        return investTime;
    }

    public void setInvestTime(Date investTime) {
        this.investTime = investTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getRedemptionMoney() {
        return redemptionMoney;
    }

    public void setRedemptionMoney(BigDecimal redemptionMoney) {
        this.redemptionMoney = redemptionMoney;
    }

    public String getInvestStatus() {
        return investStatus;
    }

    public void setInvestStatus(String investStatus) {
        this.investStatus = investStatus;
    }

    public Integer getLenderLoginId() {
        return lenderLoginId;
    }

    public void setLenderLoginId(Integer lenderLoginId) {
        this.lenderLoginId = lenderLoginId;
    }

    public Date getDestroyDate() {
        return destroyDate;
    }

    public void setDestroyDate(Date destroyDate) {
        this.destroyDate = destroyDate;
    }

    public String getSelNum() {
        return selNum;
    }

    public void setSelNum(String selNum) {
        this.selNum = selNum;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getInvestNum() {
        return investNum;
    }

    public void setInvestNum(String investNum) {
        this.investNum = investNum;
    }
}