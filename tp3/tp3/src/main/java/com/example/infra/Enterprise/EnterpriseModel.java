package com.example.infra.Enterprise;

import com.example.infra.User.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EnterpriseModel extends UserModel {
    @JsonProperty
    private String cnpj;
    
    public EnterpriseModel() {

    }

    public EnterpriseModel(String cnpj) {
        this.cnpj = cnpj;
    }

    public EnterpriseModel(int id, String nome, String email, String telefone, boolean status, String endereco, String cnpj) {
        super(id, nome, email, telefone, endereco, status);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
