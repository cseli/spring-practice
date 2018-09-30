package com.cspp.springpractice.api.car;

import com.cspp.springpractice.util.exception.exception.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cspp.springpractice.api.car.model.Car;

@Service
public class LocalCarService implements CarService{

	@Autowired
	CarManager carManager;

	@Override
	public Car getCarById(long carId) {
		return carManager.findById(carId).orElseThrow(CarNotFoundException::new);
	}

	@Override
	public void createCar(Car car) {
		carManager.save(car);
	}
}
