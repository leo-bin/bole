package com.bin.bole.dao;


import com.bin.bole.domain.emp.Employeeremove;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeremoveMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);
}