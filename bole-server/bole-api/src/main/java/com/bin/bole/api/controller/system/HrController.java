package com.bin.bole.api.controller.system;


import com.bin.bole.api.aop.OpLogMonitor;
import com.bin.bole.common.result.Result;
import com.bin.bole.domain.emp.AdjustSalary;
import com.bin.bole.domain.hr.Hr;
import com.bin.bole.domain.req.AddHrReq;
import com.bin.bole.domain.sys.Role;
import com.bin.bole.service.HrService;
import com.bin.bole.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：sys hr api
 **/
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @OpLogMonitor(op = "添加一名hr")
    @PostMapping("/")
    public Result addHr(@RequestBody @Valid AddHrReq addHrReq, Authentication authentication) {
        if (hrService.addHr(addHrReq) == 1) {
            return Result.success("添加成功！");
        }
        return Result.error("添加失败!");
    }

    @PutMapping("/")
    public Result updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public Result updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @OpLogMonitor(op = "删除一名hr")
    @DeleteMapping("/{id}")
    public Result deleteHrById(@PathVariable Integer id, Authentication authentication) {
        if (hrService.deleteHrById(id) == 1) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败!");
    }


}
