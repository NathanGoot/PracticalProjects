package io.github.nathanvegetable.numbers;

import java.util.Scanner;

/**
 * Change Return Program - The user enters a cost and then the amount of money
 * given. The program will figure out the change and the number of quarters,
 * dimes, nickels, pennies needed for the change.
 * 
 * @author NathanVegetable
 *
 */
public class ChangeReturn {

	public static final String[] RETURN_ORDER = new String[] { "Quarters", "Dimes", "Nickels", "Pennies" };
	public static final double[] RETURN_VALUES = new double[] { 0.25d, 0.10d, 0.05d, 0.01d };

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter the initial cost: ");
		double cost = inputScanner.nextDouble();

		System.out.print("Enter the amount of money given: ");
		double given = inputScanner.nextDouble();

		int[] change = getChange(cost, given);
	}

	/**
	 * 
	 * @param cost
	 *            The starting cost
	 * @param amountGiven
	 *            The amount paid towards the cost
	 * @return An array following {@link #RETURN_ORDER} and {@link #RETURN_VALUES}
	 *         giving the amount of change per change type given to give back for
	 *         over-payment of the <b>cost</b>
	 */
	public static int[] getChange(double cost, double amountGiven) {
		// TODO
		return null;
	}
}
