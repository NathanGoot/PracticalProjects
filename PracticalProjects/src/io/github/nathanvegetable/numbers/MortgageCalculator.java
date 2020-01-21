package io.github.nathanvegetable.numbers;

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
		System.out.println(MortgageCalculator.getTotalLoanCost(5000, 5, 12, 10));
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
	public static double getTotalLoanCost(double initialBalance, double interestRate,
			double interestAppliedPerTimePeriod, double timePeriods) {
		return initialBalance * Math.pow((1 + ((interestRate / 100) / interestAppliedPerTimePeriod)),
				interestAppliedPerTimePeriod * timePeriods);
	}
}
