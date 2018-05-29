package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/4/13.
 */

/**
 * 返回参数整理
 *
 * @author 刘俊汉
 * @create 2018-04-13 15:12
 **/
public class RequstDataSuper {


    private String reqData;


    private String sing;

    private String serviceName;

    public String getReqData() {

        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData;
    }

    public String getSing() {
        return sing;
    }

    public void setSing(String sing) {
        this.sing = sing;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "RequstDataSuper{" +
                "reqData='" + reqData + '\'' +
                ", sing='" + sing + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
