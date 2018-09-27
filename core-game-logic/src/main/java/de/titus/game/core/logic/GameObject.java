package de.titus.game.core.logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import de.titus.game.core.math.doublepoint.Polygon;
import de.titus.game.core.math.doublepoint.Vector;
import de.titus.game.core.world.database.v2.SpaceObject;

public class GameObject extends SpaceObject<Object> {
	/** The color of the object */
	private Color	color;
	private Shape	graphicShape;
	private double	scale;

	public GameObject(final Vector aDirection, final Polygon aLocalCollisionBox, final Object aData, final double aScale) {
		super(aDirection, aLocalCollisionBox, aData);
		this.scale = aScale;
		this.color = new Color((float) Math.random() * 0.5f + 0.5f, (float) Math.random() * 0.5f + 0.5f, (float) Math.random() * 0.5f + 0.5f);
	}

	/**
	 * Draws the body.
	 * <p>
	 * Only coded for polygons and circles.
	 *
	 * @param g the graphics object to render to
	 */
	public void render(final Graphics2D g) {
		// save the original transform
		AffineTransform ot = g.getTransform();
		Vector worldCenter = this.getWorldCenter();
		// transform the coordinate system from world coordinates to local coordinates
		AffineTransform lt = new AffineTransform();
		lt.translate(worldCenter.x, worldCenter.y);
		lt.rotate(this.direction.getAngle());
		lt.scale(this.scale, this.scale);

		// apply the transform
		g.transform(lt);
		if (this.graphicShape == null) {
			Path2D.Double p = new Path2D.Double();
			p.moveTo(this.shape.vertices[0].x, this.shape.vertices[0].y);
			for (int i = 1; i < this.shape.vertices.length; i++) {
				p.lineTo(this.shape.vertices[i].x, this.shape.vertices[i].y);
			}
			p.closePath();
			this.graphicShape = p;
		}
		g.setColor(this.color);
		g.fill(this.graphicShape);
		// draw the outline
		// g.setColor(GameObject.getOutlineColor(this.color));
		g.draw(this.graphicShape);

		g.setTransform(ot);
	}

	private static Color getOutlineColor(final Color color) {
		Color oc = color.darker();
		return new Color(oc.getRed(), oc.getGreen(), oc.getBlue(), color.getAlpha());
	}
}
