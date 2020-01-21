package io.github.nathanvegetable.numbers;

public class FindPiToTheNthDigit {
	public static int DEFAULT_LIMIT = 10;

	public static void main(String[] args) {
		FindPiToTheNthDigit.findWithMathPI(DEFAULT_LIMIT);
	}

	public static double findWithMathPI(int limit) {
		// Math.PI has only precision up to 15 digits.
		if (limit < 0 || limit > 15)
			throw new IllegalArgumentException("limit must be > 0 && <= 15");
		double pi = Math.PI;
		String piString = String.valueOf(pi).replace(".", "");
		piString = piString.substring(0, limit + 1);
		return Double.parseDouble(piString);
	}
}
