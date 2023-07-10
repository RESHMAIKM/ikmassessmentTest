package com.ikm.assessmentest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikm.assessmentest.model.Employee;
import com.ikm.assessmentest.repository.EmployeeRepository;
import com.ikm.assessmentest.service.EmployeeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    EmployeeRepository employeeRepository;
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createCitizen(@Valid @RequestBody  Employee employee) {
        if (employee.getName() == null){
            return new ResponseEntity("Name must not be Empty", HttpStatus.BAD_REQUEST);
        }
        if (employee.getAddress().getHousename() == null){
            return new ResponseEntity("House name must not be Empty",HttpStatus.BAD_REQUEST);
        }

        else{
            Employee emp = employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Employee created");

        }
    }
}
