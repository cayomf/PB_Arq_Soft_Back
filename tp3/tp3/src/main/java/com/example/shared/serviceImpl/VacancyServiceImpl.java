package com.example.shared.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.external.repositories.CriterionRepository;
import com.example.infra.Criterion.Criterion;
import com.example.infra.Criterion.CriterionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.external.repositories.VacancyRepository;
import com.example.infra.Vacancy.Vacancy;
import com.example.infra.Vacancy.VacancyModel;
import com.example.shared.service.VacancyService;

@Component
public class VacancyServiceImpl implements VacancyService {
    
    @Autowired
    VacancyRepository vacancyRepositorio;
    @Autowired
    CriterionRepository criterionRepository;

    @Override
    public List<VacancyModel> getAllVacancyByStatus() throws SQLException {
        List<VacancyModel> vacancyModels = new ArrayList<>();
        VacancyModel vacancyModel;
        List<CriterionModel>criterionModels;
        List<Vacancy> vacancies = vacancyRepositorio.findAllByStatus(1);
        for (Vacancy v : vacancies){
            criterionModels = new ArrayList<>();
            vacancyModel = new VacancyModel(v.getId(),v.getEmpresaId(),v.getDataCriacao(),v.getCargo(),v.getEndereco(),v.getStatus(),v.getSalario());
            List<Criterion> criterionList = criterionRepository.findAllByVagaId(v);
            for (Criterion c: criterionList){
                CriterionModel criterionModel = new CriterionModel(c.getDescricao(), c.getPeso(),c.getId());
                criterionModels.add(criterionModel);
            }
            vacancyModel.setCriterios(criterionModels);
            vacancyModels.add(vacancyModel);
        }
        return vacancyModels;
    }

    @Override
    public void create(VacancyModel newVacancy) {
        Vacancy vacancy = new Vacancy();

        vacancy.setId(newVacancy.getId());
        vacancy.setEmpresaId(newVacancy.getEmpresaId());
        vacancy.setDataCriacao(newVacancy.getDataCriacao());
        vacancy.setCargo(newVacancy.getCargo());
        vacancy.setStatus(newVacancy.getStatus());
        vacancy.setEndereco(newVacancy.getEndereco());
        vacancy.setSalario(newVacancy.getSalario());
        vacancyRepositorio.save(vacancy);
        for (CriterionModel criterionModel : newVacancy.getCriterios()){
            Criterion criterion = new Criterion(vacancy,criterionModel.getDescricao(),criterionModel.getPeso(),criterionModel.getId());
            criterionRepository.save(criterion);
        }
    }

    @Override
    public void edit(VacancyModel vacancy) {
        Vacancy newVacancy = new Vacancy();
        newVacancy.setId(vacancy.getId());
        newVacancy.setEmpresaId(vacancy.getEmpresaId());
        newVacancy.setDataCriacao(vacancy.getDataCriacao());
        newVacancy.setCargo(vacancy.getCargo());
        newVacancy.setStatus(vacancy.getStatus());
        newVacancy.setEndereco(vacancy.getEndereco());

        vacancyRepositorio.save(newVacancy);
    }

    @Override
    public void delete(String id) {
        Vacancy vacancy = vacancyRepositorio.getById(id);
        vacancyRepositorio.delete(vacancy);
    }

    @Override
    public List<VacancyModel> getAll() {
        List<Vacancy> allVacancies = vacancyRepositorio.findAll();
        List<VacancyModel> allVancancyObjs = new ArrayList<>();

        for (Vacancy vacancy : allVacancies) {
            VacancyModel vacancyModelObj = new VacancyModel();
            List<Criterion> criteria = criterionRepository.findAllByVagaId(vacancy);
            List<CriterionModel> criteriaModelObjs = new ArrayList<>();

            vacancyModelObj.setId(vacancy.getId());
            vacancyModelObj.setCargo(vacancy.getCargo());
            vacancyModelObj.setStatus(vacancy.getStatus());
            vacancyModelObj.setEndereco(vacancy.getEndereco());
            vacancyModelObj.setDataCriacao(vacancy.getDataCriacao());
            vacancyModelObj.setEmpresaId(vacancy.getEmpresaId());
            vacancyModelObj.setSalario(vacancy.getSalario());

            for (Criterion criterion : criteria) {
                CriterionModel criterionModelObj = new CriterionModel();

                criterionModelObj.setId(criterion.getId());
                criterionModelObj.setDescricao(criterion.getDescricao());
                criterionModelObj.setPeso(criterion.getPeso());

                criteriaModelObjs.add(criterionModelObj);
            }

            vacancyModelObj.setCriterios(criteriaModelObjs);

            allVancancyObjs.add(vacancyModelObj);
        }

        return allVancancyObjs;
    }



    @Override
    public List<VacancyModel> getVacancyForEnterprise(String id) {
        List<VacancyModel> vacancyModels = new ArrayList<>();
        VacancyModel vacancyModel;
        List<CriterionModel>criterionModels;
        List<Vacancy> vacancies = vacancyRepositorio.findAllByEmpresaId(id);
        for (Vacancy v : vacancies){
            criterionModels = new ArrayList<>();
            vacancyModel = new VacancyModel(v.getId(),v.getEmpresaId(),v.getDataCriacao(),v.getCargo(),v.getEndereco(),v.getStatus(),v.getSalario());
            List<Criterion> criterionList = criterionRepository.findAllByVagaId(v);
            for (Criterion c: criterionList){
                CriterionModel criterionModel = new CriterionModel(c.getDescricao(), c.getPeso(),c.getId());
                criterionModels.add(criterionModel);
            }
            vacancyModel.setCriterios(criterionModels);
            vacancyModels.add(vacancyModel);
        }
        return vacancyModels;
    }

    @Override
    public void updateVacancyStatus(Long vacancyId, String newStatus) {
        Vacancy vacancy = vacancyRepositorio.findById(vacancyId);
        vacancy.setStatus(newStatus);
        vacancyRepositorio.save(vacancy);
    }

    @Override
    public void reOpen(Long vacancyId, String newStatus, String newDate) {
        Vacancy vacancy = vacancyRepositorio.findById(vacancyId);
        vacancy.setStatus(newStatus);
        vacancy.setDataCriacao(newDate);
        vacancyRepositorio.save(vacancy);
    }

    @Override
    public Vacancy get(String id) {
        Vacancy vacancy = vacancyRepositorio.getById(id);

        return vacancy;
    }
}
