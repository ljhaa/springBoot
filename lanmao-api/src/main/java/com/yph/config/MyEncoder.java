package com.yph.config;

import java.lang.reflect.Type;

import com.alibaba.fastjson.JSONObject;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/15 10:54
 */
public class MyEncoder implements Encoder {

	@Override
	public void encode(Object arg0, Type type, RequestTemplate arg2)
			throws EncodeException {
		if(!type.equals(String.class))
		{
		arg2.body(JSONObject.toJSONString(arg0));
		}
	}

}
