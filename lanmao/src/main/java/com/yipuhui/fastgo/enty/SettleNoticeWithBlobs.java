package com.yipuhui.fastgo.enty;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class SettleNoticeWithBlobs extends SettleNotice {
    private String noticedata;

    private String responsedata;

    public String getNoticedata() {
        return noticedata;
    }

    public void setNoticedata(String noticedata) {
        this.noticedata = noticedata == null ? null : noticedata.trim();
    }

    public String getResponsedata() {
        return responsedata;
    }

    public void setResponsedata(String responsedata) {
        this.responsedata = responsedata == null ? null : responsedata.trim();
    }
}