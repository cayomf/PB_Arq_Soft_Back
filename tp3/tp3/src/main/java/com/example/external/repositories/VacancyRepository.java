package com.example.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infra.Vacancy.Vacancy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, String>{

    List<Vacancy> findAllByStatus(int i);

    List<Vacancy> findAllByEmpresaId(String id);

    @Modifying
    Vacancy findById(Long vacancyId);
}