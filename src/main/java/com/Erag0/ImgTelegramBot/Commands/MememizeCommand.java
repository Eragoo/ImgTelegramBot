package com.Erag0.ImgTelegramBot.Commands;

import com.Erag0.ImgTelegramBot.util.Image;
import com.pengrad.telegrambot.model.Update;

import java.awt.image.BufferedImage;

public class MememizeCommand {
    private double n = 3;

    public void execute(String url, String path) {
        Image.saveFromUrl(url, path);
        BufferedImage img = Image.getBufferedImage(path);
        img = Image.getWidthMultipliedImage(img, 3);
        img = Image.getQualityImpairedImage(img);
        Image.save(img,path);
    }
}
