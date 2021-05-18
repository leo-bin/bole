package com.bin.bole.service;

import com.bin.bole.dao.AdjustSalaryMapper;
import com.bin.bole.dao.EmpSalaryMapper;
import com.bin.bole.dao.SalaryMapper;
import com.bin.bole.domain.emp.AdjustSalary;
import com.bin.bole.domain.emp.Salary;
import com.bin.bole.domain.resp.EmpSalaryResp;
import com.bin.bole.domain.resp.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;
    @Autowired
    EmpSalaryMapper empSalaryMapper;
    @Autowired
    AdjustSalaryMapper adjustSalaryMapper;

    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalaryById(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    public Integer adjustSalary(AdjustSalary adjustSalary) {
        int i = empSalaryMapper.updateBaseSalByEId(adjustSalary.getEid(), adjustSalary.getAfterSalary());
        return i + adjustSalaryMapper.insertSelective(adjustSalary);
    }

    public EmpSalaryResp getSalaryByWorkId(String workId) {
        return empSalaryMapper.selectByWorkId(workId);
    }

    public RespPageBean getAll(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<EmpSalaryResp> list = empSalaryMapper.getAllSalariesByPage(page, size);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(empSalaryMapper.getTotal());
        return respPageBean;
    }
}
