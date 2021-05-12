package com.bin.bole.domain.sys;

import java.util.Date;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote
 */
public class MsgContent {

    private Integer id;
    private String title;
    private String message;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}