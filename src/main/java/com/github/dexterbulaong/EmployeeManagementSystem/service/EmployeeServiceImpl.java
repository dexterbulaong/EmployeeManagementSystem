package com.github.dexterbulaong.EmployeeManagementSystem.service;

import com.github.dexterbulaong.EmployeeManagementSystem.dao.EmployeeRepository;
import com.github.dexterbulaong.EmployeeManagementSystem.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()) {
            employee = result.get();
        }
        else {
            // employee with id not found
            throw new RuntimeException("Did not find employee id: " + id);
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
