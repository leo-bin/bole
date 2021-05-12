package com.bin.bole.api.controller.system.basic;

import com.bin.bole.common.result.Result;
import com.bin.bole.domain.sys.Menu;
import com.bin.bole.domain.sys.Role;
import com.bin.bole.service.MenuService;
import com.bin.bole.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：sys permission api
 **/
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public Result updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @PostMapping("/role")
    public Result addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return Result.success("添加成功!");
        }
        return Result.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    public Result deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败!");
    }
}
