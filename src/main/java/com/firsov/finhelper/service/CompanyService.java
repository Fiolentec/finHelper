package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Company;
import com.firsov.finhelper.data.CompanyTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Slf4j
public class CompanyService {
    final CompanyTable companyTable;

    public Company createCompany(String identifier, Double dividendRate,
                                 Double dividendYield, LocalDate exDividendDate) {
        return Company.builder()
                .identifier(identifier)
                .dividendRate(dividendRate)
                .dividendYield(dividendYield)
                .exDividendDate(exDividendDate)
                .build();
    }

    public Company createCompany(String identifier, String dividendRate,
                                 String dividendYield, String exDividendDate) {
        return createCompany(identifier, Double.valueOf(dividendRate),
                Double.valueOf(dividendYield), LocalDate.parse(exDividendDate));
    }

    @Transactional
    public void saveCompany(String identifier, String dividendRate,
                            String dividendYield, String exDividendDate) {
        Company company = createCompany(identifier, dividendRate, dividendYield, exDividendDate);
        companyTable.save(company);
    }

    @Transactional
    public void saveCompany(Company company) {
        companyTable.save(company);
    }

    @Transactional
    public Company getCompany(String identifier) {
        return companyTable.getCompanyByIdentifier(identifier);
    }
}
