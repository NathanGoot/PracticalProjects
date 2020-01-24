package io.github.nathanvegetable.numbers;

import java.util.ArrayList;

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
				// There was no 0 found to increment. Take the leftmost decimal, switch it to 0,
				// and add a new leftmost 1
				decimalRepresentation.set(0, Boolean.FALSE);
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
