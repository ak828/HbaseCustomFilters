package com.test.program;

import java.io.Serializable;

public class AddressClass implements Serializable {

	int houseNum;
	String street;
	String city;

	public AddressClass(int houseNum, String street, String city) {
		super();
		this.houseNum = houseNum;
		this.street = street;
		this.city = city;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AddressClass [houseNum=" + houseNum + ", street=" + street + ", city=" + city + "]";
	}
}
