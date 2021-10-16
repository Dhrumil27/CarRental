package com.dhrumil.CarRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhrumil.CarRental.model.CarEntity;

public interface CarJpa extends JpaRepository<CarEntity, Long> {
	
	public List<CarEntity> findByStatus(byte status);

}
