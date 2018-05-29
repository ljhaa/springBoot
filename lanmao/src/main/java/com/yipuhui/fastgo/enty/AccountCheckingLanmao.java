package com.yipuhui.fastgo.enty;

import java.util.Date;

/**  
 *    
 *   
 * @author 刘俊汉  
 * @date 2018/5/11 17:26
 * @param   
 * @return   
 */ 
public class AccountCheckingLanmao {
    private Integer id;

    private String businessType;

    private String lanmaoRelevancePlatform;

    private Date billCreatTime;

    private Date creatTime;

    private Integer checkStatus;

    private String lanmaoData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getLanmaoRelevancePlatform() {
        return lanmaoRelevancePlatform;
    }

    public void setLanmaoRelevancePlatform(String lanmaoRelevancePlatform) {
        this.lanmaoRelevancePlatform = lanmaoRelevancePlatform == null ? null : lanmaoRelevancePlatform.trim();
    }

    public Date getBillCreatTime() {
        return billCreatTime;
    }

    public void setBillCreatTime(Date billCreatTime) {
        this.billCreatTime = billCreatTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getLanmaoData() {
        return lanmaoData;
    }

    public void setLanmaoData(String lanmaoData) {
        this.lanmaoData = lanmaoData == null ? null : lanmaoData.trim();
    }
}