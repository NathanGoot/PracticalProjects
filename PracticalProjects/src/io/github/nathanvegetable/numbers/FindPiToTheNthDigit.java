package io.github.nathanvegetable.numbers;

public class FindPiToTheNthDigit {
	public static int DEFAULT_LIMIT = 10;
	public static int MATH_PI_MAX_PRECISION = 15;

	public static void main(String[] args) {
		double result = FindPiToTheNthDigit.findWithMathPI(DEFAULT_LIMIT);
		System.out.println(doubleStringNoNotation(result, DEFAULT_LIMIT));
	}

	public static double findWithMathPI(int limit) {
		// Math.PI has only precision up to 15 digits.
		if (limit < 0 || limit > MATH_PI_MAX_PRECISION)
			throw new IllegalArgumentException("limit must be > 0 && <= " + MATH_PI_MAX_PRECISION);
		double pi = Math.PI;
		String piString = doubleStringNoNotation(pi, MATH_PI_MAX_PRECISION).replace(".", "");
		piString = piString.substring(1, limit);
		return Double.parseDouble("3." + piString);
	}

	private static String doubleStringNoNotation(double number, int digits) {
		return String.format("%." + digits + "f", number);
	}
}
