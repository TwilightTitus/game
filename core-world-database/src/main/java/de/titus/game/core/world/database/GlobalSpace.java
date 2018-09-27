package de.titus.game.core.world.database;

import de.titus.game.core.math.doublepoint.MathContext;
import de.titus.game.core.math.doublepoint.Vector;
import de.titus.game.core.world.database.v2.Entity;

/**
 * The Class Space.
 *
 * @param <D> the generic type
 */
public class GlobalSpace<D> extends Space<D> {

	/**
	 * Instantiates a new global space.
	 *
	 * @param aSize the a size
	 * @param aMaxDeph the a max deph
	 * @param aMaxSize the a max size
	 */
	public GlobalSpace(final double aSize, final int aMaxDeph, final double aMaxSize) {
		super(SpaceContext.createRootContext(aSize, aMaxDeph, aMaxSize));
	}

	/**
	 * Adds the shape.
	 *
	 * @param aData the a shape
	 * @param aPoint the a point
	 * @return the space
	 */
	@Override
	public Space<D> addData(final D aData, final Vector aPoint) {
		if (MathContext.inRange(aPoint.x) && MathContext.inRange(aPoint.y))
			return super.addData(aData, aPoint);

		return null;
	}

	/**
	 * Gets the space.
	 *
	 * @param aPoint the a point
	 * @return the space
	 * @see de.titus.game.core.world.database.Space#getSpace(de.titus.game.core.math.doublepoint.Vector)
	 */
	@Override
	public Space<D> getSpace(final Vector aPoint) {
		if (MathContext.inRange(aPoint.x) && MathContext.inRange(aPoint.y))
			return super.getSpace(aPoint);

		return null;
	}

	public void addSpaceObject(final Entity<D> aObject) {

	}

}
