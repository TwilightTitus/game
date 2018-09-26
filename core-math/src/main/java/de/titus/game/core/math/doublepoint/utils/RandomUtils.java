/**
 * 
 */
package de.titus.game.core.math.doublepoint.utils;

import java.util.Random;

import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class RandomUtils.
 *
 * @author Titus
 */
public final class RandomUtils {

	/** The Constant RANDOM. */
	public static final Random RANDOM = new Random();

	/**
	 * Instantiates a new random utils.
	 */
	private RandomUtils() {
	}

	/**
	 * Gets the random point.
	 *
	 * @param aScale the a scale
	 * @return the random point
	 */
	public static Vector getRandomPoint(final double aScale) {
		double x = (RandomUtils.RANDOM.nextBoolean() ? 1 : -1) * (RandomUtils.RANDOM.nextDouble() * aScale);
		double y = (RandomUtils.RANDOM.nextBoolean() ? 1 : -1) * (RandomUtils.RANDOM.nextDouble() * aScale);
		return new Vector(x, y);
	}

}
