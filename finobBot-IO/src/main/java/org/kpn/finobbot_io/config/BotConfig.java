package org.kpn.finobbot_io.config;

import org.kpn.finobbot_io.Bot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.ApiContext;

@Configuration
public class BotConfig {

    @Value("${bot.name}")
    private String name;
    @Value("${bot.token}")
    private String token;
    @Value("${bot.webhookPath}")
    private String webhookPath;

    @Bean
    public TelegramWebhookBot bot(){

        return new Bot(
                ApiContext.getInstance(DefaultBotOptions.class),
                webhookPath,
                name,
                webhookPath
        );
    }
}