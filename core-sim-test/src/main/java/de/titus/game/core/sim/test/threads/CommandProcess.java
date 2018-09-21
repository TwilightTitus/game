package de.titus.game.core.sim.test.threads;

import java.util.Random;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Circle;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;

import de.titus.game.core.sim.test.EntityManager;
import de.titus.game.core.sim.test.GameObject;

public class CommandProcess extends AbstractProcess {

	private final Random		random		= new Random();
	private static final int	itemCount	= 10000;

	public CommandProcess() {
		super(1000 / 60);
	}

	@Override
	protected void runProcess(final long aCurrentTime, final long aLastRun, final long aDeltaTime) {
		if (EntityManager.WORLD.getBodyCount() > 0) {
			int index = this.random.nextInt(EntityManager.WORLD.getBodyCount());

			Vector2 f = new Vector2(this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 100, this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 100);
			Body body = EntityManager.WORLD.getBody(index);
			body.applyForce(f);

		}

		if (EntityManager.WORLD.getBodyCount() < CommandProcess.itemCount) {

			for (int i = 0; i < 1000; i++) {
				Vector2 f = new Vector2(this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 10, this.random.nextBoolean() ? -1 : 1 * this.random.nextDouble() * 10);

				GameObject cap = new GameObject();

				cap.addFixture(new Circle(0.1));
				cap.setMass(MassType.NORMAL);

				cap.translate(f.multiply(this.random.nextDouble() * 10));
				cap.applyImpulse(f);
				EntityManager.WORLD.addBody(cap);
			}
		}

		// System.out.println("applied force at " + body);

	}

}
