package de.titus.game.core.math.doublepoint.utils;

import org.junit.jupiter.api.Test;

class RandomUtilsTest {

	@Test
	void test() {
		for (int i = 0; i < 1000; i++)
			System.out.println(RandomUtils.getRandomPoint(1000));
	}

}
