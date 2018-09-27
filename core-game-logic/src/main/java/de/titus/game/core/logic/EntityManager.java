package de.titus.game.core.logic;

import de.titus.game.core.world.database.v2.ChunkedSpace;

/**
 * The Class EntityManager.
 */
public final class EntityManager {

	/** The Constant WORLD. */
	public static final ChunkedSpace<Object> WORLD = new ChunkedSpace<>(10, 1000);
	static {
		EntityManager.WORLD.init();
	}
}
