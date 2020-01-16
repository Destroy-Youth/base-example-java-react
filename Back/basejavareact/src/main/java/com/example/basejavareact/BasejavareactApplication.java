package com.example.basejavareact;

import com.example.basejavareact.services.service.IPersonsService;
import com.example.basejavareact.services.service.Impl.PersonsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasejavareactApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasejavareactApplication.class, args);
	}

	@Bean
	public IPersonsService personsService() {
		return new PersonsService();
	}

}
