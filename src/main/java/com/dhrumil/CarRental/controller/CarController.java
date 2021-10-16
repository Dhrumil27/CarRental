package com.dhrumil.CarRental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhrumil.CarRental.model.CarEntity;
import com.dhrumil.CarRental.repository.CarJpa;
import com.dhrumil.CarRental.service.CarService;

@RestController
@RequestMapping({"/api"})
public class CarController {
	
	@Autowired
	CarJpa carJpa;
	
	@Autowired
	private CarService service;
	
	
	@GetMapping("/getFreeList")
	public ResponseEntity<List<CarEntity>> getFreeList() throws Exception {
		List<CarEntity> result = service.getFreeCars();
		if (result != null) {
			return new ResponseEntity<List<CarEntity>>(result, HttpStatus.OK);
		} else {
			throw new Exception("The free car is not exist", null);
		} 
	}
	
	@PostMapping("/rentCar/{id}")
	public ResponseEntity<Boolean> rentCar(@PathVariable Long id) throws Exception {
		boolean result = service.rentCar(id);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	
	@GetMapping("/getRentedList")
	public ResponseEntity<List<CarEntity>> getRentedList() throws Exception {
		List<CarEntity> result = service.getRentedCars();
		if (result != null) {
			return new ResponseEntity<List<CarEntity>>(result, HttpStatus.OK);
		} else {
			throw new Exception("The rent car is not exist", null);
		} 
	}
	
	
	@PostMapping("returnCar/{id}")
		public ResponseEntity<Boolean> returnCar(@PathVariable Long id) throws Exception {
			boolean result = service.returnCar(id);
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}

}
