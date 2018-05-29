package com.yipuhui.fastgo.utils.yphutil;

import com.yph.toolcenter.util.StringUtil;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import java.security.MessageDigest;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class Md5Util {


	private static final String ENCRYMODE1 = "MD5";
	/**
	 *
	 * spring
	 * MD5加密私钥
	 */
	private static final String PRIVATE_KEY = "www.ephwealth.com888";

	/**
	 * 32位md5.
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return encrypt(ENCRYMODE1, str);
	}

	/**
	 * Description:得到加密后的字符
	 *
	 * @author 刘俊汉
	 * @param null
	 * @date 2018/5/14 15:47
	 * @return
	 */
	public static String encrypt(String algorithm, String str) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(str.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] bytes = md.digest();
			for (int i = 0; i < bytes.length; i++) {
				int b = bytes[i] & 0xFF;
				if (b < 0x10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 
	 * Description: MD5加密
	 * 
	 * @param str
	 * @return String
	 * @Author leichunlai
	 * @Create Date: 2013-3-1 上午10:28:01
	 */
	public static String encrypt(String str) {
		Md5PasswordEncoder md5pe = new Md5PasswordEncoder();
		if (StringUtil.isNotBlank(str)) {
			return md5pe.encodePassword(PRIVATE_KEY, str);
		}
		return null;
	}




}
