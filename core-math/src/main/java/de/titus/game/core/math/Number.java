package de.titus.game.core.math;

import de.titus.game.core.math.specials.MaxValue;
import de.titus.game.core.math.specials.MinValue;
import de.titus.game.core.math.specials.NegativInfinity;
import de.titus.game.core.math.specials.NegativOne;
import de.titus.game.core.math.specials.One;
import de.titus.game.core.math.specials.PositivInfinity;
import de.titus.game.core.math.specials.Zero;

/**
 * The Class Number.
 */
public class Number implements Cloneable {

	/** The Constant MAX_VALUE. */
	public static final Number MAX_VALUE = MaxValue.INSTANCE;

	/** The Constant MIN_VALUE. */
	public static final Number MIN_VALUE = MinValue.INSTANCE;

	/** The Constant POSITIV_INFINITY. */
	public static final Number POSITIV_INFINITY = PositivInfinity.INSTANCE;

	/** The Constant NEGATIV_INFINITY. */
	public static final Number NEGATIV_INFINITY = NegativInfinity.INSTANCE;

	/** The Constant NaN. */
	public static final Number NaN = de.titus.game.core.math.specials.NaN.INSTANCE;

	/** The Constant PI. */
	public static final Number PI = new Number(MathContext.PI);

	/** The Constant E. */
	public static final Number E = new Number(MathContext.E);

	/** The Constant ZERO. */
	public static final Number ZERO = Zero.INSTANCE;

	/** The Constant ONE. */
	public static final Number ONE = One.INSTANCE;

	/** The Constant NEGATIV_ONE. */
	public static final Number NEGATIV_ONE = NegativOne.INSTANCE;

	/** The computable. */
	public final boolean computable;

	/** The nativ. */
	public final long nativ;

	/** The sign. */
	public final boolean sign;

	/**
	 * Instantiates a new number.
	 *
	 * @param aNativ       the a nativ
	 * @param isComputable the is computable
	 */
	protected Number(final long aNativ, final boolean isComputable) {
		this.computable = isComputable;
		this.nativ = aNativ;
		this.sign = this.nativ < 0;
	}

	/**
	 * Instantiates a new number.
	 *
	 * @param aNativ the a nativ
	 */
	protected Number(final long aNativ) {
		this(aNativ, true);
	}

	/**
	 * Instantiates a new number.
	 *
	 * @param aPredicimal the a predicimal
	 * @param aDecimal    the a decimal
	 */
	protected Number(final long aPredicimal, final long aDecimal) {
		this((aPredicimal * MathContext.PRECISION + (aDecimal * MathContext.PRECISION / 10)));
	}

	/**
	 * Instantiates a new number.
	 *
	 * @param aSign       the a sign
	 * @param aPredicimal the a predicimal
	 * @param aDecimal    the a decimal
	 */
	protected Number(final boolean aSign, final long aPredicimal, final long aDecimal) {
		this((aSign ? -1 : 1) * (aPredicimal * MathContext.PRECISION + (aDecimal * MathContext.PRECISION / 10)));
	}

	/**
	 * Sum.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number sum(final Number aNumber) {
		if (!aNumber.computable)
			return Number.NaN;
		return Number.toNumber(this.nativ + aNumber.nativ);
	}

	/**
	 * Sub.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number sub(final Number aNumber) {
		if (!aNumber.computable)
			return Number.NaN;

		return Number.toNumber(this.nativ - aNumber.nativ);
	}

	/**
	 * Multi.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number multi(final Number aNumber) {
		if (!aNumber.computable)
			return Number.NaN;

		return Number.toNumber(this.nativ * aNumber.nativ);
	}

	/**
	 * Div.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number div(final Number aNumber) {
		if (!aNumber.computable)
			return Number.NaN;

		return Number.toNumber(this.nativ / aNumber.nativ);
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 */
	public Number pow() {
		if (!this.computable)
			return Number.NaN;

		long result = this.nativ * this.nativ;
		if (result > Number.MAX_VALUE.nativ)
			return Number.POSITIV_INFINITY;
		else
			return new Number(result);
	}

	/**
	 * Sqrt.
	 *
	 * @return the number
	 */
	public Number sqrt() {
		if (!this.computable || this.sign)
			return Number.NaN;

		double test = (double) this.nativ / MathContext.PRECISION;
		test = Math.sqrt(test);
		long result = (long) (test * MathContext.PRECISION);
		return new Number(result);
	}

	/**
	 * Negate.
	 *
	 * @return the number
	 */
	public Number negate() {
		if (!this.computable)
			return Number.NaN;

		return new Number(this.nativ * -1);
	}

	/**
	 * Clone.
	 *
	 * @return the number
	 * @throws CloneNotSupportedException the clone not supported exception
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Number clone() throws CloneNotSupportedException {
		return new Number(this.nativ, this.computable);
	}

	/**
	 * To number.
	 *
	 * @param aValue the a value
	 * @return the number
	 */
	public static Number toNumber(final long aValue) {
		if (aValue > Number.MAX_VALUE.nativ)
			return Number.POSITIV_INFINITY;
		else if (aValue < Number.MIN_VALUE.nativ)
			return Number.NEGATIV_INFINITY;
		else if (aValue == 0)
			return Number.ZERO;
		else if (aValue == Number.ONE.nativ)
			return Number.ONE;
		else if (aValue == Number.NEGATIV_ONE.nativ)
			return Number.NEGATIV_ONE;
		else if (aValue == Number.MAX_VALUE.nativ)
			return Number.MAX_VALUE;
		else if (aValue == Number.MIN_VALUE.nativ)
			return Number.MIN_VALUE;
		else
			return new Number(aValue);

	}

	/**
	 * To number.
	 *
	 * @param aPredicimal the a predicimal
	 * @param aDecimal    the a decimal
	 * @return the number
	 */
	public static Number toNumber(final long aPredicimal, final long aDecimal) {
		return Number.toNumber(aPredicimal * MathContext.PRECISION + (aDecimal * MathContext.PRECISION / 10));
	}

	/**
	 * To number.
	 *
	 * @param aSign       the a sign
	 * @param aPredicimal the a predicimal
	 * @param aDecimal    the a decimal
	 * @return the number
	 */
	public static Number toNumber(final boolean aSign, final long aPredicimal, final long aDecimal) {
		return Number.toNumber((aSign ? -1 : 1) * aPredicimal * MathContext.PRECISION + (aDecimal * MathContext.PRECISION / 10));
	}

	/**
	 * To number.
	 *
	 * @param aValue the a value
	 * @return the number
	 */
	public static Number toNumberUncecked(final long aValue) {
		return new Number(aValue);
	}

	/**
	 * To number.
	 *
	 * @param aPredicimal the a predicimal
	 * @param aDecimal    the a decimal
	 * @return the number
	 */
	public static Number toNumberUncecked(final long aPredicimal, final long aDecimal) {
		return new Number(aPredicimal, aDecimal);
	}

	/**
	 * To number.
	 *
	 * @param aSign       the a sign
	 * @param aPredicimal the a predicimal
	 * @param aDecimal    the a decimal
	 * @return the number
	 */
	public static Number toNumberUncecked(final boolean aSign, final long aPredicimal, final long aDecimal) {
		return new Number(aSign, aPredicimal, aDecimal);
	}
}
