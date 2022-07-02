package com.example.external.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.infra.User.User;
import com.example.infra.User.UserModel;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByNome(String name);

    User findByEmail(String email);
}
