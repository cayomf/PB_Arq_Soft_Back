package com.example.infra.Criterion;

import com.example.infra.Vacancy.Vacancy;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CriterionModel {
    @JsonProperty
    private long id;
    @JsonProperty
    private String descricao;

    @JsonProperty
    private int peso;
    
    public CriterionModel() {
    }

    public CriterionModel(String descricao, int peso, long id) {
        this.descricao = descricao;
        this.peso = peso;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
