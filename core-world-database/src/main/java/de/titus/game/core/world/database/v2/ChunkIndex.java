package de.titus.game.core.world.database.v2;

/**
 * The Class ChunkIndex.
 */
public class ChunkIndex {

	/** The x. */
	public final int	x;

	/** The y. */
	public final int	y;

	/**
	 * Instantiates a new chunk index.
	 *
	 * @param aX the a X
	 * @param aY the a Y
	 */
	public ChunkIndex(final int aX, final int aY) {
		this.x = aX;
		this.y = aY;
	}

	@Override
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}

}
