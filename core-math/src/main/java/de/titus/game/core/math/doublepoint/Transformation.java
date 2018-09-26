/**
 *
 */
package de.titus.game.core.math.doublepoint;

/**
 * The Class Transform.
 *
 * @author xce3560
 */
public class Transformation {

	/** The Constant ACTION__ROTATE. */
	public static final int	ACTION__ROTATE		= 0;

	/** The Constant ACTION__TRANSLATE. */
	public static final int	ACTION__TRANSLATE	= 1;

	/** The Constant ACTION__ALL. */
	public static final int	ACTION__ALL			= 2;

	/** The Tx 1. */
	public static int		Rx1					= 0, Rx2 = 1, Tx = 2;

	/** The Ty 1. */
	public static int		Ry1					= 3, Ry2 = 4, Ty = 5;

	/** The flat matrix. */
	final double[]			flatMatrix;

	/** The action. */
	public final int		action;

	/**
	 * Instantiates a new transform.
	 *
	 * @param aDirection the a direction
	 * @param aRotation the a rotation
	 */
	public Transformation(final Vector aDirection, final double aRotation) {
		double radian = Math.toRadians(aRotation);
		this.flatMatrix = new double[] {
				Math.cos(radian), -Math.sin(radian), aDirection.x, Math.sin(radian), Math.cos(radian), aDirection.y
		};
		this.action = Transformation.ACTION__ALL;
	}

	/**
	 * Instantiates a new transform.
	 *
	 * @param aRotation the a rotation
	 */
	public Transformation(final double aRotation) {
		double radian = Math.toRadians(aRotation);
		this.flatMatrix = new double[] {
				Math.cos(radian), -Math.sin(radian), 0, Math.sin(radian), Math.cos(radian), 0
		};
		this.action = Transformation.ACTION__ROTATE;
	}

	/**
	 * Instantiates a new transform.
	 *
	 * @param aDirection the a direction
	 */
	public Transformation(final Vector aDirection) {
		this.flatMatrix = new double[] {
				1, 0, aDirection.x, 0, 1, aDirection.y
		};
		this.action = Transformation.ACTION__TRANSLATE;
	}

	/**
	 * Do execute.
	 *
	 * @param aVerticy the a verticy
	 * @return the vector
	 */
	public Vector doExecute(final Vector aVerticy) {
		switch (this.action) {
		case ACTION__ROTATE:
			return new Vector(this.flatMatrix[Transformation.Rx1] * aVerticy.x + this.flatMatrix[Transformation.Rx2] * aVerticy.y, this.flatMatrix[Transformation.Ry1] * aVerticy.y + this.flatMatrix[Transformation.Ry2] * aVerticy.x);
		case ACTION__TRANSLATE:
			return new Vector(this.flatMatrix[Transformation.Tx] * aVerticy.x, this.flatMatrix[Transformation.Ty] * aVerticy.y);
		default:
			return new Vector(this.flatMatrix[Transformation.Rx1] * aVerticy.x + this.flatMatrix[Transformation.Rx2] * aVerticy.y + this.flatMatrix[Transformation.Tx] * aVerticy.x, this.flatMatrix[Transformation.Ry1] * aVerticy.y + this.flatMatrix[Transformation.Ry2] * aVerticy.x + this.flatMatrix[Transformation.Ty] * aVerticy.y);
		}
	}

	/**
	 * Do execute.
	 *
	 * @param theVertices the the vertices
	 * @return the vector[]
	 */
	public Vector[] doExecute(final Vector... theVertices) {
		Vector[] vertices = new Vector[theVertices.length];
		for (int i = 0; i < theVertices.length; i++)
			vertices[i] = this.doExecute(theVertices[i]);
		return vertices;
	}

}
