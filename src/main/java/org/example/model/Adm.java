package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adm")
@Getter
@Setter
public class Adm {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login;
    private String password;

    public Adm(String id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
