package de.titus.game.core.math;

/**
 * The Class Number.
 */
public final class NumberUtils {

	private NumberUtils() {
	}

	public static boolean isPositivInfinity(final long aLong) {
		return aLong > Number.MAX_VALUE.nativ;
	}

	public static boolean isNegativInfinity(final long aLong) {
		return aLong < Number.MIN_VALUE.nativ;
	}

	public static boolean isBetweenOneAndZero(final long aLong) {
		return aLong > 0 && aLong < Number.ONE.nativ;
	}

	public static boolean isBetweenZeroAndNegativOne(final long aLong) {
		return aLong < 0 && aLong > (Number.ONE.nativ * -1);
	}

}
