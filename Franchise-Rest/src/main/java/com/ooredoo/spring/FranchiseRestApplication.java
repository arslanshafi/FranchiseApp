package com.ooredoo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.ooredoo.persistence.repository")
@EntityScan(basePackages = {"com.ooredoo.persistence.model"})
@SpringBootApplication
@ComponentScan(basePackages = {"com.ooredoo.rest.controller",
		"com.ooredoo.spring",
		"com.ooredoo.persistence.model",
		"com.ooredoo.service",
		"com.ooredoo.util",
		"com.ooredoo.exception"})
public class FranchiseRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranchiseRestApplication.class, args);
	}

}
