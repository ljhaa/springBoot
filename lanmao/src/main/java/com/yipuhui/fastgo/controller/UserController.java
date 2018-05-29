package com.yipuhui.fastgo.controller;/**
 * Created by liujunhan on 2018/1/24.
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.api.entity.RequstData;
import com.yipuhui.api.utils.RSACoder;
import com.yipuhui.api.utils.SignUtil;

import com.yipuhui.fastgo.service.RedisUtilService;

import com.yipuhui.fastgo.utils.AppConfig;
import com.yipuhui.fastgo.utils.BeanGetFactory;
import com.yipuhui.fastgo.utils.ConnectingToLanmaoUtil;
import com.yipuhui.fastgo.utils.factory.AsyncMsgFailureManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.yipuhui.fastgo.controller.RequstToLanmaoController.beanToJson;

/**
 * 访问层
 *
 * @author 刘俊汉
 * @create 2018-01-24 12:57
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    RedisUtilService redisUtilService;

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/success")
    public String success( ) {


String test =  AppConfig.getConfig().getDataBypro("pay_company");

        return test;
    }

    @ResponseBody
    @RequestMapping(value = "/testredis")
    public String testredis(

    ) {
        redisUtilService.setValue("name","liujunhan");

        BeanGetFactory ba = BeanGetFactory.getInstance();

        AsyncMsgFailureManage asyncMsgFailureManage = ba.ceretBean("RECHARGE");
        asyncMsgFailureManage.asyncMsgFailureManage();
        return redisUtilService.chekHashkey("KEY_TEMP_BANK_9187").toString();
    }


    @RequestMapping(value = "/reflash")
    @ResponseBody
    public String reflash(){

        AppConfig.reFlash();

        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/quercade")
    public String quercade(@RequestParam("requestNo") String requestNo) {



        //============================查询用户
        Map<String, Object> reqData = new HashMap<String, Object>(16);
//        Map<String, Object> rspo = new HashMap<>();
        reqData.put("requestNo", requestNo);
        reqData.put("transactionType", "UPDATE_BANKCARD_AUDIT");
        String para =   ConnectingToLanmaoUtil.mapTojson(reqData);
        System.out.println(para);

        RequstData requstData = new RequstData();

        requstData.setReqData(para);
        try {
            requstData.setSing(RSACoder.sign(para.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        requstData.setServiceName("QUERY_TRANSACTION");
        requstData.setSaveData("asdfasdgafdhfdgd");
        System.out.println("requstData="+beanToJson(requstData));
        try {
            System.out.println("miss="+ SignUtil.encryp(beanToJson(requstData)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String aa = null;
        try {
            aa = new RequstToLanmaoController().toLanmao(SignUtil.encryp(beanToJson(requstData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("aa="+aa);
//        try {
////            aa = SignUtil.decrypt(aa);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("aa="+aa);
//        JSONObject jsonObject = JSON.parseObject(aa);
//        System.out.println("sing="+jsonObject.get("sing"));
//
//
//        System.out.println(jsonObject.get("respData").toString());
//        JSONObject jsonObject2=JSON.parseObject(jsonObject.get("respData").toString()) ;

        return aa;
    }




}
