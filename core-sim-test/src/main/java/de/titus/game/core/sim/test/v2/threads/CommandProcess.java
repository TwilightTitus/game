package de.titus.game.core.sim.test.v2.threads;

import java.util.Random;

import de.titus.game.core.math.doublepoint.Polygon;
import de.titus.game.core.math.doublepoint.Vector;
import de.titus.game.core.math.doublepoint.utils.RandomUtils;
import de.titus.game.core.sim.test.v2.EntityManager;
import de.titus.game.core.sim.test.v2.GameObject;

public class CommandProcess extends AbstractProcess {

	private final Random		random		= new Random();
	private static final int	itemCount	= 10000000;

	public static Polygon		TESTPOLYGON	= new Polygon(new Vector(1, 1), new Vector(-1, 1), new Vector(-1, -1), new Vector(1, -1));

	public CommandProcess() {
		super(1000 / 60);
	}

	@Override
	protected void runProcess(final long aCurrentTime, final long aLastRun, final long aDeltaTime) {
		try {
			if (EntityManager.WORLD.objects.size() < CommandProcess.itemCount) {
				// Chunk<Object> center =
				// EntityManager.WORLD.grid[EntityManager.WORLD.centerIndex.x][EntityManager.WORLD.centerIndex.y];
				for (int i = 0; i < 10000; i++) {
					Vector d = new Vector(this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 10, this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 10);

					GameObject object = new GameObject(d, CommandProcess.TESTPOLYGON, null, this.random.nextDouble() * 10);
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
		return RandomUtils.getRandomPoint(EntityManager.WORLD.size / 2).sum(EntityManager.WORLD.center);
	}

}