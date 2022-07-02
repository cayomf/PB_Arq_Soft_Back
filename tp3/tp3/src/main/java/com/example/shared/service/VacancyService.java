package com.example.shared.service;

import java.sql.SQLException;
import java.util.List;

import com.example.infra.Vacancy.Vacancy;
import com.example.infra.Vacancy.VacancyModel;
import org.springframework.stereotype.Service;

@Service
public interface VacancyService {
    public Vacancy get(String id);
    public void create(VacancyModel newUser);
    public void edit(VacancyModel editedUser);
    public void delete(String id);
    public List<VacancyModel> getAll();

    List<VacancyModel> getAllVacancyByStatus() throws SQLException;

    List<VacancyModel> getVacancyForEnterprise(String email);

    void updateVacancyStatus(Long vacancyId, String newStatus);

    void reOpen(Long vacancyId, String newStatus, String newDate);
}
