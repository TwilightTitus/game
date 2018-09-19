/**
 *
 */
package de.titus.game.core.math.specials;

import de.titus.game.core.math.Number;

/**
 * The Class Zero.
 *
 * @author xce3560
 */
public final class NegativOne extends Number {

	/** The instance. */
	public static NegativOne INSTANCE = new NegativOne();

	/**
	 * Instantiates a new zero.
	 */
	private NegativOne() {
		super(-1, 0);
	}

	/**
	 * Multi.
	 *
	 * @param aNumber the a number
	 * @return the number
	 * @see de.titus.game.core.math.Number#multi(de.titus.game.core.math.Number)
	 */
	@Override
	public Number multi(final Number aNumber) {
		return aNumber.negate();
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.Number#pow()
	 */
	@Override
	public Number pow() {
		return Number.ONE;
	}

	/**
	 * Sqrt.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.Number#sqrt()
	 */
	@Override
	public Number sqrt() {
		return Number.NaN;
	}

	/**
	 * Negate.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.Number#negate()
	 */
	@Override
	public Number negate() {
		return Number.ONE;
	}

}
