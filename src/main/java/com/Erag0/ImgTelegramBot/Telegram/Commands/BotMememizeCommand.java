package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.Erag0.ImgTelegramBot.Commands.MememizeCommand;
import com.Erag0.ImgTelegramBot.util.Image;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendPhoto;

import java.io.File;

public class BotMememizeCommand {
    public void execute(TelegramBot bot, Update update, String url, String path) {
        long chat_id = update.message().chat().id();
        new MememizeCommand().execute(url,path);
        File file = new File(path);
        SendPhoto sendPhoto = new SendPhoto(chat_id, file);
        bot.execute(sendPhoto);
    }
}
