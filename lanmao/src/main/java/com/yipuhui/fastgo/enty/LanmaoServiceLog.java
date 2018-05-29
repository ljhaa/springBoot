package com.yipuhui.fastgo.enty;

import java.util.Date;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class LanmaoServiceLog {
    private Integer id;

    private String requestNo;

    private String serviceName;

    private Integer reqOrRes;

    private Date time;

    private String serviceNameZh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Integer getReqOrRes() {
        return reqOrRes;
    }

    public void setReqOrRes(Integer reqOrRes) {
        this.reqOrRes = reqOrRes;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getServiceNameZh() {
        return serviceNameZh;
    }

    public void setServiceNameZh(String serviceNameZh) {
        this.serviceNameZh = serviceNameZh;
    }
}