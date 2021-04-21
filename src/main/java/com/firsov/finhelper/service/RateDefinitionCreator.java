package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Rate;
import com.firsov.finhelper.data.RatesTable;
import com.firsov.finhelper.data.ResponseContainer;
import com.firsov.finhelper.utils.Numbers;
import com.firsov.finhelper.utils.Rubles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RateDefinitionCreator implements DefinitionCreator {
    final RatesTable ratesTable;

    public ResponseContainer getDefinition(String key) {
        Rate rate = ratesTable.findFirstByCodeOrderByIdDesc(key);
        int nominal = rate.getNominal();
        String number = Numbers.fromInteger(nominal);
        if (key.equals("DKK"))
            number = "одна ";
        String rubles = Rubles.fromInteger(getInt(rate));
        String cost = " стоит ";
        if (nominal > 1)
            cost = " стоят ";
        return new ResponseContainer(number + rate.getDescription() + cost + rate.getRatevalue() + rubles);
    }

    private int getInt(Rate rate) {
        return Double.valueOf(rate.getRatevalue().replace(",", ".")).intValue();
    }
}
