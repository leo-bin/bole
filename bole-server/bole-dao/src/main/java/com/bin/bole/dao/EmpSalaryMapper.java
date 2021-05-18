package com.bin.bole.dao;


import com.bin.bole.domain.emp.EmpSalary;
import com.bin.bole.domain.resp.EmpSalaryResp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpSalaryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(EmpSalary record);

    int insertSelective(EmpSalary record);

    EmpSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpSalary record);

    int updateByPrimaryKey(EmpSalary record);

    int updateBaseSalByEId(@Param("eid") Integer eid, @Param("baseSalary") Integer baseSalary);

    EmpSalaryResp selectByWorkId(@Param("workId") String workId);

    List<EmpSalaryResp> getAllSalariesByPage(@Param("page") Integer page,@Param("size") Integer size);

    long getTotal();
}