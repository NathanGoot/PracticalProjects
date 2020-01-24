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

	/**
	 * @param binaryValue
	 *            Number to convert into decimal representation
	 * @return <b>binaryValue</b> as decimal
	 */
	public static long binaryToDecimal(long binaryValue) {
		long decimalValue = 0;
		String binaryAsString = String.valueOf(binaryValue);
		for (int i = 0; i < binaryAsString.length(); i++)
			if (binaryAsString.charAt(i) == '1')
				decimalValue += Math.pow(2, (binaryAsString.length() - i - 1));
		return decimalValue;
	}

	/**
	 * @param decimalValue
	 *            Number to convert into binary representation
	 * @return <b>decimalValue</b> as binary
	 */
	public static long decimalToBinary(long decimalValue) {
		// Represent 1 as TRUE, 0 as FALSE
		ArrayList<Boolean> binaryRepresentation = new ArrayList<Boolean>();
		binaryRepresentation.add(Boolean.FALSE);
		while (decimalValue > 0) {
			boolean foundEmptyDecimal = false;
			for (int index = binaryRepresentation.size() - 1; index >= 0 && !foundEmptyDecimal; index--) {
				// Look for the rightmost instance of 0 and increment it
				if (!binaryRepresentation.get(index)) {
					binaryRepresentation.set(index, Boolean.TRUE);
					for (int i = index + 1; i < binaryRepresentation.size(); i++) {
						// Set all decimals to the right of the new 1 to 0
						binaryRepresentation.set(i, Boolean.FALSE);
					}
					decimalValue--;
					foundEmptyDecimal = true;
				}
			}
			if (!foundEmptyDecimal) {
				// There was no 0 found to increment. Add a new leftmost 1 and set others to 0
				for (int i = 0; i < binaryRepresentation.size(); i++)
					binaryRepresentation.set(i, Boolean.FALSE);
				binaryRepresentation.add(0, Boolean.TRUE);
				decimalValue--;
			}
		}
		String decimalsInString = "";
		for (Boolean decimal : binaryRepresentation)
			decimalsInString += decimal ? "1" : "0";
		return Long.parseLong(decimalsInString);
	}
}
