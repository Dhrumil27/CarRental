package com.dhrumil.CarRental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhrumil.CarRental.model.CarEntity;
import com.dhrumil.CarRental.repository.CarJpa;

@Transactional
@Service("carService")
public class CarService {
	
	@Autowired
	private CarJpa carDao;
	
	public CarJpa getCarDao() {
		return carDao;
	}
	
	/**
	 * Rent free car
	 * @return
	 * @throws Exception 
	 */
	public boolean rentCar(Long id) throws Exception {
		Optional<CarEntity> result = carDao.findById(id);
		if (!result.isPresent()) {
			throw new Exception("Car is not exist");
		} else {
			CarEntity car = result.get();
			if (car.getStatus() != CarEntity.STATUS_FREE) {
				throw new Exception("The car is not free now");
			}
			car.setStatus(CarEntity.STATUS_RENT);
			carDao.save(car);
		}
		return true;
	}
	
	/**
	 * Return rented car 
	 * @return
	 */
	public boolean returnCar(Long id) throws Exception {
		Optional<CarEntity> result = carDao.findById(id);
		if (!result.isPresent()) {
			throw new Exception("Car is not exist");
		} else {
			CarEntity car = result.get();
			if (car.getStatus() != CarEntity.STATUS_RENT) {
				throw new Exception("Car is returning now");
			}
			car.setStatus(CarEntity.STATUS_FREE);
			carDao.save(car);
		}
		return true;
	}
	
	
	
	/**
	 * Get information of rented cars 
	 * @return
	 */
	public List<CarEntity> getRentedCars() {
		List<CarEntity> result = carDao.findByStatus(CarEntity.STATUS_RENT);
		return result;
	}
	
	/**
	 * Get information of free cars
	 * @return
	 */
	public List<CarEntity> getFreeCars() {
		List<CarEntity> result = carDao.findByStatus(CarEntity.STATUS_FREE);
		return result;
	}

}
