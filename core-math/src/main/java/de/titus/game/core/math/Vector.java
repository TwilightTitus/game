/**
 *
 */
package de.titus.game.core.math;

import de.titus.game.core.math.specials.vectors.NormalizedVector;
import de.titus.game.core.math.specials.vectors.ZeroVector;

/**
 * The Class Vector.
 *
 * @author Titus
 */
public class Vector {

	/** The Constant ZERO. */
	public static final Vector ZERO = ZeroVector.INSTANCE;

	/** The x. */
	public final Number x;

	/** The y. */
	public final Number y;

	/** The length. */
	private Number length;

	/** The normalize. */
	private Vector normalized;

	/**
	 * Instantiates a new vector.
	 *
	 * @param aX          the a X
	 * @param aY          the a Y
	 * @param aLength     the a length
	 * @param aNormalized the a normalized
	 */
	protected Vector(final Number aX, final Number aY, final Number aLength, final Vector aNormalized) {
		this.x = aX;
		this.y = aY;
		this.length = aLength;
		this.normalized = aNormalized;
	}

	/**
	 * Instantiates a new vector.
	 *
	 * @param aX the a X
	 * @param aY the a Y
	 */
	public Vector(final Number aX, final Number aY) {
		this.x = aX;
		this.y = aY;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public Number getLength() {
		if (this.length == null) {
			long x = this.x.nativ;
			long y = this.y.nativ;

			boolean fail = false;
			long xt = x;
			long yt = y;
			if (Math.abs(x) > MathContext.PRECISION) {
				xt = xt / MathContext.PRECISION;
				yt = yt / MathContext.PRECISION;
				fail = true;
			} else if (Math.abs(y) > MathContext.PRECISION) {
				xt = xt / MathContext.PRECISION;
				yt = yt / MathContext.PRECISION;
				fail = true;
			}

			this.length = Number.toNumber((long) (Math.sqrt(xt * xt + yt * yt) * (fail ? MathContext.PRECISION : 1)));
		}
		return this.length;
	}

	/**
	 * Normalize.
	 *
	 * @return the vector
	 */
	public Vector normalize() {
		if (this.normalized == null) {
			long x = this.x.nativ * MathContext.PRECISION / this.getLength().nativ;
			long y = this.y.nativ * MathContext.PRECISION / this.getLength().nativ;
			this.normalized = new NormalizedVector(Number.toNumberUncecked(x), Number.toNumberUncecked(y));
		}
		return this.normalized;
	}

	/**
	 * Adds the vector.
	 *
	 * @param aVector the a vector
	 * @return the vector
	 */
	public Vector addVector(final Vector aVector) {
		return new Vector(this.x.sum(aVector.x), this.y.sum(aVector.y));
	}

	/**
	 * Multiply.
	 *
	 * @param aNumber the a number
	 * @return the vector
	 */
	public Vector multiply(final Number aNumber) {
		return new Vector(this.x.multi(aNumber), this.y.multi(aNumber));
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
