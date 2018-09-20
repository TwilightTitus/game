package de.titus.game.core.sim.test.threads;

import java.util.Random;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Vector2;

import de.titus.game.core.sim.test.EntityManager;

public class CommandProcess extends AbstractProcess {

	private final Random random = new Random();

	public CommandProcess() {
		super(1000 / 120);
	}

	@Override
	protected void runProcess(final long aCurrentTime, final long aLastRun, final long aDeltaTime) {
		int index = this.random.nextInt(EntityManager.WORLD.getBodyCount());
		double delta = (double) aDeltaTime / 1000;

		Vector2 f = new Vector2(this.random.nextDouble() * 100 * delta, this.random.nextDouble() * 100 * delta);
		Body body = EntityManager.WORLD.getBody(index);
		body.applyForce(f);

		System.out.println("applied force at " + body);

	}

}
