package com.bin.bole.domain.sys;

import java.util.Date;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote
 */
public class OpLog {

    private Integer id;
    private Date addDate;
    private String operate;
    private Integer hrId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }
}