package com.github.dexterbulaong.EmployeeManagementSystem.controllers;

import com.github.dexterbulaong.EmployeeManagementSystem.entity.Employee;
import com.github.dexterbulaong.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel) {

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employee/employee-form";
    }

    @PostMapping("/save")
    public String saveForm(@ModelAttribute("employee") Employee theEmployee) {

        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("employeeId") int id, Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employee/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

}
