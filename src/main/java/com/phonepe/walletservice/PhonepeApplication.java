package com.phonepe.walletservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhonepeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonepeApplication.class, args);
		System.out.println("Welcome to PhonePe");
	}

}
