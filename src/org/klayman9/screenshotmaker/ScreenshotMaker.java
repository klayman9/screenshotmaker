package org.klayman9.screenshotmaker;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class ScreenshotMaker extends Thread {
	
	private static ScreenshotMaker instance;
	
	private Toolkit toolkit;
	private Robot robot;
	
	private String filePath;
	
	private ScreenshotMaker() throws AWTException {
		
		toolkit = Toolkit.getDefaultToolkit();
		robot = new Robot();
	}
	
	public static ScreenshotMaker getInstance() throws AWTException {
		
		if (instance == null)
			instance = new ScreenshotMaker();
		
		return instance;
	}
	
	public String getFilePath() {
		
		return this.filePath;
	}
	
	public void setFilePath(String path) {
		
		this.filePath = path;
	}
	
	@Override
	public void run() {
		
		boolean work = true;
		while (work) {
			
		}
	}
	
	private BufferedImage getScreenImage() {
		
		Rectangle rectangle = new Rectangle(toolkit.getScreenSize());
		BufferedImage screenImage = robot.createScreenCapture(rectangle);
		
		return screenImage;
	}
	
	public void makeScreenshot() throws IOException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
		Date date = new Date();
		
		String fileName = String.format("%s.png", dateFormat.format(date));		
		fileName = "/" + fileName;
		
		ImageIO.write(getScreenImage(), "PNG", new File(filePath + fileName));
	}
}
