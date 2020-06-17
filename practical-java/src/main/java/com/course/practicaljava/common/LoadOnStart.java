package com.course.practicaljava.common;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.course.practicaljava.repository.CarElasticRepository;
import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.service.CarService;
import com.course.practicaljava.rest.service.RandomCarService;

@Component
public class LoadOnStart {
	@Autowired
	private CarElasticRepository elasticRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CarService randomCarService;
	
	@PostConstruct
	public void populateRandomCars() throws ParseException {
		System.out.println("before Delete");
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:9200/practical-java", HttpMethod.DELETE, null, String.class);
		
		System.out.println("DELETE result " + response.getBody());
		
		List<Car> cars = new ArrayList<>();
		for(int i = 0; i<5000; i++) {
			Car car = randomCarService.generateCar();
			cars.add(car);
		}
		elasticRepository.saveAll(cars);
		System.out.println("Total number of cars saved " + elasticRepository.count());
		
	}

}
