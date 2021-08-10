package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("https.protocols", "TLSv1.1");
		SpringApplication.run(DemoApplication.class, args);
	}

}
