package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.Date;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class SettleZz {
    private Integer id;

    private String servicetype;

    private String operationcode;

    private String busplatform;

    private String serlnum;

    private String realserlnum;

    private String outuser;

    private String inuser;

    private BigDecimal amount;

    private BigDecimal outuserfee;

    private BigDecimal inuserfee;

    private String thiplatform;

    private String status;

    private String msg;

    private Date overtime;

    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype == null ? null : servicetype.trim();
    }

    public String getOperationcode() {
        return operationcode;
    }

    public void setOperationcode(String operationcode) {
        this.operationcode = operationcode == null ? null : operationcode.trim();
    }

    public String getBusplatform() {
        return busplatform;
    }

    public void setBusplatform(String busplatform) {
        this.busplatform = busplatform == null ? null : busplatform.trim();
    }

    public String getSerlnum() {
        return serlnum;
    }

    public void setSerlnum(String serlnum) {
        this.serlnum = serlnum == null ? null : serlnum.trim();
    }

    public String getRealserlnum() {
        return realserlnum;
    }

    public void setRealserlnum(String realserlnum) {
        this.realserlnum = realserlnum == null ? null : realserlnum.trim();
    }

    public String getOutuser() {
        return outuser;
    }

    public void setOutuser(String outuser) {
        this.outuser = outuser == null ? null : outuser.trim();
    }

    public String getInuser() {
        return inuser;
    }

    public void setInuser(String inuser) {
        this.inuser = inuser == null ? null : inuser.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getOutuserfee() {
        return outuserfee;
    }

    public void setOutuserfee(BigDecimal outuserfee) {
        this.outuserfee = outuserfee;
    }

    public BigDecimal getInuserfee() {
        return inuserfee;
    }

    public void setInuserfee(BigDecimal inuserfee) {
        this.inuserfee = inuserfee;
    }

    public String getThiplatform() {
        return thiplatform;
    }

    public void setThiplatform(String thiplatform) {
        this.thiplatform = thiplatform == null ? null : thiplatform.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "SettleZz{" +
                "id=" + id +
                ", servicetype='" + servicetype + '\'' +
                ", operationcode='" + operationcode + '\'' +
                ", busplatform='" + busplatform + '\'' +
                ", serlnum='" + serlnum + '\'' +
                ", realserlnum='" + realserlnum + '\'' +
                ", outuser='" + outuser + '\'' +
                ", inuser='" + inuser + '\'' +
                ", amount=" + amount +
                ", outuserfee=" + outuserfee +
                ", inuserfee=" + inuserfee +
                ", thiplatform='" + thiplatform + '\'' +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", overtime=" + overtime +
                ", addtime=" + addtime +
                '}';
    }
}