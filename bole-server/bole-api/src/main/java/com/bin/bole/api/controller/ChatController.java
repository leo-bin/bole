package com.bin.bole.api.controller;


import com.bin.bole.domain.hr.Hr;
import com.bin.bole.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：chat api
 **/
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    HrService hrService;

    @GetMapping("/hrs")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrsExceptCurrentHr();
    }
}
