package de.titus.game.core.world.database;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import de.titus.game.core.math.doublepoint.GridQuadrant;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class Space.
 *
 * @param <D> the generic type
 */
public class Space<D> {

	/** The max deph reached. */
	private static boolean			MAX_DEPH_REACHED	= false;

	public static long				CLASSCOUNTER		= 0;

	/** The id. */
	public final String				id;

	/** The shapes. */
	private final Set<D>			data;

	/** The context. */
	public final SpaceContext<D>	context;

	/** The quadrants. */
	public final Space<D>[]			quadrants;

	/**
	 * Instantiates a new space.
	 *
	 * @param aContext the a context
	 */
	@SuppressWarnings("unchecked")
	public Space(final SpaceContext<D> aContext) {
		Space.CLASSCOUNTER++;
		this.id = UUID.randomUUID().toString();
		this.context = aContext;
		if (this.context.finalSpace) {
			this.quadrants = null;
			this.data = new HashSet<>();
			if (!Space.MAX_DEPH_REACHED) {
				System.out.println("min-size: " + this.context.size + ", deph: " + this.context.depth);
				Space.MAX_DEPH_REACHED = true;
			}
		} else {
			this.quadrants = new Space[4];
			this.data = null;
		}

		// System.out.println(this);
	}

	/**
	 * Creates the full depth.
	 */
	public void createFullDepth() {
		if (!this.context.finalSpace) {
			this.quadrants[GridQuadrant.I.ordinal()] = this.newSubspace(GridQuadrant.I, true);
			this.quadrants[GridQuadrant.II.ordinal()] = this.newSubspace(GridQuadrant.II, true);
			this.quadrants[GridQuadrant.III.ordinal()] = this.newSubspace(GridQuadrant.III, true);
			this.quadrants[GridQuadrant.IV.ordinal()] = this.newSubspace(GridQuadrant.IV, true);
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
		if (this.context.finalSpace)
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
		if (this.context.finalSpace)
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
		if (this.context.finalSpace) {
			this.data.add(aData);
			return this;
		} else {
			GridQuadrant gridQuadrat = GridQuadrant.getQuadrant(aPoint, this.context.center);
			Space<D> quadrant = this.quadrants[gridQuadrat.ordinal()];
			if (quadrant == null) {
				quadrant = this.newSubspace(gridQuadrat, false);
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
		if (this.context.finalSpace)
			return this;
		else {
			GridQuadrant gridQuadrat = GridQuadrant.getQuadrant(aPoint, this.context.center);
			Space<D> quadrant = this.quadrants[gridQuadrat.ordinal()];
			if (quadrant == null)
				return null;

			return quadrant.getSpace(aPoint);
		}
	}

	/**
	 * New instance.
	 *
	 * @param aQuadrant the a quadrant
	 * @param aFullCreate the a full create
	 * @return the space
	 */
	public Space<D> newSubspace(final GridQuadrant aQuadrant, final boolean aFullCreate) {
		SpaceContext<D> context = SpaceContext.createSubspace(this, aQuadrant);
		Space<D> result = new Space<>(context);
		if (aFullCreate)
			result.createFullDepth();

		return result;
	}

	@Override
	public String toString() {
		return "Space [id=" + this.id + ", context=" + this.context + "]";
	}

}
