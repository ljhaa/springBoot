package com.yipuhui.api.entity;

import java.math.BigDecimal;

/**
 * 
 * @author Admin
 * 提现实体
 *  整数 I 整数，十亿以内
	金额 A 单位元，精确到到小数点后两位，十亿以内
	日期 D 使用 YYYYMMDD（如 20141213）的格式。时区采用北京时间（GMT+8:00）
	日期时间 T 使用 yyyyMMddHHmmss（如 20141213123456）的格式。时区采用北京时间（GMT+8:00）
	字符串 S 任意合法的字符串（英文，符号，中文等）
	枚举值 E 见具体参数描述
	浮点数 F 不超过 10 亿，小数点后最多 7 位
	布尔 B true 为是；false 为否
	复合类型 C 数组内部嵌套键值对
	简单对象 O 嵌套键值对
 */
public class WITHDRAW {

	/**
	 * 平台用户编号
	 */
	private  String platformUserNo;

	/**
	 *请求流水号
	 */
	private String requestNo;

	/**
	 *超过此时间即页面过期
	 */
	private String expired;

	/**
	 *页面回跳 UR
	 */
	private String redirectUrl;

	/**
	 *提现方式
	 */
	private String withdrawType;

	/**
	 *提现类型 IMMEDIATE 为直接提现，CONFIRMED 为待确认提现，不传默认为直
	 */
	private String withdrawForm;

	/**
	 *提现金额
	 */
	private BigDecimal amount;

	/**
	 *提现分佣
	 */
	private BigDecimal commission;
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getWithdrawType() {
		return withdrawType;
	}
	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}
	public String getWithdrawForm() {
		return withdrawForm;
	}
	public void setWithdrawForm(String withdrawForm) {
		this.withdrawForm = withdrawForm;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getCommission() {
		return commission;
	}
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
	
	
	
	
	
	
}
