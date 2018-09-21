package de.titus.game.core.math.fixpoint;

/**
 * The Enum GridQuadrant.
 */
public enum GridQuadrant {

	/** The i. */
	I(new Vector(Number.ONE, Number.ONE)),
	/** The ii. */
	II(new Vector(Number.NEGATIV_ONE, Number.ONE)),
	/** The iii. */
	III(new Vector(Number.NEGATIV_ONE, Number.NEGATIV_ONE)),
	/** The iv. */
	IV(new Vector(Number.ONE, Number.NEGATIV_ONE));

	public final Vector vector;

	/**
	 * Instantiates a new grid quadrant.
	 *
	 */
	private GridQuadrant(final Vector aVector) {
		this.vector = aVector;
	}

	/**
	 * Gets the quadrant.
	 *
	 * @param aPoint          the a point
	 * @param aQuadrantCenter the a quadrant center
	 * @return the quadrant
	 */
	public static GridQuadrant getQuadrant(final Vector aPoint, final Vector aQuadrantCenter) {
		if (aQuadrantCenter.x.nativ <= aPoint.x.nativ && aQuadrantCenter.y.nativ <= aPoint.y.nativ)
			return GridQuadrant.I;
		else if (aQuadrantCenter.x.nativ > aPoint.x.nativ && aQuadrantCenter.y.nativ <= aPoint.y.nativ)
			return GridQuadrant.II;
		else if (aQuadrantCenter.x.nativ > aPoint.x.nativ && aQuadrantCenter.y.nativ > aPoint.y.nativ)
			return GridQuadrant.III;
		else
			return GridQuadrant.IV;
	}
}
