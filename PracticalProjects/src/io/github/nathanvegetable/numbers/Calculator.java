package io.github.nathanvegetable.numbers;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

	private Logic logic = new Logic();

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

		JPanel numberButtonsPanel = new JPanel(new GridLayout(4, 3));
		String buttonsAsString = "789456123_0.";
		for (int i = 0; i < buttonsAsString.length(); i++) {
			String button = buttonsAsString.substring(i, i + 1);
			if (button.equals("_")) // Special case
				button = "+/-";
			addButton(numberButtonsPanel, button);
		}

		mainPanel.add(numberButtonsPanel, BorderLayout.CENTER);

		JPanel functionButtonsPanel = new JPanel(new GridLayout(0, 1));
		buttonsAsString = "<C÷x-+=";
		for (int i = 0; i < buttonsAsString.length(); i++) {
			String button = buttonsAsString.substring(i, i + 1);
			if (button.equals("<")) // Special case
				button = "Del";
			addButton(functionButtonsPanel, button);
		}

		mainPanel.add(functionButtonsPanel, BorderLayout.EAST);

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

	/**
	 * Listener specifically for number functions
	 */
	private class NumberListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String number = e.getActionCommand();
			System.out.println("Pressed number: " + number);
			logic.insertNumber(number);
		}
	}

	/**
	 * Listener for all non-number functions
	 */
	private class SpecialListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			System.out.println("Pressed action: " + action);
			switch (action) {
			// TODO: Add other functions
			case "+/-":
				logic.switchPolarity();
				break;
			case "C":
				logic.clearAll();
				break;
			case "Del":
				logic.delete();
				break;
			case ".":
				logic.insertPeriod();
				break;
			case "÷":
			case "x":
			case "-":
			case "+":
				logic.startCalculation(action);
				break;
			case "=":
				logic.endCalculation();
				break;
			default:
				System.err.println("action not recongized: " + action);
				break;
			}
		}
	}

	private class Logic {
		private String calculatingNumber = null;
		private String calculationOperator = null;
		/**
		 * Whether or not the user has pressed any number yet. Until they press any
		 * number we display "0", but we want that zero to be replaced with a number
		 * (instead of inserted next to it) on the first time.
		 */
		private boolean hasInteracted = false;

		public void insertNumber(String number) {
			String displayText = display.getText();
			// There's something funky with how the period gets added in insertPeriod() with
			// RIGHT_TO_LEFT orientation. Need to move the period from the front to the
			// back.
			if (displayText.startsWith("."))
				displayText = displayText.substring(1) + ".";

			if (!hasInteracted) {
				if (number.equals("0"))
					return;
				hasInteracted = true;
				display.setText(number);
			} else
				display.setText(displayText + number);
			System.out.println("Inserted number: " + number);
		}

		public void insertPeriod() {
			if (display.getText().contains("."))
				return;
			display.setText("." + display.getText());
		}

		public void delete() {
			String currentText = display.getText();
			if (currentText.length() == 1) {
				clearScreen();
				return;
			}
			currentText = currentText.substring(0, currentText.length() - 1);
			if (currentText.equals("0")) {
				clearScreen();
				return;
			}
			display.setText(currentText);
		}

		public void switchPolarity() {
			String currentNum = display.getText();
			if (!currentNum.endsWith("-"))
				display.setText(currentNum + "-");
			else
				display.setText(currentNum.split("-")[0]);
			System.out.println("Switched polarity of number to " + display.getText());

		}

		public void clearAll() {
			clearScreen();
			clearCalculations();
		}

		public void clearScreen() {
			display.setText("0");
			hasInteracted = false;
			System.out.println("Cleared screen.");
		}

		public void clearCalculations() {
			calculatingNumber = null;
			calculationOperator = null;
			System.out.println("Cleared calculations.");
		}

		public void startCalculation(String calculationOperator) {
			this.calculationOperator = calculationOperator;
			calculatingNumber = display.getText();
			clearScreen();
			System.out.println(
					"Starting calculation with number " + calculatingNumber + " and operator " + calculationOperator);
		}

		public void endCalculation() {
			if (calculatingNumber == null)
				return;
			double number = getNumber(calculatingNumber);
			double operand = getNumber(display.getText());
			switch (calculationOperator) {
			case "÷":
				System.out.println("Dividing " + number + " by " + operand);
				number = number / operand;
				break;
			case "x":
				System.out.println("Multiplying " + number + " by " + operand);
				number = number * operand;
				break;
			case "-":
				System.out.println("Subtracting " + operand + " from " + number);
				number = number - operand;
				break;
			case "+":
				System.out.println("Adding " + operand + " to " + number);
				number = number + operand;
				break;
			}
			System.out.println("Result: " + number);
			display.setText(getDisplayText(number));
		}

		public String getDisplayText(double number) {
			if (Math.round(number) == number)
				return "" + (int) number;
			String stringRep = String.valueOf(number);
			while (stringRep.endsWith("0"))
				stringRep = stringRep.substring(0, stringRep.length() - 1);
			return stringRep;
		}

		public double getNumber(String displayText) {
			// Remove periods that don't have anything after them (like when just added to
			// the front)
			if (displayText.startsWith("."))
				displayText = displayText.substring(1);
			
			boolean isNegative = displayText.endsWith("-");
			return Double.parseDouble(reverseString(displayText.replace("-", ""))) * (isNegative ? -1 : 1);
		}

		private String reverseString(String input) {
			String reversed = "";
			for (int i = input.length() - 1; i >= 0; i--)
				reversed += input.charAt(i);
			return reversed;
		}
	}
}
