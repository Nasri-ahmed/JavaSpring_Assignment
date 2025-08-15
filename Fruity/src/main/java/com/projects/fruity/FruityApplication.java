package com.projects.fruity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.projects.controllers", "com.projects.models"})
public class FruityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruityApplication.class, args);
	}

}
