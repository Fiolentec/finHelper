package com.firsov.finhelper.service;

import com.firsov.finhelper.dao.WeeklyNewsInterface;
import com.firsov.finhelper.utils.CountryNumbersMap;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ParseAndSaveWeekly {
    private final WeeklyNewsInterface weeklyNews;

    public void parseAndSave(String news) {
        if (!news.contains("События недели\n"))
            return;
        CountryNumbersMap cnm = new CountryNumbersMap();
        for (Map.Entry<String, String> entry : cnm.getCountryMap().entrySet()) {
            news = news.replace(entry.getKey(), entry.getValue());
        }
        String[] lines = news.split("\\n\\n");
        List<String> listAllNews = Arrays.stream(lines)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
        listAllNews.set(0, "На выходных биржи не работают, поэтому финансовых новостей нет");
        listAllNews.add("На выходных биржи не работают, поэтому финансовых новостей нет");
        System.out.println(listAllNews);
        weeklyNews.addAll(listAllNews);
    }
}
