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
public class NormalizedVector extends Vector {

	/**
	 * Instantiates a new normalized vector.
	 *
	 * @param aX the a X
	 * @param aY the a Y
	 */
	public NormalizedVector(final Number aX, final Number aY) {
		super(aX, aY, Number.ONE, null);
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
}
