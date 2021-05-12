package com.bin.bole.api.controller.salary;


import com.bin.bole.common.result.Result;
import com.bin.bole.domain.emp.Salary;
import com.bin.bole.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：salary sob api
 **/
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PostMapping("/")
    public Result addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return Result.success("添加成功!");
        }
        return Result.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public Result deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.deleteSalaryById(id) == 1) {
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }

    @PutMapping("/")
    public Result updateSalaryById(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }
}