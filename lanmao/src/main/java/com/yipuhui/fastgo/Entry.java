package com.yipuhui.fastgo;/**
 * Created by liujunhan on 2018/1/24.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

/**
 * 启动类
 *
 * @author 刘俊汉
 * @create 2018-01-24 13:06
 * //@EnableDiscoveryClient
 **/

@EnableScheduling()
@SpringBootApplication
public class Entry extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Entry.class);
    }

    /**
     * 查看用了什么数据库连接池
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);
    }



}
