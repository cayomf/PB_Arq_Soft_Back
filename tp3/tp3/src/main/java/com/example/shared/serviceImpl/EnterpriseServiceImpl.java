package com.example.shared.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.external.repositories.EnterpriseRepository;
import com.example.infra.Enterprise.Enterprise;
import com.example.infra.Enterprise.EnterpriseModel;
import com.example.shared.service.EnterpriseService;

@Component
public class EnterpriseServiceImpl  implements EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepositorio;

    @Override
    public void create(EnterpriseModel newEnterprise) {
        Enterprise enterprise = new Enterprise();
        enterprise.setId(newEnterprise.getId());
        enterprise.setNome(newEnterprise.getNome());
        enterprise.setEmail(newEnterprise.getEmail());
        enterprise.setTelefone(newEnterprise.getTelefone());
        enterprise.setEndereco(newEnterprise.getEndereco());
        enterprise.setCnpj(newEnterprise.getCnpj());

        enterpriseRepositorio.save(enterprise);
    }

    @Override
    public void edit(Enterprise enterprise) {
        Enterprise newEnterprise = new Enterprise();
        newEnterprise.setId(enterprise.getId());
        newEnterprise.setNome(enterprise.getNome());
        newEnterprise.setEmail(enterprise.getEmail());
        newEnterprise.setTelefone(enterprise.getTelefone());
        newEnterprise.setEndereco(enterprise.getEndereco());
        newEnterprise.setCnpj(enterprise.getCnpj());

        enterpriseRepositorio.save(enterprise);
    }

    @Override
    public void delete(String id) {
        Enterprise enterprise = enterpriseRepositorio.getById(id);
        enterpriseRepositorio.delete(enterprise);
    }

    @Override
    public List<Enterprise> getAll() {
        List<Enterprise> allEnterprises = enterpriseRepositorio.findAll();
        // List<User> listaResposta = new ArrayList<>();

        // for (User user : allUsers){
        //     User response = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        //     listaResposta.add(response);
        // }
        return allEnterprises;
    }

    @Override
    public Enterprise get(String id) {
        Enterprise enterprise = enterpriseRepositorio.getById(id);
        // User userResponse = new UserResponse(user.getNome(), user.getAtaque(), user.getDano(), user.getRaridade(), user.getId(), user.getDesconto(), user.getPrecoBase(), user.getPrecoFinal());
        return enterprise;
    }

}
