package com.codedecode.CodeDecodeCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.CodeDecodeCrud.entity.Employee;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Long>{

}
