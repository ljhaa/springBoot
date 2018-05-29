package com.yipuhui.fastgo.service.impl;

import com.yipuhui.fastgo.dao.SearchForUeAccountMapper;
import com.yipuhui.fastgo.dao.UeAccountMapper;
import com.yipuhui.fastgo.dao.UeWaterMapper;
import com.yipuhui.fastgo.enty.UeAccount;
import com.yipuhui.fastgo.enty.UeWater;
import com.yipuhui.fastgo.service.UeAccountService;
import com.yipuhui.fastgo.utils.AppConfig;
import com.yph.config.PropertyUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 刘俊汉
 * @date 2018/5/28 16:22
 */
@Service("ueAccountService")
public class UeAccountServiceImpl implements UeAccountService {
protected final Log logger = LogFactory.getLog(getClass());


private static AppConfig appConfig = AppConfig.getConfig();
	@Autowired
	private UeAccountMapper accountMapper;
	
	@Autowired
	private UeWaterMapper ueWaterMapper;

	@Autowired
	private SearchForUeAccountMapper searchForUeAccountMapper;

	@Override
	public void doAddUeMoney(Integer loginId, int type) {
		try {
			// 1.判断体验金赠送类型
			String waterDesc = "";
			BigDecimal availableMoney = BigDecimal.ZERO;
			if(type == 1) {
				waterDesc = "注册赠送体验金";
				// 从配置文件中得到注册的送体验金的金额
				String registerGiveMoney = appConfig.getDataBypro("RegisterGiveMoney");
				if(registerGiveMoney != null && registerGiveMoney.matches("\\d+")) {
					availableMoney = new BigDecimal(registerGiveMoney);
				}
			} else if(type == 2) {
				waterDesc = "开户赠送体验金";
				// 从配置文件中得到实名的送体验金的金额
				String certificationGiveMoney = PropertyUtil.getInfo("CertificationGiveMoney");
				if(certificationGiveMoney != null && certificationGiveMoney.matches("\\d+")) {
					availableMoney = new BigDecimal(certificationGiveMoney);
				}
			}
			
			// 如果体验金>0才进行赠送
			if(availableMoney.compareTo(BigDecimal.ZERO) <= 0) {
				return;
			}
			
			UeAccount ueAcount = searchForUeAccountMapper.getUeAcountByLoginId(loginId);
			// 2.检查用户对应的体验金账户是否存在
			if(ueAcount == null) {
				ueAcount = new UeAccount();
				ueAcount.setAvailable(BigDecimal.ZERO);
				ueAcount.setMoney(BigDecimal.ZERO);
				ueAcount.setLenderLoginId(loginId);
				ueAcount.setExpected(BigDecimal.ZERO);
				ueAcount.setCreateTime(new Date());
				accountMapper.insert(ueAcount);
			}
			
			// 3.更新体验金账号
			UeAccount updateueAccount = new UeAccount();
			updateueAccount.setLenderLoginId(loginId);
			updateueAccount.setAvailable(availableMoney);
			searchForUeAccountMapper.updateAccountForInvest(updateueAccount);
			
			// 4.插入体验金账号流水
			UeWater ueWater = new UeWater();
			ueWater.setMoney(availableMoney);
			ueWater.setLenderLoginId(loginId);
			ueWater.setType("1");
			ueWater.setWaterDesc(waterDesc);
			ueWater.setCreateTime(new Date());
			ueWaterMapper.insert(ueWater);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("*** 体验金赠送  *** " + loginId + "  出错" + ",类型为：" + type);
		}
	}
	


}
