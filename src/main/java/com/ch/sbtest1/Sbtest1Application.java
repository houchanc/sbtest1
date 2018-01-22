package com.ch.sbtest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//核心注解，主要目的是开启自动配置
@SpringBootApplication
public class Sbtest1Application {
	//项目启动的入口
	public static void main(String[] args) {
		SpringApplication.run(Sbtest1Application.class, args);
	}
}
