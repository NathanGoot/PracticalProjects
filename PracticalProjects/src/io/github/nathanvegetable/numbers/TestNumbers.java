/**
 * 
 */
package io.github.nathanvegetable.numbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Nathan Gutauckas
 */
class TestNumbers {

	@Test
	void piMathMaxPrecisionShouldHaveNoChange() {
		double desiredResult = 3.141592653589793d;
		assertEquals(desiredResult, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION));
	}

	@Test
	void piMathMaxPrecisionMinusOneShouldChange() {
		double desiredResult = 3.14159265358979d;
		assertEquals(desiredResult, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION - 1));
	}

}
