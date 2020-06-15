package com.course.practicaljava.rest.domain;

public class Tire {
	private String manufacturer;
	private int size;
	private int price;
	
	//no arg constructor
	public Tire() {}
	//arg constructor
	public Tire(String manufacturer, int size, int price) {
		this.manufacturer = manufacturer;
		this.size = size;
		this.price = price;
	}
	
	//generate getters and setters
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//toString()
	@Override
	public String toString() {
		return "Tire [manufacturer=" + manufacturer + ", size=" + size + ", price=" + price + "]";
	}
}
