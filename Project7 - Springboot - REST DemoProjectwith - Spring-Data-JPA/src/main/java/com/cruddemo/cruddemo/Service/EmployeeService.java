package com.cruddemo.cruddemo.Service;
import java.util.List;

import com.cruddemo.cruddemo.entity.*;
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);;
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
