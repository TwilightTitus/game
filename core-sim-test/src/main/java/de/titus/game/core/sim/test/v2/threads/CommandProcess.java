package de.titus.game.core.sim.test.v2.threads;

import java.util.Random;

import de.titus.game.core.math.doublepoint.Polygon;
import de.titus.game.core.math.doublepoint.Vector;
import de.titus.game.core.sim.test.v2.EntityManager;
import de.titus.game.core.sim.test.v2.GameObject;

public class CommandProcess extends AbstractProcess {

	private final Random		random		= new Random();
	private static final int	itemCount	= 10000;

	public static Polygon		TESTPOLYGON	= new Polygon(new Vector(1, 1), new Vector(-1, 1), new Vector(-1, -1), new Vector(1, -1));

	public CommandProcess() {
		super(1000 / 60);
	}

	@Override
	protected void runProcess(final long aCurrentTime, final long aLastRun, final long aDeltaTime) {
		try {
			if (EntityManager.WORLD.objects.size() < CommandProcess.itemCount) {

				for (int i = 0; i < 1000; i++) {
					Vector d = new Vector(this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 10, this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 10);

					GameObject object = new GameObject(d, CommandProcess.TESTPOLYGON, null);
					EntityManager.WORLD.addSpaceObject(object, this.getRandomPos());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.stop();
		}

		// System.out.println("applied force at " + body);

	}

	public Vector getRandomPos() {
		double x = (this.random.nextBoolean() ? 1 : -1) * (this.random.nextDouble() * 10);
		double y = (this.random.nextBoolean() ? 1 : -1) * (this.random.nextDouble() * 10);
		return new Vector(x, y);
	}

}
