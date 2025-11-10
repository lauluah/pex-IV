package org.example.service;

import org.example.DTO.mapper.EmployeeDOmapper;
import org.example.DTO.request.EmployeeDTOrequest;
import org.example.DTO.response.EmployeeDTOResponse;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCreatorService {
    EmployeeRepository employeeRepository;

    public EmployeeCreatorService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTOResponse createEmployeeService(EmployeeDTOrequest employeeDTOrequest) {
        Employee employee = EmployeeDOmapper.toEtity(employeeDTOrequest);
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeDOmapper.toResponse(createdEmployee);
    }
}
