package com.bin.bole.domain.emp;

import java.util.Date;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote 员工调动（内部活水）
 */
public class EmployeeRemove {

    private Integer id;
    private Integer eid;
    private Integer afterDepId;
    private Integer afterJobId;
    private Date removeDate;
    private String reason;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getAfterDepId() {
        return afterDepId;
    }

    public void setAfterDepId(Integer afterDepId) {
        this.afterDepId = afterDepId;
    }

    public Integer getAfterJobId() {
        return afterJobId;
    }

    public void setAfterJobId(Integer afterJobId) {
        this.afterJobId = afterJobId;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}