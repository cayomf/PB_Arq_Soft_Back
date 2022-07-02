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

import com.example.infra.Criterion.Criterion;
import com.example.infra.Vacancy.Vacancy;
import com.example.infra.Vacancy.VacancyModel;
import com.example.shared.service.VacancyService;

@RestController
public class VacancyController {
    
    @Autowired
    VacancyService vacancyService;

    @PostMapping("/createVacancy")
    public ResponseEntity<?> create(@RequestBody VacancyModel newVacancy){
        try {
            vacancyService.create(newVacancy);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editVacancy")
    public ResponseEntity<?> edit(
        @RequestBody VacancyModel newVacancy
        ){   
        try{
            vacancyService.edit(newVacancy);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteVacancy")
    public ResponseEntity<?> delete(@RequestParam String id){
        try {
            vacancyService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/vacancyDetails")
    public ResponseEntity<?> getById(@RequestParam String id){
        try{
            Vacancy user = vacancyService.get(id);
            return ResponseEntity.ok(user);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllVacancies")
    public ResponseEntity<?> getAll(){

        try{
            List<VacancyModel> vacancies = vacancyService.getAll();
            return ResponseEntity.ok(vacancies);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/changeVacancyStatus")
    public ResponseEntity<?> changeVacancyStatus(@RequestParam Long vacancyId, @RequestParam String newStatus){
        try{
            vacancyService.updateVacancyStatus(vacancyId, newStatus);
            return ResponseEntity.ok("Atualizado");
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/reopenVacancy")
    public ResponseEntity<?> reopenVacancy(@RequestParam Long vacancyId, @RequestParam String newStatus, @RequestParam String newDate){
        try{
            vacancyService.reOpen(vacancyId, newStatus, newDate);
            return ResponseEntity.ok("Atualizado");
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}
