package de.titus.game.core.game.logic;

import java.util.Iterator;
import java.util.ServiceLoader;

import de.titus.game.core.game.logic.processes.AbstractProcess;
import de.titus.game.core.world.database.v2.ChunkedSpace;

/**
 * The Class Game.
 */
public final class Game {

	/** The Constant WORLD. */
	public static final ChunkedSpace<Object> WORLD = new ChunkedSpace<>(10, 1000);
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

	/**
	 * Inits the.
	 */
	public static void init() {
		System.out.println("Game.init()");
		ServiceLoader<AbstractProcess> processes = ServiceLoader.load(AbstractProcess.class);
		Iterator<AbstractProcess> iterator = processes.iterator();

		while (iterator.hasNext()) {
			AbstractProcess process = iterator.next();
			System.out.println(process);
			process.start();
		}
	}

}
