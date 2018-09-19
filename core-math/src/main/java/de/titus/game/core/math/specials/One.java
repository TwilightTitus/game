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
public final class One extends Number {

	/** The instance. */
	public static One INSTANCE = new One();

	/**
	 * Instantiates a new zero.
	 */
	private One() {
		super(1, 0);
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
		return aNumber;
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.Number#pow()
	 */
	@Override
	public Number pow() {
		return this;
	}

	/**
	 * Sqrt.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.Number#sqrt()
	 */
	@Override
	public Number sqrt() {
		return this;
	}

}
