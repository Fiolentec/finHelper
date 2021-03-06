package com.firsov.finhelper.botinstance;

import com.firsov.finhelper.service.ParseAndSaveDaily;
import com.firsov.finhelper.service.ParseAndSaveDayResults;
import com.firsov.finhelper.service.ParseAndSaveWeekly;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramBotApplication extends TelegramLongPollingBot {

    String botToken;
    String botName;

    @Autowired
    ParseAndSaveDaily parserDailyNews;
    @Autowired
    ParseAndSaveDayResults parserDayResults;
    @Autowired
    ParseAndSaveWeekly parserWeeklyNews;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (update.hasMessage() && message.hasText()) {
            log.info("Get message: " + message.getText());
            parserDailyNews.parseAndSave(message.getText());
            parserDayResults.parseAndSave(message.getText());
            parserWeeklyNews.parseAndSave(message.getText());
            try {
                execute(new SendMessage().setChatId(message.getChatId()).setText("Сообщение принято"));
            } catch (Exception e) {

            }
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
