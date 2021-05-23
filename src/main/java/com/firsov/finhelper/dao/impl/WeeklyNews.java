package com.firsov.finhelper.dao.impl;

import com.firsov.finhelper.dao.WeeklyNewsInterface;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class WeeklyNews implements WeeklyNewsInterface {
    HashMap<Integer, String> newsMap = new HashMap<>();

    @Override
    public void addAll(List<String> news) {
        if (news.size() != 7)
            return;
        for (int i = 0; i < 7; i++) {
            newsMap.put(i + 1, news.get(i));
        }
    }

    @Override
    public HashMap<Integer, String> getWeeklyNews() {
        return newsMap;
    }

    @Override
    public String getTodayNews() {
        Calendar calendar = Calendar.getInstance();
        return newsMap.get(calendar.get(Calendar.DAY_OF_WEEK));
    }
    @Override
    public String getDayNews(Integer n) {
        return newsMap.get(n);
    }
}
