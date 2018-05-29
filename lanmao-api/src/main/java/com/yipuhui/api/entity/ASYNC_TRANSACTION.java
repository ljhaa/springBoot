package com.yipuhui.api.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Admin
 * @see 批量划拨接口
 */
public class ASYNC_TRANSACTION {

	/**
	 *批次号#
	 */
	private String batchNo;

	/**
	 *交易明细#
	 */
	private List<Biz_Details> bizDetails;
	//交易明细订单号#
	
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public List<Biz_Details> getBizDetails() {
		return bizDetails;
	}
	public void setBizDetails(List<Biz_Details> bizDetails) {
		this.bizDetails = bizDetails;
	}
	
	public ASYNC_TRANSACTION() {
		
	}
	public ASYNC_TRANSACTION(String batchNo, Biz_Details bizDetails) {
		super();
		this.batchNo = batchNo;
		List<Biz_Details> list=new ArrayList<Biz_Details>();
		list.add(bizDetails);
		this.bizDetails = list;
	}
	
 
}

