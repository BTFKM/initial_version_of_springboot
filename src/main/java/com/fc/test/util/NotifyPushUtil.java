package com.fc.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName NotifyPushUtil
 * @Author sjf
 * @mail sjf10050@outlook.com
 * @Date 2019-06-14 17:08
 * @Description 消息推送工具类
 */

@Component
public class NotifyPushUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyPushUtil.class.getName());

    @Async
    public boolean pushByMail(String subject, String text, String to, String from) {
        LOGGER.info("正在发送邮件");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setBcc();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(text);
        try {
            javaMailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    //TODO 检查邮箱合法
    public boolean checkMailAddressVaild(String mailAddress) {
        //^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$
        return true;
    }
}
