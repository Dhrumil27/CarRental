package com.dhrumil.CarRental.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhrumil.CarRental.model.CarEntity;

@Transactional
@Service("bootstrapService")
public class _BootstrapService {
	
	@Autowired
	private CarService carService;
	
	public _BootstrapService() {
	}
	
	public void run() {
		int countCar = (int) carService.getCarDao().count();
    	CarEntity car = null;
    	if (countCar == 0) {
    		for (int i = 0; i < 30; i++) {
    			car = new CarEntity();
    			car.setName("Car " + String.valueOf(i + 1));
    			car.setPrice((i + 1) * 100.0);
    			car.setStatus(CarEntity.STATUS_FREE);
    			carService.getCarDao().save(car);
    		}
    	}
    }
}
