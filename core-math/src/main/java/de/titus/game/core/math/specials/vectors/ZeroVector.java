/**
 *
 */
package de.titus.game.core.math.specials.vectors;

import de.titus.game.core.math.Number;
import de.titus.game.core.math.Vector;

/**
 * The Class NormalizedVector.
 *
 * @author Titus
 */
public class ZeroVector extends Vector {

	/** The Constant INSTANCE. */
	public static final ZeroVector INSTANCE = new ZeroVector();

	/**
	 * Instantiates a new normalized vector.
	 */
	private ZeroVector() {
		super(Number.ZERO, Number.ZERO, Number.ZERO, null);
	}

	/**
	 * Normalize.
	 *
	 * @return the vector
	 * @see de.titus.game.core.math.Vector#normalize()
	 */
	@Override
	public Vector normalize() {
		return this;
	}

	/**
	 * Adds the vector.
	 *
	 * @param aVector the a vector
	 * @return the vector
	 * @see de.titus.game.core.math.Vector#addVector(de.titus.game.core.math.Vector)
	 */
	@Override
	public Vector addVector(final Vector aVector) {
		return aVector;
	}

	/**
	 * Multiply.
	 *
	 * @param aNumber the a number
	 * @return the vector
	 * @see de.titus.game.core.math.Vector#multiply(de.titus.game.core.math.Number)
	 */
	@Override
	public Vector multiply(final Number aNumber) {
		return this;
	}
}
