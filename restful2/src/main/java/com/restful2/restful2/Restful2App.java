package com.restful2.restful2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Restful2App
{
	public static void main(String[] args) {
		SpringApplication.run(Restful2App.class, args);
	}
}
