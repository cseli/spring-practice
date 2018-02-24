package com.cspp.springpractice.api.car;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cspp.springpractice.api.car.model.Car;
import com.cspp.springpractice.api.response.ErrorResponse;

@RestController
@RequestMapping("/v1/car")
@Validated
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping(value = "/{carId}", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(OK)
	public Car getCarById(@PathVariable long carId) {
		return carService.getCarById(carId);
	}

	@RequestMapping(value = "/create", method = POST, produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(ACCEPTED)
	public void createCar(@Valid @RequestBody Car car) {
		carService.createCar(car);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(BAD_REQUEST)
	@ResponseBody
	public ErrorResponse invalidParameter() {
		return new ErrorResponse(BAD_REQUEST.toString(), "Invalid parameter(s)");
	}

}
