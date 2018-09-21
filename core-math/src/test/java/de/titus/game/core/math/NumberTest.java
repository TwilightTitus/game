/**
 *
 */
package de.titus.game.core.math;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import de.titus.game.core.math.fixpoint.Number;

/**
 * The Class NumberTest.
 *
 * @author xce3560
 */
class NumberTest {

	/**
	 * Test statics.
	 */
	@Test
	void testStatics() {
		Field[] fields = Number.class.getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
				try {
					System.out.println(field.getName() + ": " + ((Number) field.get(Number.class)).nativ);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
