package com.Erag0.ImgTelegramBot.Commands;

import com.Erag0.ImgTelegramBot.util.Image;

import java.awt.image.BufferedImage;

public class RedImageCommand implements ImageCommand {
    @Override
    public void execute(String url, String path) {
        Image.saveFromUrl(url, path);
        BufferedImage img = Image.getBufferedImage(path);
        img = Image.getRedBoostedImage(img);
        Image.save(img, path);
    }
}
