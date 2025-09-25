package com.f_rafael.eureka_servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServidorApplication.class, args);
	}

}
