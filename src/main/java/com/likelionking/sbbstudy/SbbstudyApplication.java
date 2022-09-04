package com.likelionking.sbbstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SbbstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbbstudyApplication.class, args);
	}

}
