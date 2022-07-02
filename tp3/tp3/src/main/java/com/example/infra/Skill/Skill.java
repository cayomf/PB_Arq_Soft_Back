package com.example.infra.Skill;

import javax.persistence.*;

import com.example.infra.Candidacy.Candidacy;
import org.hibernate.Criteria;

import com.example.infra.Criterion.Criterion;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;


@Entity
@Getter
@Setter
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private int level;
    private long criterioId;
    @ManyToOne(optional = false)
    @JoinColumn()
    private Candidacy candidacyId;

    public Skill() {
    }

    public Skill(long id, int level, long criterioId) {
        this.level = level;
        this.id = id;
        this.criterioId = criterioId;
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
