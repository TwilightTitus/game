/**
 *
 */
package de.titus.game.core.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The Class NumberTest.
 *
 * @author xce3560
 */
class NumberSumTests {

	private static final int REPITATION = 10000;
	private static final int ITERATIONS = 1000000;

	/**
	 * ******************************************** SUM TESTS
	 * ********************************************.
	 */

	/**
	 * Test sum 0 to 0.
	 */

	@Test
	void testSum_0to0() {
		long result = Number.ZERO.sum(Number.ZERO).nativ;
		Assertions.assertTrue(result == Number.ZERO.nativ, "The 0+0=0 and not " + result);
	}

	/**
	 * Test sum 0 to 1.
	 */
	@Test
	void testSum_0to1() {
		long result = Number.ZERO.sum(Number.ONE).nativ;
		Assertions.assertTrue(result == Number.ONE.nativ, "The 0+1=1 and not " + result);
	}

	/**
	 * Test sum 1 to 0.
	 */
	@Test
	void testSum_1to0() {
		long result = Number.ONE.sum(Number.ZERO).nativ;
		Assertions.assertTrue(result == Number.ONE.nativ, "The 1+0=1 and not " + result);
	}

	/**
	 * Test sum 1 to 1.
	 */
	@Test
	void testSum_1to1() {
		long result = Number.ONE.sum(Number.ONE).nativ;
		Assertions.assertTrue(result == 2 * MathContext.PRECISION, "The 1+1=2 and not " + result);
	}

	/**
	 * Test sum 1 to max value.
	 */
	@Test
	void testSum_1ToMaxValue() {
		Number result = Number.MAX_VALUE.sum(Number.ONE);
		Assertions.assertTrue(Number.POSITIV_INFINITY.equals(result), "The max-value+1=positiv infinity and not " + result);
	}

	/**
	 * Test sum 1 to max value.
	 */
	@Test
	void testSum_MinValueToMaxValue() {
		Number result = Number.MAX_VALUE.sum(Number.MIN_VALUE);
		Assertions.assertTrue(result.nativ == 0, "The max value+min value=0 and not " + result);
	}

	/**
	 * Test sum 1 to max value.
	 */
	@Test
	void testSum_1ToPositivInfinity() {
		Number result = Number.POSITIV_INFINITY.sum(Number.ONE);
		Assertions.assertTrue(Number.POSITIV_INFINITY.equals(result), "The positiv infinity+1=NaN and not " + result);
	}

	/**
	 * Test sum 1 to max value.
	 */
	@Test
	void testSum_MaxValueToMaxValue() {
		Number result = Number.MAX_VALUE.sum(Number.MAX_VALUE);
		Assertions.assertTrue(Number.POSITIV_INFINITY.equals(result), "The max value + max value = 0 and not " + result);
	}

	@Test
	void testSumPerformence() {
		long test = 0;
		long start = System.currentTimeMillis();
		for (int n = 0; n < NumberSumTests.REPITATION; n++) {
			for (int i = 0; i < NumberSumTests.ITERATIONS; i++)
				if (test == Long.MAX_VALUE)
					test = 0;
				else
					test = test + 0;
		}

		long end = System.currentTimeMillis();
		double runtimeNativ = (double) (end - start) / NumberSumTests.REPITATION;

		Number number = Number.ZERO;
		start = System.currentTimeMillis();
		for (int n = 0; n < NumberSumTests.REPITATION; n++) {
			for (int i = 0; i < NumberSumTests.ITERATIONS; i++)
				if (number.equals(Number.MAX_VALUE))
					number = Number.ZERO;
				else
					number = number.sum(Number.ONE);
		}

		end = System.currentTimeMillis();
		double runtimeLogic = (double) (end - start) / NumberSumTests.REPITATION;

		System.out.println("testSumPerformence operation count: " + (long) NumberSumTests.REPITATION * (long) NumberSumTests.ITERATIONS);
		System.out.println("testSumPerformence runtime (nativ long): " + runtimeNativ + "ms");
		System.out.println("testSumPerformence runtime (nativ long) avg: " + runtimeNativ * 1000000 / NumberSumTests.ITERATIONS + "ns");
		System.out.println("testSumPerformence runtime: " + runtimeLogic + "ms");
		System.out.println("testSumPerformence runtime avg: " + runtimeLogic * 1000000 / NumberSumTests.ITERATIONS + "ns");

	}

}
