package com.course.practicaljava.rest.domain;

public class Engine {
	private String fuelType;
	private int horsePower;
	
	//generate no arg constructor
	public Engine() {}
	//generate constructor with args
	public Engine(String fuelType, int horsePower) {
		this.fuelType = fuelType;
		this.horsePower = horsePower;
	}
	
	//getters and setters.
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	//generate toString.
	@Override
	public String toString() {
		return "Engine [fuelType=" + fuelType + ", horsePower=" + horsePower + "]";
	}
}
