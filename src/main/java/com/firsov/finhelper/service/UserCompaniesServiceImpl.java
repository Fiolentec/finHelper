package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Company;
import com.firsov.finhelper.data.UserCompanies;
import com.firsov.finhelper.data.UserCompaniesTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserCompaniesServiceImpl implements UserCompaniesService {
    private final UserCompaniesTable userCompaniesTable;
    private final CompanyCreatorAndGetter companyCreatorAndGetter;
    private final ActualDividendDateGetter actualDividendDateGetter;

    @Transactional
    public void createNewUser(String userId) {
        UserCompanies userCompanies = UserCompanies.builder()
                .userId(userId)
                .build();
        userCompaniesTable.save(userCompanies);
    }

    @Transactional
    public void createNewUser(String userId, Set<Company> companySet) {
        UserCompanies userCompanies = UserCompanies.builder()
                .userId(userId)
                .companiesSet(companySet)
                .build();
        userCompaniesTable.save(userCompanies);
    }

    @Transactional
    public void addCompanySet(String userId, Set<Company> companySet) {
        UserCompanies userCompanies = userCompaniesTable.getUserCompaniesByUserId(userId);
        userCompanies.setCompaniesSet(companySet);
        userCompaniesTable.save(userCompanies);
    }

    @Transactional
    public void addCompany(String userId, Company company) {
        log.info("Try to add company: {} to user with id: {}", company, userId);
        UserCompanies userCompanies = userCompaniesTable.getUserCompaniesByUserId(userId);
        if (userCompanies == null) {
            Set<Company> set = new HashSet<>();
            set.add(company);
            createNewUser(userId, set);
            return;
        }
        userCompanies.getCompaniesSet().add(company);
        userCompaniesTable.save(userCompanies);
    }

    @Transactional
    public void addCompany(String userId, String identifier) {
        Company company = companyCreatorAndGetter.getCompany(identifier);
        addCompany(userId, company);
    }

    @Transactional
    public UserCompanies getUserCompanies(String userId) {
        return userCompaniesTable.getUserCompaniesByUserId(userId);
    }

    @Transactional
    public Set<ActualDividendContainer> getActualDividendContainers(String userId, LocalDate date) {
        UserCompanies userCompanies = userCompaniesTable.getUserCompaniesByUserId(userId);
        if (userCompanies == null) {
            return null;
        }
        if (userCompanies.getCompaniesSet() == null) {
            return null;
        }
        return actualDividendDateGetter.getActualDividendContainers(
                userCompanies.getCompaniesSet(),
                date);
    }

    @Transactional
    public Set<ActualDividendContainer> getActualDividendContainers(String userId) {
        return getActualDividendContainers(userId, LocalDate.now());
    }


}
