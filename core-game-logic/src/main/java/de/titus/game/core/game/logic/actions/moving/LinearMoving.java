package de.titus.game.core.game.logic.actions.moving;

import de.titus.game.core.game.logic.GameObject;
import de.titus.game.core.game.logic.actions.Action;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class LinearMoving.
 */
public class LinearMoving extends Action {

	/** The direction. */
	public final Vector	direction;

	/** The live time. */
	public final double	liveTime;

	/**
	 * Instantiates a new linear moving.
	 *
	 * @param aEntity the a entity
	 * @param aDirection the a direction
	 * @param aLiveTime the a live time
	 */
	public LinearMoving(final GameObject aEntity, final Vector aDirection, final double aLiveTime) {
		super(aEntity);
		this.direction = aDirection;
		this.liveTime = aLiveTime;
	}

	/**
	 * Do action.
	 *
	 * @param aTick the a tick
	 * @param aCurrentTime the a current time
	 * @param aLastRun the a last run
	 * @param aDeltaTime the a delta time
	 * @param aElapsedTime the a elapsed time
	 * @see de.titus.game.core.game.logic.actions.Action#doAction(long, long, long,
	 *      long, double)
	 */
	@Override
	public void doAction(final long aTick, final long aCurrentTime, final long aLastRun, final long aDeltaTime, final double aElapsedTime) {
		Vector center = this.entity.getWorldCenter().sum(this.direction.multiply(aElapsedTime));
		this.entity.setWorldCenter(center);
	}
}
