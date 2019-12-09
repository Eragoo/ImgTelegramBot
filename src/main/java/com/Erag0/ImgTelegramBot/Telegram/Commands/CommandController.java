package com.Erag0.ImgTelegramBot.Telegram.Commands;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;

public class CommandController {
    private TelegramBot bot;
    private Update update;
    private final String[] PARAMS  = {"RED", "WIDTH", "IMPAIR"};

    public CommandController(TelegramBot bot, Update update) {
        this.bot = bot;
        this.update = update;
    }
    public void Start() {
    }


    private String[] getParams(String str) {
        if (str.length() > 100) {
            return null;
        }
        return str.split("\\s+");

    }
}
