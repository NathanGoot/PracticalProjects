package io.github.nathanvegetable.numbers;

import java.util.Scanner;

/**
 * Project: Unit Converter (temp, currency, volume, mass and more) - Converts
 * various units between one another. The user enters the type of unit being
 * entered, the type of unit they want to convert to and then the value. The
 * program will then make the conversion.
 * 
 * @author NathanVegetable
 * 
 *         I have decided to use one dollar as the base value (1).
 *
 */
public class UnitConverter {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String[] unitOptions = new String[] { Currency.class.getSimpleName(), Mass.class.getSimpleName(),
				Length.class.getSimpleName(), Speed.class.getSimpleName(), Time.class.getSimpleName() };

		System.out.println("Select a starting unit type:");
		for (int i = 0; i < unitOptions.length; i++)
			System.out.println((i + 1) + ": " + unitOptions[i]);

		int start = inputScanner.nextInt();
		System.out.println("Select an ending unit type:");
		int end = inputScanner.nextInt();
		int[] selections = new int[] { start, end };
		Unit[][] unitsToSelectFrom = new Unit[][] { {}, {} };
		for (int i = 0; i < selections.length; i++) {
			switch (selections[i]) {
			case 1:
				unitsToSelectFrom[i] = Currency.values();
				break;
			case 2:
				unitsToSelectFrom[i] = Mass.values();
				break;
			case 3:
				unitsToSelectFrom[i] = Length.values();
				break;
			case 4:
				unitsToSelectFrom[i] = Speed.values();
				break;
			case 5:
				unitsToSelectFrom[i] = Time.values();
				break;
			default:
				System.err.println("Could not find selection.");
				return;
			}
		}
		System.out.println("Select a starting unit:");
		for (int i = 0; i < unitsToSelectFrom[0].length; i++)
			System.out.println((i + 1) + ": " + unitsToSelectFrom[0][i]);
		int startUnitIdx = inputScanner.nextInt();
		Unit startUnit = unitsToSelectFrom[0][startUnitIdx - 1];

		System.out.println("Select your starting value of " + startUnit + ":");
		double startingValue = inputScanner.nextDouble();

		System.out.println("Select an ending unit:");
		for (int i = 0; i < unitsToSelectFrom[1].length; i++)
			System.out.println((i + 1) + ": " + unitsToSelectFrom[1][i]);
		int endUnitIdx = inputScanner.nextInt();
		Unit endUnit = unitsToSelectFrom[1][endUnitIdx - 1];

		double value = getValueOfAlternateUnit(startingValue, startUnit, endUnit);
		System.out.println(startingValue + " " + startUnit + " is equal to " + value + " " + endUnit);

		inputScanner.close();
	}

	public static double getValueOfAlternateUnit(double inputValue, Unit inputUnit, Unit outputUnit) {
		return inputValue * inputUnit.valueOfUnitToDollars() / outputUnit.valueOfUnitToDollars();
	}

	public static enum Currency implements Unit {
		PENNY(0.01), NICKEL(0.05), DIME(0.1), QUARTER(0.25), HALF_DOLLAR(0.50), DOLLAR(1), TEN_DOLLAR_BILL(
				10), TWENTY_DOLLAR_BILL(20), FIFTY_DOLLAR_BILL(50), HUNDRED_DOLLAR_BILL(100);
		double value;

		Currency(double value) {
			this.value = value;
		}

		@Override
		public double valueOfUnitToDollars() {
			return value;
		}
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
		public double valueOfUnitToDollars() {
			return value * 50.73;
		}
	}

	/**
	 * In honor of the long-gone $5 footlong at Subway, we compare 1 foot to 5
	 * dollars.
	 */
	public static enum Length implements Unit {
		INCH(1 / 12), FOOT(1), YARD(3), MILE(5280), MILLIMETER(0.00328084), CENTIMETER(0.0328084), DECIMETER(
				0.328084), METER(3.28084), KILOMETER(3280.84);
		double value;

		Length(double value) {
			this.value = value;
		}

		@Override
		public double valueOfUnitToDollars() {
			return value * 5;
		}
	}

	/**
	 * Per <a
	 * href=https://cleantechnica.com/2018/07/15/tesla-range-plotted-relative-to-speed-temperature-graphs/>CleanTechnica</a>
	 * the consumed power of a Model S temp <32F at 60mph is 20kW. The average
	 * electricy cost in the US as of September 2018 is <a
	 * href="https://www.electricchoice.com/electricity-prices-by-state/"13.19
	 * cents</a>. The cost of 60mph therefore is 263.80, leaving 1mph at 4.397.
	 */
	public static enum Speed implements Unit {
		MILES_PER_HOUR(1), KILOMETERS_PER_HOUR(1.60934);
		double value;

		Speed(double value) {
			this.value = value;
		}

		@Override
		public double valueOfUnitToDollars() {
			return value * 4.397;
		}
	}

	/**
	 * Per <a href=
	 * "https://tradingeconomics.com/united-states/wages">TradingEconomics.com</a>
	 * the average US hourly wage as of December 2019 is $23.79.
	 */
	public static enum Time implements Unit {
		SECOND(1 / 60 / 60), MINUTE(1 / 60), HOUR(1), DAY(24), WEEK(24 * 7), MONTH(24 * 365.25 / 12), YEAR(24 * 365.25);
		double value;

		Time(double value) {
			this.value = value;
		}

		@Override
		public double valueOfUnitToDollars() {
			return value * 23.79;
		}
	}

	public abstract interface Unit {
		/**
		 * Each Unit class can have it's own values, for example Mass could have 1 pound
		 * as value 1. If 1 pound is valued at $1.00, then this should return 1.<br/>
		 * Using this, inter-unit conversions can occur with the same base-level
		 * comparison to a dollar.
		 */
		public double valueOfUnitToDollars();
	}
}
