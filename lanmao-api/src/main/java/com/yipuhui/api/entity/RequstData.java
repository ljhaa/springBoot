package com.yipuhui.api.entity;/**
 * Created by liujunhan on 2018/4/10.
 */

import java.io.Serializable;

/**
 * 请求参数
 *
 * @author 刘俊汉
 * @create 2018-04-10 10:52
 **/
public class RequstData extends RequstDataSuper implements Serializable{




    private String saveData;


    public String getSaveData() {

        return saveData;
    }

    public void setSaveData(String saveData) {
        this.saveData = saveData;
    }

    @Override
    public String toString() {
        return "RequstData{" +
                "saveData='" + saveData + '\'' +
                '}';
    }
}
