package com.example.shared.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.external.repositories.AdminRepository;
import com.example.infra.Admin.Admin;
import com.example.infra.Admin.AdminModel;
import com.example.shared.service.AdminService;

@Component
public class AdminServiceImpl  implements AdminService {
    
    @Autowired
    AdminRepository adminRepositorio;

    @Override
    public void create(AdminModel newAdmin) {
        Admin admin = new Admin();
        admin.setId(newAdmin.getId());
        admin.setNome(newAdmin.getNome());
        admin.setEmail(newAdmin.getEmail());
        admin.setTelefone(newAdmin.getTelefone());
        admin.setEndereco(newAdmin.getEndereco());
        admin.setAdminId(newAdmin.getAdminId());

        adminRepositorio.save(admin);
    }

    @Override
    public void edit(Admin admin) {
        Admin newAdmin = new Admin();
        newAdmin.setId(admin.getId());
        newAdmin.setNome(admin.getNome());
        newAdmin.setEmail(admin.getEmail());
        newAdmin.setTelefone(admin.getTelefone());
        newAdmin.setEndereco(admin.getEndereco());

        adminRepositorio.save(admin);
    }

    @Override
    public void delete(String id) {
        Admin admin = adminRepositorio.getById(id);
        adminRepositorio.delete(admin);
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> allAdmins = adminRepositorio.findAll();
        // List<User> listaResposta = new ArrayList<>();

        // for (User user : allUsers){
        //     User response = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        //     listaResposta.add(response);
        // }
        return allAdmins;
    }

    @Override
    public Admin get(String id) {
        Admin admin = adminRepositorio.getById(id);
        // User userResponse = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        return admin;
    }

}
