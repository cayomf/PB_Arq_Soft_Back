package com.example.shared.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.external.repositories.CriterionRepository;
import com.example.external.repositories.SkillRepository;
import com.example.infra.Criterion.Criterion;
import com.example.infra.Criterion.CriterionModel;
import com.example.infra.Skill.Skill;
import com.example.infra.Skill.SkillModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.external.repositories.CandidacyRepository;
import com.example.infra.Candidacy.Candidacy;
import com.example.infra.Candidacy.CandidacyModel;
import com.example.shared.service.CandidacyService;

@Component
public class CandidacyServiceImpl  implements CandidacyService {

    @Autowired
    CandidacyRepository candidacyRepositorio;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    CriterionRepository criterionRepository;

    @Override
    public void create(CandidacyModel newCandidacy) {
        Candidacy candidacy = new Candidacy();
        double media = 0;
        double dividendo = 0;
        List<Skill> skills = new ArrayList<Skill>();

        candidacy.setVagaId(newCandidacy.getVagaId());
        candidacy.setCandidatoId(newCandidacy.getCandidatoId());


        for(SkillModel skillModel : newCandidacy.getSkills()){
            Skill skill = new Skill();
            Criterion criterion = criterionRepository.getById(Long.toString(skillModel.getCriterioId()));

            media = media + (skillModel.getLevel() * criterion.getPeso());
            dividendo = dividendo + criterion.getPeso();

            skill.setLevel(skillModel.getLevel());
            skill.setCriterioId(criterion.getId());
            skill.setCandidacyId(candidacy);

            skillRepository.save(skill);
        }
        candidacy.setMedia(media/dividendo);

        candidacyRepositorio.save(candidacy);
    }


//    @Override
//    public void edit(Candidacy candidacy) {
//        Candidacy newCandidacy = new Candidacy();
//        newCandidacy.setId(candidacy.getId());
//        newCandidacy.setVagaId(candidacy.getVagaId());
//        newCandidacy.setCandidatoId(candidacy.getCandidatoId());
//        newCandidacy.setSkills(candidacy.getSkills());
//
//        candidacyRepositorio.save(candidacy);
//    }

    @Override
    public void delete(String id) {
        Candidacy candidacy = candidacyRepositorio.getById(id);
        candidacyRepositorio.delete(candidacy);
    }

    @Override
    public List<Candidacy> getAll() {
        List<Candidacy> allCandidacies = candidacyRepositorio.findAll();

        return allCandidacies;
    }

    @Override
    public Candidacy get(String id) {
        Candidacy candidacy = candidacyRepositorio.getById(id);

        return candidacy;
    }

}
