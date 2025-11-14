package org.example.service;

import org.example.exceptions.EmployeeNotfoundException;
import org.example.model.Employee;
import org.example.model.Roles;
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

    public List<Employee> getEmployeesByRole(Roles role) {
        List<Employee> employees = employeeRepository.findByRole(role);
        if (employees.isEmpty()) {
            throw new EmployeeNotfoundException("Nenhum funcionário encontrado com o papel: " + role);
        }
        return employees;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new EmployeeNotfoundException("Nenhum funcionário encontrado: ");
        }
        return employees;
    }

}
