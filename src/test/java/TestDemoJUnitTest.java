
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	/*
	 * 1)Created a JUnit Test named assertThatTwoPositiveNumbersAreAddedCorrectly
	 * that uses @ParameterizedTest 
	 * 2)Created a JUnit Test named
	 * assertThatPairsOfPositiveNumbersAreAddedCorrectly that uses @Test indicating
	 * that it is a test method 
	 * 3)Create my Own Method & JUnit Test. 
	 * 4)Mocking a class-testDemo,Write a test for randomNumberSquared
	 */

	// create instance variable
	private TestDemo testDemo;

	// before each test this method will create new TestDemo Object
	@BeforeEach
	void setUp(){
		testDemo = new TestDemo();
	}

	// this method will test the value of expectException , if it is false , verify
	// that when TestDemo.addPositive is called with values a and b ,
	// that the result is the same as the parameter expected
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if (!expectException) {
			// when: expectException parameter is false
			// And the method addPositive is called
			// then: the return value equal the expected parameter
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			// when: expectException parameter is true
			// And the method addPositive is called
			// then: an exception is thrown
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

		}
	}

	//this method used to provide test data for parameterized tests in JUnit.
	//this method returns a Stream of Arguments objects.
	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
				//these lines are representing a  different input values and expected results for the addPositive method
				arguments(2, 4, 6, false),
				arguments(0, 10, 10, true),
				arguments(-2, 4, -2, true),
				arguments(6, 8, 14, false),
				arguments(9, 0, 9, true)
				);
		// @formatter:on

	}

	@Test
	// Package visibility method annotated with @Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		// the assertThat method from AssertJ library is used to verify the expected
		// behavior
		// The isEqualTo assertion checks whether the value returned from addPositive
		// method is equal to the specified expected value
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(4, 7)).isEqualTo(11);
		assertThat(testDemo.addPositive(8, 9)).isEqualTo(17);
	}

	// 3:
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsFordevidePositive")
	void assertThatTwoPositiveNumbersAredevideCorrectly(int dividend, int divisor, int expected,
			boolean expectException) {

		if (!expectException) {
			assertThat(testDemo.dividePositive(dividend, divisor)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.dividePositive(dividend, divisor))
					.isInstanceOf(IllegalArgumentException.class);

		}
	}

	static Stream<Arguments> argumentsFordevidePositive() {
		// @formatter:off
			return Stream.of(
					arguments(4, 2, 2, false),
					arguments(9, 3, 3, true),
					arguments(8, 4, 2, false)
					);
			// @formatter:on

	}

	@Test
	// JUnit test with @test
	void assertThatPairsOfPositiveNumbersAredevidedCorrectly() {
		assertThat(testDemo.dividePositive(10, 2)).isEqualTo(5);
		assertThat(testDemo.dividePositive(20, 10)).isEqualTo(2);
	}

	// this test creates a mock of the TestDemo class , defines a behavior
	// for the getRandomInt method to return 5, calls the randomNumberSquared method
	// on the mock object, and then verifies that the squared result is equal to the
	// expected value which is 25.
	@Test
	void assertThatNumberSquaredIsCorrect() {
		// mock the TestDemo class by using spy method
		// The spy method creates a partial mock, allowing us to retain the original
		// behavior of the class when mocking specific methods.
		TestDemo mockDemo = spy(testDemo);
		// given:sets up a specific value (5) to be returned by the getRandomInt method
		// when it is called on mockDemo object
		doReturn(5).when(mockDemo).getRandomInt();
		// when: the method randomNumberSquared called and will use 5 as a random number
		int fiveSquared = mockDemo.randomNumberSquared();
		// then: verify that the square of five is = 25
		assertThat(fiveSquared).isEqualTo(25);

	}
}
