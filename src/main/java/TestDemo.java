

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {

	/*
	 * This method takes two integer parameters a and b and returns their sum if
	 * both a and b are greater than 0. If either a or b is not greater than 0, it
	 * throws an IllegalArgumentException with the message
	 * "Both parameters must be positive!".
	 */
	public int addPositive(int a, int b) {

		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");

		}
	}

	/*
	 * This method takes two integer parameters dividend and divisor and returns
	 * their division if both dividend and divisor are positive, they are even
	 * number and dividend > divisor. otherwise it throws an
	 * IllegalArgumentException with the message
	 * "Both parameters must be positive!".
	 */
	int dividePositive(int dividend, int divisor) {

		if (dividend > 0 && divisor > 0 && dividend % 2 == 0 && divisor % 2 == 0 && dividend > divisor) {
			return dividend / divisor;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");

		}
	}

	// this Method to obtain a random int between 1 and 10 and return its square
	public int randomNumberSquared() {
		// call getRandomInt method and the value assigned to variable called randomNumber
		int randomNumber = getRandomInt();
		// returns the square of the random number obtained by multiplying it by itself.
		return randomNumber * randomNumber;
	}

	// this method generates a random int between 1 and 10
	// It is package visibility, which means it can be accessed
    // within the same package. It is annotated with @VisibleForTesting for clarity.
	@VisibleForTesting
	int getRandomInt() {
		// create instance of Random class
		Random random = new Random();
		// The result of random.nextInt(10) will be an integer from 0 to 9.
		// + 1 is added to the result of random.nextInt(10) to shift the range from 1 to
		// 10 instead of 0 to 9. 
		return random.nextInt(10) + 1;
	}
}
