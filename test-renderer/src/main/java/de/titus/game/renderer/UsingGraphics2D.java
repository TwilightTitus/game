/*
 * Copyright (c) 2010-2016 William Bittle  http://www.dyn4j.org/
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice, this list of conditions
 *     and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *     and the following disclaimer in the documentation and/or other materials provided with the
 *     distribution.
 *   * Neither the name of dyn4j nor the names of its contributors may be used to endorse or
 *     promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.titus.game.core.sim.test.v2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.titus.game.core.game.logic.Game;
import de.titus.game.core.game.logic.processes.SimulateUpdateProcess;
import de.titus.game.core.sim.test.v2.threads.CommandProcess;
import de.titus.game.core.sim.test.v2.threads.RenderProcess;
import de.titus.game.core.world.database.v2.ChunkIndex;

/**
 * Class used to show a simple example of using the dyn4j project using Java2D
 * for rendering.
 * <p>
 * This class can be used as a starting point for projects.
 *
 * @author William Bittle
 * @version 3.2.0
 * @since 3.0.0
 */
public class UsingGraphics2D extends JFrame {
	/** The serial version id */
	private static final long	serialVersionUID	= 5663760293144882635L;

	/** The scale 45 pixels per meter */
	public static final double	SCALE				= 45.0;

	/** The canvas to draw to */
	private Canvas				canvas;

	/** Wether the example is stopped or not */
	private boolean				stopped;

	private RenderProcess		renderer;

	private SimulateUpdateProcess		physicSim;

	private CommandProcess		commandProcess;

	private JSpinner			x;

	private JSpinner			y;

	/**
	 * Default constructor for the window
	 */
	public UsingGraphics2D() {
		super("Graphics2D Example");

		// setup the JFrame
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// add a window listener
		this.addWindowListener(new WindowAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(final WindowEvent e) {
				// before we stop the JVM stop the example
				UsingGraphics2D.this.stop();
				super.windowClosing(e);
			}
		});

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		ChunkIndex centerIndex = Game.WORLD.centerIndex;
		int grindSize = Game.WORLD.grid.length - 1;

		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new JLabel("x: "));
		this.x = new JSpinner(new SpinnerNumberModel(0, centerIndex.x - grindSize, grindSize - centerIndex.x, 1));
		this.x.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent e) {
				UsingGraphics2D.this.changeChunkIndex();
			}
		});

		panel.add(this.x);
		panel.add(new JLabel("y: "));
		this.y = new JSpinner(new SpinnerNumberModel(0, centerIndex.y - grindSize, grindSize - centerIndex.y, 1));
		this.y.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent e) {
				UsingGraphics2D.this.changeChunkIndex();
			}
		});
		panel.add(this.y);

		this.getContentPane().add(panel);

		JPanel rendering = new JPanel(new FlowLayout());
		// create the size of the window
		Dimension size = new Dimension(800, 600);

		// create a canvas to paint to
		this.canvas = new Canvas();
		this.canvas.setPreferredSize(size);
		this.canvas.setMinimumSize(size);
		this.canvas.setMaximumSize(size);

		rendering.add(this.canvas);
		this.getContentPane().add(rendering);
		// add the canvas to the JFrame

		// make the JFrame not resizable
		// (this way I dont have to worry about resize events)
		this.setResizable(false);

		// size everything
		this.pack();

		this.canvas.setIgnoreRepaint(true);
		this.canvas.createBufferStrategy(2);

		// make sure we are not stopped
		this.stopped = false;
	}

	private void changeChunkIndex() {
		ChunkIndex centerIndex = Game.WORLD.centerIndex;
		int xValue = (int) this.x.getValue() + centerIndex.x;
		int yValue = (int) this.y.getValue() + centerIndex.y;
		this.renderer.changeChunk(new ChunkIndex(xValue, yValue));
	}

	/**
	 * Start active rendering the example.
	 * <p>
	 * This should be called after the JFrame has been shown.
	 */
	public void start() {

		if (this.renderer == null)
			this.renderer = new RenderProcess(this.canvas, UsingGraphics2D.SCALE);

		if (this.physicSim == null)
			this.physicSim = new SimulateUpdateProcess();

		if (this.commandProcess == null)
			this.commandProcess = new CommandProcess();

		this.commandProcess.start();
		this.renderer.start();
		// this.physicSim.start();
	}

	/**
	 * The method calling the necessary methods to update the game, graphics, and
	 * poll for input.
	 */

	/**
	 * Stops the example.
	 */
	public synchronized void stop() {
		this.stopped = true;
		this.commandProcess.stop();
		this.renderer.stop();
		this.physicSim.stop();
	}

	/**
	 * Returns true if the example is stopped.
	 *
	 * @return boolean true if stopped
	 */
	public synchronized boolean isStopped() {
		return this.stopped;
	}

	/**
	 * Entry point for the example application.
	 *
	 * @param args command line arguments
	 */
	public static void main(final String[] args) {
		// set the look and feel to the system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		// create the example JFrame
		UsingGraphics2D window = new UsingGraphics2D();

		// show it
		window.setVisible(true);

		// start it
		window.start();
	}
}
