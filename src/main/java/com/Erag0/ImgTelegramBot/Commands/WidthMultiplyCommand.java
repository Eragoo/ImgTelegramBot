package com.Erag0.ImgTelegramBot.Commands;

import com.Erag0.ImgTelegramBot.util.Image;

import java.awt.image.BufferedImage;

public class WidthMultiplyCommand implements ImageCommand{

    private double n = 2;
    @Override
    public void execute(String path) {
        BufferedImage img = Image.getBufferedImage(path);
        img = Image.getWidthMultipliedImage(img, n);
        Image.save(img, path);
    }
}
