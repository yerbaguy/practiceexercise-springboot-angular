package com.ebartmedia.practiceexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EntityScan(basePackageClasses=com.ebartmedia.practiceexercise.model.Words.class)
@EntityScan
@SpringBootApplication
//@SpringBootApplication(scanBasePackages="com.ebartmedia.practiceexercise.repository.WordsRepository")
//@EnableJpaRepositories("com.ebartmedia.practiceexercise.model")
@EnableJpaRepositories
public class WordApplication {
	
public static void main(String[] args) {
		
		SpringApplication.run(WordApplication.class, args);
	}

}
