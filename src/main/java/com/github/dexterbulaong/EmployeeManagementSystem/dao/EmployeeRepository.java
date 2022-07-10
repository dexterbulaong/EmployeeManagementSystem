package com.github.dexterbulaong.EmployeeManagementSystem.dao;

import com.github.dexterbulaong.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // JPARepository provides all of the functionality for EmployeeRepository

    public List<Employee> findAllByOrderByLastNameAsc();
}
