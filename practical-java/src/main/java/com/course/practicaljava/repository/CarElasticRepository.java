package com.course.practicaljava.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.course.practicaljava.rest.domain.Car;

@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car, String> {
	
	public List<Car> findByBrandAndColor(String brand, String color);
	
	public List<Car> findByFirstReleaseDateAfter(long date);
	
	public Page<Car> findByBrandAndColor(String brand, String color, Pageable pagebale);

}
