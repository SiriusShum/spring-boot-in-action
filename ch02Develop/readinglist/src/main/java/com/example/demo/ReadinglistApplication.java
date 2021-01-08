package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring的@Configuration：标明该类使用Spring基于Java的配置。
// Spring的@ComponentScan：启用组件扫描，这样你写的Web控制器类和其他组件才能被自动发现并注册为Spring应用程序上下文里的Bean。
// Spring Boot 的 @EnableAutoConfiguration，就是这一行配置开启了Spring Boot自动配置的魔力，让你不用再写成篇的配置了。
@SpringBootApplication  // 开启组件扫描和自动配置
public class ReadinglistApplication{

	public static void main(String[] args) {
	    // 负责启动引导应用程序
		SpringApplication.run(ReadinglistApplication.class, args);
	}
	
}
