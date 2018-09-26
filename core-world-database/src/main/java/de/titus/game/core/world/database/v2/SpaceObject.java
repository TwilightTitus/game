package de.titus.game.core.world.database.v2;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import de.titus.game.core.math.doublepoint.Polygon;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class SpaceObject.
 *
 * @param <D> the generic type
 */
public class SpaceObject<D> {

	/** The id. */
	public final String			id;

	/** The local center. */
	public final Vector			direction;

	/** The data. */
	public final D				data;

	/** The local collision box. */
	public final Polygon		shape;

	/** The world center. */
	private Vector				worldCenter;

	/** The world collision box. */
	private Polygon				worldShape;

	/** The chunk. */
	public final Set<Chunk<D>>	chunks;

	/**
	 * Instantiates a new space object.
	 *
	 * @param aDirection the a direction
	 * @param aLocalCollisionBox the a local collision box
	 * @param aData the a data
	 */
	public SpaceObject(final Vector aDirection, final Polygon aLocalCollisionBox, final D aData) {
		super();
		this.id = UUID.randomUUID().toString();
		this.direction = aDirection;
		this.data = aData;
		this.shape = aLocalCollisionBox;
		this.chunks = new HashSet<>();
	}

	/**
	 * Instantiates a new space object.
	 *
	 * @param aDirection the a direction
	 * @param aLocalCollisionBox the a local collision box
	 * @param aData the a data
	 * @param aWorldCenter the a world center
	 */
	public SpaceObject(final Vector aDirection, final Polygon aLocalCollisionBox, final D aData, final Vector aWorldCenter) {
		this(aDirection, aLocalCollisionBox, aData);
		this.worldCenter = aWorldCenter;
	}

	/**
	 * Sets the world center.
	 *
	 * @param aWorldCenter the new world center
	 */
	public void setWorldCenter(final Vector aWorldCenter) {
		this.worldCenter = aWorldCenter;
		this.worldShape = null;
	}

	/**
	 * Gets the world center.
	 *
	 * @return the world center
	 */
	public Vector getWorldCenter() {
		return this.worldCenter;
	}

	/**
	 * Gets the world collion box.
	 *
	 * @return the world collion box
	 */
	public Polygon getWorldShape() {
		if (this.worldShape == null)
			this.worldShape = this.shape.move(this.worldCenter);

		return this.worldShape;
	}

	@Override
	public String toString() {
		return "SpaceObject [id=" + this.id + ", direction=" + this.direction + ", data=" + this.data + ", shape=" + this.shape + ", worldCenter=" + this.worldCenter + ", worldShape=" + this.worldShape + ", chunks=" + this.chunks + "]";
	}
}
