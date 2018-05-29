package com.yipuhui.api.enums;/**
 * Created by liujunhan on 2018/4/4.
 */

/**
 * @author 刘俊汉
 * @create 2018-04-04 13:54
 **/
public enum  CertificateTypeEnum {

    //证件类型
    PRC_ID("中华人民共和国居民身份证", "PRC_ID"),
    PASSPORT("护照", "PASSPORT"),
    COMPATRIOTS_CARD("港澳台同胞回乡证", "COMPATRIOTS_CARD"),
    PERMANENT_RESIDENCE("外国人永久居留证", "PERMANENT_RESIDENCE");


    private String name;
    private String index;

    private CertificateTypeEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (CertificateTypeEnum c : CertificateTypeEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
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


}
