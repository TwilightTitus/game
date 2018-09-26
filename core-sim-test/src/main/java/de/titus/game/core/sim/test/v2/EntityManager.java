package de.titus.game.core.sim.test.v2;

import de.titus.game.core.world.database.v2.ChunkedSpace;

/**
 * The Class EntityManager.
 */
public final class EntityManager {

	/** The Constant WORLD. */
	public static final ChunkedSpace<Object> WORLD = new ChunkedSpace<>(1000, 100);
	static {
		EntityManager.WORLD.init();
	}
}
