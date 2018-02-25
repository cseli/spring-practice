package com.cspp.springpractice.api.car.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {

	@Id
	@NotNull
	@Min(4)
	private long id;
	@NotNull
	@Size(min = 2, max = 10)
	private String type;
	@NotNull
	@Size(min = 2, max = 20)
	private String brand;

	public Car() {
	}

	public Car(long licencePlate, String type, String brand) {
		this.id = licencePlate;
		this.type = type;
		this.brand = brand;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
