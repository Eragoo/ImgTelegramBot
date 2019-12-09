package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.Erag0.ImgTelegramBot.Commands.WidthQualityCommand;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.PhotoSize;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendPhoto;

import java.io.File;

public class DefaultCommand extends BotCommand{
    public void execute(TelegramBot bot, Update update, String path) {

        String urlPath = getFullImageUrlPath(bot,update);
        long chat_id = update.message().chat().id();
        new WidthQualityCommand().execute(urlPath,path);

        File file = new File(path);
        SendPhoto sendPhoto = new SendPhoto(chat_id, file);
        bot.execute(sendPhoto);
    }
}
