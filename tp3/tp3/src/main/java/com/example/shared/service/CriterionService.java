package com.example.shared.service;

import java.util.List;

import com.example.infra.Criterion.Criterion;
import com.example.infra.Criterion.CriterionModel;
import org.springframework.stereotype.Service;

@Service
public interface CriterionService {
    public Criterion get(String id);
    public void create(CriterionModel newCriterion);
    public void edit(Criterion editedCriterion);
    public void delete(String id);
    public List<Criterion> getAll();
}
