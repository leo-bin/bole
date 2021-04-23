package com.bin.bole.api.controller.hello;

import com.bin.bole.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binLi
 * @date 2021/3/10 5:31 下午
 * Description：hello world
 **/
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/bole/hello")
    public Result<String> hello() {
        return Result.success("Hello There ! - from bole");
    }
}
