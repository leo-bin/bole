package com.bin.bole.api.controller.system.basic;


import com.bin.bole.api.aop.OpLogMonitor;
import com.bin.bole.common.result.Result;
import com.bin.bole.domain.emp.Department;
import com.bin.bole.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description： department api
 **/
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @OpLogMonitor(op = "添加一个部门")
    @PostMapping("/")
    public Result addDep(@RequestBody Department dep, Authentication authentication) {
        departmentService.addDep(dep);
        if (dep.getResult() == 1) {
            return Result.success(dep);
        }
        return Result.error("添加失败");
    }

    @OpLogMonitor(op = "删除一个部门")
    @DeleteMapping("/{id}")
    public Result deleteDepById(@PathVariable Integer id, Authentication authentication) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepById(dep);
        if (dep.getResult() == -2) {
            return Result.error("该部门下有子部门，删除失败");
        } else if (dep.getResult() == -1) {
            return Result.error("该部门下有员工，删除失败");
        } else if (dep.getResult() == 1) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}