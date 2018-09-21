package de.titus.game.core.math.fixpoint;

/**
 * The Class Number.
 */
public final class NumberUtils {

	/**
	 * Instantiates a new number utils.
	 */
	private NumberUtils() {
	}

	/**
	 * Checks if is positiv infinity.
	 *
	 * @param aLong the a long
	 * @return true, if is positiv infinity
	 */
	public static boolean isPositivInfinity(final long aLong) {
		return aLong > Number.MAX_VALUE.nativ;
	}

	/**
	 * Checks if is negativ infinity.
	 *
	 * @param aLong the a long
	 * @return true, if is negativ infinity
	 */
	public static boolean isNegativInfinity(final long aLong) {
		return aLong < Number.MIN_VALUE.nativ;
	}

	/**
	 * Checks if is between one and zero.
	 *
	 * @param aLong the a long
	 * @return true, if is between one and zero
	 */
	public static boolean isBetweenOneAndZero(final long aLong) {
		return aLong > 0 && aLong < Number.ONE.nativ;
	}

	/**
	 * Checks if is between zero and negativ one.
	 *
	 * @param aLong the a long
	 * @return true, if is between zero and negativ one
	 */
	public static boolean isBetweenZeroAndNegativOne(final long aLong) {
		return aLong < 0 && aLong > (Number.ONE.nativ * -1);
	}

	/**
	 * Checks if is out of range.
	 *
	 * @param aNumber the a number
	 * @return true, if is out of range
	 */
	public static boolean isOutOfRange(final Number aNumber) {
		if (Number.MAX_VALUE.nativ < aNumber.nativ || Number.MIN_VALUE.nativ > aNumber.nativ)
			return true;

		return false;
	}

	/**
	 * Checks if is in range.
	 *
	 * @param aNumber the a number
	 * @return true, if is in range
	 */
	public static boolean isInRange(final Number aNumber) {
		return !NumberUtils.isOutOfRange(aNumber);
	}

}
