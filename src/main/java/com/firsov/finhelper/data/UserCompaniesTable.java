package com.firsov.finhelper.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCompaniesTable extends JpaRepository<UserCompanies, Integer> {
    UserCompanies getUserCompaniesByUserId(String userId);
}
