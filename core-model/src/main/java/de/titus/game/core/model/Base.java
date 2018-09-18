package de.titus.game.core.model;

import java.util.UUID;

/**
 * The Class Base.
 */
public class Base {

	/** The id. */
	private final String id;

	/**
	 * Instantiates a new base.
	 */
	public Base() {
		id = UUID.randomUUID().toString();
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
