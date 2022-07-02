package com.example.infra.Candidate;

import com.example.infra.User.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CandidateModel extends UserModel {
    @JsonProperty
    private String cpf;

    public CandidateModel() {
    }

    public CandidateModel(String cpf) {
        this.cpf = cpf;
    }

    public CandidateModel(int id, String nome, String email, String telefone, String endereco, boolean status, String cpf) {
        super(id, nome, email, telefone, endereco, status);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
