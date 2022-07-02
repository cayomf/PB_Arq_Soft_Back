package com.example.external.controllers;

import java.util.List;

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

import com.example.infra.Enterprise.Enterprise;
import com.example.infra.Enterprise.EnterpriseModel;
import com.example.shared.service.EnterpriseService;

@RestController
public class EnterpriseController {
    
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    VacancyService vacancyService;

    @GetMapping("/enterpriseHome")
     public ResponseEntity<?>  enterpriseHome(@RequestParam String id){
        try {
            List<VacancyModel> vacancyModels = vacancyService.getVacancyForEnterprise(id);
            return ResponseEntity.ok(vacancyModels);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/createEnterprise")
//    public ResponseEntity<?> create(@RequestBody EnterpriseModel newEnterprise){
//        try {
//            enterpriseService.create(newEnterprise);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PutMapping("/editEnterprise")
//    public ResponseEntity<?> edit(@RequestParam int id,
//                                    @RequestParam String nome,
//                                    @RequestParam String email,
//                                    @RequestParam String telefone,
//                                    @RequestParam String cep,
//                                    @RequestParam String complemento,
//                                    @RequestParam String cnpj){
//                                        Enterprise enterprise = new Enterprise();
//        enterprise.setId(id);
//        enterprise.setNome(nome);
//        enterprise.setEmail(email);
//        enterprise.setTelefone(telefone);
//        enterprise.setCep(cep);
//        enterprise.setComplemento(complemento);
//        enterprise.setCnpj(cnpj);
//
//        try{
//            enterpriseService.edit(enterprise);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping("/deleteEnterprise")
//    public ResponseEntity<?> delete(@RequestParam String id){
//        try {
//            enterpriseService.delete(id);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/enterpriseDetails")
//    public ResponseEntity<?> getById(@RequestParam String id){
//        try{
//            Enterprise enterprise = enterpriseService.get(id);
//            return ResponseEntity.ok(enterprise);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/getAllEnterprises")
//    public ResponseEntity<?> getAll(){
//
//        try{
//            List<Enterprise> enterprises = enterpriseService.getAll();
//            return ResponseEntity.ok(enterprises);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }
}
