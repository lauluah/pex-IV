package org.example.DTO.mapper;

import org.example.DTO.request.EmployeeDTOrequest;
import org.example.DTO.response.EmployeeDTOResponse;
import org.example.model.Employee;

import java.time.LocalDate;

public class EmployeeDOmapper {

    public static Employee toEtity(EmployeeDTOrequest employeeRequest) {
        Employee employee = new Employee();
        employee.setRole(employeeRequest.getRole());
        employee.setPhone(employeeRequest.getPhone());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setHireDate(LocalDate.parse(employeeRequest.getHireDate()));
        return employee;
    }

    public static EmployeeDTOResponse toResponse(Employee employee) {
        EmployeeDTOResponse employeeDTOResponse = new EmployeeDTOResponse();
        employeeDTOResponse.setName(employee.getName());
        employeeDTOResponse.setRole(employee.getRole());
        employeeDTOResponse.setPhone(employee.getPhone());
        return employeeDTOResponse;
    }
}
