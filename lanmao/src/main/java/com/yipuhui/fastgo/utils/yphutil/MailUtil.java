package com.yipuhui.fastgo.utils.yphutil;


import com.yipuhui.fastgo.utils.AppConfig;
import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 
 *
 * Description: 发邮件
 *
 * @author chengzhichao 
 * @version 1.0
 * <pre>
 * Modification History: 
 *  Date           Author        Version       Description 
 * ------------------------------------------------------------------ 
 * 2015年5月6日      chengzhichao       1.0         1.0 Version 
 * </pre>
 */
public class MailUtil {

	/**
	 *
	 */
	private static AppConfig config = AppConfig.getConfig();

	private static Logger logger = Logger.getLogger(MailUtil.class);
	/**
	 *用户名(即发件人的@前缀)
	 */
	private static String username = config.getDataBypro("mail.username");
	/**
	 * 密码
 	 */

	private static String password =config.getDataBypro("mail.password");

	/**
	 * 发件人(必须开通与服务器地址对应的协议)
 	 */

	private static String frommail =config.getDataBypro("mail.from");
	/**
	 * 服务器地址
 	 */

	private static String host = config.getDataBypro("mail.smtp");
	/**
	 * private static int port = 25;// 服务器端口
	 * 默认编码
	 */

	private static String defaultencoding = "UTF-8";
	/**
	 * 标题
	 */
	private String subject = "对账结果通知";
	/**
	 * // 主题内容
	 */
	private String text;
	/**
	 *  收件人
	 */
	private String tomail;
	/**
	 *  验证邮箱
	 */
	private static String regmail = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
	
	/**
	 * 构造邮件信息
	 * 
	 * @param text
	 *            邮件内容
	 * @param tomail
	 *            收件人
	 */
	public MailUtil(String text, String tomail) {
		this.text = text;
		this.tomail = tomail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTomail() {
		return tomail;
	}

	public void setTomail(String tomail) {
		this.tomail = tomail;
	}

	/**
	 * Description: 发送邮件
	 *
	 * @author 刘俊汉
	 * @param null
	 * @date 2018/5/14 15:21
	 * @return
	 */
	public boolean sendFileMail() {
		try {
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
			// 设定服务器地址、端口
			senderImpl.setHost(host);
			// 邮件默认编码
			senderImpl.setDefaultEncoding(defaultencoding);
			// 登录用户、密码
			senderImpl.setUsername(username);
			senderImpl.setPassword(password);
			// 建立HTML邮件消息
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			// true表示开始附件模式
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mailMessage, false, defaultencoding);
			// 寄件人
			messageHelper.setFrom(frommail);
			// 设置收件人
			messageHelper.setTo(tomail);
			// 标题
			messageHelper.setSubject(subject);
			// 内容,true 表示启动HTML格式的邮件
			messageHelper.setText(text, true);
			senderImpl.send(mailMessage);
		} catch (MessagingException me) {
			logger.error(me.getMessage(), me);
			return false;
		}
		return true;
	}

	public static boolean checkEmail(String email) {
		if (null == email) {
			return false;
		}
		return email.matches(regmail);
	}

}
