package com.example.shared.service;

import java.util.List;

import com.example.infra.Admin.Admin;
import com.example.infra.Admin.AdminModel;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public Admin get(String id);
    public void create(AdminModel newAdmin);
    public void edit(Admin editedAdmin);
    public void delete(String id);
    public List<Admin> getAll();
}
