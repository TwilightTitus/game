package de.titus.game.core.game.logic.actions.moving;

import de.titus.game.core.game.logic.GameObject;
import de.titus.game.core.game.logic.actions.Action;
import de.titus.game.core.math.doublepoint.Vector;

public class LinearMoving extends Action {

	public final Vector	direction;
	public final double	liveTime;

	public LinearMoving(final GameObject aEntity, final Vector aDirection, final double aLiveTime) {
		super(aEntity);
		this.direction = aDirection;
		this.liveTime = aLiveTime;
	}

	@Override
	public void doAction(final long aTick, final long aCurrentTime, final long aLastRun, final long aDeltaTime, final double aElapsedTime) {

	}

}
