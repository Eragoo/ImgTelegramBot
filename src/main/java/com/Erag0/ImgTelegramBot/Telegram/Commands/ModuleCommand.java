package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.Erag0.ImgTelegramBot.Commands.QualityImpareCommand;
import com.Erag0.ImgTelegramBot.Commands.RedImageCommand;
import com.Erag0.ImgTelegramBot.Commands.WidthMultiplyCommand;
import com.Erag0.ImgTelegramBot.Commands.WidthQualityCommand;
import com.Erag0.ImgTelegramBot.util.Image;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendPhoto;

import java.awt.image.BufferedImage;
import java.io.File;

public class ModuleCommand extends BotCommand{

    private final String[] PARAMS = {"RED", "WIDTH", "QUALITY"};
    @Override
    public void execute(TelegramBot bot, Update update, String path) {
        String url = getFullImageUrlPath(bot,update);
        long chat_id = update.message().chat().id();
        String[] params = getParams(update.message().caption());
        saveImage(url, path);
        File file = getModificatedImageFile(params, url, path);

        SendPhoto sendPhoto = new SendPhoto(chat_id, file);
        bot.execute(sendPhoto);
    }

    private File getModificatedImageFile(String[] params, String url, String path) {
        if (params == null) {
            return null;
        }
        for (String param : params) {
            if (param.trim().toUpperCase().equals(this.PARAMS[0])) {
                new RedImageCommand().execute(path);
            }
            else if (param.trim().toUpperCase().equals(this.PARAMS[1])) {
                new WidthMultiplyCommand().execute(path);
            }
            else if(param.trim().toUpperCase().equals(this.PARAMS[2])) {
                new QualityImpareCommand().execute(path);
            }
        }

        return new File(path);
    }

    private String[] getParams(String str) {
        if (str.length() > 100) {
            return null;
        }
        return str.split("\\s+");

    }
}
