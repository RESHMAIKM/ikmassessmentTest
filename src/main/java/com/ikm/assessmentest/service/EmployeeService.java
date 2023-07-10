package com.ikm.assessmentest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikm.assessmentest.model.Employee;
import com.ikm.assessmentest.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeInterface {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}