package com.bin.bole.api.controller.system.basic;

import com.bin.bole.domain.resp.RespPageBean;
import com.bin.bole.service.OpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binLi
 * @date 2021/5/17 17:18
 * Description: opLog api
 */
@RestController
@RequestMapping("/system/basic/opLog")
public class OpLogController {

    @Autowired
    private OpLogService opLogService;

    @GetMapping("/")
    public RespPageBean getAllOpLogByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size) {
        return opLogService.getOpLogByPage(page, size);
    }
}
