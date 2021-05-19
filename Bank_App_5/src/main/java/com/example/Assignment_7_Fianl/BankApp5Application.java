package com.example.Assignment_7_Fianl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.Assignment_7_Fianl.Repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BankApp5Application {

	public static void main(String[] args) {
		SpringApplication.run(BankApp5Application.class, args);
	}

}
