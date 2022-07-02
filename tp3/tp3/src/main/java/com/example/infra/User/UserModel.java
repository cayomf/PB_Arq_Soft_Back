package com.example.infra.User;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
    @JsonProperty
    private int id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String email;
    @JsonProperty
    private String telefone;

    @JsonProperty
    private String endereco;
    @JsonProperty
    private String cpf;
    @JsonProperty
    private String cnpj;
    @JsonProperty
    private String adminId;
    @JsonProperty
    private int accountType;
    @JsonProperty
    private boolean status;

    public UserModel() {
    }

    public UserModel(int id, String nome, String email, String telefone, String endereco, boolean status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean value) {
        this.status = value;
    }
}