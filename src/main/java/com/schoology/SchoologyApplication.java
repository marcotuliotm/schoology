package com.schoology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SchoologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoologyApplication.class, args);
	}

}
