package com.cruddemo.cruddemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruddemo.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

        
}
