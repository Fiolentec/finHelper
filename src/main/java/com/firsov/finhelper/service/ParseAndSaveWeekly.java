package com.firsov.finhelper.service;

import com.firsov.finhelper.dao.DailyNewsInterface;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ParseAndSaveWeekly {
    private final DailyNewsInterface dailyNews;

    public void parseAndSave(String news) {
        if(!news.contains("РЫНКИ СЕГОДНЯ\n"))
            return;
        String[] lines = news.split("\\r?\\n");
        List<String> listAllNews = Arrays.stream(lines)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
        ArrayList<String> readyNews = new ArrayList<>();
        String str = "";
        for (int i = 2; i < 10; i += 2) {
            str = listAllNews.get(i);
            str = str.substring(str.indexOf('.') + 2);
            readyNews.add(str);
            readyNews.add(listAllNews.get(i+1));
        }
        StringBuilder agenda = new StringBuilder();
        for (int i = 11; i < listAllNews.size()-1; i++) {
            agenda.append(listAllNews.get(i));
        }
        readyNews.add(agenda.toString());
        dailyNews.addAll(readyNews);
    }
}
