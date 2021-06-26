package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ActualDividendDateGetterImpl implements ActualDividendDateGetter {
    public Set<ActualDividendContainer> getActualDividendContainers(Set<Company> companies) {
        return getActualDividendContainers(companies, LocalDate.now());
    }

    public Set<ActualDividendContainer> getActualDividendContainers(Set<Company> companies, LocalDate date) {
        if (companies == null) {
            return null;
        }
        companies = companies.stream().filter(company -> company.isActual(date)).collect(Collectors.toSet());
        if (companies.isEmpty()) {
            return null;
        }
        Set<ActualDividendContainer> containers = new HashSet<>();
        companies.forEach(company ->
                containers.add(
                        new ActualDividendContainer(company.getIdentifier(), getMessage(company, date)
                        ))
        );
        return containers;
    }

    private String getMessage(Company company, LocalDate date) {
        return String.format(
                "До даты выплаты дивидендов в размере %,.2f," +
                        " что составляет %,.2f процентов дивидендной доходности " +
                        "%s.",
                company.getDividendRate(), company.getDividendYield(), getMessageDay(company.getDays(date))
        );
    }


    private String getMessageDay(long days) {
        switch ((int) days) {
            case (1):
                return "остался один день";
            case (2):
                return "осталось два дня";
            case (3):
                return "осталось три дня";
            case (4):
                return "осталось четыре дня";
            case (5):
                return "осталось пять дней";
            case (6):
                return "осталось шесть дней";
            case (7):
                return "осталась неделя";
        }
        return "";
    }

}
