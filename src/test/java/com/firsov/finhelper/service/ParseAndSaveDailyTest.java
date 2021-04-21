package com.firsov.finhelper.service;

import com.firsov.finhelper.dao.impl.DailyNews;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseAndSaveDailyTest {

    String s = "РЫНКИ СЕГОДНЯ\n" +
            "Прогнозы аналитиков SberCIB\n" +
            "\n" +
            "\uD83D\uDE42\uD83D\uDDFA Фондовые рынки. Возможен небольшой рост в начале торгов.\n" +
            "\n" +
            "Американский фондовый рынок снизился по итогам вторника. Все большую обеспокоенность инвесторов вызывает рост числа заболевших коронавирусом — ВОЗ зафиксировала максимальное число новых случаев COVID-19 за неделю. Индекс МосБиржи упал на 1,3%. Хотя внешний фон для российского рынка этим утром скорее негативный, индекс выглядит перепроданным, поэтому аналитики SberCIB ждут роста на открытии рынка.\n" +
            "\n" +
            "\uD83D\uDEE2 Нефть. Цены на нефть под давлением.\n" +
            "\n" +
            "Сегодня котировки Брент, скорее всего, должны удержаться выше уровня $65,5 за баррель. Утром нефтяной рынок поддерживают оптимистичные данные по запасам углеводородов в США от Американского института нефти, но данные о росте заболеваемости коронавирусом и падение рынка акций в США оказывают давление.\n" +
            "\n" +
            "\uD83C\uDDF7\uD83C\uDDFA Рубль. На рубль влияет геополитика.\n" +
            "\n" +
            "Во вторник рубль ослаб до 77 за доллар, так как геополитическая напряжённость оставалась высокой. Сегодня утром он стабилен около 76,8, инвесторы ждут послания президента России Федеральному Собранию, которое должно начаться в 12:00 МСК. Если геополитическая напряженность снизится, рубль может восстановиться до 76, а если нет — ослабнет до 77 или более.\n" +
            "\n" +
            "\uD83D\uDCBC Облигации. Рынок рублевых облигаций ждёт выступления президента РФ\n" +
            "\n" +
            "Накануне рублёвые гособлигации продолжали дешеветь на фоне геополитической напряженности и ослабления рубля, однако затем частично отыграли потери. Дальше их динамика будет зависеть от выступления президента РФ.  \n" +
            "\n" +
            "НА ПОВЕСТКЕ ДНЯ\n" +
            "\n" +
            "Выступление Владимира Путина, корпоративная отчётность, российская макростатистика\n" +
            "\n" +
            "\uD83D\uDCCC Владимир Путин в 12:00 мск выступит с посланием Федеральному Собранию.\n" +
            "\n" +
            "\uD83D\uDCCC ММК опубликует финансовую отчётность, совет директоров ЛУКойла, возможно, даст рекомендацию по дивидендам.\n" +
            "\n" +
            "\uD83D\uDCCC В 19:00 мск выйдут данные по недельной инфляции в РФ.\n" +
            "\n" +
            " #daily";
    @Test
    public void parseAndSave(){
        DailyNews dailyNews = new DailyNews();
        System.out.println(s.contains("#dails"));
//        String[] lines = s.split("\\r?\\n");
//        List<String> listAllNews = Arrays.stream(lines).filter(StringUtils::isNotBlank).collect(Collectors.toList());
//        ArrayList<String> readyNews = new ArrayList<>();
//        String str = "";
//        for (int i = 2; i < 10; i += 2) {
//            str = listAllNews.get(i);
//            str = str.substring(str.indexOf('.') + 2);
//            readyNews.add(str);
//            readyNews.add(listAllNews.get(i+1));
//        }
//        StringBuilder agenda = new StringBuilder();
//        for (int i = 11; i < listAllNews.size()-1; i++) {
//            agenda.append(listAllNews.get(i));
//        }
//        readyNews.add(agenda.toString());
//        dailyNews.addAll(readyNews);
//        System.out.println(dailyNews.getNews().get("stockMarkets"));
//        System.out.println(new JSONObject(dailyNews.getNews()));
        assertTrue(true);
    }
}