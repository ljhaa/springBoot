package com.yipuhui.fastgo.utils.yphutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 *
 * Description: FastJson 工具类 
 *
 * @author lijie
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-6-3      lijie       1.0         1.0 Version 
 * </pre>
 */

public class FastJsonUtil {

	/**
	 * 
	 * Description: 将JSON字符串转成指定的类型
	 *
	 * @param json
	 * @param type
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年7月14日 下午6:20:46
	 */
	public static <T> T toAnyType(String json, TypeReference<T> type) {
		return JSON.parseObject(json, type);
	}
	
	/**
	 * 
	 * Description: 将java类型转成JSON字符串
	 *
	 * @param object
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年7月14日 下午6:21:03
	 */
	public static <T> String toJSONString(T object) {
		return JSON.toJSONString(object);
	}
	
	/**
	 * 
	 * Description: 将java类型转成JSON字符串(格式化日期)
	 *
	 * @param object 
	 * @param dateFormat yyyy-MM-dd HH:mm:ss.SSS
	 * @return
	 * @Author lijie
	 * @Create Date: 2015年7月14日 下午6:19:21
	 */
	public static <T> String toJSONString(T object, String dateFormat) {
		return JSON.toJSONStringWithDateFormat(object, dateFormat, SerializerFeature.WriteDateUseDateFormat);
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>(16);
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>(16);
		Map<String, Object> map2 = new HashMap<>(16);
		Map<String, Object> map3 = new HashMap<>(16);
		
		map1.put("name", "姚笛");
		map1.put("mobile", "123456789");

		map2.put("name", "砸死");
		map2.put("mobile", "1234567898989");
		
		map3.put("list", list);
		map3.put("address","dafei");
		
		list.add(map1);
		list.add(map2);
		
		map.put("returnCode", "001");
		map.put("returnMsg", "成功");
		map.put("returnData", map3);
		
		System.out.println(FastJsonUtil.toJSONString(map));
		
		
	}

}
