package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Company;

public interface CompanyCreatorAndGetter {
    void createCompany(String identifier);

    Company getCompany(String identifier);
}

