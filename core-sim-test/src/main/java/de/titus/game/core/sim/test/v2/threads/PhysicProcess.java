/**
 *
 */
package de.titus.game.core.sim.test.v2.threads;

/**
 * The Class PhysicSim.
 *
 * @author xce3560
 */
public class PhysicProcess extends AbstractProcess {

	/**
	 * Instantiates a new physic sim.
	 */
	public PhysicProcess() {
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
		double elapsedTime = (double) aDeltaTime / 1000;
		try {
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("stop physic");
			this.stop();
		}
	}
}
