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
	void piMathShouldMatchHardcodePI15Digit() {
		double hardcodedPI15Digit = 3.141592653589793d;
		assertEquals(hardcodedPI15Digit, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION));
	}

	@Test
	void piMathShouldMatchHardcodePI14Digit() {
		double hardcodedPI14Digit = 3.14159265358979d;
		assertEquals(hardcodedPI14Digit, FindPiToTheNthDigit.findWithMathPI(FindPiToTheNthDigit.MATH_PI_MAX_PRECISION - 1));
	}

}
