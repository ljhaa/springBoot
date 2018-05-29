package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 *审核状态
 *
 * @author 刘俊汉
 * @create 2018-04-04 13:57
 **/
public enum CheckStatusEnum {


    /**
     *
     */
    AUDIT("4","AUDIT","审核中"),
    PASSED("2","PASSED","审核通过"),
    BACK("3","BACK","审核回退"),
    REFUSED("3","REFUSED","审核拒绝");




    private String name;
    private String index;
    
    private String remark;

    private CheckStatusEnum(String name, String index,String remark) {
        this.name = name;
        this.index = index;
        this.remark = remark;
    }

    public static String getName(String index) {
        for (CheckStatusEnum c : CheckStatusEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
    
    public static String getRemark(String index) {
        for (CheckStatusEnum c : CheckStatusEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.getRemark();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    

}
