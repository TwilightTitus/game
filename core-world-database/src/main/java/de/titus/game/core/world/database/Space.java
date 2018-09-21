package de.titus.game.core.world.database;

import java.util.HashSet;
import java.util.Set;

import de.titus.game.core.math.GridQuadrant;
import de.titus.game.core.math.Number;
import de.titus.game.core.math.NumberUtils;
import de.titus.game.core.math.Vector;

/**
 * The Class Space.
 *
 * @param <D> the generic type
 */
public class Space<D> {

	/** The Constant QUADRANT_DEPH. */
	public final static Number QUADRANT_DEPH = Number.toNumber(1000, 0);

	/** The Constant maxSize. */
	public final static Number MIN_QUADRANT_SIZE = Number.toNumberUncecked(Number.POSITIV_INFINITY.nativ / Space.QUADRANT_DEPH.nativ);

	/** The id. */
	public final GridQuadrant id;

	/** The quadrants. */
	public final Space<D>[] quadrants;

	/** The shapes. */
	private final Set<D> data;

	/** The center. */
	public final Vector center;

	/** The size. */
	public final Number size;

	/** The parent. */
	public final Space<D> parent;

	/** The final space. */
	public final boolean finalSpace;

	/**
	 * Instantiates a new space.
	 *
	 * @param aCenter   the a center
	 * @param aSize     the a size
	 * @param aParent   the a parent
	 * @param aQuadrant the a quadrant
	 */
	@SuppressWarnings("unchecked")
	public Space(final Vector aCenter, final Number aSize, final Space<D> aParent, final GridQuadrant aQuadrant) {
		this.id = aQuadrant;
		this.parent = aParent;
		this.center = aCenter;
		this.size = aSize;

		if (this.size.nativ <= Space.MIN_QUADRANT_SIZE.nativ) {
			this.finalSpace = true;
			this.quadrants = null;
			this.data = new HashSet<>();
		} else {
			this.finalSpace = false;
			this.quadrants = new Space[4];
			this.data = null;
		}

		System.out.println("create space: " + this);
	}

	/**
	 * Instantiates a new space.
	 *
	 * @param aCenter     the a center
	 * @param aSize       the a size
	 * @param aParent     the a parent
	 * @param aQuadrant   the a quadrant
	 * @param aFullCreate the a full create
	 */
	public Space(final Vector aCenter, final Number aSize, final Space<D> aParent, final GridQuadrant aQuadrant, final boolean aFullCreate) {
		this(aCenter, aSize, aParent, aQuadrant);
		if (aFullCreate && !this.finalSpace) {
			this.quadrants[GridQuadrant.I.ordinal()] = Space.newInstance(this, GridQuadrant.I);
			this.quadrants[GridQuadrant.II.ordinal()] = Space.newInstance(this, GridQuadrant.II);
			this.quadrants[GridQuadrant.III.ordinal()] = Space.newInstance(this, GridQuadrant.III);
			this.quadrants[GridQuadrant.IV.ordinal()] = Space.newInstance(this, GridQuadrant.IV);
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
	 * @param aData  the a shape
	 * @param aPoint the a point
	 * @return the space
	 */
	public Space<D> addData(final D aData, final Vector aPoint) {
		if (NumberUtils.isOutOfRange(aPoint.x) || NumberUtils.isOutOfRange(aPoint.y))
			return null;

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

			return quadrant.addData(aData, aPoint);
		}
	}

	/**
	 * Gets the space.
	 *
	 * @param aPoint the a point
	 * @return the space
	 */
	public Space<D> getSpace(final Vector aPoint) {
		if (NumberUtils.isOutOfRange(aPoint.x) || NumberUtils.isOutOfRange(aPoint.y))
			return null;
		return this.internalGetSpace(aPoint);
	}

	/**
	 * Internal get space.
	 *
	 * @param aPoint the a point
	 * @return the space
	 */
	private Space<D> internalGetSpace(final Vector aPoint) {
		if (this.finalSpace)
			return this;
		else {
			GridQuadrant gridQuadrat = GridQuadrant.getQuadrant(aPoint, this.center);

			Space<D> quadrant = this.quadrants[gridQuadrat.ordinal()];
			if (quadrant == null)
				return null;

			return quadrant.getSpace(aPoint);
		}
	}

	/**
	 * New instance.
	 *
	 * @param           <D> the generic type
	 * @param aParent   the a parent
	 * @param aQuadrant the a quadrant
	 * @return the space
	 */
	public static final <D> Space<D> newInstance(final Space<D> aParent, final GridQuadrant aQuadrant) {
		return Space.newInstance(aParent, aQuadrant, false);
	}

	/**
	 * New instance.
	 *
	 * @param             <D> the generic type
	 * @param aParent     the a parent
	 * @param aQuadrant   the a quadrant
	 * @param aFullCreate the a full create
	 * @return the space
	 */
	public static final <D> Space<D> newInstance(final Space<D> aParent, final GridQuadrant aQuadrant, final boolean aFullCreate) {
		Number size = aParent.size.div(Number.toNumber(2, 0), true);
		Vector center = aParent.center.addVector(aQuadrant.vector.multiply(size));
		return new Space<D>(center, size, aParent, aQuadrant, aFullCreate);
	}

	/**
	 * New global space.
	 *
	 * @param <D> the generic type
	 * @return the space
	 */
	public static final <D> Space<D> newGlobalSpace() {
		return Space.newGlobalSpace(false);
	}

	/**
	 * New global space.
	 *
	 * @param             <D> the generic type
	 * @param aFullCreate the a full create
	 * @return the space
	 */
	public static final <D> Space<D> newGlobalSpace(final boolean aFullCreate) {
		return new Space<D>(Vector.ZERO, Number.toNumberUncecked(Number.POSITIV_INFINITY.nativ * 2), null, null, aFullCreate);
	}

	/**
	 * @return
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Space [id=" + this.id + ", center=" + this.center + ", size=" + this.size + ", finalSpace=" + this.finalSpace + "]";
	}
}
