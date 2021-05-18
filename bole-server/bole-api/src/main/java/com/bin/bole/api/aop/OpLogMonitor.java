package com.bin.bole.api.aop;

import java.lang.annotation.*;

/**
 * @author binLi
 * @date 2021/5/17 16:29
 * Description: opLog monitor
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLogMonitor {

    // 监控方法
    String op() default "";
}
