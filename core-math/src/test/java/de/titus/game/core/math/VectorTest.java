package de.titus.game.core.math;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * The Class VectorTest.
 */
class VectorTest {

	/**
	 * Test length of vector 1 1.
	 */
	@Test
	void testLengthOfVector1_1() {

		Vector one = new Vector(Number.ONE, Number.ZERO);
		Assertions.assertTrue(one.getLength().equals(Number.ONE));
		one = new Vector(Number.ZERO, Number.ONE);
		Assertions.assertTrue(one.getLength().equals(Number.ONE));
	}

	/**
	 * Test nomalize performance X 1000000.
	 */
	@RepeatedTest(value = 1000)
	void testNomalizePerformanceX1000000() {
		Random rand = new Random();
		for (int i = 0; i < 1000000; i++) {
			Number x = Number.toNumber((long) (rand.nextDouble() * 1000), (long) (rand.nextDouble() * 1000));
			Number y = Number.toNumber((long) (rand.nextDouble() * 1000), (long) (rand.nextDouble() * 1000));
			Vector v = new Vector(x, y);
			Assertions.assertTrue(v.normalize().getLength().equals(Number.ONE));
		}
	}

}
