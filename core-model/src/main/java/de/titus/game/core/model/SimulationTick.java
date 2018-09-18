package de.titus.game.core.model;

/**
 * The Class Delta.
 */
public class SimulationTick {

	/** The delta time. */
	public final double deltaTime;
	
	/** The tick. */
	public final long tick;
	
	/**
	 * Instantiates a new delta.
	 *
	 * @param deltaTime the delta time
	 * @param tick the tick
	 */
	public SimulationTick(double aDeltaTime, long aTick) {
		super();
		this.deltaTime = aDeltaTime;
		this.tick = aTick;
	}
	
	
	
}
