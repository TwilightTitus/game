package de.titus.game.core.world.database;

import java.util.HashSet;
import java.util.Set;

import de.titus.game.core.math.doublepoint.GridQuadrant;
import de.titus.game.core.math.doublepoint.MathContext;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class Space.
 *
 * @param <D> the generic type
 */
public class Space<D> {

	/** The Constant QUADRANT_DEPH. */
	public final static long	QUADRANT_DEPH		= 15;

	public final static double	QUADRANT_MAX_SIZE	= 100;

	private static boolean		MAX_DEPH_REACHED	= false;

	/** The id. */
	public final GridQuadrant	id;

	/** The quadrants. */
	public final Space<D>[]		quadrants;

	/** The shapes. */
	private final Set<D>		data;

	/** The center. */
	public final Vector			center;

	/** The size. */
	public final double			size;

	/** The parent. */
	public final Space<D>		parent;

	/** The final space. */
	public final boolean		finalSpace;

	/** The deph. */
	public final long			deph;

	/**
	 * Instantiates a new space.
	 *
	 * @param aCenter the a center
	 * @param aSize the a size
	 * @param aParent the a parent
	 * @param aQuadrant the a quadrant
	 * @param aDeph the a deph
	 */
	@SuppressWarnings("unchecked")
	public Space(final Vector aCenter, final double aSize, final Space<D> aParent, final GridQuadrant aQuadrant, final long aDeph) {
		this.id = aQuadrant;
		this.parent = aParent;
		this.center = aCenter;
		this.size = aSize;
		this.deph = aDeph;

		// if (this.deph < Space.QUADRANT_DEPH) {
		if (this.size > Space.QUADRANT_MAX_SIZE) {
			this.finalSpace = false;
			this.quadrants = new Space[4];
			this.data = null;
		} else {
			this.finalSpace = true;
			this.quadrants = null;
			this.data = new HashSet<>();
			if (!Space.MAX_DEPH_REACHED) {
				System.out.println("min-size: " + this.size + ", deph: " + this.deph);
				Space.MAX_DEPH_REACHED = true;
			}
		}
	}

	/**
	 * Instantiates a new space.
	 *
	 * @param aCenter the a center
	 * @param aSize the a size
	 * @param aParent the a parent
	 * @param aQuadrant the a quadrant
	 * @param aDeph the a deph
	 * @param aFullCreate the a full create
	 */
	public Space(final Vector aCenter, final double aSize, final Space<D> aParent, final GridQuadrant aQuadrant, final long aDeph, final boolean aFullCreate) {
		this(aCenter, aSize, aParent, aQuadrant, aDeph);
		if (aFullCreate && !this.finalSpace) {
			this.quadrants[GridQuadrant.I.ordinal()] = Space.newInstance(this, GridQuadrant.I, this.finalSpace);
			this.quadrants[GridQuadrant.II.ordinal()] = Space.newInstance(this, GridQuadrant.II, aFullCreate);
			this.quadrants[GridQuadrant.III.ordinal()] = Space.newInstance(this, GridQuadrant.III, aFullCreate);
			this.quadrants[GridQuadrant.IV.ordinal()] = Space.newInstance(this, GridQuadrant.IV, aFullCreate);
		}
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Set<D> getData() {
		return new HashSet<>(this.data);
	}

	/**
	 * Clear.
	 */
	public void clear() {
		if (this.finalSpace)
			this.data.clear();
		else {
			this.quadrants[GridQuadrant.I.ordinal()] = null;
			this.quadrants[GridQuadrant.II.ordinal()] = null;
			this.quadrants[GridQuadrant.III.ordinal()] = null;
			this.quadrants[GridQuadrant.IV.ordinal()] = null;
		}
	}

	/**
	 * Clear data.
	 */
	public void clearData() {
		if (this.finalSpace)
			this.data.clear();
		else {
			if (this.quadrants[GridQuadrant.I.ordinal()] != null)
				this.quadrants[GridQuadrant.I.ordinal()].clearData();
			if (this.quadrants[GridQuadrant.II.ordinal()] != null)
				this.quadrants[GridQuadrant.II.ordinal()].clearData();
			if (this.quadrants[GridQuadrant.III.ordinal()] != null)
				this.quadrants[GridQuadrant.III.ordinal()].clearData();
			if (this.quadrants[GridQuadrant.IV.ordinal()] != null)
				this.quadrants[GridQuadrant.IV.ordinal()].clearData();
		}
	}

	/**
	 * Adds the shape.
	 *
	 * @param aData the a shape
	 * @param aPoint the a point
	 * @return the space
	 */
	public Space<D> addData(final D aData, final Vector aPoint) {
		if (MathContext.inRange(aPoint.x) && MathContext.inRange(aPoint.y))
			return this.addInternalData(aData, aPoint);

		return null;
	}

	/**
	 * Adds the internal data.
	 *
	 * @param aData the a data
	 * @param aPoint the a point
	 * @return the space
	 */
	private Space<D> addInternalData(final D aData, final Vector aPoint) {
		if (this.finalSpace) {
			this.data.add(aData);
			return this;
		} else {
			GridQuadrant gridQuadrat = GridQuadrant.getQuadrant(aPoint, this.center);
			Space<D> quadrant = this.quadrants[gridQuadrat.ordinal()];
			if (quadrant == null) {
				quadrant = Space.newInstance(this, gridQuadrat);
				this.quadrants[gridQuadrat.ordinal()] = quadrant;
			}

			return quadrant.addInternalData(aData, aPoint);
		}
	}

	/**
	 * Gets the space.
	 *
	 * @param aPoint the a point
	 * @return the space
	 */
	public Space<D> getSpace(final Vector aPoint) {
		if (MathContext.inRange(aPoint.x) && MathContext.inRange(aPoint.y))
			return this.getInternalSpace(aPoint);

		return null;
	}

	/**
	 * Gets the internal space.
	 *
	 * @param aPoint the a point
	 * @return the internal space
	 */
	private Space<D> getInternalSpace(final Vector aPoint) {
		if (this.finalSpace)
			return this;
		else {
			GridQuadrant gridQuadrat = GridQuadrant.getQuadrant(aPoint, this.center);
			Space<D> quadrant = this.quadrants[gridQuadrat.ordinal()];
			if (quadrant == null)
				return null;

			return quadrant.getInternalSpace(aPoint);
		}
	}

	/**
	 * New instance.
	 *
	 * @param <D> the generic type
	 * @param aParent the a parent
	 * @param aQuadrant the a quadrant
	 * @return the space
	 */
	public static final <D> Space<D> newInstance(final Space<D> aParent, final GridQuadrant aQuadrant) {
		return Space.newInstance(aParent, aQuadrant, false);
	}

	/**
	 * New instance.
	 *
	 * @param <D> the generic type
	 * @param aParent the a parent
	 * @param aQuadrant the a quadrant
	 * @param aFullCreate the a full create
	 * @return the space
	 */
	public static final <D> Space<D> newInstance(final Space<D> aParent, final GridQuadrant aQuadrant, final boolean aFullCreate) {
		double size = aParent.size / 2;
		Vector center = aParent.center.sum(aQuadrant.vector.getNormalized().multiply(size));
		return new Space<>(center, size, aParent, aQuadrant, aParent.deph + 1, aFullCreate);
	}

	/**
	 * New global space.
	 *
	 * @param <D> the generic type
	 * @param aSize the a size
	 * @return the space
	 */
	public static final <D> Space<D> newGlobalSpace(final double aSize) {
		return Space.newGlobalSpace(aSize, false);
	}

	/**
	 * New global space.
	 *
	 * @param <D> the generic type
	 * @param aSize the a size
	 * @param aFullCreate the a full create
	 * @return the space
	 */
	public static final <D> Space<D> newGlobalSpace(final double aSize, final boolean aFullCreate) {
		return new Space<>(Vector.ZERO, aSize, null, null, 0, aFullCreate);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Space [" + "deph=" + this.deph + ", id=" + this.id + ", center=" + this.center + ", size=" + this.size + ", finalSpace=" + this.finalSpace + "]";
	}
}
