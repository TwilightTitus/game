package de.titus.game.content.loader.modul.test;

import java.util.Random;

import de.titus.game.core.game.logic.ActionService;
import de.titus.game.core.game.logic.Game;
import de.titus.game.core.game.logic.GameObject;
import de.titus.game.core.game.logic.actions.moving.LinearMoving;
import de.titus.game.core.game.logic.processes.AbstractProcess;
import de.titus.game.core.math.doublepoint.Polygon;
import de.titus.game.core.math.doublepoint.Vector;
import de.titus.game.core.math.doublepoint.utils.RandomUtils;

public class TestContentProcess extends AbstractProcess {

	private final Random		random		= new Random();
	private static final int	itemCount	= 100000;

	public static Polygon		TESTPOLYGON	= new Polygon(new Vector(1, 1), new Vector(-1, 1), new Vector(-1, -1), new Vector(1, -1));

	public TestContentProcess() {
		super(1000 / 60);
	}

	@Override
	protected void runProcess(final long aCurrentTime, final long aLastRun, final long aDeltaTime) {
		try {
			if (Game.WORLD.objects.size() < TestContentProcess.itemCount) {
				for (int i = 0; i < 10000; i++) {
					Vector d = new Vector(this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble(), this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble());

					GameObject object = new GameObject(d, TestContentProcess.TESTPOLYGON, null, this.random.nextDouble() * 10 + 10);
					Vector pos = this.getRandomPos();

					Game.WORLD.addSpaceObject(object, pos);
					ActionService.addAction(new LinearMoving(object, d.multiply(this.random.nextDouble() * 100), 10));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.stop();
		}
	}

	public Vector getRandomPos() {
		return RandomUtils.getRandomPoint(Game.WORLD.size / 2).sum(Game.WORLD.center);
	}

}
