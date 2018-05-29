package com.yipuhui.api.entity;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.api.utils.LanMaoConstant;

/**
 * 
 *
 * Description:
 *
 * @author Admin
 * @version 1.0
 * 
 *          <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年4月24日      Admin      1.0         1.0 Version
 * </pre>
 */
public class SearchVo {

	private List<records> records;

	private String code;

	private String status;
	
	private String errorCode;
	
	private String errorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public SearchVo() {
	}
	public List<records> getRecords() {
		return records;
	}


	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setRecords(List<records> records) {
		this.records = records;
	}


	public String getCode() {
		return code;
	}





	public void setCode(String code) {
		this.code = code;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 返回本次查询的结果，标识有没有查到数据
	 */
	public boolean isSuccess()
	{
		if(LanMaoConstant.SUCCESS_CODE.equals(code)&&LanMaoConstant.SUCCESS.equals(status))
		{
			return  true;
		}
		return false;
	}
	
	
	public String  recordStatus()
	{
		if(records!=null&&records.size()==1)
		{
			return records.get(0).getStatus();
		}
		return null;
	}
	public static  SearchVo  getSearchVo(RespData data) {

		 String respData = data.getRespData();

		 return JSONObject.parseObject(respData, SearchVo.class);
		}
	
	
	public JSONObject getJsonRecord()
	{
		if(records!=null&&records.size()==1)
		{
		 JSONObject.toJSON(records.get(0))	;
		}
		return null;
	}
}

class records {

	private String status;
	
	private BigDecimal amount;
	
	private String rechargeWay;
	
	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	private String auditStatus;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRechargeWay() {
		return rechargeWay;
	}

	public void setRechargeWay(String rechargeWay) {
		this.rechargeWay = rechargeWay;
	}

}
