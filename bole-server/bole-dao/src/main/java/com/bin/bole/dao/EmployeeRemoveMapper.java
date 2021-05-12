package com.bin.bole.dao;


import com.bin.bole.domain.emp.EmployeeRemove;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRemoveMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRemove record);

    int insertSelective(EmployeeRemove record);

    EmployeeRemove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeRemove record);

    int updateByPrimaryKey(EmployeeRemove record);
}