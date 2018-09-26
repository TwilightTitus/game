package de.titus.game.core.world.database.v2;

import de.titus.game.core.math.doublepoint.Polygon;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class SpaceObject.
 *
 * @param <D> the generic type
 */
public class SpaceObject<D> {

	/** The local center. */
	public final Vector direction;

	/** The data. */
	public final D data;

	/** The local collision box. */
	public final Polygon localCollisionBox;

	/** The world center. */
	private Vector worldCenter;

	/** The world collision box. */
	private Polygon worldCollisionBox;

	public SpaceObject(final Vector aDirection, final Polygon aLocalCollisionBox, final D aData) {
		super();
		this.direction = aDirection;
		this.data = aData;
		this.localCollisionBox = aLocalCollisionBox;
	}

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
		this.worldCollisionBox = null;
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
	public Polygon getWorldCollionBox() {
		if (this.worldCollisionBox == null)
			this.worldCollisionBox = this.localCollisionBox.move(this.worldCenter);

		return this.worldCollisionBox;
	}

}
