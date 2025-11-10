package org.example.service;

import org.example.exceptions.EmployeeNotfoundException;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeFilterService {
    private final EmployeeRepository employeeRepository;

    public EmployeeFilterService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeByName(String name) {
        List<Employee> employees = employeeRepository.findByName(name);
        if(employees.isEmpty()) {
            throw new EmployeeNotfoundException(String.format("Não foi possível encontrar funcionário com o nome: %s", name));
        }
        return employees;
    }

    public Employee getEmployeeByCpf(String cpf) {
        return employeeRepository.findByCpf(cpf)
                .orElseThrow(() ->
                        new EmployeeNotfoundException(
                                String.format("Não foi possível encontrar funcionário com o CPF: %s", cpf)
                        )
                );
    }

    public Employee getEmployeeById(Long employeeID) {
        return employeeRepository.findById(employeeID)
                .orElseThrow(() ->
                        new EmployeeNotfoundException(
                        String.format("Não foi possível encontrar funcionário com o ID: %s", employeeID)
                        )
                );
    }
}
