package com.bin.bole.common.exception;

import com.bin.bole.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author binLi
 * @date 2021/3/11 5:42 下午
 * Description：全局异常处理
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException global = (GlobalException) e;
            LOG.error("【异常】：", global);
            return Result.error(global.getCode(), global.getMessage());
        } else {
            LOG.error("【未知异常】：", e);
            return Result.error(-1, e.getMessage());
        }
    }
}
