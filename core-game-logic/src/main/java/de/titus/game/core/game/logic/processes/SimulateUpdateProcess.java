/**
 *
 */
package de.titus.game.core.game.logic.processes;

import java.util.List;

import de.titus.game.core.game.logic.ActionService;
import de.titus.game.core.game.logic.Game;
import de.titus.game.core.game.logic.actions.Action;

/**
 * The Class PhysicSim.
 *
 * @author xce3560
 */
public class SimulateUpdateProcess extends AbstractProcess {

	/**
	 * Instantiates a new physic sim.
	 */
	public SimulateUpdateProcess() {
		super(1000 / 60);
	}

	/**
	 * @param aCurrentTime
	 * @param aLastRun
	 *
	 * @see de.titus.game.core.sim.test.threads.AbstractProcess#runProcess(long,
	 *      long)
	 */
	@Override
	protected void runProcess(final long aCurrentTime, final long aLastRun, final long aDeltaTime) {
		System.out.println("start SimulateUpdateProcess");
		double elapsedTime = (double) aDeltaTime / 1000;
		try {
			long tick = Game.nextTick();
			List<Action> actions = ActionService.popActions();
			if (actions != null) {
				System.out.println("actions: " + actions.size());
				for (Action action : actions) {
					try {
						action.doAction(tick, aCurrentTime, aLastRun, aDeltaTime, elapsedTime);
					} catch (Exception e) {
						e.printStackTrace();
					}
					ActionService.addAction(action);
				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
			System.out.println("stop SimulateUpdateProcess");
			this.stop();
		}
	}
}
