
package com.yph.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 
 * Description:读取本地配置文件
 * 
 * @author yubin
 * @version 1.0
 * 
 *          <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2012-2-13    Administrator       1.0        1.0 Version
 * </pre>
 */
public class PropertyUtil {

	/**
	 * UC、CAS、WEBSERVICE配置
	 */
	private static String path = "/property/config.properties";
	/**
	 *
	 */
	private static String pathMail = "/property/mail.properties";
	/**
	 * 提示信息代码
	 */
	private static String pathMessageCode = "/property/message_code.properties";
	/**
	 *
	 */
	private static String urlPath = "/property/url.properties";
	/**
	 * 一般参数使用
	 */
	private static Properties p = new Properties();
	/**
	 * 一般参数使用
	 */
	private static Properties mail = new Properties();
	/**
	 * 一般参数使用
	 */
	private static Properties messageCode = new Properties();
	/**
	 * 一般参数使用
	 */
	private static Properties url = new Properties();
	InputStream inLog = null;
	InputStream in = null;
	static {
		InputStream in = PropertyUtil.class.getResourceAsStream(path);
		InputStream inMail = PropertyUtil.class.getResourceAsStream(pathMail);
		InputStream inMessageCode = PropertyUtil.class.getResourceAsStream(pathMessageCode);
		InputStream inUrl = PropertyUtil.class.getResourceAsStream(urlPath);
		try {
			p.load(in);
			mail.load(inMail);
			messageCode.load(inMessageCode);
			url.load(inUrl);
		} catch (IOException e) {
			throw new ExceptionInInitializerError("不能正确读取资源文件");
		} finally{
			if (in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inMail != null){
				try {
					inMail.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inMessageCode != null){
				try {
					inMessageCode.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			if (inUrl != null){
				try {
					inUrl.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	/**
	 * 从properties文件中根据key取出value值
	 * 
	 * @param key 
	 * @return String
	 */
	public static String getInfo(String key) {
		return p.getProperty(key);
	}
	
	/**
	 * 从properties文件中根据key取出value值
	 * 
	 * @param key 
	 * @return String
	 */
	public static String getMailInfo(String key) {
		return mail.getProperty(key);
	}
	
	/**
	 * 从properties文件中根据key取出value值
	 * 
	 * @param key 
	 * @return String
	 */
	public static String getMessageCodeInfo(String key){
		return messageCode.getProperty(key);
	}
	/**
	 * 从properties文件中根据key取出value值
	 * 
	 * @param key 
	 * @return String
	 */
	public static String getUrl(String key){
		return url.getProperty(key);
	}
	
	public static void main(String[] args){
		System.out.println(PropertyUtil.getUrl("pay_url"));
	}
}
