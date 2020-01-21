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
	
	@Test
	void findToNthDigitShouldMatchHardcode() {
		double hardcodedPI3Digit = 3.14d;
		assertEquals(hardcodedPI3Digit,FindEToTheNthDigit.findWithStringFormat(Math.PI, 2));
	}
	
	@Test
	void fibonacciSequence7thDigitShouldBe8() {
		assertEquals(8, FibonacciSequence.getSequence(7)[6]);
	}
	
	@Test
	void fibonacciSequence20thDigitShouldBe4181() {
		assertEquals(4181, FibonacciSequence.getSequence(20)[19]);
	}

}
