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

	/**
	 * Finds Pi to the Nth digit.<br/>
	 * Has a max precision of 15 digits due to {@link Math#PI} only storing 15
	 * digits.
	 */
	public static double findWithMathPI(int limit) {
		if (limit < 0 || limit > MATH_PI_MAX_PRECISION)
			throw new IllegalArgumentException("limit must be > 0 && <= " + MATH_PI_MAX_PRECISION);
		double pi = Math.PI;
		String piString = String.valueOf(pi).replace(".", "");
		piString = piString.substring(1, limit + 1);
		return Double.parseDouble("3." + piString);
	}
}
