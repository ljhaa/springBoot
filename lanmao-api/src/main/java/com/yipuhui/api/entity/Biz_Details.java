package com.yipuhui.api.entity;

import java.util.List;

/**
 * 
 * @author Admin
 * @see 批量划拨接口
 */
public class Biz_Details {


	/**
	 *交易明细订单号#
	 */
	private String requestNo;

	/**
	 *交易类型#
	 */
	private String tradeType;

	/**
	 *标的编号
	 */
	private String projectNo;

	/**
	 *债权出让请求流水号
	 */
	private String saleRequestNo;

	/**
	 *业务明细#
	 */
	private List<Trade_Details> details;
	
	
	
	public Biz_Details() {
	}
	
	
	
	
	public Biz_Details(String requestNo, String tradeType,
			List<Trade_Details> details) {
		super();
		this.requestNo = requestNo;
		this.tradeType = tradeType;
		this.details = details;
	}




	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getSaleRequestNo() {
		return saleRequestNo;
	}
	public void setSaleRequestNo(String saleRequestNo) {
		this.saleRequestNo = saleRequestNo;
	}
	public List<Trade_Details> getDetails() {
		return details;
	}
	public void setDetails(List<Trade_Details> details) {
		this.details = details;
	}
 
}

