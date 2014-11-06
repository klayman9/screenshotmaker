package org.klayman9.screenshotmaker;

import java.awt.AWTException;

public class ScreenshotMakerApplication {

	public ScreenshotMakerApplication() {

	}
	
	public static void main(String[] args) {
		
		ScreenshotMaker screenshotMaker;
		try {
			screenshotMaker = ScreenshotMaker.getInstance();
			
			for (int i = 0; i < args.length; i++) {
				
				if (args[i] == "-p" && i < args.length - 1) {
					screenshotMaker.setFilePath(args[i + 1]);
				}
			}
			
		} catch (AWTException e) {
			
			e.printStackTrace();
			System.exit(0);
		}

		ScreenshotMakerWindow makerWindow = new ScreenshotMakerWindow();
		makerWindow.setVisible(true);
	}
}
