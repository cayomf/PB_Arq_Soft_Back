//package com.example.external.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.infra.Criterion.Criterion;
//import com.example.infra.Skill.Skill;
//import com.example.infra.Skill.SkillModel;
//import com.example.shared.service.SkillService;
//
//@RestController
//public class SkillController {
//
//    @Autowired
//    SkillService skillService;
//
//    @PostMapping("/createSkill")
//    public ResponseEntity<?> create(@RequestBody SkillModel novaSkill){
//        try {
//            skillService.create(novaSkill);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
////    @PutMapping("/editSkill")
////    public ResponseEntity<?> edit(@RequestParam String id,
////                                    @RequestParam Criterion criterioId,
////                                    @RequestParam int level){
////                                        Skill skill = new Skill();
////        skill.setId(id);
////        skill.setCriterioId(criterioId);
////        skill.setLevel(level);
////
////        try{
////            skillService.edit(skill);
////            return new ResponseEntity<>(HttpStatus.ACCEPTED);
////        } catch (Exception e){
////            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
////        }
////    }
//
//    @DeleteMapping("/deleteSkill")
//    public ResponseEntity<?> delete(@RequestParam String id){
//        try {
//            skillService.delete(id);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/skillDetails")
//    public ResponseEntity<?> getById(@RequestParam String id){
//        try{
//            Skill skill = skillService.get(id);
//            return ResponseEntity.ok(skill);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getAllSkill")
//    public ResponseEntity<?> getAll(){
//
//        try{
//            List<Skill> skills = skillService.getAll();
//            return ResponseEntity.ok(skills);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }
//}
