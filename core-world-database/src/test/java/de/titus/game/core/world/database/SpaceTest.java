package de.titus.game.core.world.database;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import de.titus.game.core.math.doublepoint.MathContext;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class SpaceTest.
 */
class SpaceTest {

	/** The Constant RANDOM. */
	public static final Random			RANDOM		= new Random();
	/** The Constant GLOBALSPACE. */
	public static final Space<Object>	GLOBALSPACE	= new GlobalSpace<>(MathContext.POSITIV_INFINITY * 2, 10, 1000);

	/**
	 * Test create full space.
	 */
	@Test
	void testCreateFullSpace() {
		Runtime runtime = Runtime.getRuntime();
		long currentMemory = runtime.totalMemory() - runtime.freeMemory();
		Space<Object> global = new GlobalSpace<>(MathContext.POSITIV_INFINITY * 2, 10, 500);
		global.createFullDepth();
		long memoryUsage = runtime.totalMemory() - runtime.freeMemory() - currentMemory;
		System.out.println("memory usage for full space: " + ((memoryUsage / 1024 / 1024)) + "MB");
		System.out.println("Space instances: " + Space.CLASSCOUNTER);
		Assertions.assertNotNull(global);
	}

	/**
	 * Test add data.
	 */
	@Test
	void testAddData() {
		Object data;
		Vector point;

		data = new Object();
		point = new Vector(1, 1);
		SpaceTest.GLOBALSPACE.addData(data, point);
		Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));

		data = new Object();
		point = new Vector(1, 0);
		SpaceTest.GLOBALSPACE.addData(data, point);
		Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));

		data = new Object();
		point = new Vector(0, 1);
		SpaceTest.GLOBALSPACE.addData(data, point);
		Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));

		data = new Object();
		point = new Vector(0, 0);
		SpaceTest.GLOBALSPACE.addData(data, point);
		Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));
	}

	/**
	 * Test add data outside.
	 */
	@Test
	void testAddDataOutside() {
		Object data;
		Vector point;

		data = new Object();
		point = new Vector(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

		data = new Object();
		point = new Vector(-1 * (Integer.MAX_VALUE + 1), Integer.MAX_VALUE + 1);
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

		data = new Object();
		point = new Vector(-1 * (Integer.MAX_VALUE + 1), -1 * (Integer.MAX_VALUE + 1));
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

		data = new Object();
		point = new Vector(Integer.MAX_VALUE + 1, -1 * (Integer.MAX_VALUE + 1));
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

	}

	/**
	 * Test add data performace.
	 */
	@RepeatedTest(10)
	void testAddDataPerformace() {
		Space<Object> global = new GlobalSpace<>(MathContext.POSITIV_INFINITY * 2, 10, 1000);
		// global.createFullDepth();
		Object data;
		Vector point;
		long addRuntime = 0;
		long addCount = 0;
		long getRuntime = 0;
		long getCount = 0;

		for (int i = 0; i < 100000; i++) {
			data = new Object();
			double x = (SpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (SpaceTest.RANDOM.nextDouble() * MathContext.POSITIV_INFINITY);
			double y = (SpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (SpaceTest.RANDOM.nextDouble() * MathContext.POSITIV_INFINITY);

			point = new Vector(x, y);
			long startAdd = System.currentTimeMillis();
			Space<Object> space = global.addData(data, point);
			addRuntime = addRuntime + (System.currentTimeMillis() - startAdd);
			addCount++;

			if (space != null) {
				long startGet = System.currentTimeMillis();
				Assertions.assertTrue(global.getSpace(point).getData().contains(data));
				getRuntime = getRuntime + (System.currentTimeMillis() - startGet);
				getCount++;
			} else
				System.out.println("Out of space!");
		}

		System.out.println("add: " + addRuntime + "ms / " + addCount);
		System.out.println("avg add: " + ((double) addRuntime / addCount) + "ms");
		System.out.println("get: " + getRuntime + "ms / " + getCount);
		System.out.println("avg get: " + ((double) getRuntime / getCount) + "ms");
	}

	@Test
	void testAddDataPerformaceFullFill() {
		Space<Object> global = new GlobalSpace<>(MathContext.POSITIV_INFINITY * 2, 10, 1000);
		// global.createFullDepth();

		Object data;
		Vector point;
		long addRuntime = 0;
		long addCount = 0;
		long getRuntime = 0;
		long getCount = 0;

		for (int i = 0; i < 1000000; i++) {
			data = new Object();
			double x = (SpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (SpaceTest.RANDOM.nextDouble() * MathContext.POSITIV_INFINITY);
			double y = (SpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (SpaceTest.RANDOM.nextDouble() * MathContext.POSITIV_INFINITY);

			point = new Vector(x, y);
			long startAdd = System.currentTimeMillis();
			Space<Object> space = global.addData(data, point);
			addRuntime = addRuntime + (System.currentTimeMillis() - startAdd);
			addCount++;

			if (space != null) {
				long startGet = System.currentTimeMillis();
				Assertions.assertTrue(global.getSpace(point).getData().contains(data));
				getRuntime = getRuntime + (System.currentTimeMillis() - startGet);
				getCount++;
			} else
				System.out.println("Out of space!");
		}

		System.out.println("add: " + addRuntime + "ms / " + addCount);
		System.out.println("avg add: " + ((double) addRuntime / addCount) + "ms");
		System.out.println("get: " + getRuntime + "ms / " + getCount);
		System.out.println("avg get: " + ((double) getRuntime / getCount) + "ms");
	}
}
