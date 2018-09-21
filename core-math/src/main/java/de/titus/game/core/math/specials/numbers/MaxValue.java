/**
 *
 */
package de.titus.game.core.math.specials.numbers;

import de.titus.game.core.math.MathContext;
import de.titus.game.core.math.Number;

/**
 * The Class MaxValue.
 *
 * @author xce3560
 */
public final class MaxValue extends Number {

	/** The Constant INSTANCE. */
	public static final MaxValue INSTANCE = new MaxValue();

	/**
	 * Instantiates a new max value.
	 */
	private MaxValue() {
		super(MathContext.MAX_VALUE);
	}

	/**
	 * Sum.
	 *
	 * @param aNumber the a number
	 * @return the number
	 * @see de.titus.game.core.math.Number#sum(de.titus.game.core.math.Number)
	 */
	@Override
	public Number sum(final Number aNumber) {
		if (aNumber.sign)
			return super.sum(aNumber);
		else if (aNumber.equals(Number.MIN_VALUE))
			return Number.ZERO;
		else
			return Number.POSITIV_INFINITY;
	}

	/**
	 * Sub.
	 *
	 * @param aNumber the a number
	 * @return the number
	 * @see de.titus.game.core.math.Number#sub(de.titus.game.core.math.Number)
	 */
	@Override
	public Number sub(final Number aNumber) {
		if (aNumber.sign)
			return Number.POSITIV_INFINITY;
		else if (aNumber.equals(Number.MAX_VALUE))
			return Number.ZERO;
		else
			return super.sub(aNumber);
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.Number#pow()
	 */
	@Override
	public Number pow() {
		return Number.POSITIV_INFINITY;
	}

	/**
	 * Negate.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.Number#negate()
	 */
	@Override
	public Number negate() {
		return Number.MIN_VALUE;
	}

}
