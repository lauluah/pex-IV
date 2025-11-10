package org.example.DTO.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Roles;
import org.hibernate.validator.constraints.br.CPF;



import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTOrequest {

    @NotBlank(message = "O nome é obrigatório.")
    private String name;

    @Past(message = "A data de nascimento deve estar no passado.")
    private LocalDate birthDate;

    @NotBlank(message = "O telefone é obrigatório.")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Roles role;

    @NotBlank(message = "The CPF is required and cannot be blank.")
    @CPF(message = "The CPF format is invalid. Please enter a valid CPF.")
    private String cpf;


    public EmployeeDTOrequest(String name, LocalDate birthDate, String phone, LocalDate hireDate, Roles role) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.hireDate = hireDate;
        this.role = role;
    }

    public EmployeeDTOrequest() {
    }
}
