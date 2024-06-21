package com.cruddemo.cruddemo.DAO;
import java.util.List;

import com.cruddemo.cruddemo.entity.Employee;
public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);;
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
