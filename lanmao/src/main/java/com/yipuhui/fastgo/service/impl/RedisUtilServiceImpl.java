package com.yipuhui.fastgo.service.impl;/**
 * Created by liujunhan on 2018/4/13.
 */

import com.yipuhui.fastgo.service.RedisUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 缓存用服务
 *
 * @author 刘俊汉
 * @create 2018-04-13 20:05
 **/
@Service
public class RedisUtilServiceImpl implements RedisUtilService {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 设置值
     *
     * @param [key, value]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/13 20:36
     */
    @Override
    public void setValue(String key, String value) {

        stringRedisTemplate.opsForValue().set(key, value);

    }


    /**
     * 获取值
     *
     * @param [key]
     * @return java.lang.String
     * @author 刘俊汉
     * @date 2018/4/13 20:37
     */
    @Override
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);

    }


    /**
     * 检查key是否存在
     *
     * @param [key]
     * @return java.lang.String
     * @author 刘俊汉
     * @date 2018/4/13 20:37
     */
    @Override
    public Boolean chekHashkey(String key){

       return stringRedisTemplate.hasKey(key);

    }

    /**
     *
     *   设置过期时间
     * @author 刘俊汉
     * @date 2018/4/13 20:51
     * @param [key]
     * @return void
     */
    @Override
    public void expire(String key, int timeout){


        stringRedisTemplate.expire(key,timeout , TimeUnit.MILLISECONDS);


    }

    @Override
    public void delet(String key) {
        stringRedisTemplate.delete(key);
    }


}
