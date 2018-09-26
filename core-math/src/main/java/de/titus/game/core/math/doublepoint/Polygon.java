package de.titus.game.core.math.doublepoint;

import de.titus.game.core.math.doublepoint.utils.EdgeUtils;

/**
 * The Class Polygon.
 */
public class Polygon {

	/** The vertices. */
	public final Vector[]	vertices;

	/** The edges. */
	private Edge[]			edges;

	/**
	 * Instantiates a new collision box.
	 *
	 * @param theVertices the the vertices
	 */
	public Polygon(final Vector... theVertices) {
		this.vertices = theVertices;
		this.edges = EdgeUtils.buildPolygonEdges(theVertices);
	}

	/**
	 * Gets the edges.
	 *
	 * @return the edges
	 */
	public Edge[] getEdges() {
		if (this.edges == null)
			this.edges = EdgeUtils.buildPolygonEdges(this.vertices);
		return this.edges;
	}

	/**
	 * Transform.
	 *
	 * @param aTransformation the a transformation
	 * @return the polygon
	 */
	public Polygon transform(final Transformation aTransformation) {
		return new Polygon(aTransformation.doExecute(this.vertices));
	}

	/**
	 * Move.
	 *
	 * @param aVector the a vector
	 * @return the polygon
	 */
	public Polygon move(final Vector aVector) {
		Vector[] newVertices = new Vector[this.vertices.length];
		for (int i = 0; i < this.vertices.length; i++)
			newVertices[i] = this.vertices[i].sum(aVector);

		return new Polygon(newVertices);
	}
}
