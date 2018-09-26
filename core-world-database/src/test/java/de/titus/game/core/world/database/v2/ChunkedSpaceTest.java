package de.titus.game.core.world.database.v2;

import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class Chunked
 */
class ChunkedSpaceTest {
	public static final Random			RANDOM	= new Random();
	public static ChunkedSpace<Object>	SPACE	= new ChunkedSpace<>(1000, 1000).init();

	/**
	 * Test create chuncked space.
	 */
	@Disabled
	@Test
	void testCreateChunckedSpace() {
		System.out.println(new ChunkedSpace<>(100, 10000));
	}

	/**
	 * Test init chuncked space.
	 */
	@Disabled
	@Test
	void testInitChunckedSpace() {
		ChunkedSpace<Object> space = new ChunkedSpace<>(1000, 1000).init();
		System.out.println(space);

		System.out.println(space.grid[space.centerIndex.x][space.centerIndex.y]);

	}

	@Disabled
	@Test
	void testError() {

		Vector point = new Vector(415719.0, 329608.0);
		System.out.println("point: " + point);
		ChunkIndex index = ChunkedSpaceTest.SPACE.getChunkIndexFor(point);
		System.out.println(index);
		Chunk<Object> chunk = ChunkedSpaceTest.SPACE.grid[index.x][index.y];
		System.out.println(chunk);
	}

	@RepeatedTest(value = 1000)
	void testGetChunckIndex() {
		ChunkedSpace<Object> space = new ChunkedSpace<>(1000, 1000).init();
		for (int i = 0; i < 100000; i++) {
			// System.out.println(ChunkedSpaceTest.SPACE);
			// System.out.println(ChunkedSpaceTest.SPACE.grid[ChunkedSpaceTest.SPACE.centerIndex.x][ChunkedSpaceTest.SPACE.centerIndex.y]);
			// System.out.println(ChunkedSpaceTest.SPACE.grid[0][0]);
			double x = (ChunkedSpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (ChunkedSpaceTest.RANDOM.nextDouble() * (ChunkedSpaceTest.SPACE.size / 2));
			double y = (ChunkedSpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (ChunkedSpaceTest.RANDOM.nextDouble() * (ChunkedSpaceTest.SPACE.size / 2));
			Vector point = new Vector(x, y);

			// System.out.println("point: " + point);
			ChunkIndex index = space.getChunkIndexFor(point);
			// System.out.println(index);
			Chunk<Object> chunk = space.grid[index.x][index.y];
		}
		// System.out.println(chunk);
		// TODO TEST

	}

}
