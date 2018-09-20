package de.titus.game.core.sim.test;

import org.dyn4j.collision.AbstractBounds;
import org.dyn4j.collision.Collidable;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Circle;
import org.dyn4j.geometry.Vector2;

public class WorldBound extends AbstractBounds {

	private final Circle bounds;

	public WorldBound() {
		this.bounds = new Circle(5);
	}

	@Override
	public boolean isOutside(final Collidable<?> collidable) {
		double collidableRadius = collidable.getRotationDiscRadius();
		double boundsRadius = this.bounds.getRadius();
		double totalRadius = collidableRadius + boundsRadius;

		// get the centers in world space
		Vector2 boundsCenter = this.transform.getTransformed(this.bounds.getCenter());
		Vector2 collidableCenter = collidable.getWorldCenter();

		boolean isOutside = boundsCenter.distanceSquared(collidableCenter) > (totalRadius * totalRadius);

		if (isOutside) {
			System.out.println("colider is outside: " + collidable);
			if (collidable instanceof Body) {
				Body body = (Body) collidable;

				body.applyForce(body.getForce().getNegative().multiply(10));
				System.out.println("apply force");

			} else
				System.out.println("no body");
		}

		return isOutside;
	}

}
