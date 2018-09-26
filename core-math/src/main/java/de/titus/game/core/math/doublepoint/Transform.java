/**
 *
 */
package de.titus.game.core.math.doublepoint;

/**
 * The Class Transform.
 *
 * @author xce3560
 */
public class Transform {

	/** The Constant ACTION__ROTATE. */
	public static final int ACTION__ROTATE = 0;

	/** The Constant ACTION__TRANSLATE. */
	public static final int ACTION__TRANSLATE = 1;

	/** The Constant ACTION__ALL. */
	public static final int ACTION__ALL = 2;

	/** The Tx 1. */
	public static int Rx1 = 0, Rx2 = 1, Tx1 = 2;

	/** The Ty 1. */
	public static int Ry1 = 3, Ry2 = 4, Ty1 = 5;

	/** The flat matrix. */
	final double[] flatMatrix;

	/** The action. */
	public final int action;

	/**
	 * Instantiates a new transform.
	 *
	 * @param aDirection the a direction
	 * @param aRotation  the a rotation
	 */
	public Transform(final Vector aDirection, final double aRotation) {
		double radian = Math.toRadians(aRotation);
		this.flatMatrix = new double[] { Math.cos(radian), -Math.sin(radian), aDirection.x, Math.sin(radian), Math.cos(radian), aDirection.y };
		this.action = Transform.ACTION__ALL;
	}

	/**
	 * Instantiates a new transform.
	 *
	 * @param aRotation the a rotation
	 */
	public Transform(final double aRotation) {
		double radian = Math.toRadians(aRotation);
		this.flatMatrix = new double[] { Math.cos(radian), -Math.sin(radian), 0, Math.sin(radian), Math.cos(radian), 0 };
		this.action = Transform.ACTION__ROTATE;
	}

	/**
	 * Instantiates a new transform.
	 *
	 * @param aDirection the a direction
	 */
	public Transform(final Vector aDirection) {
		this.flatMatrix = new double[] { 1, 0, aDirection.x, 0, 1, aDirection.y };
		this.action = Transform.ACTION__TRANSLATE;
	}

}
