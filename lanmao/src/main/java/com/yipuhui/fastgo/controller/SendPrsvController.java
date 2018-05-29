package com.yipuhui.fastgo.controller;/**
 * Created by liujunhan on 2018/5/21.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.fastgo.service.SaveProofLogService;
import com.yipuhui.fastgo.service.impl.SaveProofLogServiceImpl;
import com.yipuhui.fastgo.utils.AppConfig;
import cunzheng.sdk.SdkClient;
import cunzheng.sdk.utils.EncoderUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * 电子存证接口
 *
 * @author 刘俊汉
 * @create 2018-05-21 11:02
 **/

@Controller
@RequestMapping("/sendPrsv")
public class SendPrsvController {

    private static  final Logger LOGG= LoggerFactory.getLogger(SendPrsvController.class);


        @Autowired
        private SaveProofLogService saveProofLogService;

    @RequestMapping("/send")
    @ResponseBody
    private void sendPrsv(@RequestParam("filePath") String filePath,
                          @RequestParam("bidInvestNum") String bidInvestNum){
        LOGG.info(">>>>>>>存证合同上传>>>>>>>>>>[bidInvestNum={}],[filePath={}]",bidInvestNum,filePath);
        saveProofLogService.saveProof(filePath,bidInvestNum);
        LOGG.info("<<<<<<<存证合同上传完毕<<<<<<<<<<<<");

    }



    @RequestMapping("/saveLog")
    @ResponseBody
    private void sendPrsvLog(@RequestParam("saveProofType") String saveProofType,
                             @RequestParam("lenderNum") String lenderNum,
                             @RequestParam("saveProofJson") String saveProofJson
                             ){
//        try{
//
//
//            String host = appConfig.getDataBypro("api.host");
//            String method = appConfig.getDataBypro("api.prsv.log");
//            String privateKey = appConfig.getDataBypro("private.key");
//            String sdkKey = appConfig.getDataBypro("sdk.key");
//            String enterpriseId = appConfig.getDataBypro("enterprise.id");
//            //商户共钥 用于密文加密
//            String publicKey =appConfig.getDataBypro("prsv.ppublickey");
//            LOGG.info(host+"host "+method+"method "+privateKey+"privateKey "+sdkKey+"sdkKey "+enterpriseId+"enterpriseId ");
//
//            /**初始化方法一：无需文档加密**/
//            //SdkClient sdkClient = new SdkClient(privateKey,host,enterpriseId,sdkKey);
//
//            /**初始化方法二：使用base64编码后的加密公钥进行文档加密**/
//
//            // 使用base64后的加密公钥实例化
//            SdkClient sdkClient = new SdkClient(privateKey, host, enterpriseId, sdkKey, publicKey);
//
//            /**初始化方法三：使用cer公钥文件的二进制流加密公钥进行文档加密**/
//            // String cerPath = "d://testPdf/pubkeyNew1c.cer";
//            // byte[] cerByte = getFileByte(cerPath);
//            // SdkClient cerSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,cerByte);// cerByte 是直接读取的cer公钥文件的二进制流
//
//            /**初始化方法四：使用pfx证书进行文档加密**/
//            // File pfxFile = new File("d://testPdf/new1C.pfx");
//            // String pfxPassword = "jgt@123";
//            // SdkClient pfxSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,pfxFile,pfxPassword);// pfxFile 是pfxFile文件File对象, pfxPassword 是pfx文件的密码
//
//            try {
//                JSONObject json = new JSONObject();
////                //电子合同pdf文件地址(默认项目resources 下面进行测试)F:\test\prsv\target\classes\test.pdf
//                String filePath = "test.log";
////                //合同文件的字节流
//                byte[] contFileByte = getFileByte(filePath);
//                //交易流水号   可查
//                String requestNo = "542de212afesowqhfdg5232f6945";
//                //合同文件的base64编码串
//                String contFile = EncoderUtils.base64EncodeToString(contFileByte);
//
//
//                //日志类型，0-日志文件类型，1-数据库类型，2-操作系统类型
//                String logType ="2";
//                //日志文件类型，0-log,1-txt,2-zip
//                String logFileType ="";
//                //操作系统类型0-win,1-linux,2-unix
//                String systemType="";
//                //数据库类型0-mysql,1-db2,2-oracle
//                String dbType ="";
//                //日志开始时间，格式如下：20170412092800
//                String beginTime ="";
//
//                //日志结束时间，格式如下：20170412092800
//                String endTime ="";
//
//                //服务器IP
//                String systemIp ="";
//
//                //Jsonobject,包括sdk产生的hash组,日志的base64编码串。日志原文可以不传。
//                String hashs = sdkClient.getHashObject(contFileByte);
//
//
//                JSONObject head = new JSONObject();
//                head.put("enterpriseId",enterpriseId);
//                json.put("head", head);
//
//                JSONObject jsonDetails = new JSONObject();
//
//                jsonDetails.put("requestNo",requestNo);
//                jsonDetails.put("logType",logType);
//                jsonDetails.put("systemType",systemType);
//                jsonDetails.put("logFileType",logFileType);
//                jsonDetails.put("dbType",dbType);
//                jsonDetails.put("beginTime",beginTime);
//                jsonDetails.put("endTime",endTime);
//                jsonDetails.put("systemIp",systemIp);
//
//                JSONObject jsonHash = new JSONObject();
//                jsonHash.put("hashs",hashs);
//                jsonHash.put("contFile",contFile);
//                jsonDetails.put("logObj",jsonHash);
//
////
//                json.put("details", jsonDetails);
//                LOGG.info(json.toJSONString());
//                JSONObject response = sdkClient.post(method, json);
//                LOGG.info(response.toJSONString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//===================保存日志信息

        LOGG.info(">>>>>>>存证日志保存==[lenderNum={}],saveProofType={}],saveProofJson={}]",lenderNum,saveProofType,saveProofJson);
        saveProofLogService.savaProofLog(lenderNum,saveProofType,saveProofJson);
        LOGG.info("<<<<<<<存证日志保存完毕<<<<<<<<");
    }


}
