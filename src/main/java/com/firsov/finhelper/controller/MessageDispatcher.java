package com.firsov.finhelper.controller;

import com.firsov.finhelper.dao.DailyNewsInterface;
import com.firsov.finhelper.dao.DayResultsInterface;
import com.firsov.finhelper.dao.DividendContainerDTO;
import com.firsov.finhelper.dao.WeeklyNewsInterface;
import com.firsov.finhelper.data.Company;
import com.firsov.finhelper.data.Definition;
import com.firsov.finhelper.data.DefinitionsTable;
import com.firsov.finhelper.data.RatesTable;
import com.firsov.finhelper.data.ResponseContainer;
import com.firsov.finhelper.data.UserCompanies;
import com.firsov.finhelper.data.UsersTable;
import com.firsov.finhelper.service.ActualDividendContainer;
import com.firsov.finhelper.service.CompanyCreatorAndGetter;
import com.firsov.finhelper.service.DefinitionCreator;
import com.firsov.finhelper.service.RateUpdater;
import com.firsov.finhelper.service.UserCompaniesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDispatcher {
    final UsersTable usersTable;
    final DefinitionsTable definitionsTable;
    final RatesTable ratesTable;
    final DefinitionCreator definitionCreator;
    final DailyNewsInterface dailyNews;
    final DayResultsInterface dailyResults;
    final WeeklyNewsInterface weeklyNews;
    final CompanyCreatorAndGetter companyCreator;
    final UserCompaniesService userCompaniesService;
    @Autowired
    RateUpdater rateUpdater;

    @GetMapping("definition/{term}")
    public Definition getDefinition(@PathVariable String term) {
        return definitionsTable.findByTerm(term);
    }

    @GetMapping(value = "rate/{code}", produces = APPLICATION_JSON_VALUE)
    public ResponseContainer getRate(@PathVariable String code) {
        return definitionCreator.getDefinition(code);
    }

    @GetMapping(value = "news", produces = APPLICATION_JSON_VALUE)
    public Map<String, String> getDailyNews() {
        return dailyNews.getNews();
    }

    @GetMapping(value = "results/{value}", produces = APPLICATION_JSON_VALUE)
    public ResponseContainer getDailyResults(@PathVariable String value) {
        if (value.equals("0"))
            dailyResults.setFirstRequest();
        return new ResponseContainer(dailyResults.getNext());
    }

    @GetMapping(value = "weekly", produces = APPLICATION_JSON_VALUE)
    public ResponseContainer getWeeklyNews() {
        return new ResponseContainer(weeklyNews.getTodayNews());
    }

    @GetMapping(value = "weekly/{day}", produces = APPLICATION_JSON_VALUE)
    public ResponseContainer getWeeklyNews(@PathVariable Integer day) {
        return new ResponseContainer(weeklyNews.getDayNews(day));
    }

    @PostMapping(value = "addCompany/{identifier}", produces = APPLICATION_JSON_VALUE)
    public void findAnsSaveCompany(@PathVariable String identifier) {
        companyCreator.createCompany(identifier);
    }

    @GetMapping(value = "company/{identifier}", produces = APPLICATION_JSON_VALUE)
    public Company getCompany(@PathVariable String identifier) {
        return companyCreator.getCompany(identifier);
    }

    @PostMapping(value = "addCompanyToUser/{userId}/{identifier}", produces = APPLICATION_JSON_VALUE)
    public void addCompanyToUser(@PathVariable String userId, @PathVariable String identifier) {
        userCompaniesService.addCompany(userId, identifier);
    }

    @GetMapping(value = "user/{userId}", produces = APPLICATION_JSON_VALUE)
    public UserCompanies addCompanyToUser(@PathVariable String userId) {
        return userCompaniesService.getUserCompanies(userId);
    }

    @GetMapping(value = "dividends/{userId}", produces = APPLICATION_JSON_VALUE)
    public DividendContainerDTO getActualDividends(@PathVariable String userId) {
        return responseDividendDto(userCompaniesService.getActualDividendContainers(userId));
    }

    @GetMapping(value = "dividends/{userId}/{date}", produces = APPLICATION_JSON_VALUE)
    public DividendContainerDTO getActualDividends(@PathVariable String userId,
                                                   @PathVariable String date) {
        return responseDividendDto(userCompaniesService.getActualDividendContainers(userId, LocalDate.parse(date)));
    }

    @PostMapping(value = "rateUpdate", produces = APPLICATION_JSON_VALUE)
    public void updateRateByHands() {
        rateUpdater.updateRates();
    }

    public DividendContainerDTO responseDividendDto(Set<ActualDividendContainer> containers) {
        if (containers == null) {
            return new DividendContainerDTO("Ближайших дат выплат дивидендов нет", null);
        }
        if (containers.isEmpty()) {
            return new DividendContainerDTO("Ближайших дат выплат дивидендов нет", null);
        }
        return new DividendContainerDTO("Актуальные выплаты дивидендов: ", containers);
    }


}
