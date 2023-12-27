package com.example.mongocruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example.mongocruddemo")
@SpringBootApplication
public class MongocrudDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(MongocrudDemoApplication.class, args);
	}

}
