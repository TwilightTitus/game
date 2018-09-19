/**
 *
 */
package de.titus.game.core.math;

import org.junit.jupiter.api.Test;

/**
 * @author xce3560
 *
 */
public class Tests {

	@Test
	void vectorTest() {

		long x = -500000 * MathContext.PRECISION;
		long y = 700000 * MathContext.PRECISION;
		long length = (long) (Math.sqrt(x * x + y * y));
		System.out.println("length: " + length);
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		x = x * MathContext.PRECISION / length;
		y = y * MathContext.PRECISION / length;

		System.out.println("normalized: (" + x + ", " + y + ")");
		System.out.println("normalized length: " + (Math.sqrt(x * x + y * y) - MathContext.PRECISION));

		double x1 = -500000;
		double y1 = 700000;

		double length1 = Math.sqrt(x1 * x1 + y1 * y1);
		System.out.println("length1: " + length1);
		System.out.println("x1: " + x1);
		System.out.println("y1: " + y1);
		x1 = x1 / length1;
		y1 = y1 / length1;
		System.out.println("normalized: (" + x1 + ", " + y1 + ")");
		System.out.println("normalized: (" + (long) (x1 * MathContext.PRECISION) + ", " + (long) (y1 * MathContext.PRECISION) + ")");

	}
}
