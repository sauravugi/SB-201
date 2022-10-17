package com.customer.entities;

public class Address {
	
	private String state;
	private String city;
	private String pin;
	private String type;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Address(String state, String city, String pin, String type) {
		super();
		this.state = state;
		this.city = city;
		this.pin = pin;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pin=" + pin + ", type=" + type + "]";
	}
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

}
