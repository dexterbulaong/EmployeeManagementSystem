package com.github.dexterbulaong.EmployeeManagementSystem.controllers;

import com.github.dexterbulaong.EmployeeManagementSystem.entity.Employee;
import com.github.dexterbulaong.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired // autowired is optional since there is only one constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employee/list-employees";

    }

}
