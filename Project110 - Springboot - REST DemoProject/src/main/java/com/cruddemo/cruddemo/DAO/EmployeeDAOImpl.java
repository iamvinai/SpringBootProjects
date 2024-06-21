package com.cruddemo.cruddemo.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cruddemo.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    //@Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> thTypedQuery = entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> employeeList = thTypedQuery.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee Employee) {
        Employee theEmployee = entityManager.merge(Employee);
        return theEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(theEmployee);
    }

}
