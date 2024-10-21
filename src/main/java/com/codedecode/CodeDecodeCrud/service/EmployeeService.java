package com.codedecode.CodeDecodeCrud.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.CodeDecodeCrud.entity.Employee;
import com.codedecode.CodeDecodeCrud.repository.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		
		Employee savedEmp = crudRepo.save(emp);
		return savedEmp;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return crudRepo.findAll();
	}

	@Override
	public Employee findById(Long id) {
		
		return crudRepo.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		
		crudRepo.deleteById(id);
		
	}

	@Override
	public void updateById(Employee emp,Long id) {
		List<Employee> employees = crudRepo.findAll();

		employees.stream().map(b -> {
			if (b.getId() == id) {
				
				b.setId(emp.getId());
				b.setName(emp.getName());
				b.setLaptop(emp.getLaptop());
				b.setAddress(emp.getAddress());
			}
			return b;
		}
		).collect(Collectors.toList());
		
	}
}
