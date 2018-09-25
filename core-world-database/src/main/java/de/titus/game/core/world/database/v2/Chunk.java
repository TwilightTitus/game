package de.titus.game.core.world.database.v2;

import java.util.HashSet;
import java.util.Set;

import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class Chunk.
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
	public final ChunkedSpace<D>	chunkedSpace;

	/** The size. */
	public final double				size;

	/** The center. */
	public final Vector				center;

	/** The index. */
	public final ChunkIndex			index;

	public final Set<D>				data;

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
		this.data = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Chunk [center=" + this.center + ", index=" + this.index + "]";
	}

}
