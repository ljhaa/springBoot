package com.yipuhui.fastgo.enty;

import java.util.Date;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class SmsInterfaceLog {
    private Integer id;

    private String modelType;

    private String mobiles;

    private String msg;

    private String title;

    private Integer sendLevel;

    private String operState;

    private Date sendTime;
    
    public SmsInterfaceLog() {
		super();
	}

	public SmsInterfaceLog(String modelType, String mobiles, String msg, String title, Integer sendLevel, String operState,
                           Date sendTime) {
		super();
		this.modelType = modelType;
		this.mobiles = mobiles;
		this.msg = msg;
		this.title = title;
		this.sendLevel = sendLevel;
		this.operState = operState;
		this.sendTime = sendTime;
	}

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

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSendLevel() {
        return sendLevel;
    }

    public void setSendLevel(Integer sendLevel) {
        this.sendLevel = sendLevel;
    }

    public String getOperState() {
        return operState;
    }

    public void setOperState(String operState) {
        this.operState = operState;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}