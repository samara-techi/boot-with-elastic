package com.course.practicaljava.rest.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.service.CarService;

@RestController
@RequestMapping("/api/car/v1")
public class CarRestController {
	@Autowired
	private CarService carService;
	
	@GetMapping(path = "/random", 
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public Car random() throws ParseException {
		return carService.generateCar();
	}
	
	@PostMapping(path="/echo", 
			     consumes = MediaType.APPLICATION_JSON_VALUE)
	public String echo(@RequestBody Car car) {
		return car.toString();
	}
	
	@GetMapping(path = "/random-cars", 
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getRandomCars() throws ParseException {
		return carService.generateRandomCars();
	}	
	

}
