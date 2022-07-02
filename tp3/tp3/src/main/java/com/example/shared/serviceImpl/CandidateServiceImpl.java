package com.example.shared.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.external.repositories.CandidateRepository;
import com.example.infra.Candidate.Candidate;
import com.example.infra.Candidate.CandidateModel;
import com.example.shared.service.CandidateService;

@Component
public class CandidateServiceImpl  implements CandidateService {

    @Autowired
    CandidateRepository candidateRepositorio;

    @Override
    public void create(CandidateModel newCandidate) {
        Optional<Candidate> validarCandidato = candidateRepositorio.findByEmail(newCandidate.getEmail());
        if (validarCandidato.isEmpty()) {
            Candidate candidate = new Candidate();
            candidate.setId(newCandidate.getId());
            candidate.setNome(newCandidate.getNome());
            candidate.setEmail(newCandidate.getEmail());
            candidate.setTelefone(newCandidate.getTelefone());
            candidate.setEndereco(newCandidate.getEndereco());
            candidate.setCpf(newCandidate.getCpf());

            candidateRepositorio.save(candidate);
        }
    }

    @Override
    public void edit(Candidate candidate) {
        Candidate newCandidate = new Candidate();
        newCandidate.setId(candidate.getId());
        newCandidate.setNome(candidate.getNome());
        newCandidate.setEmail(candidate.getEmail());
        newCandidate.setTelefone(candidate.getTelefone());
        newCandidate.setEndereco(candidate.getEndereco());
        newCandidate.setCpf(candidate.getCpf());

        candidateRepositorio.save(candidate);
    }

    @Override
    public void delete(String id) {
        Candidate candidate = candidateRepositorio.getById(id);
        candidateRepositorio.delete(candidate);
    }

    @Override
    public List<Candidate> getAll() {
        List<Candidate> allCandidates = candidateRepositorio.findAll();
        // List<User> listaResposta = new ArrayList<>();

        // for (User user : allUsers){
        //     User response = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        //     listaResposta.add(response);
        // }
        return allCandidates;
    }

    @Override
    public Candidate get(String id) {
        Candidate candidate = candidateRepositorio.getById(id);
        // User userResponse = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        return candidate;
    }

}
