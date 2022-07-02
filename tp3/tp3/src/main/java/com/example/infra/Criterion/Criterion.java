package com.example.infra.Criterion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.infra.Vacancy.Vacancy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Criterion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "criterion_id", nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vacancy vagaId;
    private String descricao;
    private int peso;

    public Criterion() {
    }

    public Criterion(Vacancy vagaId, String descricao, int peso, long id) {
        this.vagaId = vagaId;
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

    public Vacancy getVagaId() {
        return vagaId;
    }

    public void setVagaId(Vacancy vagaId) {
        this.vagaId = vagaId;
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
