package com.Erag0.ImgTelegramBot;

import com.Erag0.ImgTelegramBot.util.Image;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n: ");
		double n = in.nextDouble();
		Image.save(Image.getWidthMultipliedImage(
				Image.getBufferedImage(
				"/Users/macbook/Documents/programming/java_project/ImgTelegramBot/ImgTelegramBot/res/kartinka.jpg"), n),
				"/Users/macbook/Documents/programming/java_project/ImgTelegramBot/ImgTelegramBot/res/kartinka.jpg");
	}
}