package com.ebartmedia.practiceexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackageClasses=com.ebartmedia.practiceexercise.model.Words.class)
@SpringBootApplication
public class WordApplication {
	
public static void main(String[] args) {
		
		SpringApplication.run(WordApplication.class, args);
	}

}
