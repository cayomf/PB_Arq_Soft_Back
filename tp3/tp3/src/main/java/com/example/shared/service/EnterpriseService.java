package com.example.shared.service;

import java.util.List;

import com.example.infra.Enterprise.Enterprise;
import com.example.infra.Enterprise.EnterpriseModel;
import org.springframework.stereotype.Service;

@Service
public interface EnterpriseService {
    public Enterprise get(String id);
    public void create(EnterpriseModel newEnterprise);
    public void edit(Enterprise editedEnterprise);
    public void delete(String id);
    public List<Enterprise> getAll();
}
