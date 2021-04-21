package com.firsov.finhelper.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RateTest {
//
//    String json = "{\n" +
//            "  \"Valute\": {\n" +
//            "    \"AUD\": {\n" +
//            "      \"ID\": \"R01010\",\n" +
//            "      \"NumCode\": \"036\",\n" +
//            "      \"CharCode\": \"AUD\",\n" +
//            "      \"Nominal\": 1,\n" +
//            "      \"Name\": \"Австралийский доллар\",\n" +
//            "      \"Value\": 59.637,\n" +
//            "      \"Previous\": 58.1469\n" +
//            "    },\n" +
//            "    \"AZN\": {\n" +
//            "      \"ID\": \"R01020A\",\n" +
//            "      \"NumCode\": \"944\",\n" +
//            "      \"CharCode\": \"AZN\",\n" +
//            "      \"Nominal\": 1,\n" +
//            "      \"Name\": \"Азербайджанский манат\",\n" +
//            "      \"Value\": 45.3095,\n" +
//            "      \"Previous\": 44.5454\n" +
//            "    },\n" +
//            "    \"GBP\": {\n" +
//            "      \"ID\": \"R01035\",\n" +
//            "      \"NumCode\": \"826\",\n" +
//            "      \"CharCode\": \"GBP\",\n" +
//            "      \"Nominal\": 1,\n" +
//            "      \"Name\": \"Фунт стерлингов Соединенного королевства\",\n" +
//            "      \"Value\": 106.1026,\n" +
//            "      \"Previous\": 104.4193\n" +
//            "    },\n" +
//            "    \"AMD\": {\n" +
//            "      \"ID\": \"R01060\",\n" +
//            "      \"NumCode\": \"051\",\n" +
//            "      \"CharCode\": \"AMD\",\n" +
//            "      \"Nominal\": 100,\n" +
//            "      \"Name\": \"Армянских драмов\",\n" +
//            "      \"Value\": 14.8228,\n" +
//            "      \"Previous\": 14.6247\n" +
//            "    }\n" +
//            "  }\n" +
//            "}";
//
//
//    @Test
//    public void test() throws JsonProcessingException {
////        try{
////            String pre_apiURL = "http://www.cbr.ru/scripts/XML_daily.asp";
//////            System.out.println("url "+ pre_apiURL);
////            URL url = new URL(pre_apiURL);
////
////            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
////            DocumentBuilder db = dbf.newDocumentBuilder();
////            Document doc = db.parse(url.openStream());
////            System.out.println(doc.);
////
////        }catch(Exception ignored){}
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Rate[] rates = objectMapper.readValue(json, Rate[].class);
//        System.out.println(rates);
//    }
//
//    @Test
//    public void testt() throws IOException {
//        JSONObject my_json = new JSONObject(IOUtils.toString(new URL("https://www.cbr-xml-daily.ru/daily_json.js"), StandardCharsets.UTF_8));
//        ObjectMapper objectMapper = new ObjectMapper();
//        JSONObject jsonn = my_json.getJSONObject("Valute");
//        Iterator<String> keys = jsonn.keys();
//        ArrayList<Rate> rates = new ArrayList<>();
//        while(keys.hasNext()) {
//            String key = keys.next();
//            try {
//                rates.add(objectMapper.readValue(jsonn.get(key).toString(), Rate.class));
//            }catch (Exception e){
//                System.out.println(e);
//            }
//        }
//        System.out.println(rates.get(0));
//    }

}