package com.yipuhui.api.utils;/**
 * Created by liujunhan on 2018/4/11.
 */

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

/**
 * 签名工具类
 *
 * @author 刘俊汉
 * @create 2018-04-11 16:47
 **/
public class SignUtil {
    final static Logger logger = Logger.getLogger(DESCryptUtil.class);
    /**
     *
     * Description: 解密
     *
     * @param data
     * @return
     * @throws Exception
     * @Author xingym
     * @Create Date: 2015年9月23日 上午11:57:42
     */
    public static String decrypt(String data) throws Exception{
        String decryptStr = DESCryptUtil.getDecodeData(data);

//		decryptStr="{\"paramsData\":{\"amount\":\"1000\",\"bidId\":\"4\",\"payPwd\":\"96e79218965eb72c92a549dd5a330112\",\"lenderId\":1},\"paramsCode\":\"K12006\"}";
        logger.info("接收信息："+decryptStr);

        return decryptStr;
    }
    /**
     *
     * Description: 加密
     *
     * @param resMsg
     * @return
     * @throws Exception
     * @Author xingym
     * @Create Date: 2015年9月23日 上午11:57:51
     */
    public static String encryp(String resStr) throws Exception{

        logger.info("返回信息："+resStr);
        return DESCryptUtil.getEncrypData(resStr);
    }





    private static  AppConfig config = AppConfig.getConfig();
    /**
     *
     *   lannmaoyuibu 返回验签
     * @author 刘俊汉
     * @date 2018/4/19 18:44
     * @param [response, responseData]
     * @return void
     */
    public static boolean verifySign(String returnSign, String responseData) throws Exception {

        Map<String, Object> respMap = JSON.parseObject(responseData);

        //校验返回报文



        byte[] keyByte = Base64.decodeBase64(config.getDataBypro("lmPublicKey"));
        byte[] signByte = Base64.decodeBase64(returnSign);
        try {
            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(keyByte);

            boolean b = SignatureUtils.verify(SignatureAlgorithm.SHA1WithRSA, publicKey, responseData, signByte);
            if (!b) {
                throw new Exception("验签失败，sign与respData不匹配");
            }

            logger.info("sign success ...");
        } catch (InvalidKeySpecException e) {
            throw new InvalidKeySpecException("验签错误，生成商户公钥失败", e);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("验签错误" + e.getMessage(), e);
        } catch (GeneralSecurityException e) {
            throw new GeneralSecurityException("验签错误" + e.getMessage(), e);
        }


        return true;
    }

    public static void main(String[] args) {

        String reqda ="{\"platformUserNo\":\"861888880000339\",\"realName\":\"姜诗翠\",\"idCardType\":\"PRC_ID\",\"userRole\":\"INVESTOR\",\"idCardNo\":\"640202********6223\",\"mobile\":\"14400000054\",\"bankcardNo\":\"************2054\",\"bankcode\":\"EVER\",\"accessType\":\"FULL_CHECKED\",\"auditStatus\":\"PASSED\",\"groupAccountNO\":\"\",\"virtualCardNo\":\"\",\"requestNo\":\"20180420170707\",\"code\":\"0\",\"status\":\"SUCCESS\"}";
        String sign="e9m5grj4FqCzVN54HuF1qfLnebNFhKdwNLRFie19o9BCA219ruB+97KS91G9lnkmA7mkOeYfhBtGrN7+BVkoJ91Ao1uKFfbl/pesyPVeAQZGzpSitk2e3Tezd5Hq8K+n//DvR+y9zT2/bJVmkVEoR+KYrs03H0AmTloubgdeHRfknq2hoWCR2ilZMvO7XKe1wumeozW+cezZ1aeeTUbsJNeNJLVJoqoMOWnwrHHOsyr3GMMGZmvXwv4JbD40khY75XdL3nnhxdjUwbRnqJfep6N0mVjnsavqhpNxUBJQScE2dhG/UHHcgDHFa/sDdMLirTMrTIKZ1xase6+BuZq/wQ==";
        try {
            System.out.println(verifySign(sign,reqda));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
