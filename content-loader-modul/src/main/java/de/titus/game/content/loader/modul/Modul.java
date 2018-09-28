/**
 * 
 */
package de.titus.game.content.loader.modul;

import com.google.auto.service.AutoService;

import de.titus.game.content.loader.modul.test.TestContentProcess;
import de.titus.game.core.game.logic.GameModul;

/**
 * The Class Modul.
 *
 * @author Titus
 */
@AutoService(GameModul.class)
public class Modul implements GameModul {

	/** The test content process. */
	private TestContentProcess testContentProcess;

	/**
	 * Inits the.
	 *
	 * @see de.titus.game.core.game.logic.GameModul#init()
	 */
	@Override
	public void init() {

		this.testContentProcess = new TestContentProcess();
		this.testContentProcess.start();

	}

}
