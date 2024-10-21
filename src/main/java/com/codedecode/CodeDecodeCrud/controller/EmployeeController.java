package com.codedecode.CodeDecodeCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.CodeDecodeCrud.entity.Employee;
import com.codedecode.CodeDecodeCrud.entity.Laptop;
import com.codedecode.CodeDecodeCrud.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		
		Employee savedEmp = employeeServiceInterface.addEmployee(emp);
		return  new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> listEmp = employeeServiceInterface.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(listEmp, HttpStatus.OK);
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Long id){
		Employee emp = employeeServiceInterface.findById(id);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable Long id){
		employeeServiceInterface.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity <Employee> updateEmployee (@RequestBody Employee emp,
			@PathVariable Long id ){
		
		employeeServiceInterface.updateById(emp,id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
	}
			
	

}
