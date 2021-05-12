package com.bin.bole.api.controller.system.basic;

import com.bin.bole.common.result.Result;
import com.bin.bole.domain.emp.Position;
import com.bin.bole.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：sys position api
 **/
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public Result addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return Result.success("添加成功!");
        }
        return Result.error("添加失败!");
    }

    @PutMapping("/")
    public Result updatePositions(@RequestBody Position position) {
        if (positionService.updatePositions(position) == 1) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public Result deletePositionById(@PathVariable Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败!");
    }

    @DeleteMapping("/")
    public Result deletePositionsByIds(Integer[] ids) {
        if (positionService.deletePositionsByIds(ids) == ids.length) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败!");
    }
}
