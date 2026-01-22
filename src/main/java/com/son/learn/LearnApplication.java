package com.son.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
		System.out.println("Truy cập: http://localhost:8080");
		System.out.println("Endpoints:");
		System.out.println("   - http://localhost:8080/");
		System.out.println("   - http://localhost:8080/greet?name=YourName");
		System.out.println("   - http://localhost:8080/info");
	}

}
