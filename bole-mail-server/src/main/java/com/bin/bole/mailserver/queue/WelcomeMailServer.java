package com.bin.bole.mailserver.queue;


import com.bin.bole.common.consts.MailConst;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import javax.annotation.Resource;

/**
 * @author binLi
 * @date 2021/3/10 4:35 下午
 * Description：welcome mail
 **/
@Component
public class WelcomeMailServer {

    public static final Logger logger = LoggerFactory.getLogger(WelcomeMailServer.class);

    @Resource
    JavaMailSender javaMailSender;
    @Resource
    MailProperties mailProperties;
    @Resource
    TemplateEngine templateEngine;
    @Resource
    StringRedisTemplate redisTemplate;


    @RabbitListener(queues = MailConst.MAIL_QUEUE_NAME)
    public void handler(Message message, Channel channel) {

    }

}
