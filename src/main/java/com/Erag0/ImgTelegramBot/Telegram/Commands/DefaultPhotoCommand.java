package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.Erag0.ImgTelegramBot.Commands.WidthQualityCommand;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.PhotoSize;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendPhoto;

import java.io.File;

public class DefaultPhotoCommand extends BotCommand{
    public void execute(TelegramBot bot, Update update, String path) {

        String url = getFullImageUrlPath(bot,update);
        long chat_id = update.message().chat().id();
        saveImage(url, path);
        new WidthQualityCommand().execute(path);

        File file = new File(path);
        SendPhoto sendPhoto = new SendPhoto(chat_id, file);
        bot.execute(sendPhoto);
    }
}
