package com.firsov.finhelper.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyTable extends JpaRepository<Company, Integer> {
    Company getCompanyByIdentifier(String identifier);
}
