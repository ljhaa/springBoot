package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.Date;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class OpenModelConfig {
	
	/**
	 * 主键
	 */
    private Integer id;

    /**
     * 模块类型
     */
    private String modelType;

    /**
     * 模块描述
     */
    private String modelDescription;

    /**
     * 是否开启: 1:开启，0:关闭
     */
    private String isOpen;

    /**
     * 优惠券类型:    抵扣券:1,  现金券:2
     */
    private String couponType;

    /**
     * 使用额度限制(元)
     */
    private BigDecimal useLineLimit;

    /**
     * 优惠券额度(元)
     */
    private BigDecimal couponLimit;

    /**
     * 优惠券有限天数(日)
     */
    private Integer couponValidDays;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 操作时间
     */
    private Date operateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
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

    public Integer getCouponValidDays() {
        return couponValidDays;
    }

    public void setCouponValidDays(Integer couponValidDays) {
        this.couponValidDays = couponValidDays;
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