package com.ITHS.carmanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ITHS.carmanagement.domain.Car;

@Stateless
public class CarManagementDaoImplementation implements CarManagementDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Car createCar(Car newCar) {
		em.persist(newCar);
		return newCar;
	}

	@Override
	public Car removeCar(int id) {
		Car car = em.find(Car.class, id);

		em.remove(car);
		return car;

	}

	@Override
	public Car getCar(int id) {
		return em.find(Car.class, id);
	}

	@Override
	public List<Car> getAllCars() {
		Query q = em.createQuery("select car from Car car");
		return q.getResultList();

	}

	@Override
	public List<Car> getAllCarsByBrand(String brand) {
		Query q = em.createQuery("select car from Car car WHERE car.brand = :brand");
		q.setParameter("brand", brand);

		return q.getResultList();
	}

	@Override
	public Car updateCar(Car updateCar) {
		em.merge(updateCar);
		return updateCar;
	}
}
