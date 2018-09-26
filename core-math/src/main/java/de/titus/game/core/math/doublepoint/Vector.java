package de.titus.game.core.math.doublepoint;

/**
 * The Class Vector.
 */
public class Vector implements Cloneable {

	/** The Constant X_AXIS. */
	public static final Vector	X_AXIS	= new Vector(1.0, 0.0);

	/** The Constant Y_AXIS. */
	public static final Vector	Y_AXIS	= new Vector(0.0, 1.0);

	/** The Constant ZERO. */
	public static final Vector	ZERO	= new Vector(0.0, 0, 0, 0);

	/** The x. */
	public final double			x;

	/** The y. */
	public final double			y;

	/** The calc magnitude. */
	private volatile boolean	calcMagnitude;

	/** The magnitude. */
	private volatile double		magnitude;

	/** The magnitude squared. */
	private volatile double		magnitudeSquared;

	/** The calc direction. */
	private volatile boolean	calcDirection;

	/** The direction. */
	private volatile double		direction;

	/** The normalized. */
	private volatile Vector		normalized;

	/**
	 * Instantiates a new vector.
	 *
	 * @param aX the a X
	 * @param aY the a Y
	 * @param aMagnitude the a magnitude
	 * @param aDirection the a direction
	 */
	private Vector(final double aX, final double aY, final double aMagnitude, final double aDirection) {
		super();
		this.x = aX;
		this.y = aY;
		this.calcMagnitude = false;
		this.magnitude = aMagnitude;
		this.magnitudeSquared = aMagnitude * aMagnitude;
		this.calcDirection = false;
		this.direction = aDirection;
	}

	/**
	 * Instantiates a new vector.
	 *
	 * @param aX the a X
	 * @param aY the a Y
	 */
	public Vector(final double aX, final double aY) {
		this.x = aX;
		this.y = aY;
		this.calcMagnitude = true;
		this.calcDirection = true;
	}

	/**
	 * Clone.
	 *
	 * @return the vector
	 * @throws CloneNotSupportedException the clone not supported exception
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Vector clone() throws CloneNotSupportedException {
		return new Vector(this.x, this.y);
	}

	/**
	 * Distance to.
	 *
	 * @param aPoint the a point
	 * @return the double
	 */
	public double distanceTo(final Vector aPoint) {
		double dx = this.x - aPoint.x;
		double dy = this.y - aPoint.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * Distance squared to.
	 *
	 * @param point the point
	 * @return the double
	 */
	public double distanceSquaredTo(final Vector point) {
		double dx = this.x - point.x;
		double dy = this.y - point.y;
		return dx * dx + dy * dy;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}

	/**
	 * Gets the x vector.
	 *
	 * @return the x vector
	 */
	public Vector getXVector() {
		return new Vector(this.x, 0.0);
	}

	/**
	 * Gets the y vector.
	 *
	 * @return the y vector
	 */
	public Vector getYVector() {
		return new Vector(0.0, this.y);
	}

	/**
	 * Gets the magnitude.
	 *
	 * @return the magnitude
	 */
	public double getMagnitude() {
		if (this.calcMagnitude) {
			this.magnitudeSquared = this.x * this.x + this.y * this.y;
			this.magnitude = Math.sqrt(this.magnitudeSquared);
			this.calcMagnitude = false;
		}

		return this.magnitude;
	}

	/**
	 * Gets the magnitude squared.
	 *
	 * @return the magnitude squared
	 */
	public double getMagnitudeSquared() {
		if (this.calcDirection) {
			this.getMagnitude();
		}

		return this.magnitudeSquared;
	}

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public double getAngle() {
		if (this.calcDirection) {
			this.direction = Math.atan2(this.y, this.x);
			this.calcDirection = false;
		}

		return this.direction;
	}

	/**
	 * Sum.
	 *
	 * @param aVector the vector
	 * @return the vector
	 */
	public Vector sum(final Vector aVector) {
		return new Vector(this.x + aVector.x, this.y + aVector.y);
	}

	/**
	 * Subtract.
	 *
	 * @param aVector the vector
	 * @return the vector
	 */
	public Vector subtract(final Vector aVector) {
		return new Vector(this.x - aVector.x, this.y - aVector.y);
	}

	/**
	 * Multiply.
	 *
	 * @param aScalar the scalar
	 * @return the vector
	 */
	public Vector multiply(final double aScalar) {
		// TODO optimize magnitude | direction | normalized Vector
		return new Vector(this.x * aScalar, this.y * aScalar);
	}

	/**
	 * Dot.
	 *
	 * @param aVector the vector
	 * @return the double
	 */
	public double dot(final Vector aVector) {
		return this.x * aVector.x + this.y * aVector.y;
	}

	/**
	 * Cross.
	 *
	 * @param aVector the vector
	 * @return the double
	 */
	public double cross(final Vector aVector) {
		return this.x * aVector.y - this.y * aVector.x;
	}

	/**
	 * Checks if is orthogonal.
	 *
	 * @param aVector the vector
	 * @return true, if is orthogonal
	 */
	public boolean isOrthogonal(final Vector aVector) {
		return Math.abs(this.x * aVector.x + this.y * aVector.y) <= MathContext.E ? true : false;
	}

	/**
	 * Negate.
	 *
	 * @return the vector
	 */
	public Vector negate() {
		// TODO optimize magnitude | direction | normalized Vector
		return new Vector(this.x * -1, this.y * -1);
	}

	/**
	 * Rotate.
	 *
	 * @param aArc the theta
	 * @return the vector
	 */
	public Vector rotate(final double aArc) {
		// TODO optimize magnitude | direction | normalized Vector
		double cos = Math.cos(aArc);
		double sin = Math.sin(aArc);
		return new Vector(this.x * cos - this.x * sin, this.x * sin + this.x * cos);
	}

	/**
	 * Project.
	 *
	 * @param aVector the vector
	 * @return the vector
	 */
	public Vector project(final Vector aVector) {
		double dotProd = this.dot(aVector);
		double denominator = aVector.dot(aVector);
		if (denominator == 0)
			return Vector.ZERO;
		denominator = dotProd / denominator;
		return new Vector(denominator * aVector.x, denominator * aVector.y);
	}

	/**
	 * Gets the right hand orthogonal vector.
	 *
	 * @return the right hand orthogonal vector
	 */
	public Vector getRightHandOrthogonalVector() {
		// TODO optimize magnitude | direction | normalized Vector
		return new Vector(-this.y, this.x);
	}

	/**
	 * Gets the left hand orthogonal vector.
	 *
	 * @return the left hand orthogonal vector
	 */
	public Vector getLeftHandOrthogonalVector() {
		// TODO optimize magnitude | direction | normalized Vector
		return new Vector(this.y, -this.x);
	}

	/**
	 * Gets the normalized.
	 *
	 * @return the normalized
	 */
	public Vector getNormalized() {
		if (this.normalized == null) {
			double magnitude = this.getMagnitude();
			if (magnitude == 0)
				this.normalized = Vector.ZERO;
			else
				this.normalized = new Vector(this.x / magnitude, this.y / magnitude);
		}
		return this.normalized;
	}

	/**
	 * Gets the angle between.
	 *
	 * @param aVector the vector
	 * @return the angle between
	 */
	public double getAngleBetween(final Vector aVector) {
		double a = Math.atan2(aVector.y, aVector.x) - Math.atan2(this.y, this.x);
		if (a > MathContext.PI)
			return a - MathContext.PIx2;
		if (a < MathContext.NEGATIV_PI)
			return a + MathContext.PIx2;
		return a;
	}

	/**
	 * Creates the.
	 *
	 * @param aMagnitude the a magnitude
	 * @param aDirection the a direction
	 * @return the vector
	 */
	public static Vector createDirectionAndMagnitude(final double aMagnitude, final double aDirection) {
		double x = aMagnitude * Math.cos(aDirection);
		double y = aMagnitude * Math.sin(aDirection);
		return new Vector(x, y, aMagnitude, aDirection);
	}

	/**
	 * Instantiates a new vector.
	 *
	 * @param aDirection the a direction
	 * @return the vector
	 */
	public static Vector createDirection(final double aDirection) {
		return Vector.createDirectionAndMagnitude(1, aDirection);
	}

	/**
	 * Triple product.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @return the vector
	 */
	public static Vector tripleProduct(final Vector a, final Vector b, final Vector c) {
		double ac = a.x * c.x + a.y * c.y;
		double bc = b.x * c.x + b.y * c.y;
		return new Vector(b.x * ac - a.x * bc, b.y * ac - a.y * bc);
	}
}
