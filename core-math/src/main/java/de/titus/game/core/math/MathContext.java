/**
 *
 */
package de.titus.game.core.math;

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

	/** The Constant PRECISION. */
	public static final long PRECISION = 1000000L;

	/** The Constant MAX_VALUE. */
	public static final long MAX_VALUE = 99999999999999L;

	/** The Constant MIN_VALUE. */
	public static final long MIN_VALUE = MathContext.MAX_VALUE * -1;

	/** The Constant POSITIV_INFINITY. */
	public static final long POSITIV_INFINITY = MathContext.MAX_VALUE + 1;

	/** The Constant NEGATIV_INFINITY. */
	public static final long NEGATIV_INFINITY = MathContext.MIN_VALUE - 1;

	/** The Constant PI. */
	public static final long PI = (long) (java.lang.Math.PI * MathContext.PRECISION);

	/** The Constant E. */
	public static final long E = (long) (java.lang.Math.E * MathContext.PRECISION);
}
