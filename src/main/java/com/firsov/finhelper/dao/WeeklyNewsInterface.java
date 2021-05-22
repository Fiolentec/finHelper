package com.firsov.finhelper.dao;

import java.util.List;

public interface WeeklyNewsInterface {
    void addAll(List<String> news);
    List<String> getWeeklyNews();
    String getTodayNews();
}
