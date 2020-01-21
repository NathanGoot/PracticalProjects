/**
 * 
 */
package io.github.nathanvegetable.numbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Nathan
 *
 */
class TestNumbers {

	@Test
	void piMathMaxPrecisionShouldHaveNoChange() {
		double pi = Math.PI;
		assertEquals(pi, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION));
	}

	@Test
	void piMathMaxPrecisionMinusOneShouldChange() {
		double pi = Math.PI;
		assertNotEquals(pi, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION - 1));
	}

}
