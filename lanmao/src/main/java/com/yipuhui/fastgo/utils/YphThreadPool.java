package com.yipuhui.fastgo.utils;/**
 * Created by liujunhan on 2018/5/11.
 */

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author 刘俊汉
 * @create 2018-05-11 17:30
 **/
public class YphThreadPool {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("thread-pool-%d").build();

    private static ExecutorService singleThreadPool = new ThreadPoolExecutor(10, 1000, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void runThread(Runnable runnable){

    singleThreadPool.execute(runnable);
    singleThreadPool.shutdown();

    }



}
