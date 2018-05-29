package com.yipuhui.fastgo.utils;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public enum SignatureAlgorithm {

	//加密类型
	SHA1WithRSA("SHA1WithRSA"),

	MD5WithRSA("MD5WithRSA");
	
	private String signAlgorithm;

	private SignatureAlgorithm(String signAlgorithm) {
		this.signAlgorithm = signAlgorithm;
	}

	public String getSignAlgorithm() {
		return signAlgorithm;
	}
}
