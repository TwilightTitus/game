package de.titus.game.core.world.database;

import de.titus.game.core.math.doublepoint.GridQuadrant;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class SpaceContext.
 *
 * @param <D> the generic type
 */
public class SpaceContext<D> {

	/** The center. */
	public final Vector			center;

	/** The quadrant. */
	public final GridQuadrant	quadrant;

	/** The parent. */
	public final Space<D>		parent;

	/** The depth. */
	public final int			depth;

	/** The size. */
	public final double			size;

	/** The max depth. */
	public final int			maxDepth;

	/** The max size. */
	public final double			maxSize;

	/** The final space. */
	public final boolean		finalSpace;

	/**
	 * Instantiates a new space context.
	 *
	 * @param aCenter the a center
	 * @param aQudrant the a qudrant
	 * @param aSize the a size
	 * @param aDepth the a depth
	 * @param aParent the a parent
	 */
	private SpaceContext(final Vector aCenter, final GridQuadrant aQudrant, final double aSize, final int aDepth, final Space<D> aParent) {
		this.center = aCenter;
		this.quadrant = aQudrant;
		this.parent = aParent;
		this.depth = aDepth;
		this.size = aSize;
		this.maxDepth = aParent.context.maxDepth;
		this.maxSize = aParent.context.maxSize;
		this.finalSpace = this.size <= this.maxSize;
	}

	/**
	 * Instantiates a new space context.
	 *
	 * @param aCenter the a center
	 * @param aQudrant the a qudrant
	 * @param aSize the a size
	 * @param aDepth the a depth
	 * @param aMaxDepth the a max depth
	 * @param aMaxSize the a max size
	 */
	private SpaceContext(final Vector aCenter, final GridQuadrant aQudrant, final double aSize, final int aDepth, final int aMaxDepth, final double aMaxSize) {
		this.center = aCenter;
		this.quadrant = aQudrant;
		this.parent = null;
		this.depth = aDepth;
		this.size = aSize;
		this.maxDepth = aMaxDepth;
		this.maxSize = aMaxSize;
		this.finalSpace = this.size <= this.maxSize;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpaceContext [center=" + this.center + ", quadrant=" + this.quadrant + ", parent=" + this.parent + ", depth=" + this.depth + ", size=" + this.size + ", maxDepth=" + this.maxDepth + ", maxSize=" + this.maxSize + ", finalSpace=" + this.finalSpace + "]";
	}

	/**
	 * To create subspace.
	 *
	 * @param <D> the generic type
	 * @param aSpace the a space
	 * @param aQuadrant the a quadrant
	 * @return the space context
	 */
	public static <D> SpaceContext<D> createSubspace(final Space<D> aSpace, final GridQuadrant aQuadrant) {
		double size = aSpace.context.size / 2;
		Vector center = aSpace.context.center.sum(aQuadrant.vector.getNormalized().multiply(size));
		return new SpaceContext<>(center, aQuadrant, size, aSpace.context.depth + 1, aSpace);
	}

	/**
	 * Creates the root context.
	 *
	 * @param <D> the generic type
	 * @param aSize the a size
	 * @param aMaxDepth the a max depth
	 * @param aMaxSize the a max size
	 * @return the space context
	 */
	public static <D> SpaceContext<D> createRootContext(final double aSize, final int aMaxDepth, final double aMaxSize) {
		return new SpaceContext<>(GridQuadrant.ROOT.vector, GridQuadrant.ROOT, aSize, 0, aMaxDepth, aMaxSize);
	}

}
