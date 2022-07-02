package com.example.shared.service;

import java.util.List;

import com.example.infra.Candidate.Candidate;
import com.example.infra.Candidate.CandidateModel;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {
    public Candidate get(String id);
    public void create(CandidateModel newCandidate);
    public void edit(Candidate editedCandidate);
    public void delete(String id);
    public List<Candidate> getAll();


}
