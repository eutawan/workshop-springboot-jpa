package com.cursojava.course;

import com.cursojava.course.entities.Order;
import com.cursojava.course.entities.User;
import com.cursojava.course.entities.enums.OrderStatus;
import com.cursojava.course.repositories.OrderRepository;
import com.cursojava.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, OrderRepository orderRepository) {
		return args -> {

			User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
			User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

			userRepository.saveAll(Arrays.asList(u1, u2));

			Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
			Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);
			Order o3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);

			orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		};
	}
}
