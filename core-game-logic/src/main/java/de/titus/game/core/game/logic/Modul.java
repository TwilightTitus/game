/**
 * 
 */
package de.titus.game.core.game.logic;

import com.google.auto.service.AutoService;

import de.titus.game.core.game.logic.processes.SimulateUpdateProcess;

/**
 * The Class Modul.
 *
 * @author Titus
 */
@AutoService(GameModul.class)
public class Modul implements GameModul {

	/** The update process. */
	private SimulateUpdateProcess updateProcess;

	/**
	 * Inits the.
	 *
	 * @see de.titus.game.core.game.logic.GameModul#init()
	 */
	@Override
	public void init() {
		this.updateProcess = new SimulateUpdateProcess();
		this.updateProcess.start();
	}

}
