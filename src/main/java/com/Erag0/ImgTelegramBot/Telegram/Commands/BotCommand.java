package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.Erag0.ImgTelegramBot.util.Image;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.PhotoSize;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;

public abstract class BotCommand {
    public abstract void execute(TelegramBot bot, Update update, String path);

    protected String getFullImageUrlPath(TelegramBot bot, Update update) {
        PhotoSize[] photos = update.message().photo();
        String file_id = photos[1].fileId();

        GetFile getFileRequest = new GetFile(file_id);

        com.pengrad.telegrambot.model.File file = bot.execute(getFileRequest).file();
        return bot.getFullFilePath(file);
    }

    protected void saveImage(String url, String path) {
        Image.saveFromUrl(url,path);
    }
}
