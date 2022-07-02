package com.example.external.controllers;

import java.util.List;

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

import com.example.infra.Candidacy.Candidacy;
import com.example.infra.Candidacy.CandidacyModel;
import com.example.shared.service.CandidacyService;

@RestController
public class CandidacyController {
        
    @Autowired
    CandidacyService candidacyService;

    @PostMapping("/createCandidacy")
    public ResponseEntity<?> create(@RequestBody CandidacyModel newCandidacy){
        try {
            candidacyService.create(newCandidacy);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

//    // TODO
//    @PutMapping("/editCandidacy")
//    public ResponseEntity<?> edit(@RequestBody CandidacyModel candidacyModel
//                                    ){
//                                        Candidacy candidacy = new Candidacy();
//        candidacyModel.setId(candidacy.getId());
//        candidacyModel.setVagaId(candidacy.getVagaId());
//        candidacyModel.setCandidatoId(candidacy.getCandidatoId());
//
//        try{
//            candidacyService.edit(candidacy);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping("/deleteCandidacy")
//    public ResponseEntity<?> delete(@RequestParam String id){
//        try {
//            candidacyService.delete(id);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/candidacyDetails")
//    public ResponseEntity<?> getById(@RequestParam String id){
//        try{
//            Candidacy candidacy = candidacyService.get(id);
//            return ResponseEntity.ok(candidacy);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<?> getAll(){
//        try{
//            List<Candidacy> candidacies = candidacyService.getAll();
//            return ResponseEntity.ok(candidacies);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

}
