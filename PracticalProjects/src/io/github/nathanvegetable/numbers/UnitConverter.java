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

	/**
	 * Per
	 * <a href="https://goldprice.org/gold-price-per-gram.html">GoldPrice.org</a> as
	 * of 10:46PM 01/29/2020, gold is worth $50.73 per gram.<br/>
	 * When comparing money to weight, we compare weight in gold.
	 */
	public static enum Mass implements Unit {
		MILLIGRAM(0.001), CENTIGRAM(0.01), DECIGRAM(0.1), GRAM(1), DEKAGRAM(10), HECTOGRAM(100), KILOGRAM(
				1000), METRIC_TON(1000000), OUNCE(28.3495), POUND(453.592), TON(907185);
		double value;

		Mass(double value) {
			this.value = value;
		}

		@Override
		public double multiplicationToReachOneDollar() {
			return 1 / 50.73;
		}

	}

	public static enum Currency implements Unit {
		PENNY(0.01), NICKEL(0.05), DIME(0.1), QUARTER(0.25), HALF_DOLLAR(0.50), DOLLAR(1), TEN_DOLLAR_BILL(
				10), TWENTY_DOLLAR_BILL(20), FIFTY_DOLLAR_BILL(50), HUNDRED_DOLLAR_BILL(100);
		double value;

		Currency(double value) {
			this.value = value;
		}

		@Override
		public double multiplicationToReachOneDollar() {
			return 1;
		}
	}

	public abstract interface Unit {
		/**
		 * Each Unit class can have it's own values, for example Mass could have 1 pound
		 * as value 1. If 1 pound is valued at $1.00, then this should return 1.<br/>
		 * Using this, inter-unit conversions can occur with the same base-level
		 * comparison to a dollar.
		 */
		public double multiplicationToReachOneDollar();
	}
}
