package com.yph.config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

import com.alibaba.fastjson.JSONObject;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/15 10:54
 */
public class MyDecoder implements Decoder {

	@Override
	public Object decode(Response response, Type type) throws IOException,
			DecodeException, FeignException {
	
		String result=inputStream2String(response.body().asReader());
		if(type.equals(String.class))
		{
			return result;
		}else{
		return JSONObject.parseObject(result, type);
		}
	}
	
	
	public   static   String   inputStream2String(Reader   is)   throws   IOException{ 
        ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream(); 
        int   i=-1; 
        while((i=is.read())!=-1){ 
        baos.write(i); 
        } 
       return   new String(baos.toString().getBytes(System.getProperty("file.encoding"))); 
}
  public static void main(String[] args) {
	   System.out.println("系统默认编码：    "+System.getProperty("file.encoding"));
	  
}
}
