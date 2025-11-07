package org.example.service;

import org.example.repository.EmployeeRepository;

public class EmployeeCreatorService {
    EmployeeRepository employeeRepository;

    public EmployeeCreatorService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


}
