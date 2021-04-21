package com.firsov.finhelper.config;

import com.firsov.finhelper.botinstance.TelegramBotApplication;
import com.firsov.finhelper.service.ParseAndSaveDaily;
import lombok.AccessLevel;
import lombok.Data;

import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
public class BotConfig {

//    @Value("#{environment.BOT_TOKEN}")
    String botToken = "1647945337:AAE8UomQz3TzDZyK-2D8ZxpDU7hnk3FPgHA";

//    @Value("#{environment.BOT_NAME}")
    String botName="figbook_bot";

    @Autowired
    final ParseAndSaveDaily parserDailyNews;

    @Bean
    public TelegramBotApplication telegramBotApplication() {
        TelegramBotApplication bot = new TelegramBotApplication();
        bot.setBotName(botName);
        bot.setBotToken(botToken);
        return bot;
    }

}
