package com.cspp.springpractice.api.car;

import org.springframework.data.repository.CrudRepository;

import com.cspp.springpractice.api.car.model.Car;

public interface CarManager extends CrudRepository<Car, Long> {
}
