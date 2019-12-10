package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;

public class CommandController {

    public void Start(TelegramBot bot, Update update, String path) {
        if(update.message().text() == null) {
            if (update.message().caption() != null) {
                new ModuleCommand().execute(bot, update, path);
            } else {
                new DefaultCommand().execute(bot,update,path);
            }
        }
    }
}
