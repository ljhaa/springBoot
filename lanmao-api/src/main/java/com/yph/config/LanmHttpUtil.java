package com.yph.config;

import java.lang.reflect.InvocationTargetException;








import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.api.entity.RequstData;
import com.yipuhui.api.entity.RespData;
import com.yipuhui.api.utils.RSACoder;
import com.yipuhui.api.utils.SignUtil;

import feign.Feign;

/**
 * 
 * @author Admin
 *
 */
public class LanmHttpUtil {

	
	
    private static final Logger log = LoggerFactory.getLogger(LanmHttpUtil.class);
    
    
  private  static ClientIdRemoteService clientIdRemoteService;
  private   static ClientIdRemoteService getClientIdRemoteService()
    {
    	if(clientIdRemoteService==null)
    	{
    		 log.info("初始化获取uuid服务的Feign接口");
    		  clientIdRemoteService= Feign.builder()
    	    		  .encoder(new MyEncoder())
    	              .decoder(new MyDecoder())
    	         .target(ClientIdRemoteService.class,PropertyUtil.getUrl("LANMAO_URL"));
    	}
    
    		return clientIdRemoteService;
    }
	/**
	 * 
	 * Description: 懒猫划拨
	 * @param url string
	 * @param OpenAccountEntity openAccountEntity
	 * @return 
	 * @Author abh
	 * @Create Date: 2017年6月7日 下午6:06:49
	 */
	public static RespData lanmapHttp(Object obj,String serviceName,String saveData ) {
		try {
			String reqDate=JSONObject.toJSONString(obj);
			log.info("发出数据:"+reqDate);
			RequstData data=new RequstData();
			data.setSing(RSACoder.sign(reqDate.getBytes()));
			data.setReqData(reqDate);
			data.setServiceName(serviceName);
			data.setSaveData(saveData);
			String resDate=getClientIdRemoteService().toLanmao(SignUtil.encryp(JSONObject.toJSONString(data)));
			resDate=SignUtil.decrypt(resDate);
			log.info("接收数据:"+resDate);
			RespData  responsEntity = (RespData)JSONObject.parseObject(resDate, RespData.class);
			return responsEntity;
			//调用第三方接口

		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}


	/**
	 * Description:
	 *
	 * @author 刘俊汉
	 * @param obj
	 * @date 2018/5/24 17:53
	 * @return
	 */
	public static String lanmczHttp(Object obj) {
		try {
			String reqDate=JSONObject.toJSONString(obj);
			log.info("发出数据:"+reqDate);

			String resDate=getClientIdRemoteService().sendPrsv(SignUtil.encryp(reqDate));
			resDate=SignUtil.decrypt(resDate);
			log.info("接收数据:"+resDate);

			return resDate;
			//调用第三方接口

		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
