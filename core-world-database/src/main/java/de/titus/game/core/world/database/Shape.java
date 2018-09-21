package de.titus.game.core.world.database;

import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class Shape.
 */
public class Shape {

	/** The points. */
	public final Vector[]	points;

	/** The data. */
	public final Object		data;

	/**
	 * Instantiates a new shape.
	 *
	 * @param points the points
	 */
	public Shape(final Vector... points) {
		super();
		this.points = points;
		this.data = null;
	}

	/**
	 * Instantiates a new shape.
	 *
	 * @param aData the a data
	 * @param points the points
	 */
	public Shape(final Object aData, final Vector... points) {
		super();
		this.points = points;
		this.data = aData;
	}
}
