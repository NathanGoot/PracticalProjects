package io.github.nathanvegetable.numbers;

import java.util.ArrayList;

/**
 * Project: Have the user enter a number and find all Prime Factors (if there
 * are any) and display them.
 * 
 * @author NathanVegetable
 *
 */
public class PrimeFactorization {

	public static void main(String[] args) {
		ArrayList<Integer> result = PrimeFactorization.findPrimeFactors(25);
		for (int num : result)
			System.out.println("" + num);
	}

	public static ArrayList<Integer> findPrimeFactors(int input) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for (int i = 2; i <= input; i++) {
			while (input % i == 0) {
				primeFactors.add(i);
				input /= i;
			}
		}
		return primeFactors;
	}
}
