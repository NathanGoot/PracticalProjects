package io.github.nathanvegetable.numbers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project: Binary to Decimal and Back Converter - Develop a converter to
 * convert a decimal number to binary or a binary number to its decimal
 * equivalent.
 * 
 * @author NathanVegetable
 *
 */
public class BinaryDecimalConverter {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter the decimal to convert to binary: ");
		long decimal = inputScanner.nextLong();

		long binary = decimalToBinary(decimal);
		System.out.println("Decimal represented in binary: " + binary);

		decimal = binaryToDecimal(binary);
		System.out.println("Converted back to decimal: " + decimal);

		inputScanner.close();
	}

	public static long binaryToDecimal(long decimalValue) {
		// TODO
		return -1;
	}

	public static long decimalToBinary(long binaryValue) {
		// Represent 1 as TRUE, 0 as FALSE
		ArrayList<Boolean> decimalRepresentation = new ArrayList<Boolean>();
		decimalRepresentation.add(Boolean.FALSE);
		while (binaryValue > 0) {
			boolean foundEmptyDecimal = false;
			for (int index = decimalRepresentation.size() - 1; index >= 0 && !foundEmptyDecimal; index--) {
				if (!decimalRepresentation.get(index)) {
					decimalRepresentation.set(index, Boolean.TRUE);
					binaryValue--;
					foundEmptyDecimal = true;
				}
			}
			if (!foundEmptyDecimal) {
				// There was no 0 found to increment. Add a new leftmost 1 and set all others to
				// 0
				for (int i = 0; i < decimalRepresentation.size(); i++)
					decimalRepresentation.set(i, Boolean.FALSE);
				decimalRepresentation.add(0, Boolean.TRUE);
				binaryValue--;
			}
		}
		String decimalsInString = "";
		for (Boolean decimal : decimalRepresentation)
			decimalsInString += decimal ? "1" : "0";
		return Long.parseLong(decimalsInString);
	}
}
