package com.yipuhui.api.enums;

public enum TransTypeEnum {
	
	DBHB("DBHB","TENDER","COMPENSATORY",false),//担保到个人账户划拨（担保理财账户到借款人负债账户）
	HBCZ("HBCZ","MARKETING","MARKETING",false),//红包充值
	HBDK("HBDK","MARKETING","MARKETING",false),//红包代扣
	HBFX("HBFX","MARKETING","MARKETING",false),//红包返息
	LCHB("LCHB","TENDER","TENDER",true),//理财划拨
	PHKHB("PHKHB","REPAYMENT","REPAYMENT",true),//个人还款划拨回调接口,150709
	PTHB("PTHB","TENDER","COMMISSION",false),//理财人账户到平台账户分账划拨
	FRHB("FRHB","PLATFORM_INDEPENDENT_PROFIT","PROFIT",false),//分润
	SHHB("SHHB","CREDIT_ASSIGNMENT","CREDIT_ASSIGNMENT",false),//赎回划拨
	TYJHB("TYJHB","MARKETING","MARKETING",false)//体验金划拨
	;
	
	public final String serviceType;
	
	public final  String bizType;
	
	public final  String tradeType;
	
	public final boolean isauto;

	private TransTypeEnum(String serviceType, String bizType, String tradeType,boolean isauto) {
		this.serviceType = serviceType;
		this.bizType = bizType;
		this.tradeType = tradeType;
		this.isauto=isauto;
	}
	

	 public static TransTypeEnum getType(String serviceType)
	 {
		 
		 for(TransTypeEnum e:TransTypeEnum.values())
		 {
			 if(e.serviceType.equals(serviceType))
			 {
				return e; 
			 }
		 }
		 return null;
	 }
	 
 
}
