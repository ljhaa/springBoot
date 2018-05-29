package com.yipuhui.fastgo.enty;

import java.util.Date;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class LenderDetail {
	/**
	 * 主键
	 */
    private Integer id;

    /**
     * 客户编号(出借人编号)
     */
    private String lenderNum;

    /**
     * 投资人登录主键
     */
    private Integer lenderLoginId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号码
     */
    private String cardNum;
    
    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 居住地址
     */
    private String residentialAddr;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 所在公司
     */
    private String company;

    /**
     * 职位类型
     */
    private String position;

    /**
     * 月收入
     */
    private String incomeMonth;

    /**
     * 开户状态（未处理1\处理中2\开户成功3\开户失败4）
     */
    private String lenderStatus;

    /**
     * 实名认证状态(未认证:1,认证通过:2,认证失败:3)
     */
    private String certificationStatus;

    /**
     * 系统编码标示
     */
    private String systemCode;
    
    private Date createTime;

    private Date operateTime;
    
    private String useStatus;
    
    private String middleMen;

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
        this.lenderNum = lenderNum;
    }

    public Integer getLenderLoginId() {
        return lenderLoginId;
    }

    public void setLenderLoginId(Integer lenderLoginId) {
        this.lenderLoginId = lenderLoginId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getResidentialAddr() {
        return residentialAddr;
    }

    public void setResidentialAddr(String residentialAddr) {
        this.residentialAddr = residentialAddr;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(String incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public String getLenderStatus() {
        return lenderStatus;
    }

    public void setLenderStatus(String lenderStatus) {
        this.lenderStatus = lenderStatus;
    }

    public String getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(String certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getMiddleMen() {
        return middleMen;
    }

    public void setMiddleMen(String middleMen) {
        this.middleMen = middleMen;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "LenderDetail{" +
                "id=" + id +
                ", lenderNum='" + lenderNum + '\'' +
                ", lenderLoginId=" + lenderLoginId +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", birthDate=" + birthDate +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", residentialAddr='" + residentialAddr + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", incomeMonth='" + incomeMonth + '\'' +
                ", lenderStatus='" + lenderStatus + '\'' +
                ", certificationStatus='" + certificationStatus + '\'' +
                ", systemCode='" + systemCode + '\'' +
                ", createTime=" + createTime +
                ", operateTime=" + operateTime +
                ", useStatus='" + useStatus + '\'' +
                ", middleMen='" + middleMen + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String str = "188585423-831218337-0001-0001_1";

        System.out.println(str.split("_")[0]);
    }
}