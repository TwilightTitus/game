/**
 *
 */
package de.titus.game.core.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.titus.game.core.math.fixpoint.Number;

/**
 * The Class NumberTest.
 *
 * @author xce3560
 */
class NumberSubTests {

	/**
	 * Test sub 0 to 0.
	 */
	@Test
	void testSub_0to0() {
		long result = Number.ZERO.sub(Number.ZERO).nativ;
		Assertions.assertTrue(result == Number.ZERO.nativ, "The 0-0=1 and not " + result);
	}

	/**
	 * Test sub 1 to 1.
	 */
	@Test
	void testSub_1to1() {
		long result = Number.ONE.sub(Number.ONE).nativ;
		Assertions.assertTrue(result == Number.ZERO.nativ, "The 1-1=0 and not " + result);
	}
}
