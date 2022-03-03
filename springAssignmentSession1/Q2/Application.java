package com.example.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		Car car = new Car();
		car.set(new Audi());
		car.startProcess();
		car.set(new BMW());
		car.startProcess();
	}

}
