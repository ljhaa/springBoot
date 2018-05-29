package com.yph.config;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import feign.Feign;
//import feign.jackson.JacksonDecoder;
//import feign.jackson.JacksonEncoder;
//
//
//@Configuration
//public class NonCloudFeignConfig {
//    private static final Logger log = LoggerFactory.getLogger(NonCloudFeignConfig.class);
//
//
//    @Bean
//    public ClientIdRemoteService clientIdRemoteService() {
//        log.info("初始化获取uuid服务的Feign接口");
//      return   Feign.builder()
//    		  .encoder(new MyEncoder())
//              .decoder(new MyDecoder())
//         .target(ClientIdRemoteService.class, "http://172.16.33.218:1112/");
//
//    }
//}