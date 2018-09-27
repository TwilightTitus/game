package de.titus.game.core.game.logic;

import de.titus.game.core.world.database.v2.ChunkedSpace;

public final class Game {

	/** The Constant WORLD. */
	public static final ChunkedSpace<Object> WORLD = new ChunkedSpace<>(10, 1000);
	static {
		Game.WORLD.init();
	}

}
