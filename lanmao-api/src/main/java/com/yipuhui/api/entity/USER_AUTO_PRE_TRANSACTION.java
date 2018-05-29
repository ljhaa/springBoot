package com.yipuhui.api.entity;

import java.math.BigDecimal;

/**
 * 授权预处理
 * @author Admin
 *
 */
public class USER_AUTO_PRE_TRANSACTION {

	/**
	 *请求流水号
	 */
	private String requestNo;
	/**
	 *平台用户编号
	 */
	private String platformUserNo;
	/**
	 *关联充值请求流水号（原充值成功请求流水号）
	 */
	private String originalRechargeNo;
	/**
	 *见【预处理业务类型】,若传入关联请求流水号，则业务类型需要相对应
	 */
	private String bizType;
	/**
	 *冻结金额
	 */
	private BigDecimal amount;
	/**
	 *预备使用的红包金额，只记录不冻结，仅限投标业务类型
	 */
	private String preMarketingAmount;
	/**
	 *备注
	 */
	private String remark;
	/**
	 *标的号, 若传入关联充值请求流水号，则标的号固定为充值请求传入的标的号
	 */
	private String projectNo;
	/**
	 *购买债转份额，业务类型为债权认购时，需要传此参数
	 */
	private String share;
	/**
	 *债权出让请求流水号，只有债权认购业务需填此参数
	 */
	private String creditsaleRequestNo;
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	public String getOriginalRechargeNo() {
		return originalRechargeNo;
	}
	public void setOriginalRechargeNo(String originalRechargeNo) {
		this.originalRechargeNo = originalRechargeNo;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getPreMarketingAmount() {
		return preMarketingAmount;
	}
	public void setPreMarketingAmount(String preMarketingAmount) {
		this.preMarketingAmount = preMarketingAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public String getCreditsaleRequestNo() {
		return creditsaleRequestNo;
	}
	public void setCreditsaleRequestNo(String creditsaleRequestNo) {
		this.creditsaleRequestNo = creditsaleRequestNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
