package io.github.nathanvegetable.numbers;

/**
 * Project: Find e to the Nth Digit - Just like the previous problem, but with e
 * instead of PI. Enter a number and have the program generate e up to that many
 * decimal places. Keep a limit to how far the program will go.
 * 
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
