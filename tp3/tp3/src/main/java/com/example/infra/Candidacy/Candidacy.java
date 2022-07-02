package com.example.infra.Candidacy;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Candidacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Candidacy_id")
    private long candidacyId;
    private String vagaId;
    private String candidatoId;
    private Double media;

    public Candidacy() {
    }

    public Candidacy(String vagaId, String candidatoId, long candidacyId) {
        this.vagaId = vagaId;
        this.candidatoId = candidatoId;
        this.candidacyId = candidacyId;
    }
}
