//package com.example.shared.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.external.repositories.SkillRepository;
//import com.example.infra.Criterion.Criterion;
//import com.example.infra.Criterion.CriterionModel;
//import com.example.infra.Skill.Skill;
//import com.example.infra.Skill.SkillModel;
//import com.example.shared.service.SkillService;
//
//@Service
//public class SkillServiceImpl  implements SkillService {
//    @Autowired
//    SkillRepository skillRepository;
//
//    @Override
//    public void create(SkillModel newSkill) {
//        Skill skill = new Skill();
//        Criterion criterion = new Criterion();
//        CriterionModel criterionModel = newSkill.getCriterioId();
//
//        criterion.setId(criterionModel.getId());
//        criterion.setVagaId(criterionModel.getVagaId());
//        criterion.setDescricao(criterionModel.getDescricao());
//        criterion.setRelevancia(criterionModel.getRelevancia());
//        criterion.setPeso(criterionModel.getPeso());
//
//        skill.setId(newSkill.getId());
//        skill.setCriterioId(newSkill.getCriterioId());
//        skill.setLevel(newSkill.getLevel());
//
//        skillRepository.save(skill);
//    }
//
//    @Override
//    public void edit(Skill skill) {
//        Skill newSkill = new Skill();
//        newSkill.setId(skill.getId());
//        newSkill.setCriterioId(skill.getCriterioId());
//        newSkill.setLevel(skill.getLevel());
//
//        skillRepository.save(skill);
//    }
//
//    @Override
//    public void delete(String id) {
//        Skill skill = skillRepository.getById(id);
//        skillRepository.delete(skill);
//    }
//
//    @Override
//    public List<Skill> getAll() {
//        List<Skill> allSkills = skillRepository.findAll();
//        // List<User> listaResposta = new ArrayList<>();
//
//        // for (User user : allUsers){
//        //     User response = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
//        //     listaResposta.add(response);
//        // }
//        return allSkills;
//    }
//
//    @Override
//    public Skill get(String id) {
//        Skill skill = skillRepository.getById(id);
//        // User userResponse = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
//        return skill;
//    }
//
//}
