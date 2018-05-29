package com.yipuhui.fastgo.enty;

import java.util.Date;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class UpdateCard {
    private Integer id;

    private String selNum;

    private String status;

    private String lenderNum;

    private String data;

    private Date submitTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSelNum() {
        return selNum;
    }

    public void setSelNum(String selNum) {
        this.selNum = selNum == null ? null : selNum.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLenderNum() {
        return lenderNum;
    }

    public void setLenderNum(String lenderNum) {
        this.lenderNum = lenderNum == null ? null : lenderNum.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}