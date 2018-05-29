package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.Date;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class LenderCouponRelation {
    private Integer id;

    private Integer lenderLoginId;

    private Integer activityId;

    private String couponName;

    private String couponNum;

    private String couponType;

    private String applicationRange;

    private BigDecimal useLineLimit;

    private BigDecimal couponLimit;

    private BigDecimal ratio;

    private String useStatus;

    private Date validStartDate;

    private Date validEndDate;

    private Date createTime;

    private Date operateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLenderLoginId() {
		return lenderLoginId;
	}

	public void setLenderLoginId(Integer lenderLoginId) {
		this.lenderLoginId = lenderLoginId;
	}

	public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(String couponNum) {
        this.couponNum = couponNum;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getApplicationRange() {
        return applicationRange;
    }

    public void setApplicationRange(String applicationRange) {
        this.applicationRange = applicationRange;
    }

    public BigDecimal getUseLineLimit() {
        return useLineLimit;
    }

    public void setUseLineLimit(BigDecimal useLineLimit) {
        this.useLineLimit = useLineLimit;
    }

    public BigDecimal getCouponLimit() {
        return couponLimit;
    }

    public void setCouponLimit(BigDecimal couponLimit) {
        this.couponLimit = couponLimit;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public Date getValidStartDate() {
        return validStartDate;
    }

    public void setValidStartDate(Date validStartDate) {
        this.validStartDate = validStartDate;
    }

    public Date getValidEndDate() {
		return validEndDate;
	}

	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}