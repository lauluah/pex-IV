package org.example.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.example.DTO.request.EmployeeDTOrequest;
import org.example.DTO.response.EmployeeDTOResponse;
import org.example.model.Employee;
import org.example.model.Roles;
import org.example.service.EmployeeCreatorService;
import org.example.service.EmployeeFilterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.io.OutputStream;
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

    @GetMapping("/employees/pdf")
    public void exportEmployeesPDF(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=funcionarios.pdf");

        List<Employee> employees = employeeFilterService.getAllEmployees();

        try (OutputStream out = response.getOutputStream()) {
            com.lowagie.text.Document document = new com.lowagie.text.Document();
            com.lowagie.text.pdf.PdfWriter.getInstance(document, out);
            document.open();

            document.add(new com.lowagie.text.Paragraph("Lista de Funcionários\n\n"));

            for (Employee f : employees) {
                document.add(new com.lowagie.text.Paragraph(
                        "Nome: " + f.getName() +
                                ", Cargo: " + f.getRole() +
                                ", Data de entrada: " + f.getHireDate()
                ));
            }

            document.close();
        }
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

    @GetMapping("/role")
    public List<Employee> getEmployeeByRole(@RequestParam Roles role) {
        return employeeFilterService.getEmployeesByRole(role);
    }

    @GetMapping("/cpf")
    public Employee getEmployeeByCPF(@RequestParam String cpf) {
        return employeeFilterService.getEmployeeByCpf(cpf);
    }

    @GetMapping("/id")
    public Employee getEmployeeByID(@RequestParam Long id) {
        return employeeFilterService.getEmployeeById(id);
    }

}
