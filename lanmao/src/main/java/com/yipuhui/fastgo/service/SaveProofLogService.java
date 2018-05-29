package com.yipuhui.fastgo.service;/**
 * Created by liujunhan on 2018/5/21.
 */

/**
 * 存证日志本地保存信息操作
 *
 * @author 刘俊汉
 * @create 2018-05-21 15:39
 **/
public interface SaveProofLogService {


    /**
     * Description:保存存证日志信息
     *
     * @author 刘俊汉
     * @param saveProofType
     * @param saveProofJson
     * @date 2018/5/21 15:49
     * @return void
     */
    public void savaProofLog(String lenderNum,String saveProofType, String saveProofJson);

    /**
     * Description:
     *
     * @author 刘俊汉
     * @param bidInvestNum
     * @date 2018/5/21 17:18
     * @return
     */
    public void saveProof(String filePath,String bidInvestNum);

}
