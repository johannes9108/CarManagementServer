package com.ITHS.carmanagement.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ITHS.carmanagement.dataaccess.CarManagementDao;
import com.ITHS.carmanagement.domain.Car;

@Stateless
public class CarManagementServiceImplementation implements CarManagementService {

	@Inject
	private CarManagementDao dao;
	
	@Override
	public Car createCar(Car newCar) {
		return dao.createCar(newCar);
	}

	@Override
	public Car removeCar(int id) {
		return dao.removeCar(id);
	}

	@Override
	public Car getCar(int id) {
		return dao.getCar(id);
	}

	@Override
	public List<Car> getAllCars() {
		return dao.getAllCars();
	}

	@Override
	public List<Car> getAllCarsByBrand(String brand) {
		return dao.getAllCarsByBrand(brand);
	}

	@Override
	public Car updateCar(Car updateCar) {
		return dao.updateCar(updateCar);
	}

}
