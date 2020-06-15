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
	
	Car generateCar() throws ParseException;

}
