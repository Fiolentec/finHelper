package com.firsov.finhelper.service;

import com.firsov.finhelper.dao.DayResultsInterface;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParseAndSaveDayResults {
    private final DayResultsInterface dayResults;

    public void parseAndSave(String results) {
        if (!results.contains("ИТОГИ ДНЯ\n"))
            return;
        String[] lines = results.split("\\r?\\n");
        List<String> listAllNews = Arrays.stream(lines)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
        listAllNews.remove(0);
        listAllNews.remove(listAllNews.size() - 1);
        listAllNews.add("Новостей на сегодня больше нет. Хотите прослушать ещё раз?");
        dayResults.addAll(listAllNews);
    }
}
