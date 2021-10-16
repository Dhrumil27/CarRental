package com.dhrumil.CarRental;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dhrumil.CarRental.service._BootstrapService;

@SpringBootApplication
public class CarRentalApplication {
	
	@Autowired
	private _BootstrapService initService;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}
	
	/*load cars in database when application run */
	@PostConstruct
	public void init() {
		initService.run();
	}

}
