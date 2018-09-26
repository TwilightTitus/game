/**
 *
 */
package de.titus.game.core.sim.test.v2.threads;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import de.titus.game.core.sim.test.v2.EntityManager;
import de.titus.game.core.sim.test.v2.GameObject;
import de.titus.game.core.world.database.v2.SpaceObject;

/**
 * The Class Renderer.
 *
 * @author xce3560
 */
public class RenderProcess extends AbstractProcess {

	/** The canvas. */
	private final Canvas	canvas;

	/** The scale. */
	private final double	scale;

	/**
	 * Instantiates a new renderer.
	 *
	 * @param aCanvas the a canvas
	 * @param aScale the a scale
	 */
	public RenderProcess(final Canvas aCanvas, final double aScale) {
		super(1000 / 60);
		this.canvas = aCanvas;
		this.scale = aScale;
	}

	/**
	 * Run process.
	 *
	 * @param aCurrentTime the a current time
	 * @param aLastRun the a last run
	 * @see de.titus.game.core.sim.test.threads.AbstractProcess#runProcess(long,
	 *      long)
	 */
	@Override
	protected void runProcess(final long aCurrentTime, final long aLastRun, final long aDeltaTime) {
		// get the graphics object to render to
		Graphics2D g = (Graphics2D) this.canvas.getBufferStrategy().getDrawGraphics();

		// before we render everything im going to flip the y axis and move the
		// origin to the center (instead of it being in the top left corner)
		AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
		AffineTransform move = AffineTransform.getTranslateInstance(400, -300);
		g.transform(yFlip);
		g.transform(move);

		// now (0, 0) is in the center of the screen with the positive x axis
		// pointing right and the positive y axis pointing up

		// render anything about the Example (will render the World objects)
		this.renderEntities(g);

		// dispose of the graphics object
		g.dispose();

		// blit/flip the buffer
		BufferStrategy strategy = this.canvas.getBufferStrategy();
		if (!strategy.contentsLost()) {
			strategy.show();
		}

		// Sync the display on some systems.
		// (on Linux, this fixes event queue problems)
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Renders the example.
	 *
	 * @param g the graphics object to render to
	 */
	protected void renderEntities(final Graphics2D g) {
		// lets draw over everything with a white background
		g.clearRect(-400, -300, 800, 600);
		g.setColor(Color.WHITE);
		g.fillRect(-400, -300, 800, 600);

		// lets move the view up some
		g.translate(0.0, -1.0 * this.scale);

		List<SpaceObject<Object>> objects = new ArrayList<>(EntityManager.WORLD.objects.values());
		// draw all the objects in the world
		if (objects != null)
			for (SpaceObject<Object> object : objects) {
				if (object instanceof GameObject) {
					try {
						((GameObject) object).render(g);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		System.out.println("renderer game object count: " + objects.size());
	}

}
