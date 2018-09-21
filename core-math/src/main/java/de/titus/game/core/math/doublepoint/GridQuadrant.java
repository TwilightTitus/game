package de.titus.game.core.math.doublepoint;

/**
 * The Enum GridQuadrant.
 */
public enum GridQuadrant {

	/** The i. */
	I(new Vector(1, 1)),
	/** The ii. */
	II(new Vector(-1, 1)),
	/** The iii. */
	III(new Vector(-1, -1)),
	/** The iv. */
	IV(new Vector(1, -1));

	/** The vector. */
	public final Vector vector;

	/**
	 * Instantiates a new grid quadrant.
	 *
	 * @param aVector the a vector
	 */
	private GridQuadrant(final Vector aVector) {
		this.vector = aVector;
	}

	/**
	 * Gets the quadrant.
	 *
	 * @param aPoint the a point
	 * @param aQuadrantCenter the a quadrant center
	 * @return the quadrant
	 */
	public static GridQuadrant getQuadrant(final Vector aPoint, final Vector aQuadrantCenter) {
		if (aQuadrantCenter.x <= aPoint.x && aQuadrantCenter.y <= aPoint.y)
			return GridQuadrant.I;
		else if (aQuadrantCenter.x > aPoint.x && aQuadrantCenter.y <= aPoint.y)
			return GridQuadrant.II;
		else if (aQuadrantCenter.x > aPoint.x && aQuadrantCenter.y > aPoint.y)
			return GridQuadrant.III;
		else
			return GridQuadrant.IV;
	}
}
