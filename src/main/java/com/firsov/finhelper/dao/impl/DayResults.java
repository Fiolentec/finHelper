package com.firsov.finhelper.dao.impl;

import com.firsov.finhelper.dao.DayResultsInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayResults implements DayResultsInterface {
    ArrayList<String> results = new ArrayList<>();
    int currentResIndex = -1;

    @Override
    public void addOne(String news) {
        results.add(news);
    }

    @Override
    public void setFirstRequest() {
        currentResIndex = -1;
    }

    @Override
    public void addAll(List<String> news) {
        results.addAll(news);
    }

    @Override
    public String getNext() {
        currentResIndex++;
        if (currentResIndex >= results.size()) {
            currentResIndex = 0;
        }
        return results.get(currentResIndex);
    }
}
