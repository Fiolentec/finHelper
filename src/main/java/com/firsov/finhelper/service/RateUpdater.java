package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Rate;
import com.firsov.finhelper.data.RatesTable;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

@Service
@Slf4j
public class RateUpdater {
    final RatesTable ratesTable;

    public RateUpdater(RatesTable ratesTable) {
        this.ratesTable = ratesTable;
        updateRates();
    }

    @Scheduled(cron = "0 0 6 * * *", zone = "Europe/Moscow")
    public void updateRates() {
        log.info("STARTED RATES UPDATER");
        JSONObject my_json = new JSONObject();
        try {
            my_json = new JSONObject(IOUtils.toString(new URL("https://www.cbr-xml-daily.ru/daily_json.js"), StandardCharsets.UTF_8));
        }catch (Exception e){
            log.error(String.valueOf(e));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonn = my_json.getJSONObject("Valute");
        Iterator<String> keys = jsonn.keys();
        ArrayList<Rate> rates = new ArrayList<>();
        while(keys.hasNext()) {
            String key = keys.next();
            try {
                rates.add(objectMapper.readValue(jsonn.get(key).toString(), Rate.class));
            }catch (Exception e){
                log.error(String.valueOf(e));
            }
        }
        ratesTable.saveAll(rates);
    }
}
