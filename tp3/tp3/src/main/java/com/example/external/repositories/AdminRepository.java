package com.example.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infra.Admin.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
    
}
