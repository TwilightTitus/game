/**
 *
 */
package de.titus.game.core.sim.test.threads;

/**
 * The Class Process.
 *
 * @author xce3560
 */
public abstract class AbstractProcess implements Runnable {

	/** The thread. */
	private final Thread thread;

	/** The update rate. */
	private final long updateRate;

	/** The stop. */
	private boolean stop;

	/**
	 * Instantiates a new process.
	 *
	 * @param aUpdateRate the a update rate
	 */
	public AbstractProcess(final long aUpdateRate) {
		this.thread = new Thread(this);
		this.thread.setDaemon(true);
		this.updateRate = aUpdateRate;
	}

	/**
	 * Start.
	 */
	public void start() {
		this.stop = false;
		this.thread.start();
	}

	/**
	 * Stop.
	 */
	public void stop() {
		this.stop = true;
	}

	/**
	 * Run.
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		long lastRun = 0;
		while (!this.stop) {
			try {
				long currentTime = System.currentTimeMillis();
				if (lastRun != 0) {
					long deta = currentTime - lastRun;
					this.runProcess(currentTime, lastRun, deta);
				}
				lastRun = currentTime;
				long sleep = (this.updateRate - (System.currentTimeMillis() - currentTime));
				if (sleep > 0)
					Thread.sleep(sleep);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Run process.
	 *
	 * @param aCurrentTime the a current time
	 * @param aLastRun     the a last run
	 * @param aDeltaTime   the a delta time
	 */
	protected abstract void runProcess(long aCurrentTime, final long aLastRun, long aDeltaTime);

}
