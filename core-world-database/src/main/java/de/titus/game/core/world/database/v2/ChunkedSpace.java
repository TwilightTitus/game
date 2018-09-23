package de.titus.game.core.world.database.v2;

public class ChunkedSpace {

	public final double		size;
	public final double		chunkSize;
	public final Chunk[][]	grid;

	public ChunkedSpace(final int aChunkSize, final int aChunkCount) {
		this.size = aChunkSize * aChunkCount;
		this.chunkSize = aChunkSize;

		this.grid = new Chunk[aChunkCount][aChunkCount];

	}
}
