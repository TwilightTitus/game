package de.titus.game.core.world.database.v2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.titus.game.core.math.doublepoint.Polygon;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class ChunkedSpace.
 *
 * @param <D> the generic type
 */
public class ChunkedSpace<D> {

	/** The size. */
	public final double							size;

	/** The chunk size. */
	public final double							chunkSize;

	/** The grid. */
	public final Chunk<D>[][]					grid;

	/** The center. */
	public final Vector							center	= Vector.ZERO;

	/** The center index. */
	public final ChunkIndex						centerIndex;

	/** The objects. */
	public final Map<String, SpaceObject<D>>	objects;

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
		this.objects = new ConcurrentHashMap<>();
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
		int x = (int) Math.round(this.centerIndex.x - aPoint.x / this.chunkSize);
		int y = (int) Math.round(this.centerIndex.y - aPoint.y / this.chunkSize);
		return new ChunkIndex(x, y);
	}

	/**
	 * Gets the chunk for.
	 *
	 * @param aPoint the a point
	 * @return the chunk for
	 */
	public Chunk<D> getChunkFor(final Vector aPoint) {
		try {
			int x = (int) Math.round(this.centerIndex.x - aPoint.x / this.chunkSize);
			int y = (int) Math.round(this.centerIndex.y - aPoint.y / this.chunkSize);
			return this.grid[x][y];
		} catch (Exception e) {
			System.out.println(this);
			System.out.println(aPoint);
			throw e;
		}
	}

	/**
	 * Adds the space object.
	 *
	 * @param aObject the a object
	 * @param aPoint the a point
	 */
	public void addSpaceObject(final SpaceObject<D> aObject, final Vector aPoint) {
		aObject.setWorldCenter(aPoint);
		Polygon shape = aObject.getWorldShape();
		for (int i = 0; i < shape.vertices.length; i++)
			this.getChunkFor(shape.vertices[i]).addData(aObject);
		this.objects.put(aObject.id, aObject);
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
