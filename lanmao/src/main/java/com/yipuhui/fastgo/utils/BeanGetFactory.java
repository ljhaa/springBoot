package com.yipuhui.fastgo.utils;/**
 * Created by liujunhan on 2018/5/9.
 */

import com.yipuhui.fastgo.interf.ServiceName;
import com.yipuhui.fastgo.utils.factory.AsyncMsgFailureManage;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据注解获取相应的bean
 *
 * @author 刘俊汉
 * @create 2018-05-09 11:28
 **/
public class BeanGetFactory {
    /**
     *  这里是一个常量，表示我们扫描策略的包
     */

    private static final String BEAN_GET_PACKAGE = "com.yipuhui.fastgo.utils.factory";

    private ClassLoader classLoader = getClass().getClassLoader();


    private List<Class<? extends AsyncMsgFailureManage>> asyncMsgFailureManages;


    /**
     * 获取对应的实例
     *
     * @param []
     * @return com.yipuhui.fastgo.utils.factory.AsyncMsgFailureManage
     * @author 刘俊汉
     * @date 2018/5/9 12:02
     */
    public AsyncMsgFailureManage ceretBean(String serviceName) {

        for (Class<? extends AsyncMsgFailureManage> clazz : asyncMsgFailureManages) {
            //获取该策略的注解
            ServiceName serviceName1 = handleAnnotation(clazz);


            if (serviceName1.serviceName().equals(serviceName)) {

                return SpringUtil.getBean(clazz);


            }


        }

        return null;

    }


    /**
     * Description:处理注解，我们传入一个策略类，返回它的注解
     *
     * @author 刘俊汉
     * @param null
     * @date 2018/5/14 15:35
     * @return
     */
    private ServiceName handleAnnotation(Class<? extends AsyncMsgFailureManage> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof ServiceName) {

                System.out.println( annotations[i]);
                return (ServiceName) annotations[i];
            }
        }
        return null;
    }


    //工厂类单例模式

    private BeanGetFactory() {

        init();
    }


    private void init() {

        asyncMsgFailureManages = new ArrayList<>();
        //获取到包下所有的class文件
        File[] resources = getResources();

        Class<AsyncMsgFailureManage> asyncMsgFailureManageClass = null;
        try {
            //使用相同的加载器加载接口
            asyncMsgFailureManageClass = (Class<AsyncMsgFailureManage>) classLoader.loadClass(AsyncMsgFailureManage.class.getName());
        } catch (ClassNotFoundException e1) {
            throw new RuntimeException("未找到接口");
        }

        for (int i = 0; i < resources.length; i++) {
            try {
                //载入包下的类
                Class<?> clazz = classLoader.loadClass(BEAN_GET_PACKAGE + "." + resources[i].getName().replace(".class", ""));
                //判断是否是CalPrice的实现类并且不是CalPrice它本身，满足的话加入到策略列表
                if (AsyncMsgFailureManage.class.isAssignableFrom(clazz) && clazz != asyncMsgFailureManageClass) {
                    asyncMsgFailureManages.add((Class<? extends AsyncMsgFailureManage>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }


    private File[] getResources() {

      final   String classname = ".class";
        try {
            File file = new File(classLoader.getResource(BEAN_GET_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    //我们只扫描class文件
                    if (pathname.getName().endsWith(classname)) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到资源");
        }

    }


    private static BeanGetFactory beanGetFactory = null;

    public static BeanGetFactory getInstance() {

        if (beanGetFactory != null) {

            return beanGetFactory;
        }


        synchronized (BeanGetFactory.class) {
            if (beanGetFactory != null) {

                return beanGetFactory;
            } else {

                beanGetFactory = new BeanGetFactory();

                return beanGetFactory;


            }

        }

    }


}
