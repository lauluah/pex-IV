package org.example.controller;

import jakarta.validation.Valid;
import org.example.DTO.request.EmployeeDTOrequest;
import org.example.DTO.response.EmployeeDTOResponse;
import org.example.model.Employee;
import org.example.service.EmployeeCreatorService;
import org.example.service.EmployeeFilterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
   EmployeeFilterService employeeFilterService;
   EmployeeCreatorService employeeCreatorService;

    public EmployeeController(EmployeeFilterService employeeFilterService, EmployeeCreatorService employeeCreatorService) {
        this.employeeFilterService = employeeFilterService;
        this.employeeCreatorService = employeeCreatorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTOResponse createEmployee(@Valid @RequestBody EmployeeDTOrequest employeeDTOrequest) {
      return employeeCreatorService.createEmployeeService(employeeDTOrequest);
    }

    @GetMapping("/name")
    public List<Employee> getEmployeeByName(@RequestParam String name) {
        return employeeFilterService.getEmployeeByName(name);
    }

}
