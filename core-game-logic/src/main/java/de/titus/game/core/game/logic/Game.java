package de.titus.game.core.game.logic;

import de.titus.game.core.world.database.v2.ChunkedSpace;

/**
 * The Class Game.
 */
public final class Game {

	/** The Constant WORLD. */
	public static final ChunkedSpace<Object> WORLD = new ChunkedSpace<>(1000000, 1000);
	static {
		Game.WORLD.init();
	}

	/** The tick. */
	private static long tick = 0;

	/**
	 * Gets the current tick.
	 *
	 * @return the current tick
	 */
	public static long getCurrentTick() {
		return Game.tick;
	}

	/**
	 * Next tick.
	 *
	 * @return the long
	 */
	public static long nextTick() {
		return ++Game.tick;
	}

}
