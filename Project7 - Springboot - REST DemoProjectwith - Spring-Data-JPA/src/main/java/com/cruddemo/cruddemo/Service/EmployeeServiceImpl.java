package com.cruddemo.cruddemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cruddemo.cruddemo.entity.Employee;


import com.cruddemo.cruddemo.DAO.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;

    //@Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
       Optional<Employee> theEmployee = employeeRepository.findById(id);
       Employee employee=null;
       if(theEmployee.isPresent()){
            employee = theEmployee.get();
       }
       else{
         throw new RuntimeException("Did not find employee with Id: "+id);
       }
       return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}
