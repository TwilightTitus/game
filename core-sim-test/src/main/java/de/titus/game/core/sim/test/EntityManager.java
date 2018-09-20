package de.titus.game.core.sim.test;

import org.dyn4j.dynamics.World;

/**
 * The Class EntityManager.
 */
public final class EntityManager {

	/** The Constant WORLD. */
	public static final World WORLD = EntityManager.initializeWorld();

	/**
	 * Creates game objects and adds them to the world.
	 * <p>
	 * Basically the same shapes from the Shapes test in the TestBed.
	 *
	 * @return the world
	 */
	private static synchronized World initializeWorld() {
		// create the world
		World world = new World();
		world.setBounds(new WorldBound());
		world.setGravity(World.ZERO_GRAVITY);

		return world;
	}
}
