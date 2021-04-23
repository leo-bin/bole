package com.bin.bole.mailserver;

import com.bin.bole.common.consts.MailConst;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @author binLi
 * @date 2021/3/10 4:25 下午
 * Description：bole-mail启动入口
 **/
@SpringBootApplication
public class MailServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailServerApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(MailConst.MAIL_QUEUE_NAME);
    }
}
