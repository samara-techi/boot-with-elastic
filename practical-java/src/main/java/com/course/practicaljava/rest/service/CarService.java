package com.course.practicaljava.rest.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.course.practicaljava.rest.domain.Car;


public interface CarService {
	
	List<String> BRANDS = Arrays.asList("Toyota", "Honda", "Ford");
	List<String> COLORS = Arrays.asList("red", "black", "white");
	List<String> TYPES = Arrays.asList("Sedan", "SUV", "MPV");
	List<String> ADDITIONAL_FEATURES = Arrays.asList("GPS", "AC", "Leather Seats", "Auto Gear", "Auto drive", "power boost", "Auto recharge");
	
	List<String> FUEL_TYPE = Arrays.asList("Petrol", "Electric", "Hybrid");
	List<String> TIRE_MANUFACTURERS = Arrays.asList("Goodyear", "Bridgestone", "Dunlop");
	
	Car generateCar() throws ParseException;
	
	List<Car> generateRandomCars() throws ParseException;

}
