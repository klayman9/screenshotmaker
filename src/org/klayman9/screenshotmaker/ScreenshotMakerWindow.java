package org.klayman9.screenshotmaker;

import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ScreenshotMakerWindow extends JFrame {

	private JButton screenButton;
	private ScreenshotMaker screenshotMaker;
	
	public ScreenshotMakerWindow() {
		
		super("ScreenshotMaker");
		setLayout(new FlowLayout());
		
		try {
			screenshotMaker = ScreenshotMaker.getInstance();
		} catch (AWTException exception) {
			
			exception.printStackTrace();
			System.exit(0);
		}
		
		screenButton = new JButton("Сделать снимок");
		screenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				try {
					setVisible(false);
					
					screenshotMaker.makeScreenshot();
					setVisible(true);
					
				} catch (IOException exception) {
					
					exception.printStackTrace();
				}
			}
		});
		
		add(screenButton);
		setSize(150, 60);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
