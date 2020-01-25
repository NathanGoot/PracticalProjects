package io.github.nathanvegetable.numbers;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Project: Calculator - A simple calculator to do basic operators. Make it a
 * scientific calculator for added complexity.
 * 
 * @author NathanVegetable
 *
 */
public class Calculator {
	JFrame mainFrame = null;
	JTextField display = null;
	final static Font DISPLAY_FONT = new Font("serif", Font.PLAIN, 20);

	NumberListener numberListener = new NumberListener();
	SpecialListener specialListener = new SpecialListener();

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.display();
	}

	public Calculator() {
		init();
	}

	public void init() {
		mainFrame = new JFrame("Calculator");
		mainFrame.setPreferredSize(new Dimension(300, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(5, 5));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainFrame.add(mainPanel);

		display = new JTextField("0", 12);
		display.setEditable(false);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setFont(DISPLAY_FONT);
		mainPanel.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		String buttonsAsString = "789456123-0.";
		for (int i = 0; i < buttonsAsString.length(); i++)
			addButton(buttonPanel, buttonsAsString.substring(i, i + 1));

		mainPanel.add(buttonPanel, BorderLayout.CENTER);

		mainFrame.pack();
		// Set to center of screen
		mainFrame.setLocationRelativeTo(null);
	}

	public void display() {
		mainFrame.setVisible(true);
	}

	private void addButton(JPanel panel, String buttonText) {
		ActionListener listener = null;
		if (isInt(buttonText))
			listener = numberListener;
		else
			listener = specialListener;

		JButton newButton = new JButton(buttonText);
		newButton.addActionListener(listener);
		panel.add(newButton);
	}

	private boolean isInt(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}