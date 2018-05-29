package com.yipuhui.fastgo.timing;/**
 * Created by liujunhan on 2018/5/22.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.fastgo.controller.SendPrsvController;
import com.yipuhui.fastgo.dao.SaveProofLogMapper;
import com.yipuhui.fastgo.enty.SaveProofLog;
import com.yipuhui.fastgo.utils.AppConfig;
import cunzheng.sdk.SdkClient;
import cunzheng.sdk.utils.EncoderUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 定时上传存证日志
 *
 * @author 刘俊汉
 * @create 2018-05-22 12:04
 **/
@Component
public class SaveProofLogJob {

    private static AppConfig appConfig = AppConfig.getConfig();

//  private static  final   Logger LOGG= LoggerFactory.getLogger(SaveProofLogJob.class);

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private SaveProofLogMapper saveProofLogMapper;
    /**
     * Description:定时上传存证日志
     *
     * @author 刘俊汉
     * @param
     * @date 2018/5/22 12:06
     * @return
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void saveProofLog()  {

        //获取昨天的日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        //Integer.valueOf(appConfig.getDataBypro("checkDate"))
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
        String filePath = appConfig.getDataBypro("file_path")+FORMAT.format(calendar.getTime())+".txt";

        //将信息写入文件
        saveDataToTxt(filePath,calendar);


        //将信息发送到第三方
        sendTxtToLanmao(filePath,calendar);
    }


    /**
     * Description: 将信息写入文件
     *
     * @author 刘俊汉
     * @param filePath
     * @param calendar
     * @date 2018/5/22 13:13
     * @return void
     */
    private void saveDataToTxt(String filePath,Calendar calendar){


        //获取昨天所有的日志信息
        List<SaveProofLog> saveProofLogs = saveProofLogMapper.selectSaveProofLogByTime(calendar.getTime());

        //将信息写入文件


        File file = new File(filePath);

        //常见流对象

        FileOutputStream fileOutputStream = null  ;


        try {
            //文件不存在则创建文件
            if(!file.exists()){

                file.createNewFile();

            }

            //将信息写入文件中
            fileOutputStream = new FileOutputStream( file,true);

            for(SaveProofLog saveProofLog : saveProofLogs){
                if(null != saveProofLog && saveProofLog.getSaveProofJson() != null){

                    String str = saveProofLog.getSaveProofJson() + "\r\n";


                    fileOutputStream.write(str.getBytes());

                }


            }

            fileOutputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if(fileOutputStream != null ){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    /**
     * Description: 将文件发送到三方
     *
     * @author 刘俊汉
     * @param filePath
     * @param calendar
     * @date 2018/5/22 13:13
     * @return void
     */
    private void sendTxtToLanmao(String filePath,Calendar calendar){

        try{


            String host = appConfig.getDataBypro("api.host");
            String method = appConfig.getDataBypro("api.prsv.log");
            String privateKey = appConfig.getDataBypro("private.key");
            String sdkKey = appConfig.getDataBypro("sdk.key");
            String enterpriseId = appConfig.getDataBypro("enterprise.id");
            //商户共钥 用于密文加密
            String publicKey =appConfig.getDataBypro("prsv.ppublickey");
//            LOGG.info(host+"host "+method+"method "+privateKey+"privateKey "+sdkKey+"sdkKey "+enterpriseId+"enterpriseId ");

            /**初始化方法一：无需文档加密**/
            //SdkClient sdkClient = new SdkClient(privateKey,host,enterpriseId,sdkKey);

            /**初始化方法二：使用base64编码后的加密公钥进行文档加密**/

            // 使用base64后的加密公钥实例化
            SdkClient sdkClient = new SdkClient(privateKey, host, enterpriseId, sdkKey, publicKey);

            /**初始化方法三：使用cer公钥文件的二进制流加密公钥进行文档加密**/
            // String cerPath = "d://testPdf/pubkeyNew1c.cer";
            // byte[] cerByte = getFileByte(cerPath);
            // SdkClient cerSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,cerByte);// cerByte 是直接读取的cer公钥文件的二进制流

            /**初始化方法四：使用pfx证书进行文档加密**/
            // File pfxFile = new File("d://testPdf/new1C.pfx");
            // String pfxPassword = "jgt@123";
            // SdkClient pfxSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,pfxFile,pfxPassword);// pfxFile 是pfxFile文件File对象, pfxPassword 是pfx文件的密码

            try {
                JSONObject json = new JSONObject();

                //日志文件文件的字节流
                byte[] contFileByte = getFileByte(filePath);
                //交易流水号
                String requestNo = "logFor"+String.valueOf(System.currentTimeMillis());
                //合同文件的base64编码串
                String contFile = EncoderUtils.base64EncodeToString(contFileByte);


                //日志类型，0-日志文件类型，1-数据库类型，2-操作系统类型
                String logType =appConfig.getDataBypro("log_type");
                //日志文件类型，0-log,1-txt,2-zip
                String logFileType =appConfig.getDataBypro("log_file_type");
                //操作系统类型0-win,1-linux,2-unix
                String systemType=appConfig.getDataBypro("system_type");
                //数据库类型0-mysql,1-db2,2-oracle
                String dbType =appConfig.getDataBypro("db_type");
                //日志开始时间，格式如下：20170412092800
                String beginTime =FORMAT.format(calendar.getTime())+"000000";

                //日志结束时间，格式如下：20170412092800
                String endTime =FORMAT.format(calendar.getTime())+"235959";

                //服务器IP
                String systemIp =appConfig.getDataBypro("system_ip");

                //Jsonobject,包括sdk产生的hash组,日志的base64编码串。日志原文可以不传。
                String hashs = sdkClient.getHashObject(contFileByte);


                JSONObject head = new JSONObject();
                head.put("enterpriseId",enterpriseId);
                json.put("head", head);

                JSONObject jsonDetails = new JSONObject();

                jsonDetails.put("requestNo",requestNo);
                jsonDetails.put("logType",logType);
                jsonDetails.put("systemType",systemType);
                jsonDetails.put("logFileType",logFileType);
                jsonDetails.put("dbType",dbType);
                jsonDetails.put("beginTime",beginTime);
                jsonDetails.put("endTime",endTime);
                jsonDetails.put("systemIp",systemIp);

                JSONObject jsonHash = new JSONObject();
                jsonHash.put("hashs",JSONObject.parseObject(hashs));
                jsonHash.put("contFile",contFile);
                jsonDetails.put("logObj",jsonHash);

//
                json.put("details", jsonDetails);
//                LOGG.info(json.toJSONString());
                JSONObject response = sdkClient.post(method, json);
//                LOGG.info(response.toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }
    /**
     * 根据文件路径读取文件
     * @param path 文件路径
     * @return byte[]
     */
    private static byte[] getFileByte(String path) {
        System.out.println("path = "+path);
//        URL url = SaveProofLogJob.class.getClassLoader().getResource(path);
//        assert url != null;
        File file = new File(path);
        InputStream in;
        //文件流
        byte[] bytes = null;
        try {
            in = new FileInputStream(file);
            // 取得文件大小
            long length = file.length();
            // 根据大小创建字节数组
            bytes = new byte[(int) length];
            // 读取文件内容到字节数组**
            int offset = 0;
            int numRead;
            while (offset < bytes.length
                    && (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            // 读取完毕的校验
            if (offset < bytes.length) {
                System.out.println("不能完全读取的文件："+ file.getName());
            }
            in.close();
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("读取流异常");
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("读取流异常");
        }
        return bytes;
    }
//    public static void main(String[] args) {
//
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
//            System.out.println(host+" \r\n"+method+" \r\n"+privateKey+" \r\n"+sdkKey+" \r\n"+enterpriseId+" \r\n"+publicKey);
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
//                String filePath = appConfig.getDataBypro("file_path")+"test.txt";
////                //合同文件的字节流
//                byte[] contFileByte = getFileByte(filePath);
//                //交易流水号   可查
//                String requestNo = "542de212afesowqhfdg5232f6945AA";
//                //合同文件的base64编码串
//                String contFile = EncoderUtils.base64EncodeToString(contFileByte);
//
//
//                //日志类型，0-日志文件类型，1-数据库类型，2-操作系统类型
//                String logType ="2";
//                //日志文件类型，0-log,1-txt,2-zip
//                String logFileType ="1";
//                //操作系统类型0-win,1-linux,2-unix
//                String systemType="0";
//                //数据库类型0-mysql,1-db2,2-oracle
//                String dbType ="0";
//                //日志开始时间，格式如下：20170412092800
//                String beginTime ="20180522000000";
//
//                //日志结束时间，格式如下：20170412092800
//                String endTime ="20180522235959";
//
//                //服务器IP
//                String systemIp ="172.16.33.218";
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
//                jsonHash.put("hashs",JSONObject.parseObject(hashs));
//                jsonHash.put("contFile",contFile);
//                jsonDetails.put("logObj",jsonHash);
//
////
//                json.put("details", jsonDetails);
//                System.out.println(json.toJSONString());
//                JSONObject response = sdkClient.post(method, json);
//                System.out.println(response.toJSONString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }


    public static void main(String[] args) {

        try{


            String host = appConfig.getDataBypro("api.host");
            String method = appConfig.getDataBypro("api.prsv");
            String privateKey = appConfig.getDataBypro("private.key");
            String sdkKey = appConfig.getDataBypro("sdk.key");
            String enterpriseId = appConfig.getDataBypro("enterprise.id");
            //商户共钥 用于密文加密
            String publicKey =appConfig.getDataBypro("prsv.ppublickey");
            System.out.println(host+" \r\n"+method+" \r\n"+privateKey+" \r\n"+sdkKey+" \r\n"+enterpriseId+" \r\n"+publicKey);

            /**初始化方法一：无需文档加密**/
//            SdkClient sdkClient = new SdkClient(privateKey,host,enterpriseId,sdkKey);

            /**初始化方法二：使用base64编码后的加密公钥进行文档加密**/

            // 使用base64后的加密公钥实例化
            SdkClient sdkClient = new SdkClient(privateKey, host, enterpriseId, sdkKey, publicKey);

            /**初始化方法三：使用cer公钥文件的二进制流加密公钥进行文档加密**/
            // String cerPath = "d://testPdf/pubkeyNew1c.cer";
            // byte[] cerByte = getFileByte(cerPath);
            // SdkClient cerSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,cerByte);// cerByte 是直接读取的cer公钥文件的二进制流

            /**初始化方法四：使用pfx证书进行文档加密**/
            // File pfxFile = new File("d://testPdf/new1C.pfx");
            // String pfxPassword = "jgt@123";
            // SdkClient pfxSdkClient = new SdkClient(privateKey, sdkHost, enterpriseId, sdkKey,pfxFile,pfxPassword);// pfxFile 是pfxFile文件File对象, pfxPassword 是pfx文件的密码

            try {
                JSONObject json = new JSONObject();
//                //电子合同pdf文件地址(默认项目resources 下面进行测试)F:\test\prsv\target\classes\test.pdf
                String filePath = appConfig.getDataBypro("file_path")+"test.txt";
//                //合同文件的字节流
                byte[] contFileByte = getFileByte(filePath);
                //交易流水号
                String requestNo = "752de212afesnwqhpdg5252f6947";
                //合同文件的base64编码串
                String contFile = EncoderUtils.base64EncodeToString(contFileByte);

                // 渠道用户使用-p2p企业名称
                String enterpriseName="测试企业名称";

                //合同名称
                String contName = "李**的借款合同";
                //合同编号
                String contNo = "TF151418****494";
                //标的名称
                String projectName = "存管标的";
                //标的编号
                String projectNo = "12452312432346";
                //合同类型:0-普通合同（没有共同借款人信息） 1-共同借款人合同（有共同借款人信息）
                String contType = "1";
                String fileType = "pdf";//文档类型pdf,word
                //合同签约完成时间
                String contSignTime = "20180517181500";
                //借款人账号
                String borrowerAccount = "RT0001";
                //借款人姓名
                String borrowerName = "张**";
                //借款人身份证号
                String borrowerCode = "1302291996****5637";
                //投资人账号
                String investorAccount = "RT***2";
                //投资人名称
                String investorName = "李**";
                //投资人身份证号
                String investorCode = "1482291985****3752";

                //担保人信息
                //担保人平台账号
                String guaranteeAccount = "3234*****732";
                //担保人姓名/企业名称
                String guaranteeName = "北京********科技有限公司";
                //担保人身份证号
                //String guaranteeCode = "1302291996****5637";

                //contType 为1 才有这个信息,否则没有这个参数信息
                JSONArray coBorrowerArray = new JSONArray();
                JSONObject jsonCoBorrower1 = new JSONObject();
                //共同借款人姓名
                jsonCoBorrower1.put("coBorrowerName","张三");
                //共同借款人身份证号码
                jsonCoBorrower1.put("coBorrowerNo","410219953546516");
                //共同借款人手机号
                jsonCoBorrower1.put("coBorrowerPhone","138565245254");
                JSONObject jsonCoBorrower2 = new JSONObject();
                jsonCoBorrower2.put("coBorrowerName","李四");
                jsonCoBorrower2.put("coBorrowerNo","410219953546516");
                jsonCoBorrower2.put("coBorrowerPhone","138565245254");
                JSONObject jsonCoBorrower3 = new JSONObject();
                jsonCoBorrower3.put("coBorrowerName","王五");
                jsonCoBorrower3.put("coBorrowerNo","410219953546516");
                jsonCoBorrower3.put("coBorrowerPhone","138565245254");
                coBorrowerArray.add(jsonCoBorrower1);
                coBorrowerArray.add(jsonCoBorrower2);
                coBorrowerArray.add(jsonCoBorrower3);

                JSONObject head = new JSONObject();
                head.put("enterpriseId",enterpriseId);
                json.put("head", head);

                JSONObject jsonDetails = new JSONObject();
                jsonDetails.put("requestNo",requestNo);
                jsonDetails.put("contFile",contFile);

                JSONObject jsonConInfo = new JSONObject();
                jsonPut(jsonConInfo,"contName",contName);
                jsonPut(jsonConInfo,"contNo",contNo);
                jsonPut(jsonConInfo,"projectNo",projectNo);
                jsonPut(jsonConInfo,"projectName",projectName);
                jsonPut(jsonConInfo,"contType",contType);
                jsonPut(jsonConInfo,"fileType",fileType);
                jsonPut(jsonConInfo,"contSignTime",contSignTime);
                jsonPut(jsonConInfo,"borrowerAccount",borrowerAccount);
                jsonPut(jsonConInfo,"borrowerName",borrowerName);
                jsonPut(jsonConInfo,"borrowerCode",borrowerCode);
                jsonPut(jsonConInfo,"investorAccount",investorAccount);
                jsonPut(jsonConInfo,"investorName",investorName);
                jsonPut(jsonConInfo,"investorCode",investorCode);
                jsonPut(jsonConInfo,"guaranteeAccount",guaranteeAccount);
                jsonPut(jsonConInfo,"guaranteeName",guaranteeName);
                jsonPut(jsonConInfo,"coBorrower",coBorrowerArray);
                // 渠道用户使用
                jsonPut(jsonConInfo,"enterpriseName",enterpriseName);

                //获取文件的hash组
                String hashs = sdkClient.getHashObject(contFileByte);
                jsonDetails.put("hashs", JSON.parseObject(hashs));
                jsonDetails.put("conInfo",jsonConInfo);
                json.put("details",jsonDetails);
                System.out.println(json);
                JSONObject response = sdkClient.post(method, json);
                System.err.println(response.toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }

    /**
     * 对json进行封装 测试用
     * @param json JsonObject对象
     * @param name 键
     * @param value 值
     */
    private static void jsonPut(JSONObject json, String name, Object value){
        if (value!=null){
            if (value instanceof String){
                if (StringUtils.isNotBlank((String)value)){
                    json.put(name,value);
                }
            }else{
                json.put(name,value);
            }
        }
    }

}
