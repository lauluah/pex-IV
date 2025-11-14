package org.example.service;

import org.example.exceptions.EmployeeNotfoundException;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDeleteService {

    EmployeeRepository employeeRepository;

    public EmployeeDeleteService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void deleteEmployeeService(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotfoundException("Funcionário não encontrado");
        }

        employeeRepository.deleteById(id);
    }
}
