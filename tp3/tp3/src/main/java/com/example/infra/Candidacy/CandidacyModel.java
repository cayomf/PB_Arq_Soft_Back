package com.example.infra.Candidacy;

import java.util.List;

import com.example.infra.Skill.SkillModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidacyModel {

    @JsonProperty
    private String vagaId;
    @JsonProperty
    private String candidatoId;
    @JsonProperty
    private List<SkillModel> skills;
    
    public CandidacyModel() {
    }

    public CandidacyModel(String vagaId, String candidatoId, long id) {
        this.vagaId = vagaId;
        this.candidatoId = candidatoId;
//        this.skills = skills;
    }

    public String getVagaId() {
        return vagaId;
    }

    public void setVagaId(String vagaId) {
        this.vagaId = vagaId;
    }

    public String getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(String candidatoId) {
        this.candidatoId = candidatoId;
    }


}
