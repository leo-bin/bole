package com.bin.bole.domain.emp;

import java.util.Date;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote 员工奖罚
 */
public class EmployeeEc {

    private Integer id;
    private Integer eid;
    private Date ecDate;
    private String ecReason;
    /**
     * 奖罚得分
     */
    private Integer ecPoint;
    /**
     * 奖罚类型：0=奖，1=罚
     */
    private Integer ecType;
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

    public Date getEcDate() {
        return ecDate;
    }

    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }

    public String getEcReason() {
        return ecReason;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason == null ? null : ecReason.trim();
    }

    public Integer getEcPoint() {
        return ecPoint;
    }

    public void setEcPoint(Integer ecPoint) {
        this.ecPoint = ecPoint;
    }

    public Integer getEcType() {
        return ecType;
    }

    public void setEcType(Integer ecType) {
        this.ecType = ecType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}