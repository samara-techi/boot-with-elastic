package com.course.practicaljava.rest.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.practicaljava.repository.CarElasticRepository;
import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.service.CarService;

@RestController
@RequestMapping("/api/car/v1")
public class CarRestController {
	@Autowired
	private CarService carService;
	@Autowired
	private CarElasticRepository carElasticRepository;
	
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
	
	@GetMapping("/cars/count")
	public long carCount() {
		return carElasticRepository.count();
		
	}
	@PostMapping(path = "/cars", 
			     produces = MediaType.APPLICATION_JSON_VALUE)
	public Car createCar(@RequestBody Car car) {
		return carElasticRepository.save(car);
	}
	
	@GetMapping(path="/cars/{id}")
	public Car findCarById(@PathVariable String id) {
		Optional<Car> optional = carElasticRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@PutMapping(path = "/cars/{id}")
	public Car updateCarById(@PathVariable String id, @RequestBody Car car) {
		car.setId(id);
		return carElasticRepository.save(car);
	}
	
	@GetMapping(path = "/cars/{brand}/{color}")
	public List<Car> findCarsByPath(@PathVariable String brand, @PathVariable String color) {
		return carElasticRepository.findByBrandAndColor(brand, color);
	}
	
	//'brand', 'color' as request params
	@GetMapping("/cars")
	public List<Car> findCarsByParam(@RequestParam String brand, 
			                         @RequestParam String color) {
		return carElasticRepository.findByBrandAndColor(brand, color);
	}
	
	@GetMapping("/cars/date")
	public List<Car> findCarByReleaseDateAfter(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date releaseDate) {
		return carElasticRepository.findByFirstReleaseDateAfter(releaseDate.getTime());
	}
	
	@GetMapping("/cars/page")
	public List<Car> findCarsByParamPagination(@RequestParam String brand, 
			                         @RequestParam String color, 
			                         @RequestParam(defaultValue = "0") int page, 
			                         @RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return carElasticRepository.findByBrandAndColor(brand, color, pageable).getContent();
		
	}
	
	@GetMapping("/cars/page/{brand}/{color}")
	public List<Car> findCarsByPathPagination(@PathVariable String brand, @PathVariable String color, 
			                        @RequestParam(defaultValue = "0") int page, 
			                        @RequestParam(defaultValue = "10") int size) {
		//Displaying car data by price descending order. 
		Pageable pageable = PageRequest.of(page, size, Sort.by(Direction.DESC, "price"));
		return carElasticRepository.findByBrandAndColor(brand, color, pageable).getContent();
	}
	

}
