package de.titus.game.renderer;

import com.google.auto.service.AutoService;

import de.titus.game.core.game.logic.GameModul;

/**
 * The Class Modul.
 */
@AutoService(GameModul.class)
public class Modul implements GameModul {

	/** The renderer. */
	private RenderProcess renderer;

	/**
	 * Inits the.
	 *
	 * @see de.titus.game.core.game.logic.GameModul#init()
	 */
	@Override
	public void init() {

		this.renderer = new RenderProcess();
		this.renderer.start();

	}

}
