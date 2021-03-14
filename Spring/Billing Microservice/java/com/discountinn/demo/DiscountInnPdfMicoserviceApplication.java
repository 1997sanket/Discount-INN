package com.discountinn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DiscountInnPdfMicoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountInnPdfMicoserviceApplication.class, args);
	}

}
