package org.klayman9.screenshotmaker;

import java.awt.AWTException;

public class ScreenshotMakerApplication {
	
	private static ScreenshotMaker screenshotMaker;

	public ScreenshotMakerApplication() {

	}
	
	public static void main(String[] args) {
		
		try {
			
			screenshotMaker = ScreenshotMaker.getInstance();
			
			for (int i = 0; i < args.length; i++) {
				
				if (args[i].equals("-h") || args[i].equals("--h") ||
						args[i].equals("-help") || args[i].equals("--help") ||
						args[i].equals("help")) {
					
					String help = "Справка:\n" + 
							"\t-p - задаёт каталог в который будут " + 
							"сохраняться снимки\n\t-h - выводит это сообщение";
					
					System.out.println(help);
				}
				
				if (args[i].equals("-p") && i < args.length - 1)
					screenshotMaker.setFilePath(args[i + 1]);
			}
			
		} catch (AWTException exception) {
			
			exception.printStackTrace();
			System.exit(0);
		}

		ScreenshotMakerWindow makerWindow = new ScreenshotMakerWindow();
		makerWindow.setVisible(true);
	}
}
