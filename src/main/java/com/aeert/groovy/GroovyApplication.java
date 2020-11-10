package com.aeert.groovy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GroovyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroovyApplication.class, args);
	}

}
