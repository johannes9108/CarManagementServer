package com.ITHS.carmanagement.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.ITHS.carmanagement.domain.Car;

@Local
public interface CarManagementService {
	public Car createCar(Car newCar);
    public Car removeCar(int id);
    public Car getCar(int id);
    List<Car> getAllCars();
    List<Car> getAllCarsByBrand(String brand);
    public Car updateCar(Car updateCar);
}
