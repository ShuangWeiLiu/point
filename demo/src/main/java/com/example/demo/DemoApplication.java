package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
	    // 打印spring boot 版本
	    String implementationVersion = SpringApplication.class.getPackage().getImplementationVersion();  
        System.out.println("[spring boot 版本]" + implementationVersion);  

        SpringApplication.run(DemoApplication.class, args);
	}
}
