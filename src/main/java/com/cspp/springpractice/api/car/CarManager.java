package com.cspp.springpractice.api.car;

import org.springframework.stereotype.Repository;

import com.cspp.springpractice.api.car.model.Car;

@Repository
public class CarManager {

	public Car getCarById(long carId) {
		return new Car(carId, "combi", "BMW");
	}

	public void createCar(Car car) {
		return;
	}
}
