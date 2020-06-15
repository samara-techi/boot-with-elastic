package com.course.practicaljava.rest.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.util.RandomDateUtil;

@Service
public class RandomCarService implements CarService {
	
	private Random random = new Random();

	@Override
	public Car generateCar() throws ParseException {
		String randomBrand = BRANDS.get(random.nextInt(BRANDS.size()));
		String randomColor = COLORS.get(random.nextInt(COLORS.size()));
		String randomType = TYPES.get(random.nextInt(TYPES.size()));
		
		List<String> additionalFeatures = new ArrayList<>();
		int randomCount = random.nextInt(ADDITIONAL_FEATURES.size());
		for(int i = 1; i<=randomCount; i++) {
			additionalFeatures.add(ADDITIONAL_FEATURES.get(i-1));
		}
		
		Car car = new Car(randomBrand, randomColor, randomType);
		
		car.setAvailable(random.nextBoolean());
		car.setPrice(5000 + random.nextInt(7001));
		car.setFirstReleaseDate(RandomDateUtil.parseDate());
		
		car.setAdditionalFeatures(additionalFeatures);
		return car;
	}

	@Override
	public List<Car> generateRandomCars() throws ParseException {
		List<Car> cars = new ArrayList<>();
		for(int i = 0; i<random.nextInt(6); i++) {
			cars.add(generateCar());
		}
		return cars;
	}
}
