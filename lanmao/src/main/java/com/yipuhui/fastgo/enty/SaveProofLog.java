package com.yipuhui.fastgo.enty;

import java.util.Date;

public class SaveProofLog {
    private Integer id;

    private String lenderNum;

    private String saveProofType;

    private String saveProofJson;

    private Date saveProofTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLenderNum() {
        return lenderNum;
    }

    public void setLenderNum(String lenderNum) {
        this.lenderNum = lenderNum == null ? null : lenderNum.trim();
    }

    public String getSaveProofType() {
        return saveProofType;
    }

    public void setSaveProofType(String saveProofType) {
        this.saveProofType = saveProofType == null ? null : saveProofType.trim();
    }

    public String getSaveProofJson() {
        return saveProofJson;
    }

    public void setSaveProofJson(String saveProofJson) {
        this.saveProofJson = saveProofJson == null ? null : saveProofJson.trim();
    }

    public Date getSaveProofTime() {
        return saveProofTime;
    }

    public void setSaveProofTime(Date saveProofTime) {
        this.saveProofTime = saveProofTime;
    }
}