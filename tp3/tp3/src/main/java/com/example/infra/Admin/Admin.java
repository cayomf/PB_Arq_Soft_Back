package com.example.infra.Admin;

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
public class Admin extends User {
    private String adminId;

    public Admin() {
    }

    public Admin(String adminId) {
        this.adminId = adminId;
    }

    public Admin(String nome, String email, String telefone, boolean status, int id, String endereco, String adminId) {
        super(nome, email, telefone, status, id, endereco);
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
