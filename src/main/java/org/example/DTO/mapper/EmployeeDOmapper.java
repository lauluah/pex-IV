package org.example.DTO.mapper;

import org.example.DTO.request.EmployeeDTOrequest;
import org.example.DTO.response.EmployeeDTOResponse;
import org.example.model.Employee;

public class EmployeeDOmapper {

    public static Employee toEtity(EmployeeDTOrequest employeeRequest) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setRole(employeeRequest.getRole());
        employee.setPhone(employeeRequest.getPhone());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setHireDate(employeeRequest.getHireDate());
        employee.setCpf(employeeRequest.getCpf());
        return employee;
    }

    public static EmployeeDTOResponse toResponse(Employee employee) {
        EmployeeDTOResponse employeeDTOResponse = new EmployeeDTOResponse();
        employeeDTOResponse.setId(employee.getId());
        employeeDTOResponse.setName(employee.getName());
        employeeDTOResponse.setRole(employee.getRole());
        employeeDTOResponse.setBirthDate(employee.getBirthDate());
        employeeDTOResponse.setPhone(employee.getPhone());
        employeeDTOResponse.setHireDate(employee.getHireDate());
        return employeeDTOResponse;
    }
}
