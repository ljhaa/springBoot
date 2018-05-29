package com.yph.config;


import feign.Param;
import feign.RequestLine;

//@RequestLine("POST /account/{id}")
/**
 * Description:
 * 
 * @author 刘俊汉
 * @date 2018/5/15 10:52
 */
public interface ClientIdRemoteService {

	



	   /**
	    * Description:
	    *
	    * @author
	    * @param params
	    * @date 2018/5/15 10:52
	    * @return java.lang.String
	    */
	   @RequestLine("GET /toLanmao?params={params}")
		public  String toLanmao(@Param("params") String params);

	/**
	 * Description:
	 *
	 * @author
	 * @param params
	 * @date 2018/5/15 10:52
	 * @return java.lang.String
	 */
	@RequestLine("GET /send?params={params}")
	public  String sendPrsv(@Param("params") String params);
	}
