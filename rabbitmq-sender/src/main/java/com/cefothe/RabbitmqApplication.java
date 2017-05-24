package com.cefothe;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class RabbitmqApplication {

	@Configuration
	@EnableScheduling
	public abstract class Config{

		@Bean
		public Queue hello(){
			return  new Queue("hello");
		}

		@Bean
		public Sender sender(){
			return new Sender();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}
}
