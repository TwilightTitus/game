/**
 *
 */
package de.titus.game.core.math.specials.numbers;

import de.titus.game.core.math.fixpoint.MathContext;
import de.titus.game.core.math.fixpoint.Number;

/**
 * The Class MaxValue.
 *
 * @author xce3560
 */
public final class MinValue extends Number {

	/** The Constant INSTANCE. */
	public static final MinValue INSTANCE = new MinValue();

	/**
	 * Instantiates a new max value.
	 */
	private MinValue() {
		super(MathContext.MIN_VALUE);
	}

	@Override
	public Number sum(final Number aNumber) {
		if (aNumber.sign)
			return Number.NEGATIV_INFINITY;
		else if (aNumber.equals(Number.MAX_VALUE))
			return Number.ZERO;
		else
			return super.sum(aNumber);
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
		if (aNumber.sign)
			return super.sub(aNumber);
		else if (aNumber.equals(Number.MAX_VALUE))
			return Number.ZERO;
		else
			return Number.NEGATIV_INFINITY;
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 * @see de.titus.game.core.math.fixpoint.Number#pow()
	 */
	@Override
	public Number pow() {
		return Number.POSITIV_INFINITY;
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
		return Number.MAX_VALUE;
	}

}
