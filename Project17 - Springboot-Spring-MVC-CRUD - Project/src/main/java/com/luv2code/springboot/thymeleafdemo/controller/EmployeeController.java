package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService theEmployeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        this.theEmployeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model theModel){
        List<Employee> employees = theEmployeeService.findAll();
        System.out.println(employees);  
        theModel.addAttribute("employees", employees);
        return "employees/list-employees";
    }
    @GetMapping("/showFormtoAdd")
    public String showAddForm(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        theEmployeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForupdate")
    public String updateEmployee(@RequestParam("employeeId") int employeeId, Model theModel){
        Employee theEmployee = theEmployeeService.findById(employeeId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId, Model theModel){
        theEmployeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }
}
