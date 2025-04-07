package com.cursojava.course;

import com.cursojava.course.entities.Order;
import com.cursojava.course.entities.User;
import com.cursojava.course.repositories.OrderRepository;
import com.cursojava.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, OrderRepository orderRepository) {
		return args -> {

			if (userRepository.count() == 0) {

				Optional<User> user1 = userRepository.findById(1L);
				Optional<User> user2 = userRepository.findById(2L);

				if (user1.isPresent() && user2.isPresent()) {
					User u1 = user1.get();
					User u2 = user2.get();

					Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
					Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u2);
					Order o3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u2);

					orderRepository.saveAll(Arrays.asList(o1, o2, o3));
				}
				else {
					System.out.println("Usuário não encontrado");
				}
			}
			else {
				System.out.println("Já existe no banco!");
			}
		};
	}
}
