package com.cursojava.course;

import com.cursojava.course.entities.User;
import com.cursojava.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"));
			userRepository.save(new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"));
			System.out.println("Usuários inseridos!");
		};
	}

}
