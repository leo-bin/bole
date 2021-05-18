package com.bin.bole.api.controller.system.basic;


import com.bin.bole.api.aop.OpLogMonitor;
import com.bin.bole.common.result.Result;
import com.bin.bole.domain.emp.JobLevel;
import com.bin.bole.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：job level api
 **/
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @OpLogMonitor(op = "添加一个工作职位")
    @PostMapping("/")
    public Result addJobLevel(@RequestBody JobLevel jobLevel, Authentication authentication) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return Result.success("添加成功!");
        }
        return Result.error("添加失败!");
    }

    @OpLogMonitor(op = "修改工作职位")
    @PutMapping("/")
    public Result updateJobLevelById(@RequestBody JobLevel jobLevel, Authentication authentication) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @OpLogMonitor(op = "删除工作职级")
    @DeleteMapping("/{id}")
    public Result deleteJobLevelById(@PathVariable Integer id, Authentication authentication) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败!");
    }

    @DeleteMapping("/")
    public Result deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败!");
    }
}