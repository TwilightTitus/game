/**
 *
 */
package de.titus.game.core.math.specials;

import de.titus.game.core.math.MathContext;
import de.titus.game.core.math.Number;

/**
 * The Class PositivInfinity.
 *
 * @author xce3560
 */
public class NegativInfinity extends Number {

	/** The Constant INSTANCE. */
	public static final NegativInfinity INSTANCE = new NegativInfinity();

	/**
	 * Instantiates a new positiv infinity.
	 */
	protected NegativInfinity() {
		super(MathContext.NEGATIV_INFINITY, false);
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
		return this;
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
		return this;
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
		return this;
	}

	/**
	 * Div.
	 *
	 * @param aNumber the a number
	 * @return the number
	 * @see de.titus.game.core.math.Number#div(de.titus.game.core.math.Number)
	 */
	@Override
	public Number div(final Number aNumber) {
		return this;
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
		return Number.POSITIV_INFINITY;
	}

	/**
	 * Clone.
	 *
	 * @return the number
	 * @throws CloneNotSupportedException the clone not supported exception
	 * @see de.titus.game.core.math.Number#clone()
	 */
	@Override
	protected Number clone() throws CloneNotSupportedException {
		return this;
	}

}
