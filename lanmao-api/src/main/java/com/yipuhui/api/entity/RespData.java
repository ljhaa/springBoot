package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/4/10.
 */

import java.io.Serializable;

/**
 * 响应参数
 *
 * @author 刘俊汉
 * @create 2018-04-10 10:54
 **/
public class RespData implements Serializable{


    private String respData;

    private String sing;

    private String yphCode;

    private String yphMessage;

    private String url;

    public String getRespData() {
        return respData;
    }

    public void setRespData(String respData) {
        this.respData = respData;
    }

    public String getSing() {
        return sing;
    }

    public void setSing(String sing) {
        this.sing = sing;
    }

    public String getYphCode() {
        return yphCode;
    }

    public void setYphCode(String yphCode) {
        this.yphCode = yphCode;
    }

    public String getYphMessage() {
        return yphMessage;
    }

    public void setYphMessage(String yphMessage) {
        this.yphMessage = yphMessage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RespData{" +
                "respData='" + respData + '\'' +
                ", sing='" + sing + '\'' +
                ", yphCode='" + yphCode + '\'' +
                ", yphMessage='" + yphMessage + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
