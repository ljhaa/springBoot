package com.yipuhui.fastgo.utils;/**
 * Created by liujunhan on 2018/5/9.
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取spring bean
 *
 * @author 刘俊汉
 * @create 2018-05-09 10:32
 **/
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }

    }

    /**
     * Description:获取applicationContext
     *
     * @author 刘俊汉
     * @param null
     * @date 2018/5/14 16:01
     * @return
     */
    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Description:通过name获取 Bean.
     *
     * @author 刘俊汉
     * @param null
     * @date 2018/5/14 16:01
     * @return
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * Description:通过class获取Bean.
     *
     * @author 刘俊汉
     * @param null
     * @date 2018/5/14 16:01
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * Description:通过name,以及Clazz返回指定的Bean
     *
     * @author 刘俊汉
     * @param null
     * @date 2018/5/14 16:02
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }


    public static void main(String[] args) {
        String heng="_";

        System.out.println(heng.charAt(0));
    }

}
