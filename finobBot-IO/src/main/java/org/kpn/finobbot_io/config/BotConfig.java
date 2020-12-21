package org.kpn.finobbot_io.config;

import org.kpn.finobbot_io.Bot;
import org.kpn.finobbot_io.exception.BotEnvironmentVariableNotExistException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.ApiContext;

@Configuration
public class BotConfig {

    @Value("${env.var.names.bot.name}")
    private String varBotName;
    @Value("${env.var.names.bot.token}")
    private String varBotToken;
    @Value("${env.var.names.bot.webhookPath}")
    private String varBotWebhook;

    private final Environment environment;

    public BotConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public TelegramWebhookBot bot() throws BotEnvironmentVariableNotExistException {

        String webhookPath = getBotEnvVar(varBotWebhook);
        String name = getBotEnvVar(varBotName);
        String token = getBotEnvVar(varBotToken);

        return new Bot(
                ApiContext.getInstance(DefaultBotOptions.class),
                webhookPath,
                name,
                token
        );
    }

    private String getBotEnvVar(String property) throws BotEnvironmentVariableNotExistException {
        String value = environment.getProperty(property);
        if (value == null){
            throw new BotEnvironmentVariableNotExistException(property);
        }
        return value;
    }
}