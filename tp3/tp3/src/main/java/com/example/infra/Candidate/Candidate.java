package com.example.infra.Candidate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.infra.User.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Candidate extends User {
    private String cpf;

    public Candidate() {
    }

    public Candidate(String cpf) {
        this.cpf = cpf;
    }

    public Candidate(String nome, String email, String telefone, boolean status, long id, String endereco, String cpf) {
        super(nome, email, telefone, status, id, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
