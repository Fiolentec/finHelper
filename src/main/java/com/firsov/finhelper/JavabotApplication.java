package com.firsov.finhelper;

import com.firsov.finhelper.botinstance.TelegramBotApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class JavabotApplication {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new TelegramBotApplication());
        } catch (TelegramApiException ignored) {
        }
        SpringApplication.run(JavabotApplication.class, args);
        log.info("========== FINANCIAL DICTIONARY APP STARTED ==========");
    }
}
