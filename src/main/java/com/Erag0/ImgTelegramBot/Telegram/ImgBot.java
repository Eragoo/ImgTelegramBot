package com.Erag0.ImgTelegramBot.Telegram;

import com.Erag0.ImgTelegramBot.Telegram.Commands.CommandController;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;

import java.util.List;

public class ImgBot {
    private static final String TOKEN = "592148368:AAE59ohkGYvBjkJLt-zrmmtPKYANRtSrTYY";
    private TelegramBot bot;

    public ImgBot() {
        this.bot = new TelegramBot(TOKEN);
    }

    public void Start() {
        BotCore();
    }

    private void BotCore() {
        this.bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> updates) {
                for (Update update : updates) {
                    System.out.println(update.toString());
                    new CommandController().Start(bot, update, "/Users/macbook/Documents/programming/java_project/ImgTelegramBot/ImgTelegramBot/res/kartinka.jpg");
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
    }
}