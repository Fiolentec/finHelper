package com.firsov.finhelper.dao;

import java.util.ArrayList;
import java.util.Map;


public interface DailyNewsInterface {
    void addStock(String stock, String stockAll);

    void addOil(String oil, String oilAll);

    void addRuble(String ruble, String rubleAll);

    void addBond(String bond, String bondAll);

    void addAgenda(String agenda);

    void addAll(ArrayList<String> strings);

    Map<String, String> getNews();

}
