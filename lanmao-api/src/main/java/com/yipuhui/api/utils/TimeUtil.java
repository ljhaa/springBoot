package com.yipuhui.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Admin
 */
public class TimeUtil {

    public static SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * @param seconds
     * @return
     * @返回超时时间
     */
    public static String getExpired(int seconds) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, seconds);

        String famData = null;

        synchronized (fmt) {
            famData = fmt.format(c.getTime());
        }

        return famData;
    }

    public static void main(String[] args) {

        System.out.println(getExpired(60 * 10));

    }
}
