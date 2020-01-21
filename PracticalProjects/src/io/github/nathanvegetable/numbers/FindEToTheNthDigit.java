package io.github.nathanvegetable.numbers;

/**
 * @author Nathan Gutauckas
 */
public class FindEToTheNthDigit {

	public static void main(String[] args) {
		double result = FindEToTheNthDigit.findWithStringFormat(Math.PI, 10);
		System.out.println(result);
	}

	public static double findWithStringFormat(double input, int digits) {
		return Double.parseDouble(String.format("%." + digits + "f", input));
	}
}
