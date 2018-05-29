package com.yipuhui.api.utils;

/**
 * Description:
 * 
 * @author 刘俊汉
 * @date 2018/5/15 10:55
 */
public enum SignatureAlgorithm {

	/**
	 *
	 */
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
