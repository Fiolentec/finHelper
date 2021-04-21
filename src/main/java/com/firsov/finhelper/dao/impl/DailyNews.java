package com.firsov.finhelper.dao.impl;

import com.firsov.finhelper.dao.DailyNewsInterface;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class DailyNews implements DailyNewsInterface {
    HashMap<String, String> news = new HashMap<>();

    public DailyNews(){
        news.put("stockMarkets","");
        news.put("stockMarketsAll","");
        news.put("oil","");
        news.put("oilAll","");
        news.put("ruble","");
        news.put("rubleAll","");
        news.put("bonds","");
        news.put("bondsAll","");
        news.put("agenda","");
    }

    @Override
    public void addStock(String stock, String stockAll) {
        news.put("stockMarkets", stock);
        news.put("stockMarketsAll", stockAll);
    }

    @Override
    public void addOil(String oil, String oilAll) {
        news.put("oil", oil);
        news.put("oilAll", oilAll);
    }

    @Override
    public void addRuble(String ruble, String rubleAll) {
        news.put("ruble", ruble);
        news.put("rubleAll", rubleAll);
    }

    @Override
    public void addBond(String bonds, String bondsAll) {
        news.put("bonds", bonds);
        news.put("bondsAll", bondsAll);
    }

    @Override
    public void addAgenda(String agenda) {
        news.put("agenda", agenda);
    }

    @Override
    public void addAll(ArrayList<String> strings) {
        addStock(strings.get(0),strings.get(1));
        addOil(strings.get(2),strings.get(3));
        addRuble(strings.get(4),strings.get(5));
        addBond(strings.get(6),strings.get(7));
        addAgenda(strings.get(8));
    }

    @Override
    public Map<String, String> getNews() {
        return news;
    }
}
