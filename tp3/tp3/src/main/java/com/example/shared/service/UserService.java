package com.example.shared.service;

import java.util.List;

import com.example.infra.User.User;
import com.example.infra.User.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User get(String id);
    public User findByEmail(String email);
    public void create(UserModel newUser) throws Exception;
    public void edit(User editedUser);
    public void delete(String id);
    public List<User> getAll();

    void disableAccount(String email);
}
