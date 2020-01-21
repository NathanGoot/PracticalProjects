package io.github.nathanvegetable.numbers;

/**
 * @author Nathan Gutauckas
 */
public class FindPiToTheNthDigit {
	public static int DEFAULT_LIMIT = 10;
	public static int MATH_PI_MAX_PRECISION = 15;

	public static void main(String[] args) {
		double result = FindPiToTheNthDigit.findWithMathPI(DEFAULT_LIMIT);
		System.out.println(result);
	}

	public static double findWithMathPI(int limit) {
		// Math.PI has only precision up to 15 digits.
		if (limit < 0 || limit > MATH_PI_MAX_PRECISION)
			throw new IllegalArgumentException("limit must be > 0 && <= " + MATH_PI_MAX_PRECISION);
		double pi = Math.PI;
		String piString = String.valueOf(pi).replace(".", "");
		piString = piString.substring(1, limit + 1);
		return Double.parseDouble("3." + piString);
	}
}
