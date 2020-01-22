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
	public static final double DEFAULT_TOTAL_COST = 100000d;
	public static final double DEFAULT_YEARLY_INTEREST = 0.1d;
	public static final int DEFAULT_TERM_IN_YEARS = 30;

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter the beginning principal amount: ");
		double principal = inputScanner.nextDouble();

		System.out.println("Enter the yearly interest percentage: ");
		double yearlyInterest = inputScanner.nextDouble();

		System.out.println("Enter the term length in years: ");
		double termLength = inputScanner.nextDouble();

		System.out.println("Enter the Compound Interval");
		for (int i = 0; i < CompoundInterval.values().length; i++)
			System.out.println((i + 1) + ": " + CompoundInterval.values()[i]);
		System.out.println("Select from the above number options: ");
		CompoundInterval interval = CompoundInterval.values()[inputScanner.nextInt() - 1];

		double totalLoanCost = getTotalLoanCost(principal, yearlyInterest, termLength, interval);
		System.out.println("Total loan cost: " + totalLoanCost);
		
		inputScanner.close();
	}

	public enum CompoundInterval {
		DAILY(365.25), MONTHLY(12), YEARLY(1);
		public double amountInYear;

		CompoundInterval(double amountInYear) {
			this.amountInYear = amountInYear;
		}
	}

	/**
	 * A = P (1 + r/n)^(nt)<br/>
	 * A = the future value of the investment/loan, including interest<br/>
	 * P = the principal investment amount (the initial deposit or loan amount)<br/>
	 * r = the annual interest rate (decimal)<br/>
	 * n = the number of times that interest is compounded per unit t<br/>
	 * t = the time the money is invested or borrowed for<br/>
	 * <a href=
	 * "https://www.thecalculatorsite.com/articles/finance/compound-interest-formula.php">Source</a>
	 */
	public static double getTotalLoanCost(double initialBalance, double interestRate, double timePeriods,
			CompoundInterval compoundInterval) {
		return initialBalance * Math.pow((1 + ((interestRate / 100) / compoundInterval.amountInYear)),
				compoundInterval.amountInYear * timePeriods);
	}
}
