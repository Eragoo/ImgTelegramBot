package com.Erag0.ImgTelegramBot.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Image {

    public static BufferedImage getRedBoostedImage(BufferedImage image) {
        if (image == null) {
            return null;
        }
        BufferedImage resImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < resImg.getWidth(); i++){
            for (int j = 0; j < resImg.getHeight(); j++){
                Color c = new Color(image.getRGB(i,j));
                int red = 255;
                int green = c.getGreen();
                int blue = c.getBlue();
                c = new Color(red,green,blue);
                resImg.setRGB(i,j,c.getRGB());
            }
        }
        return resImg;

    }

    public static BufferedImage getWidthMultipliedImage(BufferedImage img, double n) {
        if (img == null) {
            return null;
        }
        BufferedImage resultImage = new BufferedImage((int) (img.getWidth()*n), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int j = 0; j < resultImage.getHeight(); j++) {
            for (int i = 0; i < resultImage.getWidth(); i++){
                resultImage.setRGB(i,j,img.getRGB((int) (i/n),j));
            }
        }
        return resultImage;
    }

    public static BufferedImage getQualityImpairedImage(BufferedImage image) {
        if (image == null) {
            return null;
        }
        BufferedImage resImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        int rgb = image.getRGB(0,0);
        for (int i = 0; i < resImg.getWidth(); i++){
            for (int j = 0; j < resImg.getHeight(); j++){
                if (j % 5 == 0){
                    rgb = image.getRGB(i,j);
                }
                resImg.setRGB(i,j,rgb);
            }
        }
        return resImg;
    }

    public static void save(BufferedImage img, String path) {
        saveBufferedImage(img, path.substring(path.lastIndexOf(".") + 1), path);
    }

    public static void saveFromUrl(String url, String path){
        try{
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(path);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getBufferedImage(String path) {
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File(path));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }

    private static void saveBufferedImage(BufferedImage img, String formatname, String path) {
        try {
            ImageIO.write(img, formatname, new File(path));
        } catch (IOException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
