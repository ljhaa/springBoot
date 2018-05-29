package com.yipuhui.fastgo.enty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UeWater implements Serializable {
    /**
     * ue_water.ue_water_id (主键)
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    private Integer ueWaterId;

    /**
     * ue_water.money (体验金收益)
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    private BigDecimal money;

    /**
     * ue_water.lender_login_id (用户主键)
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    private Integer lenderLoginId;

    /**
     * ue_water.type (类型1虚拟 2现金)
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    private String type;

    /**
     * ue_water.create_time (创建时间)
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    private Date createTime;

    /**
     * ue_water.water_desc (描述)
     * @ibatorgenerated 2016-05-06 14:31:00
     */
    private String waterDesc;

    public Integer getUeWaterId() {
        return ueWaterId;
    }

    public void setUeWaterId(Integer ueWaterId) {
        this.ueWaterId = ueWaterId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWaterDesc() {
        return waterDesc;
    }

    public void setWaterDesc(String waterDesc) {
        this.waterDesc = waterDesc;
    }
}