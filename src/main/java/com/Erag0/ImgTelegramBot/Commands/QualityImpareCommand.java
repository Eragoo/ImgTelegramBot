package com.Erag0.ImgTelegramBot.Commands;

import com.Erag0.ImgTelegramBot.util.Image;

import java.awt.image.BufferedImage;

public class QualityImpareCommand implements ImageCommand{
    @Override
    public void execute(String path) {
        BufferedImage img = Image.getBufferedImage(path);
        img = Image.getQualityImpairedImage(img);
        Image.save(img, path);
    }
}
