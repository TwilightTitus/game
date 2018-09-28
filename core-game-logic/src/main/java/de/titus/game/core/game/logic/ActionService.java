package de.titus.game.core.game.logic;

import java.util.ArrayList;
import java.util.List;

import de.titus.game.core.game.logic.actions.Action;

/**
 * The Class ActionService.
 */
public final class ActionService {

	/** The actions. */
	private static volatile List<Action> ACTIONS = new ArrayList<>();

	/**
	 * Instantiates a new action service.
	 */
	private ActionService() {
	}

	/**
	 * Adds the action.
	 *
	 * @param aAction the a action
	 */
	public static void addAction(final Action aAction) {
		synchronized (ActionService.ACTIONS) {
			ActionService.ACTIONS.add(aAction);
		}
	}

	/**
	 * Pop actions.
	 *
	 * @return the list
	 */
	public static List<Action> popActions() {

		List<Action> actions = ActionService.ACTIONS;
		synchronized (ActionService.ACTIONS) {
			ActionService.ACTIONS = new ArrayList<>();
		}

		return actions;
	}

}
