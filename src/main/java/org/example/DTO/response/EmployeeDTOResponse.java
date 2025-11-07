package org.example.DTO.response;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Roles;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTOResponse {

    private String name;
    private LocalDate birthDate;
    private String phone;
    private Roles role;
    private LocalDate hireDate;

    public EmployeeDTOResponse(String name, LocalDate birthDate, String phone, Roles role, LocalDate hireDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.role = role;
        this.hireDate = hireDate;
    }

    public EmployeeDTOResponse() {
    }
}
