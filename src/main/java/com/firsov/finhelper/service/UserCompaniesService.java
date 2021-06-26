package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Company;
import com.firsov.finhelper.data.UserCompanies;

import java.time.LocalDate;
import java.util.Set;

public interface UserCompaniesService {
    void createNewUser(String userId);

    void createNewUser(String userId, Set<Company> companySet);

    void addCompanySet(String userId, Set<Company> companySet);

    void addCompany(String userId, Company company);

    void addCompany(String userId, String identifier);

    UserCompanies getUserCompanies(String userId);

    Set<ActualDividendContainer> getActualDividendContainers(String userId);

    Set<ActualDividendContainer> getActualDividendContainers(String userId, LocalDate date);
}
