package com.cspp.springpractice.api.car;

import com.cspp.springpractice.api.car.model.Car;

public interface CarService {

	Car getCarById(long carId);

	void createCar(Car car);
}
