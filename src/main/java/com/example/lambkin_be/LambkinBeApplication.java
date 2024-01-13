package com.example.lambkin_be;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EntityScan(basePackages = "com.example.lambkin_be")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class LambkinBeApplication {




	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(LambkinBeApplication.class, args);
	}

}
