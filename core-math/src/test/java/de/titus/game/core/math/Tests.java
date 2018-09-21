/**
 *
 */
package de.titus.game.core.math;

import org.junit.jupiter.api.Test;

import de.titus.game.core.math.fixpoint.MathContext;

/**
 * @author xce3560
 *
 */
public class Tests {

	@Test
	void vectorTest() {
		System.out.println("\n*********************");
		long x = 5 * MathContext.PRECISION / 10;
		long y = 5 * MathContext.PRECISION / 10;
		System.out.println("x: " + x);
		System.out.println("y: " + y);

		boolean fail = false;
		long xt = x;
		long yt = y;
		if (Math.abs(x) > MathContext.PRECISION) {
			xt = xt / MathContext.PRECISION;
			yt = yt / MathContext.PRECISION;
			fail = true;
		} else if (y > MathContext.PRECISION) {
			xt = xt / MathContext.PRECISION;
			yt = yt / MathContext.PRECISION;
			fail = true;
		}
		System.out.println("xt: " + xt);
		System.out.println("yt: " + yt);
		System.out.println("xt * xt: " + (xt * xt));
		long length = (long) (Math.sqrt(xt * xt + yt * yt)) * (fail ? MathContext.PRECISION : 1);
		System.out.println("length: " + length);

		x = x * MathContext.PRECISION / length;
		y = y * MathContext.PRECISION / length;

		System.out.println("normalized: (" + x + ", " + y + ")");
		System.out.println("normalized length: " + (Math.sqrt(x * x + y * y)) / MathContext.PRECISION);

		System.out.println("\n*********************");
		double x1 = 500000;
		double y1 = 500000;

		double length1 = Math.sqrt(x1 * x1 + y1 * y1);
		System.out.println("length1: " + length1);
		System.out.println("x1: " + x1);
		System.out.println("y1: " + y1);
		x1 = x1 / length1;
		y1 = y1 / length1;
		System.out.println("normalized: (" + x1 + ", " + y1 + ")");
		System.out.println("normalized: (" + (long) (x1 * MathContext.PRECISION) + ", " + (long) (y1 * MathContext.PRECISION) + ")");
		System.out.println("normalized length: " + (Math.sqrt(x1 * x1 + y1 * y1)));

	}
}
