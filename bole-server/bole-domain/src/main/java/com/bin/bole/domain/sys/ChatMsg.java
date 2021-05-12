package com.bin.bole.domain.sys;

import lombok.Data;

import java.util.Date;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote
 */
@Data
public class ChatMsg {

    private String from;
    private String to;
    private String content;
    private Date date;
    private String fromNickname;
}
