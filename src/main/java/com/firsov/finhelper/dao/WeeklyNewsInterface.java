package com.firsov.finhelper.dao;

import java.util.HashMap;
import java.util.List;

public interface WeeklyNewsInterface {
    void addAll(List<String> news);

    HashMap<Integer, String> getWeeklyNews();

    String getTodayNews();

    String getDayNews(Integer n);
}
