package org.kpn.finobbot_io;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramWebhookBot {

    private final String botPath;
    private final String botUserName;
    private final String botToken;

    public Bot(DefaultBotOptions options,
               String botPath,
               String botUserName,
               String botToken) {
        super(options);
        this.botPath = botPath;
        this.botUserName = botUserName;
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }
}
