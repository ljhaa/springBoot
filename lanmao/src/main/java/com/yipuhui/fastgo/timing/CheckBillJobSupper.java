package com.yipuhui.fastgo.timing;/**
 * Created by liujunhan on 2018/4/19.
 */



import com.yipuhui.api.entity.CheckRechargeEntity;
import com.yipuhui.fastgo.utils.AppConfig;
import net.lingala.zip4j.core.ZipFile;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 定时支持类
 *
 * @author 刘俊汉
 * @create 2018-04-19 12:51
 **/
public class CheckBillJobSupper {

    private static AppConfig config = AppConfig.getConfig();

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckBillJob.class);

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");

    /**
     * 请求文件三方访问接口下载文件
     *
     * @param [map, url]
     * @return java.lang.String
     * @author 刘俊汉
     * @date 2018/4/18 16:22
     */
    protected String httpPost(Map<String, String> map, String url) throws Exception {
        Map<String, String> personMap = map;
        String uri = null;
        List<NameValuePair> list = new LinkedList<NameValuePair>();
        for (Map.Entry<String, String> entry : personMap.entrySet()) {
            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        HttpPost httpPost = new HttpPost(url);
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list, "utf-8");
        httpPost.setEntity(formEntity);
        CloseableHttpClient httpCient = HttpClients.createDefault();
        HttpResponse httpresponse = null;
        try {
            httpresponse = httpCient.execute(httpPost);

            HttpEntity httpEntity = httpresponse.getEntity();
            InputStream inputStream = httpEntity.getContent();

            BufferedInputStream bis = new BufferedInputStream(inputStream);

            //获取昨天的日期
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());

            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - Integer.valueOf(config.getDataBypro("checkDate")));
            uri = config.getDataBypro("localFileUri") + FORMAT.format(calendar.getTime()) + ".zip";
            File file = new File(uri);
            FileOutputStream fileOutputStream = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(uri);

                BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
                byte[] buf = new byte[4096];
                int length = bis.read(buf);
                //保存文件
                while (length != -1) {
                    bos.write(buf, 0, length);
                    length = bis.read(buf);
                }
                bos.close();
                bis.close();
                httpCient.close();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                try {
                    inputStream.close();
                    fileOutputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }


        } catch (ClientProtocolException e) {
            System.out.println("http请求失败，uri{},exception{}");
        }
        return uri;
    }

    /**
     * @param []
     * @return void
     * @author 刘俊汉
     * @date 2018/4/19 9:56
     */
    protected void unZipUtil(String uri) {

        File zipFile = null;
        ZipFile zipFile1 = null;
        File destDir = null;
        try {

            zipFile = new File(uri);
            if (zipFile.exists()) {

                zipFile1 = new ZipFile(zipFile);

                destDir = new File(uri.substring(0, uri.lastIndexOf(".")));
                if (destDir.exists() && destDir.isDirectory()) {

                    destDir.mkdir();
                }

                // 将文件抽出到解压目录(解压)
                zipFile1.extractAll(uri.substring(0, uri.lastIndexOf(".")));


            }


        } catch (Exception e) {

            e.printStackTrace();

        }


    }


//    /**
//     *
//     *   将文件读入系统并转换为list格式
//     * @author 刘俊汉
//     * @date 2018/4/19 11:36
//     * @param [uri]
//     * @return java.util.Map<java.lang.String,java.lang.Object>
//     */
//    protected Map<String,Object> lodDataToSys(String uri){
//        Map<String,Object> map = new HashMap<>(3);
//
//
//        //读取充值对账文件
//        lodFileUtil(map,uri, ConnectoGatewayNameEnum.RECHARGE.getIndex(),16);
////        System.out.println(map);
//
//        //读取提现对账文件
//        lodFileUtil(map,uri, ConnectoGatewayNameEnum.WITHDRAW.getIndex(),18);
//
//
//        //读取转账对账文件
//        lodFileUtil(map,uri,"TRANSACTION",17);
//
//
//
//
//        return map;
//    }
//

    protected void lodFileUtil(Class calzz, Map<String, Object> map, String uri, String serivecName, int length, int positioning) {


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - Integer.valueOf(config.getDataBypro("checkDate")));
        BufferedReader br = null;
        //读取充值对账文件

        File file = new File(uri.substring(0, uri.lastIndexOf(".")) + "/" + FORMAT.format(calendar.getTime()) + "_" + config.getDataBypro("platformNo") + "_" + serivecName + ".txt");
        if (file.exists()) {
            //存在读取文件 每行以数组格式存入list
            try {

                String str = "";
                String[] strArray = null;
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                br.readLine();
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                    dataToObjeckt(calzz, str, map,length, positioning);


                }
//                   if(serivecName.equals("RECHARGE")){
//
//                       List<CheckRechargeEntity> list = new ArrayList<>();
//                       CheckRechargeEntity checkRechargeEntity=null;
//                       while ((str = br.readLine()) != null ){
////                           strArray = str.split(",",lethg);
////                             checkRechargeEntity = new CheckRechargeEntity(
////                                    strArray[0],
////                                    strArray[1],
////                                    strArray[2],
////                                    strArray[3],
////                                    strArray[4],
////                                    strArray[5],
////                                    strArray[6],
////                                    strArray[7],
////                                    strArray[8],
////                                    strArray[9],
////                                    strArray[10],
////                                    strArray[11],
////                                    strArray[12],
////                                    strArray[13],
////                                    strArray[14],
////                                    strArray[15]
////                                     );
//
//
//                           map.put(strArray[positioning],checkRechargeEntity);
//                       }
//                       return map;
//                   }else if(serivecName.equals("WITHDRAW")){
//
//                       while ((str = br.readLine()) != null ){
//                           strArray = str.split(",",lethg);
//                           CheckWithdrawEntity checkWithdrawEntity = new CheckWithdrawEntity(
//
//                                   strArray[0],
//                                   strArray[1],
//                                   strArray[2],
//                                   strArray[3],
//                                   strArray[4],
//                                   strArray[5],
//                                   strArray[6],
//                                   strArray[7],
//                                   strArray[8],
//                                   strArray[9],
//                                   strArray[10],
//                                   strArray[11],
//                                   strArray[12],
//                                   strArray[13],
//                                   strArray[14],
//                                   strArray[15],
//                                   strArray[16],
//                                   strArray[17]
//                           );
//
//                       }
//
//                   }else if(serivecName.equals("TRANSACTION")){
//                       while ((str = br.readLine()) != null ){
//                           strArray = str.split(",",lethg);
//                           CheckTransactionEntity checkRechargeEntity = new CheckTransactionEntity();
//
//                       }
//
//                   }else if(serivecName.equals("BACKROLL_RECHARGE")){
//
//                       while ((str = br.readLine()) != null ){
//                           strArray = str.split(",",lethg);
//                           CheckBackrollRechargeEntity checkBackrollRechargeEntity = new CheckBackrollRechargeEntity();
//
//                       }
//
//                   }


//                for (int i =0 ; i<5;i++)
//                System.out.println(listS.get(i)[14]);
                br.close();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }


    protected void dataToObjeckt(Class clazz, String str, Map<String, Object> map,int length, int positioning) {

        String[] strArray = str.split(",",length);


        System.out.println(strArray.length);
        int lengths = 10;
        if (strArray.length == 0 || strArray.length < lengths) {

            return;

        }

        System.out.println(clazz.getCanonicalName());

        try {
            Object obj = clazz.getDeclaredConstructor(String[].class).newInstance(new Object[]{strArray});

            map.put(strArray[positioning], obj);
            System.out.println("map="+map);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        String str = "提现时间,平台商编,平台请求流水号,订单号,业务类型,金额,币种,会员编号,平台用户编号,银行卡号,银行编码,到账金额,备注,提现状态,提现方式,垫资金额,出款类型,提现类型";
        new CheckBillJobSupper().dataToObjeckt(CheckRechargeEntity.class, str, map, 18,1);

        System.out.println(map);

    }
}