package com.firsov.finhelper.controller;

import com.firsov.finhelper.dao.DailyNewsInterface;
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

    @GetMapping("getDefinition/{term}")
    public @ResponseBody
    Definition getDefinition(@PathVariable String term) {
        Definition definition = definitionsTable.findByTerm(term);
        System.out.println(definition);
        return definition;
    }

    @GetMapping(value = "getRate/{code}", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseContainer getRate(@PathVariable String code) {
        return definitionCreator.getDefinition(code);
    }

    @GetMapping(value = "getNews", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map<String, String> getDailyNews() {
        return dailyNews.getNews();
    }


}
