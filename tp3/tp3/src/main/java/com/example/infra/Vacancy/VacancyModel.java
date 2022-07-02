package com.example.infra.Vacancy;

import java.util.List;

import com.example.infra.Criterion.CriterionModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VacancyModel {
    @JsonProperty
    private int id;
    @JsonProperty
    private String empresaId;
    @JsonProperty
    private String dataCriacao;
    @JsonProperty
    private String cargo;

    @JsonProperty
    private String endereco;
    @JsonProperty
    private String status;
    private double salario;
    @JsonProperty
    private List<CriterionModel> criterios;
    
    public VacancyModel() {
    }

    public VacancyModel(int id, String empresaId, String dataCriacao, String cargo, String endereco, String status, double salario
            ) {
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

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CriterionModel> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<CriterionModel> criterios) {
        this.criterios = criterios;
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

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
