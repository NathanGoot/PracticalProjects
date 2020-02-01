package io.github.nathanvegetable.numbers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Project: Alarm Clock - A simple clock where it plays a sound after X number
 * of minutes/seconds or at a particular time.
 * 
 * @author NathanVegetable
 *
 */
public class AlarmClock {
	JFrame mainFrame = null;
	JLabel[] numberDisplays = new JLabel[4];
	final static Font DISPLAY_FONT = new Font("serif", Font.PLAIN, 60);

	public static void main(String[] args) {
		AlarmClock alarmClock = new AlarmClock();
		alarmClock.display();
	}

	public AlarmClock() {
		init();
	}

	public void init() {
		mainFrame = new JFrame("Calculator");
		mainFrame.setPreferredSize(new Dimension(500, 120));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
		mainFrame.add(mainPanel);

		JPanel numberPanel = new JPanel(new GridLayout(1, 4, 5, 5));
		mainPanel.add(numberPanel, BorderLayout.NORTH);
		for (int i = 0; i < numberDisplays.length; i++) {
			numberDisplays[i] = new JLabel("0");
			numberDisplays[i].setHorizontalAlignment(JLabel.CENTER);
			numberDisplays[i].setVerticalAlignment(JLabel.CENTER);
			numberDisplays[i].setFont(DISPLAY_FONT);
			numberDisplays[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			numberPanel.add(numberDisplays[i]);
		}

		mainFrame.pack();
		// Set to center of screen
		mainFrame.setLocationRelativeTo(null);
	}

	public void display() {
		mainFrame.setVisible(true);
	}
}
