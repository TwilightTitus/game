package de.titus.game.core.math;

/**
 * The Class Number.
 */
public final class Number {

	/** The Constant MAX_VALUE. */
	public static final Number MAX_VALUE = new Number(MathContext.MAX_VALUE);

	/** The Constant MIN_VALUE. */
	public static final Number MIN_VALUE = new Number(MathContext.MIN_VALUE);

	/** The Constant POSITIV_INFINITY. */
	public static final Number POSITIV_INFINITY = new Number(MathContext.POSITIV_INFINITY, false);

	/** The Constant NEGATIV_INFINITY. */
	public static final Number NEGATIV_INFINITY = new Number(MathContext.NEGATIV_INFINITY, false);

	/** The Constant NaN. */
	public static final Number NaN = new Number(0, false);

	/** The Constant PI. */
	public static final Number PI = new Number(MathContext.PI);

	/** The Constant E. */
	public static final Number E = new Number(MathContext.E);

	/** The computable. */
	public final boolean computable;

	/** The nativ. */
	public final long nativ;

	/**
	 * Instantiates a new number.
	 *
	 * @param aNativ       the a nativ
	 * @param isComputable the is computable
	 */
	public Number(final long aNativ, final boolean isComputable) {
		this.computable = isComputable;
		this.nativ = aNativ;
	}

	/**
	 * Instantiates a new number.
	 *
	 * @param aNativ the a nativ
	 */
	public Number(final long aNativ) {
		this(aNativ, true);
	}

	/**
	 * Sum.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number sum(final Number aNumber) {
		if (this.computable && aNumber.computable)
			return Number.NaN;

		long result = this.nativ + aNumber.nativ;
		if (result > Number.MAX_VALUE.nativ)
			return Number.POSITIV_INFINITY;
		else if (result < Number.MIN_VALUE.nativ)
			return Number.NEGATIV_INFINITY;
		else
			return new Number(result);
	}

	/**
	 * Sub.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number sub(final Number aNumber) {
		if (this.computable && aNumber.computable)
			return Number.NaN;

		long result = this.nativ - aNumber.nativ;
		if (result > Number.MAX_VALUE.nativ)
			return Number.POSITIV_INFINITY;
		else if (result < Number.MIN_VALUE.nativ)
			return Number.NEGATIV_INFINITY;
		else
			return new Number(result);
	}

	/**
	 * Multi.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number multi(final Number aNumber) {
		if (this.computable && aNumber.computable)
			return Number.NaN;

		long result = this.nativ * aNumber.nativ;
		if (result > Number.MAX_VALUE.nativ)
			return Number.POSITIV_INFINITY;
		else if (result < Number.MIN_VALUE.nativ)
			return Number.NEGATIV_INFINITY;
		else
			return new Number(result);
	}

	/**
	 * Div.
	 *
	 * @param aNumber the a number
	 * @return the number
	 */
	public Number div(final Number aNumber) {
		if (this.computable && aNumber.computable)
			return Number.NaN;

		long result = this.nativ / aNumber.nativ;
		if (result > Number.MAX_VALUE.nativ)
			return Number.POSITIV_INFINITY;
		else if (result < Number.MIN_VALUE.nativ)
			return Number.NEGATIV_INFINITY;
		else
			return new Number(result);
	}

	/**
	 * Pow.
	 *
	 * @return the number
	 */
	public Number pow() {
		if (this.computable)
			return Number.NaN;

		long result = this.nativ * this.nativ;
		if (result > Number.MAX_VALUE.nativ)
			return Number.POSITIV_INFINITY;
		else if (result < Number.MIN_VALUE.nativ)
			return Number.NEGATIV_INFINITY;
		else
			return new Number(result);
	}

	/**
	 * Sqrt.
	 *
	 * @return the number
	 */
	public Number sqrt() {
		if (this.computable)
			return Number.NaN;

		double test = (double) this.nativ / MathContext.PRECISION;
		test = Math.sqrt(test);
		long result = (long) (test * MathContext.PRECISION);
		return new Number(result);
	}

}
