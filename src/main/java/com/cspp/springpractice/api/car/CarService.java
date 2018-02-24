package com.cspp.springpractice.api.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cspp.springpractice.api.car.model.Car;

@Service
public class CarService {

	@Autowired
	CarManager carManager;

	public Car getCarById(long carId) {
		return carManager.getCarById(carId);
	}

	public Car createCar(Car car) {
		return carManager.createCar(car);
	}
}