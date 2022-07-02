package com.example.infra.Skill;

import com.example.infra.Criterion.CriterionModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillModel {
    @JsonProperty
    private long id;
    @JsonProperty
    private long criterioId;
    @JsonProperty
    private int level;

    public SkillModel() {
    }

    public SkillModel(long id, long criterioId, int level) {
        this.criterioId = criterioId;
        this.level = level;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCriterioId() {
        return criterioId;
    }

    public void setCriterioId(long criterioId) {
        this.criterioId = criterioId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
