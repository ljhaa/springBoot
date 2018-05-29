package com.yipuhui.fastgo.service;/**
 * Created by liujunhan on 2018/4/13.
 */

/**
 * 缓存用服务
 *
 * @author 刘俊汉
 * @create 2018-04-13 20:04
 **/
public interface RedisUtilService {


    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param key
     * @param value
     * @date 2018/5/14 14:29
     * @return void
     */
    public void setValue(String key,String value );

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param key
     * @date 2018/5/14 14:29
     * @return java.lang.String
     */
    public String getValue(String key);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param key
     * @date 2018/5/14 14:29
     * @return java.lang.Boolean
     */
    public Boolean chekHashkey(String key);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param key
     * @param timeout
     * @date 2018/5/14 14:29
     * @return void
     */
    public void expire(String key,int timeout);

    /**
     * Description:
     * 
     * @author 刘俊汉
     * @param key
     * @date 2018/5/14 14:38
     * @return void
     */
    public void delet(String key);
}
