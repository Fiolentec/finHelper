package com.firsov.finhelper.service;

import com.firsov.finhelper.data.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParserAndSaverCompany implements CompanyCreatorAndGetter {
    private final CompanyService companyService;
    private final CompanyJsonParser companyJsonParser;

    public void createCompany(String identifier) {
        companyService.saveCompany(parseAndSaveCompany(identifier));

    }

    @Override
    public Company getCompany(String identifier) {
        return companyService.getCompany(identifier);
    }

    private Company parseAndSaveCompany(String identifier) {
        log.info("started parse and save company");
        String url = format("https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?modules=summaryDetail", identifier);
        log.info("try to get info from: {}", url);
        Company company;
        try {
            JSONObject my_json = new JSONObject(IOUtils.toString(new URL(url), StandardCharsets.UTF_8));
            company = companyJsonParser.parse(my_json, identifier);
        } catch (ParserException e) {
            log.error("Failed to parse with exception: ", e);
            throw new RuntimeException("Failed parse and save");
        } catch (Exception e) {
            log.error("Failed to create new JSONObject: ", e);
            throw new RuntimeException("Failed parse and save");
        }
        return company;
    }
}
