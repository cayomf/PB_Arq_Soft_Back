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

import com.example.infra.Admin.Admin;
import com.example.infra.Admin.AdminModel;
import com.example.shared.service.AdminService;

@RestController
public class AdminController {
    
    @Autowired
    AdminService adminService;

    @PostMapping("/createAdmin")
    public ResponseEntity<?> create(@RequestBody AdminModel newAdmin){
        try {
            adminService.create(newAdmin);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editAdmin")
    public ResponseEntity<?> edit(@RequestBody int id,
                                    @RequestBody String nome,
                                    @RequestBody String email,
                                    @RequestBody String telefone,
                                    @RequestBody String endereco,
                                    @RequestBody String adminId){
                                        Admin admin = new Admin();
        admin.setId(id);
        admin.setNome(nome);
        admin.setEmail(email);
        admin.setTelefone(telefone);
        admin.setEndereco(endereco);
        admin.setAdminId(adminId);

        try{
            adminService.edit(admin);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAdmin")
    public ResponseEntity<?> delete(@RequestParam String id){
        try {
            adminService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/userDetails")
    public ResponseEntity<?> getById(@RequestParam String id){
        try{
            Admin admin = adminService.get(id);
            return ResponseEntity.ok(admin);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllAdmins")
    public ResponseEntity<?> getAll(){

        try{
            List<Admin> admins = adminService.getAll();
            return ResponseEntity.ok(admins);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
