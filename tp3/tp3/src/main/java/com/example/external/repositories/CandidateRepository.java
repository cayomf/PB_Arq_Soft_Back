package com.example.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infra.Candidate.Candidate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String>{

    Optional<Candidate> findByEmail(String email);
}
