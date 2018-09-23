package de.titus.game.core.world.database.v2;

import org.junit.jupiter.api.Test;

class ChunkedSpaceTest {

	@Test
	void testCreateChunckedSpace() {
		new ChunkedSpace(100, 1000000 / 100);
	}

}
