package com.firsov.finhelper.controller;

import com.firsov.finhelper.dao.DailyNewsInterface;
import com.firsov.finhelper.dao.DayResultsInterface;
import com.firsov.finhelper.dao.WeeklyNewsInterface;
import com.firsov.finhelper.data.*;
import com.firsov.finhelper.service.DefinitionCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

}
