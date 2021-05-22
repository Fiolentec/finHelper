package com.firsov.finhelper.dao;

import java.util.List;

public interface DayResultsInterface {
    void addOne(String news);
    void setFirstRequest();
    void addAll(List<String> news);
    String getNext();
}
