package de.titus.game.core.world.database;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import de.titus.game.core.math.GridQuadrant;
import de.titus.game.core.math.Number;
import de.titus.game.core.math.Vector;

/**
 * The Class SpaceTest.
 */
class SpaceTest {

	/** The Constant RANDOM. */
	public static final Random RANDOM = new Random();
	/** The Constant GLOBALSPACE. */
	public static final Space<Object> GLOBALSPACE = Space.newGlobalSpace();

	/**
	 * Test create full space.
	 */
	@Test
	void testCreateFullSpace() {
		Space<Object> aSpace = Space.newGlobalSpace(true);
		Assertions.assertNotNull(aSpace);
	}

	/**
	 * Test add data.
	 */
	@Test
	void testAddData() {
		Object data;
		Vector point;

		data = new Object();
		point = new Vector(Number.ONE, Number.ONE);
		SpaceTest.GLOBALSPACE.addData(data, point);
		Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));

		data = new Object();
		point = new Vector(Number.ONE, Number.ZERO);
		SpaceTest.GLOBALSPACE.addData(data, point);
		Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));

		data = new Object();
		point = new Vector(Number.ZERO, Number.ONE);
		SpaceTest.GLOBALSPACE.addData(data, point);
		Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));

		data = new Object();
		point = new Vector(Number.ZERO, Number.ZERO);
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
		point = new Vector(Number.POSITIV_INFINITY, Number.POSITIV_INFINITY);
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

		data = new Object();
		point = new Vector(Number.NEGATIV_INFINITY, Number.POSITIV_INFINITY);
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

		data = new Object();
		point = new Vector(Number.NEGATIV_INFINITY, Number.NEGATIV_INFINITY);
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

		data = new Object();
		point = new Vector(Number.POSITIV_INFINITY, Number.NEGATIV_INFINITY);
		Assertions.assertNull(SpaceTest.GLOBALSPACE.addData(data, point));

	}

	/**
	 * Test add data performace.
	 */
	@Disabled
	@RepeatedTest(10)
	void testAddDataPerformace() {
		SpaceTest.GLOBALSPACE.clearData();
		Object data;
		Vector point;
		for (int i = 0; i < 100000; i++) {
			data = new Object();

			Number x = Number.toNumber((SpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (SpaceTest.RANDOM.nextDouble() * Number.POSITIV_INFINITY.nativ));
			Number y = Number.toNumber((SpaceTest.RANDOM.nextBoolean() ? 1 : -1) * (long) (SpaceTest.RANDOM.nextDouble() * Number.POSITIV_INFINITY.nativ));

			point = new Vector(x, y);
			SpaceTest.GLOBALSPACE.addData(data, point);
			Assertions.assertTrue(SpaceTest.GLOBALSPACE.getSpace(point).getData().contains(data));
		}
	}

	/**
	 * Test new instance.
	 */
	@Test
	void testNewInstance() {
		Space.newInstance(Space.newGlobalSpace(), GridQuadrant.I);
	}

}
