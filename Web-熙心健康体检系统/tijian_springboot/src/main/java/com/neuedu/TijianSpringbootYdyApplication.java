package com.neuedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neuedu.mapper") // 新增这一行，扫描所有mapper接口
public class TijianSpringbootYdyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TijianSpringbootYdyApplication.class, args);
    }

}