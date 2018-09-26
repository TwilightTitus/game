package de.titus.game.core.world.database.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.titus.game.core.math.doublepoint.Vector;
import de.titus.game.core.math.doublepoint.utils.RandomUtils;

/**
 * The Class Chunk.
 *
 * @param <D> the generic type
 */
public class Chunk<D> {

	/**
	 * The Enum Directions.
	 */
	public static enum Directions {

		/** The n. */
		N(new Vector(0, 1)),

		/** The no. */
		NO(new Vector(1, 1)),

		/** The o. */
		O(new Vector(1, 0)),

		/** The so. */
		SO(new Vector(1, -1)),

		/** The s. */
		S(new Vector(0, -1)),

		/** The sw. */
		SW(new Vector(-1, -1)),

		/** The w. */
		W(new Vector(-1, 0)),

		/** The nw. */
		NW(new Vector(-1, 1));

		/** The vector. */
		public final Vector vector;

		/**
		 * Instantiates a new directions.
		 *
		 * @param aVector the a vector
		 */
		private Directions(final Vector aVector) {
			this.vector = aVector;
		}
	}

	/** The chunked space. */
	public final ChunkedSpace<D>				chunkedSpace;

	/** The size. */
	public final double							size;

	/** The center. */
	public final Vector							center;

	/** The index. */
	public final ChunkIndex						index;

	/** The data. */
	private final Map<String, SpaceObject<D>>	data;

	/**
	 * Instantiates a new chunk.
	 *
	 * @param aIndex the a index
	 * @param aCenter the a center
	 * @param aSize the a size
	 * @param aChunkedSpace the a chunked space
	 */
	public Chunk(final ChunkIndex aIndex, final Vector aCenter, final double aSize, final ChunkedSpace<D> aChunkedSpace) {
		this.index = aIndex;
		this.center = aCenter;
		this.size = aSize;
		this.chunkedSpace = aChunkedSpace;
		this.data = new ConcurrentHashMap<>();
	}

	/**
	 * Adds the data.
	 *
	 * @param aObject the a object
	 */
	public void addData(final SpaceObject<D> aObject) {
		this.data.put(aObject.id, aObject);
		aObject.chunks.add(this);
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<SpaceObject<D>> getData() {
		return new ArrayList<>(this.data.values());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chunk [center=" + this.center + ", index=" + this.index + "]";
	}

	/**
	 * Gets the random point.
	 *
	 * @return the random point
	 */
	public Vector getRandomPoint() {
		return RandomUtils.getRandomPoint(this.size / 2).sum(this.center);
	}
}
