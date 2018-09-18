package de.titus.game.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Class Chunk.
 */
public class Chunk implements ISimulate {

	/** The entities. */
	private Map<String, GameEntity>	entities;

	/** The appended entities. */
	public List<GameEntity>			appendedEntities	= new ArrayList<>();

	/** The position. */
	private Vector					position;

	/** The last tick. */
	private SimulationTick			lastTick;

	/**
	 * Instantiates a new chunk.
	 *
	 * @param aPosition the a position
	 */
	public Chunk(final Vector aPosition) {
		super();
		this.position = aPosition;

		this.init();
	}

	/**
	 * Inits the.
	 */
	private void init() {

	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Vector getPosition() {
		return this.position;
	}

	/**
	 * Adds the entity.
	 *
	 * @param aEntity the a entity
	 */
	public void addEntity(final GameEntity aEntity) {
		this.appendedEntities.add(aEntity);
	}

	/**
	 * Adds the entities.
	 *
	 * @param theEntities the the entities
	 */
	public void addEntities(final List<GameEntity> theEntities) {
		this.appendedEntities.addAll(theEntities);
	}

	/**
	 * Gets the entities.
	 *
	 * @return the entities
	 */
	public List<GameEntity> getEntities() {
		return new ArrayList<>(this.entities.values());
	}

	/**
	 * Do simulate.
	 *
	 * @param aSimulationTick the a simulation tick
	 * @see de.titus.game.core.model.ISimulate#doSimulate(de.titus.game.core.model.SimulationTick)
	 */
	@Override
	public void doSimulate(final SimulationTick aSimulationTick) {

		this.lastTick = aSimulationTick;
	}

	/**
	 * Gets the last tick.
	 *
	 * @return the last tick
	 */
	public SimulationTick getLastTick() {
		return this.lastTick;
	}

}
