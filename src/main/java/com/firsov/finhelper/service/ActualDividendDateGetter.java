package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Company;

import java.time.LocalDate;
import java.util.Set;

public interface ActualDividendDateGetter {
    Set<ActualDividendContainer> getActualDividendContainers(Set<Company> companies);

    Set<ActualDividendContainer> getActualDividendContainers(Set<Company> companies, LocalDate date);
}
