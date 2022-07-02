package com.example.infra.Vacancy;

import java.util.List;

import javax.persistence.*;

import com.example.infra.Criterion.Criterion;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaga_id", nullable = false)
    private int id;
    private String empresaId;
    private String dataCriacao;
    private String cargo;
    private String endereco;
    private String status;
    private double salario;

    public Vacancy() {
    }

    public Vacancy(int id, String empresaId, String dataCriacao, String cargo, String endereco, String status, double salario) {
        this.id = id;
        this.empresaId = empresaId;
        this.dataCriacao = dataCriacao;
        this.cargo = cargo;
        this.endereco = endereco;
        this.status = status;
        this.salario = salario;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String complemento) {
        this.endereco = complemento;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double id) {
        this.salario = salario;
    }
}
