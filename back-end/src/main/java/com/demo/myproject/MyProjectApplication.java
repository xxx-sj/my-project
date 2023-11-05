package com.demo.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	//임시 Bean
	@Bean
	public AuditorAware<String> auditorProvider() {
		//spring security를 사용한다면 holder에서 session정보를 꺼내서 해주어야한다.
		return () -> Optional.of(UUID.randomUUID().toString());
	}
}
