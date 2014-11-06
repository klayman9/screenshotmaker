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
		} catch (AWTException e) {
			
			e.printStackTrace();
			System.exit(0);
		}
		
		screenButton = new JButton("Сделать снимок");
		screenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("SHOT");
				try {
					setVisible(false);
					screenshotMaker.makeScreenshot();
					setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(screenButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
