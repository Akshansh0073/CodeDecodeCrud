package com.codedecode.CodeDecodeCrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Address {

	@Id
	private int addressId;
	private int zipCode;
	private String country;
	private String city;
	
	@ManyToOne
	@JoinColumn(name="Emp_id")
	private Employee emp;
	
	
	public Address() {
		super();
	}

	public Address(int addressId, int zipCode, String country, String city, Employee emp) {
		super();
		this.addressId = addressId;
		this.zipCode = zipCode;
		this.country = country;
		this.city = city;
		this.emp = emp;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", zipCode=" + zipCode + ", country=" + country + ", city=" + city
				+ ", emp=" + emp + "]";
	}
	
	
	
	

}
