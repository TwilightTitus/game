package de.titus.game.core.math.java;

import org.junit.jupiter.api.Test;

class PerformenceTests {

	public static final int REPITATION = 100000;
	public static final int ITERATIONS = 1000000000;

	@Test
	void testBooleanCeck() {
		boolean test = true;
		long start = System.nanoTime();
		for (int n = 0; n < PerformenceTests.REPITATION; n++)
			for (int i = 0; i < PerformenceTests.ITERATIONS; i++)
				if (test)
					test = !test;
				else
					test = !test;

		long end = System.nanoTime();
		System.out.println("testBooleanCeck runtime: " + ((end - start) / PerformenceTests.REPITATION) + "ns");
	}

	@Test
	void testLongCeck() {
		long test = 0;
		long start = System.nanoTime();
		for (int n = 0; n < PerformenceTests.REPITATION; n++)
			for (int i = 0; i < PerformenceTests.ITERATIONS; i++)
				if (test == 0)
					test = 1;
				else
					test = 0;

		long end = System.nanoTime();
		System.out.println("testLongCeck runtime: " + ((end - start) / PerformenceTests.REPITATION) + "ns");
	}

}
