package de.titus.game.core.world.database.v2;

import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class ChunkedSpace.
 *
 * @param <D> the generic type
 */
public class ChunkedSpace<D> {

	/** The size. */
	public final double			size;

	/** The chunk size. */
	public final double			chunkSize;

	/** The grid. */
	public final Chunk<D>[][]	grid;

	/** The center. */
	public final Vector			center	= Vector.ZERO;

	/** The center index. */
	public final ChunkIndex		centerIndex;

	/**
	 * Instantiates a new chunked space.
	 *
	 * @param aChunkSize the a chunk size
	 * @param aChunkCount the a chunk count
	 */
	@SuppressWarnings("unchecked")
	public ChunkedSpace(final int aChunkSize, final int aChunkCount) {
		this.size = aChunkSize * aChunkCount;
		this.chunkSize = aChunkSize;
		this.grid = new Chunk[aChunkCount + 1][aChunkCount + 1];
		this.centerIndex = new ChunkIndex(this.grid.length / 2, this.grid.length / 2);
	}

	/**
	 * Inits the.
	 *
	 * @return the chunked space
	 */
	public ChunkedSpace<D> init() {
		for (int x = 0; x < this.grid.length; x++) {
			for (int y = 0; y < this.grid.length; y++) {
				Vector center = new Vector((this.centerIndex.x - x) * this.chunkSize, (this.centerIndex.y - y) * this.chunkSize);
				this.grid[x][y] = new Chunk<>(new ChunkIndex(x, y), center, this.chunkSize, this);
			}
		}
		return this;
	}

	/**
	 * Gets the chunk index for.
	 *
	 * @param aPoint the a point
	 * @return the chunk index for
	 */
	public ChunkIndex getChunkIndexFor(final Vector aPoint) {
		int x = (int) Math.round(Math.abs(aPoint.x) % this.chunkSize);
		int y = (int) Math.round(Math.abs(aPoint.y) % this.chunkSize);

		return new ChunkIndex(x, y);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChunkedSpace [size=" + this.size + ", chunkSize=" + this.chunkSize + ",  center=" + this.center + ", centerIndex=" + this.centerIndex + "]";
	}
}
