package com.example.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infra.Candidacy.Candidacy;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidacyRepository extends JpaRepository<Candidacy, String>{
    
}
