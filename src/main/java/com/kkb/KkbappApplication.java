package com.kkb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.kkb.*.mapper")
@EnableScheduling
public class KkbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KkbappApplication.class, args);
	}

}
