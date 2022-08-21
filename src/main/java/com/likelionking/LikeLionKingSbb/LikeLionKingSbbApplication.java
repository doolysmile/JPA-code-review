package com.likelionking.LikeLionKingSbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA Auditing 활성화 = DB에 데이터 저장, 수정 감지하여 관리(main 클래스에 적용)
@EnableJpaAuditing
@SpringBootApplication
public class LikeLionKingSbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikeLionKingSbbApplication.class, args);
	}

}
