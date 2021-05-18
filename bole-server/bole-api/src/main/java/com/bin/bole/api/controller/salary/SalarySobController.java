package com.bin.bole.api.controller.salary;


import com.bin.bole.api.aop.OpLogMonitor;
import com.bin.bole.common.result.Result;
import com.bin.bole.domain.emp.AdjustSalary;
import com.bin.bole.domain.emp.Salary;
import com.bin.bole.domain.resp.EmpSalaryResp;
import com.bin.bole.domain.resp.RespPageBean;
import com.bin.bole.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：salary sob api
 **/
@RestController
@RequestMapping("/salary/sob")
public class SalarySobController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @OpLogMonitor(op = "add Salary")
    @PostMapping("/")
    public Result addSalary(@RequestBody Salary salary, Authentication authentication) {
        if (salaryService.addSalary(salary) == 1) {
            return Result.success("添加成功!");
        }
        return Result.error("添加失败!");
    }

    @OpLogMonitor(op = "delete Salary By Id")
    @DeleteMapping("/{id}")
    public Result deleteSalaryById(@PathVariable Integer id, Authentication authentication) {
        if (salaryService.deleteSalaryById(id) == 1) {
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }

    @OpLogMonitor(op = "update Salary By Id")
    @PutMapping("/")
    public Result updateSalaryById(@RequestBody Salary salary, Authentication authentication) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @PostMapping("/adjustSal")
    public Result adjustSalary(@RequestBody @Valid AdjustSalary adjustSalary) {
        if (salaryService.adjustSalary(adjustSalary) == 2) {
            return Result.success("调整成功！");
        }
        return Result.error("调整失败！");
    }

    @GetMapping("/getByWorkId")
    public Result<EmpSalaryResp> getByWorkId(@RequestParam(name = "workId") String workId) {
        return Result.success(salaryService.getSalaryByWorkId(workId));
    }

    @GetMapping("/getAll")
    public RespPageBean getAll(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer size) {
        return salaryService.getAll(page, size);
    }

}