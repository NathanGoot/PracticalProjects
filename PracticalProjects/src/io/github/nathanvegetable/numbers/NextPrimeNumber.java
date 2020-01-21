package io.github.nathanvegetable.numbers;

import java.math.BigInteger;

/**
 * Project: Have the program find prime numbers until the user chooses to stop
 * asking for the next one.
 * 
 * @author NathanVegetable
 *
 */
public class NextPrimeNumber {

	public static void main(String[] args) {
		int nextNumber = NextPrimeNumber.findNextPrimeNumber(1005);
		System.out.println(nextNumber);
	}

	public static int findNextPrimeNumber(int input) {
		int nextNum = input++;
		while (!isPrimeNumber(nextNum))
			nextNum++;
		return nextNum;
	}

	public static int findNextPrimeNumberWithBigInteger(int input) {
		BigInteger bigInt = new BigInteger(String.valueOf(input));
		return Integer.parseInt(bigInt.nextProbablePrime().toString());
	}

	public static boolean isPrimeNumber(int input) {
		if (input < 2)
			return false;
		for (int i = 2; i < input; i++)
			if (input % i == 0)
				return false;
		return true;
	}
}
