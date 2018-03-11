package com.monix.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("spring-beans.xml")
public class BanqueKataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueKataApplication.class, args);
	}
}
