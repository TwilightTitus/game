/**
 * 
 */
package de.titus.game.core.game.logic.actions;

import de.titus.game.core.game.logic.GameObject;

/**
 * @author Titus
 *
 */
public abstract class Action {

	public final GameObject entity;

	public Action(final GameObject aEntity) {
		this.entity = aEntity;
	}

	public abstract void doAction(final long aTick, final long aCurrentTime, final long aLastRun, final long aDeltaTime, final double aElapsedTime);

}
