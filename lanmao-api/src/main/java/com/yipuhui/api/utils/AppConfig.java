package com.yipuhui.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 
 * @author Iren08
 * @date 2017年3月8日 下午1:17:25
 * @version 1.0
 */
public final class AppConfig {

	private static final Logger logger = LoggerFactory
			.getLogger(AppConfig.class);

	private static final String FILE_NAME = "propert/application.properties";

	private Properties properties = null;

	private static AppConfig sdkConfig = null;


	private AppConfig() {
		this.loadPropertiesFromSrc();
	}

	public static AppConfig getConfig() {
		synchronized (AppConfig.class) {
			if (null == sdkConfig) {
				sdkConfig = new AppConfig();
			}
			return sdkConfig;
		}
	}

	private void loadPropertiesFromSrc() {
		InputStream in = null;
		try {

			logger.info("从classpath: "
					+ AppConfig.class.getClassLoader().getResource("")
							.getPath() + " 获取属性文件" + FILE_NAME);
			in = AppConfig.class.getClassLoader()
					.getResourceAsStream(FILE_NAME);
			if (null != in) {
				BufferedReader bf = new BufferedReader(new InputStreamReader(
						in, "utf-8"));
				properties = new Properties();
				try {
					properties.load(bf);

				} catch (IOException e) {
					throw e;
				}
			} else {
				logger.error(FILE_NAME
						+ "属性文件未能在classpath指定的目录下 "
						+ AppConfig.class.getClassLoader().getResource("")
								.getPath() + " 找到!");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public String getDataBypro(String key){


		return properties.getProperty(key);
	}


}
