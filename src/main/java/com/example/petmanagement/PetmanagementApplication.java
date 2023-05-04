package com.example.petmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
public class PetmanagementApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PetmanagementApplication.class);
		app.run(PetmanagementApplication.class, args);
	}

}
