package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private LocalDate aniversario;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Cargos cargo;

    private LocalDate dataDeContratacao;

    public Funcionario(long id, String nome, LocalDate aniversario, String phone, Cargos cargo, LocalDate dataDeContratacao) {
        this.id = id;
        this.nome = nome;
        this.aniversario = aniversario;
        this.phone = phone;
        this.cargo = cargo;
        this.dataDeContratacao = dataDeContratacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(LocalDate dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }
}
