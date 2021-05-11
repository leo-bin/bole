package com.bin.bole.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author binLi
 * @date 2021/3/10 5:23 下午
 * Description：bole-server 启动入口
 **/
@EnableCaching
@EnableScheduling
@MapperScan(basePackages = "com.bin.bole.dao")
@SpringBootApplication(scanBasePackages = "com.bin.bole")
public class BoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoleApplication.class);
    }
}
