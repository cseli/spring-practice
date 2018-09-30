package com.cspp.springpractice.api.car;

import com.cspp.springpractice.api.car.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/car")
@Validated
public class CarController {

    @Autowired
    private CarService localCarService;

    @RequestMapping(value = "/{carId}", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Car getCarById(@PathVariable long carId) {
        return localCarService.getCarById(carId);
    }

    @RequestMapping(value = "/create", method = POST, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(ACCEPTED)
    public void createCar(@Valid @RequestBody Car car) {
        localCarService.createCar(car);
    }
}
