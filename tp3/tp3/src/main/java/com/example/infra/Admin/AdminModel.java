package com.example.infra.Admin;

import com.example.infra.User.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AdminModel extends UserModel {
    @JsonProperty
    private String adminId;
    
    public AdminModel() {
    }

    public AdminModel(int id, String nome, String email, String telefone, boolean status, String endereco, String adminId) {
        super(id, nome, email, telefone, endereco, status);
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}

