package com.bin.bole.mailserver.consts;

/**
 * @author binLi
 * @date 2021/3/10 4:41 下午
 * Description：mail const
 **/
public class MailConst {

    /**
     * queue
     */
    public static final String MAIL_QUEUE_NAME = "bole.mail.queue";
    public static final String MAIL_EXCHANGE_NAME = "bole.mail.exchange";
    public static final String MAIL_ROUTING_KEY_NAME = "bole.mail.routing.key";

    /**
     * 消息超时时间
     */
    public static final Integer MSG_TIMEOUT = 1;
}
