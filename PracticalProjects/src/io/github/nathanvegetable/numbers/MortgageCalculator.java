package io.github.nathanvegetable.numbers;

import java.util.Scanner;

/**
 * Project: Mortgage Calculator - Calculate the monthly payments of a fixed term
 * mortgage over given Nth terms at a given interest rate. Also figure out how
 * long it will take the user to pay back the loan. For added complexity, add an
 * option for users to select the compounding interval (Monthly, Weekly, Daily,
 * Continually).
 * 
 * @author NathanVegetable
 *
 */
public class MortgageCalculator {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter the beginning principal amount: ");
		double principal = inputScanner.nextDouble();

		System.out.println("Enter the yearly interest percentage: ");
		double yearlyInterest = inputScanner.nextDouble();

		System.out.println("Enter the term length in years: ");
		double termLength = inputScanner.nextDouble();

		double totalLoanCost = getTotalLoanCost(principal, yearlyInterest, termLength);
		System.out.println("Total loan cost: " + totalLoanCost);

		double monthlyPayments = totalLoanCost / termLength / 12d;
		System.out.println("Fixed monthly payments: " + monthlyPayments + " for " + (termLength / 12d) + " months.");

		inputScanner.close();
	}

	public static double getTotalLoanCost(double initialBalance, double interestRate, double yearsOfTerm) {
		return getLoanMonthlyPayment(initialBalance, interestRate, yearsOfTerm) * 12 * yearsOfTerm;
	}

	/**
	 * M = P [ i(1 + i)n ] / [ (1 + i)n - 1]<br/>
	 * M = the monthly payment<br/>
	 * P = the principal investment amount (the initial deposit or loan amount)<br/>
	 * r = the annual interest rate (decimal) divided by the compounding rate<br/>
	 * n = the amount of payments<br/>
	 * <a href="https://www.fonerbooks.com/interest.htm">Source</a>
	 */
	public static double getLoanMonthlyPayment(double initialBalance, double interestRate, double yearsOfTerm) {
		double p = initialBalance;
		double i = (interestRate / 100) / 12;
		double n = 12 * yearsOfTerm;
		return p * ((i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1));
	}
}
