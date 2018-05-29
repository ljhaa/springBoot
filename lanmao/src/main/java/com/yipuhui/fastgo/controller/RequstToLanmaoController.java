package com.yipuhui.fastgo.controller;/**
 * Created by liujunhan on 2018/4/10.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.api.entity.RequstData;
import com.yipuhui.api.entity.RequstDataSuper;
import com.yipuhui.api.entity.RespData;
import com.yipuhui.api.enums.ConnectoGatewayNameEnum;
import com.yipuhui.api.enums.ConnectorDirectNameEnum;
import com.yipuhui.api.utils.RSACoder;
import com.yipuhui.api.utils.SignUtil;
import com.yipuhui.fastgo.common.MagicParameterConstants;
import com.yipuhui.fastgo.enty.LanmaoServiceLogWithBlobs;
import com.yipuhui.fastgo.service.SaveProofLogService;
import com.yipuhui.fastgo.service.ToLanmaoService;
import com.yipuhui.fastgo.utils.ConnectingToLanmaoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 三方连接类
 *
 * @author 刘俊汉
 * @create 2018-04-10 9:47
 **/
@Controller
@RequestMapping(value = "/requst")
public class RequstToLanmaoController {

    private final static Logger logger = LoggerFactory
            .getLogger(RequstToLanmaoController.class);

    @Autowired
    private ToLanmaoService toLanmaoService;


    @Autowired
    private SaveProofLogService saveProofLogService;

    @RequestMapping(value = "/send")
    @ResponseBody
    private String sendPrsv( String params
                          ){

        logger.info("paramsSDK="+params);
        String relut="INIT" ;

        JSONObject jsonObject = null ;
        try{
            params=SignUtil.decrypt(params);
            logger.info("params="+params);
            jsonObject = JSONObject.parseObject(params);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(jsonObject != null ){

            String filePath=  jsonObject.getString("filePath");
         String bidInvestNum=   jsonObject.getString("bidInvestNum");
            logger.info(">>>>>>>存证合同上传>>>>>>>>>>[bidInvestNum={}],[filePath={}]",bidInvestNum,filePath);
            saveProofLogService.saveProof(filePath,bidInvestNum);
            logger.info("<<<<<<<存证合同上传完毕<<<<<<<<<<<<");

            relut = "SUCCESS";
        }




        return relut;
    }


    @RequestMapping(value = "/toLanmao")
    @ResponseBody
    public String toLanmao(String params){


        String relut=null ;


        try{
            params=SignUtil.decrypt(params);
           logger.info("params="+params);

        }catch (Exception e){
            e.printStackTrace();
        }


        try{
            //本地保存日志参数提出
            paramProcessing(ConnectingToLanmaoUtil.jsonToBean(params));
        }catch (Exception e){
            e.printStackTrace();
        }





        RequstDataSuper requstData = ConnectingToLanmaoUtil.jsonToBean(params);
        RequstData requstData1 = ConnectingToLanmaoUtil.jsonToBean(params);


        logger.info("============请求参数为[requsdata={}][requstDataSupper={}]",requstData,requstData1);
        RespData respData = new RespData();
        try{

            logger.info("============验签 [结果={}]",RSACoder.verify(requstData.getReqData().getBytes(),requstData.getSing()));
            //验签
            if(RSACoder.verify(requstData.getReqData().getBytes(),requstData.getSing())){
//            if(true){


                Map<String,Object> mapResult = ConnectingToLanmaoUtil.connectingToLanmao(ConnectingToLanmaoUtil.jsonToMap(requstData.getReqData()),requstData.getServiceName());


                //操作是否成功
                if(mapResult != null && MagicParameterConstants.NEGATIVE.equals(String.valueOf(mapResult.get(MagicParameterConstants.YPHCODE)))){

                    respData.setYphMessage(String.valueOf(mapResult.get("yphMessage")));
                    respData.setYphCode(String.valueOf(mapResult.get("yphCode")));


                }else if(mapResult != null && MagicParameterConstants.ZERO.equals(String.valueOf(mapResult.get(MagicParameterConstants.YPHCODE)))){

                    //成功
                    respData.setYphCode(String.valueOf(mapResult.get("yphCode")));
                    respData.setRespData(String.valueOf(mapResult.get("reqData")));
                    respData.setSing(RSACoder.sign(respData.getRespData().getBytes()));

                    if(mapResult.get(MagicParameterConstants.URL) != null ){

                        respData.setUrl(String.valueOf(mapResult.get("url")));
                    }

                }

            }else{


                respData.setYphCode("-1");
                respData.setYphMessage("验签失败");

            }




        }catch (Exception e){

            e.printStackTrace();
            respData.setYphCode("-1");
            respData.setYphMessage("系统异常");

        }

        try{

            saveRespData(respData,requstData.getServiceName(),  requstData1);


        }catch (Exception e){
            e.printStackTrace();
        }




        try {
            relut=  SignUtil.encryp(ConnectingToLanmaoUtil.beanToJson(respData));
        }catch (Exception e){
            e.printStackTrace();
        }




            return relut;

    }


    /**
     *    参数整理加工保存
     *
     * @author 刘俊汉
     * @date 2018/4/13 13:10
     * @param [requstData]
     * @return java.lang.String
     */
    public void  paramProcessing(RequstData requstData){

        String jsonStr = requstData.getSaveData();
        String jsonTo = requstData.getReqData();




            if(null != jsonTo  ){

                //获取流水号
                String sul = JSON.parseObject(jsonTo).getString("requestNo");
                //获取接口名称
                String serviceName = requstData.getServiceName();


                LanmaoServiceLogWithBlobs lanmaoServiceLog = new LanmaoServiceLogWithBlobs();
                lanmaoServiceLog.setReqData(jsonTo);
                lanmaoServiceLog.setRequestNo(sul);
                lanmaoServiceLog.setSaveData(jsonStr);
                lanmaoServiceLog.setReqOrRes(1);
                lanmaoServiceLog.setServiceName(serviceName);
                lanmaoServiceLog.setServiceNameZh("发送_"+(ConnectorDirectNameEnum.getName(serviceName) == null?ConnectoGatewayNameEnum.getName(serviceName):ConnectorDirectNameEnum.getName(serviceName)));
                lanmaoServiceLog.setTime(new Date());

                toLanmaoService.localRequestDataSave(lanmaoServiceLog);
            }




    }






        /**
         *
         *   保存相应参数
         * @author 刘俊汉
         * @date 2018/4/13 17:12
         * @param []
         * @return void
         */
        private void saveRespData(RespData respData,String serviceName, RequstData requstData1){
            String respStr = respData.getRespData();
            String reqData = requstData1.getReqData();
            String sul = JSON.parseObject(reqData).getString("requestNo");
            LanmaoServiceLogWithBlobs lanmaoServiceLog = new LanmaoServiceLogWithBlobs();

            lanmaoServiceLog.setRequestNo(sul);
            lanmaoServiceLog.setTime(new Date());
            lanmaoServiceLog.setServiceName(serviceName);
            lanmaoServiceLog.setServiceNameZh("请求三方_"+(ConnectorDirectNameEnum.getName(serviceName) == null?ConnectoGatewayNameEnum.getName(serviceName):ConnectorDirectNameEnum.getName(serviceName)));
            lanmaoServiceLog.setReqOrRes(ConnectorDirectNameEnum.getName(serviceName) == null?ConnectoGatewayNameEnum.getCode(serviceName):ConnectorDirectNameEnum.getCode(serviceName));
            lanmaoServiceLog.setReqData(ConnectingToLanmaoUtil.beanToJson(respData));
            toLanmaoService.localRequestDataSave(lanmaoServiceLog);

        }








    private static final DateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static void main(String[] args) throws  Exception{



        //============================查询用户
        Map<String, Object> reqData = new HashMap<String, Object>(16);
//        Map<String, Object> rspo = new HashMap<>();
        reqData.put("requestNo ", "open1525687129994");
        reqData.put("transactionType", "UPDATE_BANKCARD_AUDIT");
      String para =   ConnectingToLanmaoUtil.mapTojson(reqData);
       logger.info(para);

        RequstData requstData = new RequstData();

        requstData.setReqData(para);
        requstData.setSing(RSACoder.sign(para.getBytes()));
        requstData.setServiceName("UPDATE_BANKCARD_AUDIT");
        requstData.setSaveData("asdfasdgafdhfdgd");
       logger.info("requstData="+beanToJson(requstData));
       logger.info("miss="+SignUtil.encryp(beanToJson(requstData)));

        String aa = new RequstToLanmaoController().toLanmao(SignUtil.encryp(beanToJson(requstData)));
       logger.info("aa="+aa);
        aa = SignUtil.decrypt(aa);
        logger.info("aa="+aa);
        JSONObject jsonObject = JSON.parseObject(aa);
       logger.info("sing="+jsonObject.get("sing"));


       logger.info(jsonObject.get("respData").toString());
        JSONObject jsonObject2=JSON.parseObject(jsonObject.get("respData").toString()) ;
//       logger.info(jsonObject2.get("reqData").toString());


//       logger.info(SignUtil.decrypt("ZyYE01u22dHxjGuJ9KpNIeAqNi/H8jIB9iI55UCZB9rRj/5mxXHI+ZuywRno2PeHnyIf+g/Dl4PLcO6O1nQwKtvZGj3pqOmNMwtwKmLuPZeS3oFoA6PZ2EzkOt5Isltr4rhnkYPkePmyMCLSEd7SYJLzhui6E/tQHk4/bagKHMWCvoem+DtD66QaGa7HYBuMyFRvZBMSvejg5uk5jrCoNJvbFc5DJTypOhJPCxW30EyHae56LJyMbEdT82/VudspkvOG6LoT+1A5VyZr/ACtHqZJFA1wFwdR+DwLz73ED1gGz0RkGjIlwLNJlSDDQyyx/CouLve5a33314cEAR45EuRGGYIimyLrLozxnr4wdhq5Ho4hR5BjwR86EU1cuBhI6XB+0njxlbRWyF4z3keSA5uywRno2PeHgpNE80aWTDz/wqJgd58zIEr4rK6jCOAO/8a5SfhNAhR+R6hQBcYIgoulC5XIYxFsZh4j1LsodVpcjXqKCOkZxwHZn8928zBOOOS54PVTAdumy3jUznXqWZM9/xxqMMOTlGQL8YO1rHO2ODaBW4A1JfwqLi73uWt9i+WL/uMG3NyxdLRl3023cTdrMMRDmPjKJdg0R11KNu/k+9qRbc4eP5oFV26k9ubNGaq9cpRG/L2HRj+keENljtuekfi3+IpHBg11cNrsln0c1fJll6LMewN7Kcl+gRKIH42meO+Tl/X0rVfSDiEYXJRkC/GDtaxz8ydXOjJg7nJbq0YNoHkw9n1ZSoV6enXVulJC5kXtZZRK+KyuowjgDmoBVQOIbJle/CouLve5a32kK0WwUGkbzqgrfMeFwTzt4pY9qP5OdNvbhEqo25S9951e3hR+QylXuxXOwLkCLjyvjLfTuNnRvnp8gRY+hYgz4UloJFxd63toks2KeWGiJ6TkydmJCBYe9VszNZPnLqQeKt0qJyEjajRqaoZ2hbV/tbHNtuDyAVetgzGxbXxikLRyTWlu9woWoXCDNhVbyqmOErSdQOZoynxBUALkMKSC2l5m3mpreCVo8XZjt37uiU0Ihs3D5z+finKCIXklBMY/202tWjd16M5AyCVrgFPp2GQGOSRwbtifV5jlkMmAK0iiTU9C81BMeseDKgUJJKhhgZ/bLpemRaqef0ArN7AIBmxxvhoa9C3IdlWWjBPvDx1GrM7aTtIO6rxl4WgBNENGgIs8C5raEroMo6qUcQzOy0RNxw+zHWmu4aD40nEvPhvLgZSUVw5ZOZ8oyFFZWUk6mTzpBPgazknLXPS2RsTIQIUPVdG0oe8/+LhIvysGZUrYanG6WG1+rcXZlW8B3R+FoAL7D3wKhCzjsfPyn4ge7JJcxMYfxUfqFC+nf6igWdjWLjWmZUsjTDFeVn1NwlXWkIYTSNmk5aIGNpV2oMVR0+YT6sxyGRxeNw/vzQiUl449bEHWn/O7FaCwOGuw4b5CJbKdrzopbhiYhrdGIQMj5v4YHiyQfNoZKWMax6Og1TXqpk3QvuzMc/p6ck7srt3JFM+0aN2SNU8kWjhsrYudIBdyakxcgKFNOSiXyyC1RlOXm55ibKr/I8j6gI4tV/DoVnjH/yXjufgbUa0uxBBbSrpDkzq2wl3cLwxiaD8cAlPWsA6CkrQJXegwu6c3SkcVyQz8kNcViQtV7guUvKTdAwoV/zAoPCRylmUZS3rmMX7xeAlGmT12oSc9gXs04AyYNKC9tD6i6DrHlg3hubRVdxsNWT60187ub0WS9vIxOlXpJDIsOa0RMJn4u4PlnCXhSOVDkDFX8JJzWZQJbRm2"));

    }



    /**
     *
     *   将javabean转换成json字符串
     * @author 刘俊汉
     * @date 2018/4/10 12:01
     * @param "[respData]"
     * @return java.lang.String
     */
    public static String beanToJson( RequstData requstData) {

        JSONObject jsonObject=  (JSONObject)JSON.toJSON(requstData);
        return  jsonObject.toString();
    }


}
