package com.example.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infra.Skill.Skill;

public interface SkillRepository extends JpaRepository<Skill, String>{

}
