package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class DefaultCommand extends BotCommand{

    @Override
    public void execute(TelegramBot bot, Update update, String path) {
        bot.execute(new SendMessage(update.message().chat().id(),"_Прости, но я не понимаю тебя_👀").parseMode(ParseMode.Markdown));
    }
}
