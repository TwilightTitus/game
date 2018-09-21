/**
 *
 */
package de.titus.game.core.math.specials.numbers;

import de.titus.game.core.math.fixpoint.Number;

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
	 * @see de.titus.game.core.math.fixpoint.Number#multi(de.titus.game.core.math.fixpoint.Number)
	 */
	@Override
	public Number multi(final Number aNumber) {
		return aNumber.negate();
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#pow()
	 */
	@Override
	public Number pow() {
		return Number.ONE;
	}

	/**
	 * Sqrt.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#sqrt()
	 */
	@Override
	public Number sqrt() {
		return Number.NaN;
	}

	/**
	 * Negate.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#negate()
	 */
	@Override
	public Number negate() {
		return Number.ONE;
	}

}
