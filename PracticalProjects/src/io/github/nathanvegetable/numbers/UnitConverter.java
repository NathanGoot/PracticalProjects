package io.github.nathanvegetable.numbers;

/**
 * Project: Unit Converter (temp, currency, volume, mass and more) - Converts
 * various units between one another. The user enters the type of unit being
 * entered, the type of unit they want to convert to and then the value. The
 * program will then make the conversion.
 * 
 * @author NathanVegetable
 * 
 *         I have decided to use one penny as the base value (1).
 *
 */
public class UnitConverter {

	public static void main(String[] args) {

	}

	public static enum Currency implements Unit {
		PENNY(1), NICKEL(5), DIME(10), QUARTER(25), HALF_DOLLAR(50), DOLLAR(100), TEN_DOLLAR_BILL(
				1000), TWENTY_DOLLAR_BILL(2000), FIFTY_DOLLAR_BILL(5000), HUNDRED_DOLLAR_BILL(10000);
		long value;

		Currency(long value) {
			this.value = value;
		}

		@Override
		public double multiplicationToReachOnePenny() {
			return 1;
		}
	}

	public abstract interface Unit {
		/**
		 * Each Unit class can have it's own values, for example Mass could have 1 pound
		 * as value 1. If 1 pound is valued at $1.00, then this should return 100.<br/>
		 * Using this, inter-unit conversions can occur with the same base-level
		 * comparison to a penny.
		 */
		public double multiplicationToReachOnePenny();
	}
}
