package de.titus.game.core.model;

import java.util.Map;

/**
 * The Class StarSystem.
 *
 * @author Titus
 */
public final class World extends Base {

	/** The chunks. */
	private Map<String, Chunk>		chunks;

	/** The entities. */
	private Map<String, GameEntity>	entities;

	public static void load() {

	}

	/**
	 * Gets the chunks.
	 *
	 * @return the chunks
	 */
	public static Map<String, Chunk> getChunks() {
		return this.chunks;
	}

	/**
	 * Sets the chunks.
	 *
	 * @param chunks the chunks
	 */
	public void setChunks(final Map<String, Chunk> chunks) {
		this.chunks = chunks;
	}

	/**
	 * Gets the entities.
	 *
	 * @return the entities
	 */
	public Map<String, GameEntity> getEntities() {
		return this.entities;
	}

	/**
	 * Sets the entities.
	 *
	 * @param entities the entities
	 */
	public void setEntities(final Map<String, GameEntity> entities) {
		this.entities = entities;
	}

}
