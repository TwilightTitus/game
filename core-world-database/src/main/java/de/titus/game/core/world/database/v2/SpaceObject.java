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
	public final Vector localCenter;

	/** The data. */
	public final D data;

	/** The local collision box. */
	public final Polygon localCollisionBox;

	/** The world center. */
	private Vector worldCenter;

	/** The world collision box. */
	private Polygon worldCollisionBox;

	/**
	 * Instantiates a new space object.
	 *
	 * @param aLocalCenter       the a local center
	 * @param aLocalCollisionBox the a local collision box
	 * @param aData              the a data
	 */
	public SpaceObject(final Vector aLocalCenter, final Polygon aLocalCollisionBox, final D aData) {
		super();
		this.localCenter = aLocalCenter;
		this.data = aData;
		this.localCollisionBox = aLocalCollisionBox;
	}

	/**
	 * Instantiates a new space object.
	 *
	 * @param aLocalCenter       the a local center
	 * @param aLocalCollisionBox the a local collision box
	 * @param aData              the a data
	 * @param aWorldCenter       the a world center
	 */
	public SpaceObject(final Vector aLocalCenter, final Polygon aLocalCollisionBox, final D aData, final Vector aWorldCenter) {
		this(aLocalCenter, aLocalCollisionBox, aData);
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
