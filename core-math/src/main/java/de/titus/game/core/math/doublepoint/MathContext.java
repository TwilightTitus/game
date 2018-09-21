/**
 *
 */
package de.titus.game.core.math.doublepoint;

/**
 * The Class Math.
 *
 * @author xce3560
 */
public final class MathContext {

	/**
	 * Instantiates a new math.
	 */
	private MathContext() {
	}

	/** The Constant LOWEST_POSITIV_VALUE. */
	public static final double	LOWEST_POSITIV_VALUE	= 0.0000001;

	/** The Constant POSITIV_INFINITY. */
	public static final double	POSITIV_INFINITY		= 1000000;

	/** The Constant NEGATIV_INFINITY. */
	public static final double	NEGATIV_INFINITY		= MathContext.POSITIV_INFINITY * -1;

	/** The Constant MAX_VALUE. */
	public static final double	MAX_VALUE				= MathContext.POSITIV_INFINITY - MathContext.LOWEST_POSITIV_VALUE;

	/** The Constant MIN_VALUE. */
	public static final double	MIN_VALUE				= MathContext.NEGATIV_INFINITY + MathContext.LOWEST_POSITIV_VALUE;

	/** The Constant PI. */
	public static final double	PI						= java.lang.Math.PI;

	/** The Constant NEGATIV_PI. */
	public static final double	NEGATIV_PI				= java.lang.Math.PI * -1;

	/** The Constant PIx2. */
	public static final double	PIx2					= java.lang.Math.PI * 2;

	/** The Constant NEGATIV_PIx2. */
	public static final double	NEGATIV_PIx2			= java.lang.Math.PI * -2;

	/** The Constant E. */
	public static final double	E						= java.lang.Math.E;

	/**
	 * In range.
	 *
	 * @param aNumber the a number
	 * @return true, if successful
	 */
	public static boolean inRange(final double aNumber) {
		if (MathContext.NEGATIV_INFINITY < aNumber && aNumber < MathContext.POSITIV_INFINITY)
			return true;

		return false;
	}

	/**
	 * Out range.
	 *
	 * @param aNumber the a number
	 * @return true, if successful
	 */
	public static boolean outRange(final double aNumber) {
		return !MathContext.inRange(aNumber);
	}

}
