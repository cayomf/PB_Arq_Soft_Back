package com.example.external.repositories;

import com.example.infra.Vacancy.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infra.Criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, String>{

    List<Criterion> findAllByVagaId(Vacancy v);
}
