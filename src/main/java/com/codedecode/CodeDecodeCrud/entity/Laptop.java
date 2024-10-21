package com.codedecode.CodeDecodeCrud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "laptops")

public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int laptopId;
	private String modelNumber;
	private String brand;
	
	// Not making two different foreign key column one is already created in employee
	@OneToOne(mappedBy = "laptop")
	// For bidirectional purpose this is child class to back reference
	@JsonBackReference
	private Employee emp;
	
	public Laptop() {
		super();
	}

	public Laptop(int laptopId, String modelNumber, String brand, Employee emp) {
		super();
		this.laptopId = laptopId;
		this.modelNumber = modelNumber;
		this.brand = brand;
		this.emp = emp;
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", modelNumber=" + modelNumber + ", brand=" + brand + ", emp=" + emp
				+ "]";
	}
	
	

}
