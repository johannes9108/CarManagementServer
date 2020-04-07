package com.ITHS.carmanagement.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ITHS.carmanagement.domain.Car;
import com.ITHS.carmanagement.service.CarManagementService;

@Stateless
@Path("/car")
public class CarResource {

	@Inject	
	private CarManagementService service;
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response createCar(Car newCar) {
		
		if(service.createCar(newCar)!=null)
			return Response.ok(newCar).build();
		else
			return Response.status(500).build();
	
	}
	@DELETE
    @Path("{id}")
    public void removeCar(@PathParam("id")int id) {
    	service.removeCar(id);
    }
	
	
	// GET
	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Car getCar(@PathParam("id")int id) {
    	return service.getCar(id);
    	
    }
	
	@GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Car> getAllCars(){
    	return service.getAllCars();
    }
	
	@GET
    @Path("/getByBrand/{brand}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Car> getAllCarsByBrand(@PathParam("brand") String brand){
    	System.out.println("---------------------------------------------------------- " + brand);
		return service.getAllCarsByBrand(brand);
    }
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void updateCar(Car updateCar) {
    	service.updateCar(updateCar);
    }
	
	
}
