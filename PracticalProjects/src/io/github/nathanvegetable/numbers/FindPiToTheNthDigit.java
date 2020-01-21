package io.github.nathanvegetable.numbers;

public class FindPiToTheNthDigit {
	public static int DEFAULT_LIMIT = 10;
	
	public static void main(String[] args) {
		FindPiToTheNthDigit.findWithLimit(DEFAULT_LIMIT);
	}

	public static double findWithLimit(int limit) {
		double pi = Math.PI;
		String piString = String.valueOf(pi).replace(".", "");
		piString = piString.substring(0, limit + 1);
		return Double.parseDouble(piString);
	}
}
