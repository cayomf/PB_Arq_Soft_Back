package com.example.shared.service;

import java.util.List;

import com.example.infra.Candidacy.Candidacy;
import com.example.infra.Candidacy.CandidacyModel;
import org.springframework.stereotype.Service;

@Service
public interface CandidacyService {
    public Candidacy get(String id);
    public void create(CandidacyModel newCandidacy);
//    public void edit(Candidacy editedCandidacy);
    public void delete(String id);
    public List<Candidacy> getAll();
}
