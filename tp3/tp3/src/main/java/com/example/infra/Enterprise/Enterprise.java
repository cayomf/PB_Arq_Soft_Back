package com.example.infra.Enterprise;

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
public class Enterprise extends User {
    private String cnpj;

    public Enterprise() {

    }

    public Enterprise(String cnpj) {
        this.cnpj = cnpj;
    }

    public Enterprise(String nome, String email, String telefone, long id, boolean status, String endereco, String cnpj) {
        super(nome, email, telefone, status, id, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
