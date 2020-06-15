package com.course.practicaljava.rest.domain;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Car {
	private String brand;
	private String color;
	private String type;
	private int price;
	private boolean available;
	private Date firstReleaseDate;
	
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
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", type=" + type + ", price=" + price + ", available=" + available + ", first release date=" + firstReleaseDate + "]";
	}
}
