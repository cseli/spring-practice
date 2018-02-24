package com.cspp.springpractice.api.car;

import org.springframework.stereotype.Repository;

import com.cspp.springpractice.api.car.model.Car;

@Repository
public class CarManager {

	public Car getCarById(long carId) {
		return new Car(carId, "combi", "BMW");
	}

	public Car createCar(Car car) {
		return new Car(car.getId(), car.getType(), car.getBrand());
	}
}
