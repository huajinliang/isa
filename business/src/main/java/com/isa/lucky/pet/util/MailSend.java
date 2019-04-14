package com.isa.lucky.pet.util;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 邮件发送
 * Date: 2017-11-27
 *
 * @author huajinliang
 */
public class MailSend {
    private static final Logger LOG = LoggerFactory.getLogger(MailSend.class);

    private String host;
    private String username;
    private String password;
    private String titlePrex;
    private String from;
    private String to;
    private String subject;
    private String content;

    public MailSend(String subject, String content) {
        host = "smtp.gmail.com";
        username = "isaluckypet@gmail.com";
        password = "isaluckypet20190410";
        titlePrex = "客户网站提交信息: ";
        from = "isaluckypet@gmail.com";
        to = "isaluckypet@gmail.com";
        this.subject = subject;
        this.content = content;
    }

    public void doSend() {
        Properties props = new Properties();
        // 初始化props
        props.put("mail.smtp.host", host);
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

        // 验证
        MailAuthenticator authenticator = new MailAuthenticator(username,
                password);
        // 创建session
        Session session = Session.getInstance(props, authenticator);
        // 打印一些调试信息
        session.setDebug(false);
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        try {
            message.setFrom(new InternetAddress(from));
            // 设置收件人们
            String[] recipients = to.split(";");
            final int num = recipients.length;
            InternetAddress[] addresses = new InternetAddress[num];
            for (int i = 0; i < num; i++) {
                addresses[i] = new InternetAddress(recipients[i]);
            }
            message.setRecipients(Message.RecipientType.TO, addresses);
            // 设置主题
            message.setSubject(titlePrex + subject);
            // 设置邮件内容
            message.setContent(content.toString(), "text/html;charset=utf-8");
            // 设置发信时间
            message.setSentDate(new Date());
            // 存储邮件信息
            message.saveChanges();
            // 发送邮件
            Transport.send(message);
            LOG.info("send mail success,subject={}", titlePrex + subject);
        } catch (Exception e) {
            LOG.error("send mail fail", e);
        }
    }

    public class MailAuthenticator extends Authenticator {
        private String username;
        private String password;

        /**
         *
         * @param username String
         * @param password String
         */
        MailAuthenticator(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }
}
