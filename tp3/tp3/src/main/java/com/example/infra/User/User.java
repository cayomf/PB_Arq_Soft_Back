package com.example.infra.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "user_id")
    private long id;
    private String nome;
    private String email;
    private String telefone;

    private String endereco;
    private Boolean status;

    public User() {
    }

    public User(String nome, String email, String telefone, boolean status, long id, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
        this.endereco = endereco;
        this.status = status;
    }

}