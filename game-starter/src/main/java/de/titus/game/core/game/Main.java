package de.titus.game.core.game;

import java.util.Iterator;
import java.util.ServiceLoader;

import de.titus.game.core.game.logic.GameModul;

public class Main {

	public static void main(final String[] args) {
		System.out.println("start");

		ServiceLoader<GameModul> moduls = ServiceLoader.load(GameModul.class);
		Iterator<GameModul> iterator = moduls.iterator();

		while (iterator.hasNext()) {
			GameModul modul = iterator.next();
			System.out.println(modul);
			modul.init();
		}

	}

}
