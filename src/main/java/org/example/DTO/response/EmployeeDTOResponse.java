package org.example.DTO.response;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Roles;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTOResponse {
    private long id;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private Roles role;
    private LocalDate hireDate;


    public EmployeeDTOResponse(long id, String name, LocalDate birthDate, String phone, Roles role, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.role = role;
        this.hireDate = hireDate;
    }

    public EmployeeDTOResponse() {
    }
}
