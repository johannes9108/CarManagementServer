package com.ITHS.carmanagement.dataaccess;

import java.util.List;

import javax.ejb.Local;

import com.ITHS.carmanagement.domain.Car;

@Local
public interface CarManagementDao {
	Car createCar(Car newCar);

	Car removeCar(int id);

	Car getCar(int id);

	List<Car> getAllCars();

	List<Car> getAllCarsByBrand(String brand);

	Car updateCar(Car updateCar);
}
