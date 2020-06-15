package com.course.practicaljava.rest.domain;

import java.util.Date;
import java.util.List;


public class Car {
	private String brand;
	private String color;
	private String type;
	private int price;
	private boolean available;
	
	private Date firstReleaseDate;
	private Engine engine;
	
	private List<String> additionalFeatures;
	private List<Tire> tires;
	
	public Car() {}
	public Car(String brand, String color, String type) {
		this.brand = brand;
		this.color = color;
		this.type = type;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Date getFirstReleaseDate() {
		return firstReleaseDate;
	}
	public void setFirstReleaseDate(Date firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}
	public List<String> getAdditionalFeatures() {
		return additionalFeatures;
	}
	public void setAdditionalFeatures(List<String> additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public List<Tire> getTires() {
		return tires;
	}
	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + 
			   ", type=" + type + ", price=" + price + ", available=" + available + 
			   ", first release date=" + firstReleaseDate + 
			   ", additional features "+ additionalFeatures + "]";
	}
}
