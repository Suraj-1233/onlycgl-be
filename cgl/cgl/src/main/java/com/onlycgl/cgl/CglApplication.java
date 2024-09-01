package com.onlycgl.cgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.onlycgl.cgl"})
public class CglApplication {

	public static void main(String[] args) {
		SpringApplication.run(CglApplication.class, args);
	}

}
