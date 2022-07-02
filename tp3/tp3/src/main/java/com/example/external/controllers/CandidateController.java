package com.example.external.controllers;

import java.util.List;

import com.example.infra.Vacancy.Vacancy;
import com.example.infra.Vacancy.VacancyModel;
import com.example.shared.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.infra.Candidate.Candidate;
import com.example.infra.Candidate.CandidateModel;
import com.example.shared.service.CandidateService;

@RestController
public class CandidateController {
    
    @Autowired
    CandidateService candidateService;
    @Autowired
    VacancyService vacancyService;

    @PostMapping("/createCandidate")
    public ResponseEntity<?> create(@RequestBody CandidateModel newCandidate){
        try {
            candidateService.create(newCandidate);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editCandidate")
    public ResponseEntity<?> edit(@RequestParam int id,
                                    @RequestParam String nome,
                                    @RequestParam String email,
                                    @RequestParam String telefone,
                                    @RequestParam String endereco,
                                    @RequestParam String cpf){   
                                        Candidate candidate = new Candidate();
        candidate.setId(id);
        candidate.setNome(nome);
        candidate.setEmail(email);
        candidate.setTelefone(telefone);
        candidate.setEndereco(endereco);
        candidate.setCpf(cpf);

        try{
            candidateService.edit(candidate);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCandidate")
    public ResponseEntity<?> delete(@RequestParam String id){
        try {
            candidateService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/candidateDetails")
    public ResponseEntity<?> getById(@RequestParam String id){
        try{
            Candidate user = candidateService.get(id);
            return ResponseEntity.ok(user);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllCandidates")
    public ResponseEntity<?> getAll(){
        try{
            List<Candidate> users = candidateService.getAll();
            return ResponseEntity.ok(users);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllVacancyForCandidate")
    public ResponseEntity<?> getAllVacancy(){
        try {
            List<VacancyModel> vacancyList = vacancyService.getAllVacancyByStatus();
            return ResponseEntity.ok(vacancyList);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
