package de.titus.game.core.math.doublepoint.utils;

import de.titus.game.core.math.doublepoint.Edge;
import de.titus.game.core.math.doublepoint.Vector;

/**
 * The Class EdgeUtils.
 */
public final class EdgeUtils {

	/**
	 * Instantiates a new edge utils.
	 */
	private EdgeUtils() {
	}

	/**
	 * Builds the polygon edges.
	 *
	 * @param theVertices the the vertices
	 * @return the edge[]
	 */
	public static Edge[] buildPolygonEdges(final Vector... theVertices) {
		if (theVertices == null || theVertices.length < 2)
			return null;
		else if (theVertices.length == 2) {
			Edge[] edges = new Edge[1];
			edges[0] = new Edge(theVertices[0], theVertices[1]);
			return edges;
		} else {
			Edge[] edges = new Edge[theVertices.length];
			int edgeCounter = 0;
			Vector a = theVertices[0];
			for (int i = 1; i < theVertices.length; i++) {
				edges[edgeCounter] = new Edge(a, theVertices[i]);
				a = theVertices[i];
				edgeCounter++;
			}
			edges[edgeCounter] = new Edge(a, theVertices[0]);
			return edges;
		}
	}

}
