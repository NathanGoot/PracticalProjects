package io.github.nathanvegetable.numbers;

/**
 * 
 * Project: Find PI to the Nth Digit - Enter a number and have the program
 * generate PI up to that many decimal places. Keep a limit to how far the
 * program will go.
 * 
 * @author NathanVegetable
 */
public class FindPiToTheNthDigit {
	public static int DEFAULT_LIMIT = 10;
	public static int MATH_PI_MAX_PRECISION = 15;

	public static void main(String[] args) {
		double result = FindPiToTheNthDigit.findWithMathPI(DEFAULT_LIMIT);
		System.out.println(result);
	}

	/**
	 * Has a max precision of 15 digits due to {@link Math#PI} only storing 15
	 * digits.
	 * 
	 * @param limit
	 *            The amount of decimals to trim the result to
	 * @return Pi to the Nth digit.
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
