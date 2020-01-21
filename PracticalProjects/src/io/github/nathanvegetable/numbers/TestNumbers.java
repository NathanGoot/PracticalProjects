package io.github.nathanvegetable.numbers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author NathanVegetable
 */
class TestNumbers {

	@Test
	void piMathShouldMatchHardcodePI15Digit() {
		double hardcodedPI15Digit = 3.141592653589793d;
		assertEquals(hardcodedPI15Digit, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION));
	}

	@Test
	void piMathShouldMatchHardcodePI14Digit() {
		double hardcodedPI14Digit = 3.14159265358979d;
		assertEquals(hardcodedPI14Digit,
				FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION - 1));
	}

	@Test
	void findToNthDigitShouldMatchHardcode() {
		double hardcodedPI3Digit = 3.14d;
		assertEquals(hardcodedPI3Digit, FindEToTheNthDigit.findWithStringFormat(Math.PI, 2));
	}

	@Test
	void fibonacciSequence7thDigitShouldBe8() {
		assertEquals(8, FibonacciSequence.getSequence(7)[6]);
	}

	@Test
	void fibonacciSequence20thDigitShouldBe4181() {
		assertEquals(4181, FibonacciSequence.getSequence(20)[19]);
	}

	@Test
	void primeFactorOf15Is3And5() {
		ArrayList<Integer> result = PrimeFactorization.findPrimeFactors(15);
		boolean[] found = new boolean[2];
		int[] lookingFor = new int[] { 3, 5 };
		for (int i = 0; i < result.size(); i++)
			for (int j = 0; j < lookingFor.length; j++)
				if (result.get(i) == lookingFor[j])
					found[j] = true;
		assertTrue(found[0] && found[1]);
	}

	@Test
	void nextPrimeNumberAfter1005Is1009() {
		assertEquals(1009, NextPrimeNumber.findNextPrimeNumber(1005));
		assertEquals(1009, NextPrimeNumber.findNextPrimeNumberWithBigInteger(1005));
	}

	@Test
	void costOfTilesMatch() {
		int tileSize = 2, floorSize = 4, cost = 2, expectedCost = 8;
		assertEquals(expectedCost,
				FindCostOfTileToCoverWxHFloor.findCostOfFloorPlan(cost, tileSize, tileSize, floorSize, floorSize));
	}

}
