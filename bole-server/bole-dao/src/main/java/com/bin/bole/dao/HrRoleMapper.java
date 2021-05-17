package com.bin.bole.dao;

import com.bin.bole.domain.hr.HrRole;
import org.apache.ibatis.annotations.Param;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteByHrid(@Param("hrId") Integer hrId);

    Integer addRole(@Param("hrId") Integer hrid, @Param("rids") Integer[] rids);
}