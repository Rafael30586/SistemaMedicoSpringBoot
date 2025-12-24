package com.f_rafael.farmacia_servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FarmaciaServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaServicioApplication.class, args);
	}

}
