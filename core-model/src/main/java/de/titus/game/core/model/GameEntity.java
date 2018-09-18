package de.titus.game.core.model;

/**
 * The Class GameEntity.
 */
public class GameEntity extends Base {

	/** The position. */
	private Vector position;

	/**
	 * Instantiates a new game entity.
	 *
	 * @param aPosition the a position
	 */
	public GameEntity(final Vector aPosition) {
		super();
		this.position = aPosition;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Vector getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(final Vector position) {
		this.position = position;
	}

}
