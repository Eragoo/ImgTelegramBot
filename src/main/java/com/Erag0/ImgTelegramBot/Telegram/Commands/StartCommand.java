package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class StartCommand extends BotCommand {
    @Override
    public void execute(TelegramBot bot, Update update, String path) {
        String text = "*Привет*👻\n" +
                "_Надо быстро сделать мем из какой-то картинки?_\n" +
                "*Легко!*✨\n" +
                "_Нужно просто отправить мне любое фото!_\n" +
                "✏️*Так же можно передавать параметры для редактирования фото :*\n" +
                "✔️`width` - *растянуть фото по ширине*\n" +
                "✔️`quality` - *ухудшить качество изображения*\n" +
                "✔️`red` - *сделать картинку красной*_(без социализма пж)_\n";
        SendMessage msg = new SendMessage(update.message().chat().id(), text)
                .parseMode(ParseMode.Markdown);
        bot.execute(msg);
    }
}
