package com.bin.bole.api.controller.salary;


import com.bin.bole.common.result.Result;
import com.bin.bole.domain.emp.Salary;
import com.bin.bole.domain.resp.RespPageBean;
import com.bin.bole.service.EmployeeService;
import com.bin.bole.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：salary sob config api
 **/
@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PutMapping("/")
    public Result updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if (result == 1 || result == 2) {
            return Result.success("更新成功");
        }
        return Result.error("更新失败");
    }
}
