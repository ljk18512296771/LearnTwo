package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//利用包扫描的形式扫描指定包路径,为接口创建代理对象批量操作
@MapperScan("com.jt.mapper")//@Mapper的包扫描类型
public class SpringbootDome2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDome2Application.class, args);
	}

}
