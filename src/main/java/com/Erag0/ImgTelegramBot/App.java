package com.Erag0.ImgTelegramBot;

import com.Erag0.ImgTelegramBot.Telegram.ImgBot;
import com.Erag0.ImgTelegramBot.util.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class App {

	public static void main(String[] args) throws IOException {
		ImgBot bot = new ImgBot();
		bot.Start();
	}
}