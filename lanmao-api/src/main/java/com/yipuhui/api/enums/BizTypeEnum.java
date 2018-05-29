package com.yipuhui.api.enums;
/**
 * 
 * @author Admin
 * @see 业务类型
 */
public enum BizTypeEnum {

	/**
	 *
	 */
	TENDER("1","投标")
	,REPAYMENT("1","还款")
	,CREDIT_ASSIGNMENT("1","债权认购")
	,COMPENSATORY("1","代偿")
	,COMPENSATORY_REPAYMENT("1","还款代偿")
	,PLATFORM_INDEPENDENT_PROFIT("1","独立分润")
	,MARKETING("1","营销红包")
	,INTEREST("1","派息")
	,ALTERNATIVE_RECHARGE("1","代充值")
	,INTEREST_REPAYMENT("1","还派息款")
	,COMMISSION("1","佣金")
	,PROFIT("1","关联分润")
	,DEDUCT("1","平台服务费")
	,FUNDS_TRANSFER("1","平台资金划拨")
	,APPEND_FREEZE("1","追加冻结");
	
	public  String value;
	
	public String name;

	private BizTypeEnum(String value, String name) {
		this.value = value;
		this.name = name;
	}
	
	
	
	public static String getType(String type)
	{
		for(BizTypeEnum e:BizTypeEnum.values())
		{
			if(e.value.equals(type)) {
				return e.toString();
			}
		}
		
			return "";
	}
}
