package org.example.service;

import org.example.DTO.request.EmployeeDTOrequest;
import org.example.exceptions.EmployeeNotfoundException;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeUpdateService {

    private final EmployeeRepository employeeRepository;

    public EmployeeUpdateService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee updateEmployee(Long id, EmployeeDTOrequest dto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotfoundException(
                                String.format("Funcionário com ID %s não encontrado", id))
                );

        if (dto.getName() != null) employee.setName(dto.getName());
        if (dto.getCpf() != null) employee.setCpf(dto.getCpf());
        if (dto.getRole() != null) employee.setRole(dto.getRole());
        if (dto.getPhone() != null) employee.setPhone(dto.getPhone());
        if (dto.getBirthDate() != null) employee.setBirthDate(dto.getBirthDate());

        return employeeRepository.save(employee);
    }
}
