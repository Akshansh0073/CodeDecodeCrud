package com.codedecode.CodeDecodeCrud.service;

import java.util.List;

import com.codedecode.CodeDecodeCrud.entity.Employee;

public interface EmployeeServiceInterface {


	public Employee addEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee findById(Long id);

	public void deleteById(Long id);

	public void updateById(Employee emp,Long id);

	

}
