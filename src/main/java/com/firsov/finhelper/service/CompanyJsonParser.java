package com.firsov.finhelper.service;


import com.firsov.finhelper.data.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyJsonParser {
    private final CompanyService companyService;

    public Company parse(JSONObject jsonObject, String identifier) {
        JSONObject jsonResult = jsonObject.getJSONObject("quoteSummary");
        JSONArray results = jsonResult.getJSONArray("result");
        if (results.length() > 0) {
            jsonResult = results.getJSONObject(0).getJSONObject("summaryDetail");
        } else {
            throw new ParserException("Failed to get results array");
        }
        Company company;
        try {
            company = companyService.createCompany(identifier,
                    getDividendRate(jsonResult),
                    getDividendYield(jsonResult),
                    getExDividendDate(jsonResult));
        } catch (Exception e) {
            throw new ParserException("Failed to create new Company with exception: ", e);
        }
        return company;

    }

    private String getDividendRate(JSONObject jsonObject) {
        return jsonObject.getJSONObject("dividendRate")
                .get("raw").toString();
    }

    private String getDividendYield(JSONObject jsonObject) {
        return jsonObject.getJSONObject("dividendYield")
                .get("raw").toString();
    }

    private String getExDividendDate(JSONObject jsonObject) {
        return jsonObject.getJSONObject("exDividendDate")
                .get("fmt").toString();
    }
}
