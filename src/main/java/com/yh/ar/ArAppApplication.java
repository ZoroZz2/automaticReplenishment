package com.yh.ar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName: ArAppApplication
 * @Description: 自动补货项目启动类
 * @Author: system
 * @Date: 2024-10-25 17:07
 * @Version: 1.0
 **/

@SpringBootApplication
@EnableScheduling
@MapperScan({"com.yh.ar.account.mapper", "com.yh.ar.business.mapper"})
public class ArAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArAppApplication.class);
    }

}
