package com.yipuhui.fastgo.enty;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class LanmaoServiceLogWithBlobs extends LanmaoServiceLog {
    private String reqData;

    private String saveData;

    public String getReqData() {
        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData == null ? null : reqData.trim();
    }

    public String getSaveData() {
        return saveData;
    }

    public void setSaveData(String saveData) {
        this.saveData = saveData == null ? null : saveData.trim();
    }
}