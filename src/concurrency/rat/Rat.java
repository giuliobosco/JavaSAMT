/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package concurrency.rat;

import java.awt.*;

/**
 * Class for represent a Rat.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Rat extends Thread {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Step of the rat and radius of the rat.
     */
    public final static int DIM = 10;

    /**
     * Step per minute of the rat.
     */
    public final static int STEP_PER_MINUTE = 100;

    /**
     * Rat direction north.
     */
    public final static int DIRECTION_NORTH = 0;

    /**
     * Rat direction east.
     */
    public final static int DIRECTION_EAST = 1;

    /**
     * Rat direction south.
     */
    public final static int DIRECTION_SOUTH = 2;

    /**
     * Rat direction west.
     */
    public final static int DIRECTION_WEST = 3;

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Container of the rat.
     */
    private RatContainer container;

    /**
     * Position of the rat.
     */
    private Point position;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Get the position of the rat.
     *
     * @return Position of the rat.
     */
    public Point getPosition() {
        return this.position;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor with the container of the rat.
     *
     * @param container Container of the rat.
     */
    public Rat(RatContainer container) {
        this.container = container;
        this.position = new Point(
                this.container.getWidth() - DIM,
                this.container.getHeight() - DIM
        );
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Calculate random integer number.
     *
     * @param min Minimum of the random number.
     * @param max Maximum of the random number.
     * @return Random integer number.
     */
    private int getRandom(int min, int max) {
        return (int) ((max - min) * Math.random()) + min;
    }

    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Paint the rat.
     *
     * @param g Graphics of the rat container.
     */
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(
                this.position.x - DIM,
                this.position.y - DIM,
                DIM * 2,
                DIM * 2
        );
    }

    /**
     * Life of the rat, manage movements of the rat.
     */
    @Override
    public void run() {
        try {
            while (true) {
                boolean flag = true;
                do {
                    int direction = this.getRandom(0, 4);

                    if (direction == 0) {
                        if (this.position.y - DIM > DIRECTION_NORTH) {
                            flag = false;
                            this.position.y -= DIM;
                        }
                    } else if (direction == DIRECTION_EAST) {
                        if (this.position.x + DIM < this.container.getWidth()) {
                            flag = false;
                            this.position.x += DIM;
                        }
                    } else if (direction == DIRECTION_SOUTH) {
                        if (this.position.y + DIM < this.container.getHeight()) {
                            flag = false;
                            this.position.y += DIM;
                        }
                    } else if (direction == DIRECTION_WEST) {
                        if (this.position.x - DIM > 0) {
                            flag = false;
                            this.position.x -= DIM;
                        }
                    }
                } while (flag);

                this.container.ratMoved(this);

                Thread.sleep(60 * 1000 / STEP_PER_MINUTE);
            }
        } catch (InterruptedException ie) {

        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components

}
