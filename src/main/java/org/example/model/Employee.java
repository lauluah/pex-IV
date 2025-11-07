package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Roles role;

    private LocalDate hireDate;

    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    public Employee() {
    }

    public Employee(long id, String name, LocalDate birthDate, String phone, Roles role, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.role = role;
        this.hireDate = hireDate;
    }
}
