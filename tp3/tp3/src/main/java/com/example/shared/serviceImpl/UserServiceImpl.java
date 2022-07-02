package com.example.shared.serviceImpl;

import com.example.external.repositories.UserRepository;
import com.example.infra.Admin.Admin;
import com.example.infra.Candidate.Candidate;
import com.example.infra.Enterprise.Enterprise;
import com.example.infra.User.User;
import com.example.infra.User.UserModel;
import com.example.shared.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepositorio;

    @Override
    public void create(UserModel newUser) throws Exception {
        User user = new User();

        if (newUser.getAccountType() == 1){
            user = new Candidate(newUser.getNome(), newUser.getEmail(),
                    newUser.getTelefone(), newUser.getStatus(),
                    newUser.getId(), newUser.getEndereco(),
                    newUser.getCpf() );
        }else if (newUser.getAccountType() == 2){
            user = new Enterprise(newUser.getNome(), newUser.getEmail(),
                    newUser.getTelefone(),
                    newUser.getId(),  newUser.getStatus(), newUser.getEndereco(),
                    newUser.getCnpj());
        }else if (newUser.getAccountType() == 3){
            user = new Admin(newUser.getNome(), newUser.getEmail(),
                    newUser.getTelefone(), newUser.getStatus(),
                    newUser.getId(), newUser.getEndereco(),
                    newUser.getAdminId());
        }else {
            throw new Exception("Tipo de conta não existe");
        }
        userRepositorio.save(user);
    }

    @Override
    public void edit(User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setNome(user.getNome());
        newUser.setEmail(user.getEmail());
        newUser.setTelefone(user.getTelefone());
        newUser.setEndereco(user.getEndereco());

        userRepositorio.save(user);
    }

    @Override
    public void delete(String id) {
        User user = userRepositorio.getById(id);
        userRepositorio.delete(user);
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = userRepositorio.findAll();

        return allUsers;
    }

    @Override
    public void disableAccount(String email) {
        User user = userRepositorio.findByEmail(email);
        user.setStatus(false);
        userRepositorio.save(user);
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepositorio.findByEmail(email);

        return user;
    }

    @Override
    public User get(String id) {
        User user = userRepositorio.getById(id);

        return user;
    }
}
