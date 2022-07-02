package com.example.external.controllers;

import com.example.infra.Admin.Admin;
import com.example.infra.Candidate.Candidate;
import com.example.infra.Enterprise.Enterprise;
import com.example.infra.User.User;
import com.example.infra.User.UserModel;
import com.example.shared.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> create(@RequestBody UserModel newUser){
        try {
            userService.create(newUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String email){
        try{
            User user = userService.findByEmail(email);
            UserModel userModelObj = new UserModel();
            int accountType = 0;

            if (user instanceof Candidate) accountType = 1;
            if (user instanceof Enterprise) accountType = 2;
            if (user instanceof Admin) accountType = 3;

            userModelObj.setEmail(user.getEmail());
            userModelObj.setEndereco(user.getEndereco());
            userModelObj.setId(userModelObj.getId());
            userModelObj.setStatus(user.getStatus());
            userModelObj.setAccountType(accountType);
            userModelObj.setTelefone(user.getTelefone());
            userModelObj.setNome(user.getNome());

            if (user instanceof Candidate) userModelObj.setCpf(((Candidate) user).getCpf());
            if (user instanceof Enterprise) userModelObj.setCnpj(((Enterprise) user).getCnpj());
            if (user instanceof Admin) userModelObj.setAdminId(((Admin) user).getAdminId());

            return ResponseEntity.ok(userModelObj);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping("/editUser")
//    public ResponseEntity<?> edit(@RequestBody UserModel newUser){
//        User user = new User();
//        user.setId(newUser.getId());
//        user.setNome(newUser.getNome());
//        user.setEmail(newUser.getEmail());
//        user.setTelefone(newUser.getTelefone());
//        user.setCep(newUser.getCep());
//        user.setComplemento(newUser.getComplemento());
//
//        try{
//            userService.edit(user);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping("/deleteUser")
//    public ResponseEntity<?> delete(@RequestParam String id){
//        try {
//            userService.delete(id);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/userDetails")
//    public ResponseEntity<?> getUserById(@RequestParam String id){
//        try{
//            User user = userService.get(id);
//            return ResponseEntity.ok(user);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/getAllUsers")
//    public ResponseEntity<?> getAll(){
//
//        try{
//            List<User> users = userService.getAll();
//            return ResponseEntity.ok(users);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/disableAccount")
    public ResponseEntity<?> disableAccount(@RequestParam String email){
        try {
            userService.disableAccount(email);
            return ResponseEntity.ok("Desativado");
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
