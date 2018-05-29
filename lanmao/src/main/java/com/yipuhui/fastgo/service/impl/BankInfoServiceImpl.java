/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: BankInfoServiceImpl.java 
 *
 * Created: [2015年4月25日 上午10:47:48] by cheng 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: ephwealth-online 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yipuhui.fastgo.service.impl;


import com.yipuhui.fastgo.dao.BankInfoMapper;
import com.yipuhui.fastgo.dao.SystemDictMapper;
import com.yipuhui.fastgo.dao.UpdateCardMapper;
import com.yipuhui.fastgo.enty.BankInfo;
import com.yipuhui.fastgo.enty.SystemDict;
import com.yipuhui.fastgo.enty.UpdateCard;
import com.yipuhui.fastgo.service.BankInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author chengzhichao
 * @version 1.0
 *          <pre>
 *                   Modification History:
 *                    Date           Author        Version       Description
 *                   ------------------------------------------------------------------
 *                   2015年4月25日      chengzhichao       1.0         1.0 Version
 *                   </pre>
 */

@Service("bankInfoService")
public class BankInfoServiceImpl implements BankInfoService {

    private static final Logger logger = LoggerFactory.getLogger(BankInfoServiceImpl.class);


    @Autowired
    private BankInfoMapper bankInfoMapper;

    @Autowired
    private UpdateCardMapper updateCardMapper;

    @Override
    public Map<String, Object> getBankInfoByLenderNum(String lenderNum) {
        return bankInfoMapper.getBankInfoByLenderNum(lenderNum);
    }

    @Override
    public BankInfo selectByPrimaryKey(Integer bankId) {
        return bankInfoMapper.selectByPrimaryKey(bankId);
    }

    @Override
    public int verifyAccountNum(String accountNum) {
        return bankInfoMapper.verifyAccountNum(accountNum);
    }

    @Override
    public Map<String, Object> getBankInfoByCardNum(String cardNum) {
        return bankInfoMapper.getBankInfoByCardNum(cardNum);
    }

    @Override
    public Map<String, Object> getLenderInfoByLenderNum(String lenderNum) {
        return bankInfoMapper.getLenderInfoByLenderNum(lenderNum);
    }

    @Override
    public BankInfo selectByAccountNum(String accountNum) {

        return bankInfoMapper.selectByAccountNum(accountNum);
    }

    @Override
    public int updateByPrimaryKeySelective(BankInfo info) {

        return bankInfoMapper.updateByPrimaryKeySelective(info);
    }

    /**
     * Description:修改银行卡号
     *
     * @return
     * @Author liujunhan
     * @Create Date: 2017年11月13日 上午11:48:54
     */
    @Override
    public Integer changeCard(String bankId, String bankStatus, String usrStatus) {
        //根据id，将银行卡状态改为处理中
        return bankInfoMapper.updateChangeCard(bankStatus, usrStatus, bankId);


    }

    @Override
    public BankInfo selectDataByLenderNum(String lenderNum) {
        return bankInfoMapper.selectDataByLenderNum(lenderNum);

    }

    /**
     * Description: 插入数据
     *
     * @return
     * @Author liujunhan
     * @Create Date: 2017年11月13日 下午5:21:42
     */
    @Override
    public int insetBankInfo(BankInfo bankInfo) {
        return bankInfoMapper.insert(bankInfo);
    }

    @Override
    public Map<String, Object> getBankInfoByCjCardNum(String cardNum) {
        return bankInfoMapper.getBankInfoByCjCardNum(cardNum);
    }


    /**
     * 根据银行卡号查询银行卡信息包括不可用所有银行卡
     *
     * @param [accountNum]
     * @return com.ephwealth.core.entity.BankInfo
     * @author 刘俊汉
     * @date 2018/3/14 10:13
     */
    @Override
    public BankInfo fundByAccountNum(String accountNum) {

        return bankInfoMapper.fundByAccountNum(accountNum);
    }






    /**
     * 换卡操作
     *
     * @param [accountNum, lenderNum, bankcode]
     * @return void
     * @author 刘俊汉
     * @date 2018/4/27 13:36
     */
    @Override
    public void updataBankInfoCardById(String reqData,String mobile, String lenderNum, String selNum) {


        UpdateCard updateCard = new UpdateCard();
        updateCard.setData(reqData);
        updateCard.setSubmitTime(new Date());
        updateCard.setLenderNum(lenderNum);
        updateCard.setSelNum(selNum);
        updateCard.setStatus("2");
        updateCardMapper.insert(updateCard);



    }
 //
//    /**
//     * 换卡操作状态审核中
//     *
//     * @param []
//     * @return void
//     * @author 刘俊汉
//     * @date 2018/4/27 14:00
//     */
//    private void updataBankCardFive(String accountNum, String lenderNum, String bankcode, String userStatus) {
//
//        BankInfo bankInfo = bankInfoMapper.fundByAccountNum(accountNum);
//        BankInfo bankInfo1 = bankInfoMapper.selectDataByLenderNum(lenderNum);
//        if (bankInfo != null) {
//            if (bankInfo1.getRealName().equals(bankInfo.getRealName()) && bankInfo1.getBankId().compareTo(bankInfo.getBankId()) != 0) {
////                bankInfo1.setUsedStatus("0");
////                bankInfoMapper.updateByPrimaryKeySelective(bankInfo1);
//                bankInfo1.setThirdStatus("5");
//                bankInfoMapper.updateByPrimaryKeySelective(bankInfo);
//            } else {
//
//                logger.info("================已存在卡号且用户不是同一人===[accountNum={}]", accountNum);
//            }
//
//        } else {
//            SystemDict systemDict = new SystemDict();
//            systemDict.setRemark(bankcode);
//            systemDict = systemDictMapper.selectDictByremak(systemDict);
//
//            //就卡变为不可用
//            bankInfo1.setThirdStatus("5");
//            bankInfoMapper.updateByPrimaryKeySelective(bankInfo1);
//            bankInfo1.setBankId(null);
//            bankInfo1.setUsedStatus("0");
//            bankInfo1.setThirdStatus(userStatus);
//            bankInfo1.setAccountNum(accountNum);
//            bankInfo1.setBankNum(systemDict.getDictCode());
//            bankInfoMapper.insert(bankInfo1);
//
//        }
//
//    }
//
//    /**
//     * 换卡操作状态审核失败
//     *
//     * @param []
//     * @return void
//     * @author 刘俊汉
//     * @date 2018/4/27 14:00
//     */
//    private void updataBankCardFour(String lenderNum) {
//
//
//        BankInfo bankInfo1 = bankInfoMapper.selectDataByLenderNum(lenderNum);
//        bankInfo1.setThirdStatus("3");
//        bankInfoMapper.updateByPrimaryKeySelective(bankInfo1);
//
//    }
//
//    /**
//     * 换卡操作状态审核成功
//     *
//     * @param []
//     * @return void
//     * @author 刘俊汉
//     * @date 2018/4/27 14:00
//     */
//    private void updataBankCardSuccess(String accountNum, String lenderNum) {
//
//        BankInfo bankInfo = bankInfoMapper.fundByAccountNum(accountNum);
//        BankInfo bankInfo1 = bankInfoMapper.selectDataByLenderNum(lenderNum);
//        bankInfo1.setUsedStatus("0");
//        bankInfoMapper.updateByPrimaryKeySelective(bankInfo1);
//        bankInfo.setUsedStatus("1");
//        bankInfo.setThirdStatus("3");
//        bankInfoMapper.updateByPrimaryKeySelective(bankInfo);
//    }

}
