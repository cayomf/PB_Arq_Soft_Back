package com.example.shared.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.external.repositories.CriterionRepository;
import com.example.infra.Criterion.Criterion;
import com.example.infra.Criterion.CriterionModel;
import com.example.shared.service.CriterionService;

@Component
public class CriterionServiceImpl  implements CriterionService {

    @Autowired
    CriterionRepository criterionRepositorio;

    @Override
    public void create(CriterionModel newCriterion) {
//        Criterion criterion = new Criterion();
//        criterion.setId(newCriterion.getId());
//        criterion.setVagaId(newCriterion.getVagaId());
//        criterion.setDescricao(newCriterion.getDescricao());
//        criterion.setRelevancia(newCriterion.getRelevancia());
//        criterion.setPeso(newCriterion.getPeso());
//
//        criterionRepositorio.save(criterion);
    }

    @Override
    public void edit(Criterion criterion) {
        Criterion newCriterion = new Criterion();
        newCriterion.setId(criterion.getId());
        newCriterion.setVagaId(criterion.getVagaId());
        newCriterion.setDescricao(criterion.getDescricao());
        newCriterion.setPeso(criterion.getPeso());

        criterionRepositorio.save(criterion);
    }

    @Override
    public void delete(String id) {
        Criterion criterion = criterionRepositorio.getById(id);
        criterionRepositorio.delete(criterion);
    }

    @Override
    public List<Criterion> getAll() {
        List<Criterion> allCriteria = criterionRepositorio.findAll();
        // List<User> listaResposta = new ArrayList<>();

        // for (User user : allUsers){
        //     User response = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        //     listaResposta.add(response);
        // }
        return allCriteria;
    }

    @Override
    public Criterion get(String id) {
        Criterion criterion = criterionRepositorio.getById(id);
        // User userResponse = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        return criterion;
    }

}
