package com.Erag0.ImgTelegramBot.Commands;

import com.Erag0.ImgTelegramBot.util.Image;
import com.pengrad.telegrambot.model.Update;

import java.awt.image.BufferedImage;

public class WidthQualityCommand implements ImageCommand{
    private double n = 2;

    public void execute(String path) {
        BufferedImage img = Image.getBufferedImage(path);
        img = Image.getWidthMultipliedImage(img, n);
        img = Image.getQualityImpairedImage(img);
        Image.save(img,path);
    }
}
