package io.github.nathanvegetable.numbers;

/**
 * Project: Fibonacci Sequence - Enter a number and have the program generate
 * the Fibonacci sequence to that number or to the Nth number.
 * 
 * @author NathanVegetable
 */
public class FibonacciSequence {

	public static void main(String[] args) {
		int[] result = FibonacciSequence.getSequence(10);
		for (int num : result)
			System.out.println("" + num);
	}

	public static int[] getSequence(int digits) {
		if (digits <= 0)
			throw new IllegalArgumentException("digits must be > 0");
		int[] sequence = new int[digits];
		if (digits > 1)
			sequence[1] = 1;
		for (int i = 2; i < sequence.length; i++)
			sequence[i] = sequence[i - 1] + sequence[i - 2];
		return sequence;
	}
}
