package com.Erag0.ImgTelegramBot.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTest {
    int width;
    BufferedImage img;
    @Before
    public void setUp() {
        img = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        width = img.getWidth();
    }

    @Test
    public void testMultiplyWidth() {
        int result = width * 2;
        Assert.assertEquals(result, Image.getWidthMultipliedImage(img,2).getWidth());
    }
    @Test
    public void testDivisionEvenWidth() {
        int maxDif = 1;
        int result = width / 2;
        Assert.assertTrue(maxDif >= Math.abs(Image.getWidthMultipliedImage(img,0.5).getWidth()-result));
    }

    @Test
    public void testDivisionUnevenWidth() {
        BufferedImage localImg = new BufferedImage(121,100,BufferedImage.TYPE_INT_RGB);
        int maxDif = 1;
        int suspectedWidth = localImg.getWidth() / 2;
        int expectedWith = Image.getWidthMultipliedImage(localImg,0.5).getWidth();
        int currentDif = Math.abs(expectedWith - suspectedWidth);
        Assert.assertTrue( maxDif >= currentDif);
    }

    @Test
    public void testNullIntoGetMultupyWith() {

        Assert.assertNull(Image.getWidthMultipliedImage(null,2));
    }

    @Test
    public void testgetRedBoostedImage() {
        BufferedImage img = Image.getBufferedImage("/Users/macbook/Documents/programming/java_project/ImgTelegramBot/ImgTelegramBot/src/test/java/com/Erag0/ImgTelegramBot/res/kartinka.jpg");
        img = Image.getRedBoostedImage(img);
        int red = new Color(img.getRGB(1,1)).getRed();
        Assert.assertEquals(255,red);
    }

    @Test
    public void testNullInto_getRedBoostedImage() {
        BufferedImage img = Image.getRedBoostedImage(null);
        Assert.assertNull(img);
    }

    @Test
    public void testGetBufferedImage() {
        BufferedImage img = Image.getBufferedImage("/Users/macbook/Documents/programming/java_project/ImgTelegramBot/ImgTelegramBot/src/test/java/com/Erag0/ImgTelegramBot/res/kartinka.jpg");
        Assert.assertNotNull(img.toString(), img);
    }
}
