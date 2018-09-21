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
public final class Zero extends Number {

	/** The instance. */
	public static Zero INSTANCE = new Zero();

	/**
	 * Instantiates a new zero.
	 */
	private Zero() {
		super(0, true);
	}

	/**
	 * Sum.
	 *
	 * @param aNumber the a number
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#sum(de.titus.game.core.math.fixpoint.Number)
	 */
	@Override
	public Number sum(final Number aNumber) {
		return aNumber;
	}

	/**
	 * Sub.
	 *
	 * @param aNumber the a number
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#sub(de.titus.game.core.math.fixpoint.Number)
	 */
	@Override
	public Number sub(final Number aNumber) {
		return aNumber;
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
		return this;
	}

	/**
	 * Div.
	 *
	 * @param aNumber the a number
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#div(de.titus.game.core.math.fixpoint.Number)
	 */
	@Override
	public Number div(final Number aNumber) {
		return this;
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#pow()
	 */
	@Override
	public Number pow() {
		return this;
	}

	/**
	 * Sqrt.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#sqrt()
	 */
	@Override
	public Number sqrt() {
		return this;
	}

	/**
	 * Negate.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#negate()
	 */
	@Override
	public Number negate() {
		return this;
	}

}
