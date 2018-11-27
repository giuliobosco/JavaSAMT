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
package concurrency.circles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Timer circle, create a circle that reduces his radius every second of one pixel.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Timer extends Thread {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Initial radius of the timer.
     */
    public static final int INITIAL_RADIIUS = 20;

    /**
     * Sleep time of the timer.
     */
    public static final int SLEEP_TIME = 1000;

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * List of listeners. They will receive the timeElapsed call.
     */
    private List<TimerListener> listeners;

    /**
     * Center of the timer circle.
     */
    private Point center;

    /**
     * Radius of the timer circle.
     */
    private int radius;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Get the radius of the circle.
     *
     * @return Radius of the circle.
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Get the diameter of the circle.
     *
     * @return Diameter of the circle.
     */
    public int getDiameter() {
        return this.radius * 2;
    }

    /**
     * Get the center of the circle.
     *
     * @return Center of the circle.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Get the start point to start paint the circle. Top left point.
     *
     * @return Start point to start paint the circle. Top left point.
     */
    public Point getStart() {
        Point moved = this.getCenter();
        moved.translate(-this.radius, -this.radius);
        return moved;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Create the timer circle with the the X and Y position of the timer circle center.
     *
     * @param x X position of the timer circle center.
     * @param y Y position of the timer circle center.
     */
    public Timer(int x, int y) {
        this(new Point(x, y));
    }

    /**
     * Create the timer circle with the point of the timer circle center.
     *
     * @param center Circle center point.
     */
    public Timer(Point center) {
        this.center = center;
        this.radius = INITIAL_RADIIUS;

        this.listeners = new ArrayList<>();
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Add a listener to the list of listeners.
     *
     * @param listener Listener to add to the list of listeners.
     */
    public void addTimerListener(TimerListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Remove the listener to the list of listeners.
     *
     * @param listener Listener from the list of listeners.
     */
    public void removeTimerListener(TimerListener listener) {
        this.listeners.remove(listener);
    }

    /**
     * Paint the Timer circle.
     *
     * @param g Graphics of the Frame.
     */
    public void paint(Graphics g) {
        for (int i = this.radius; i > 0; i--) {
            if (i % 2 == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.red);
            }

            g.fillOval(this.center.x - i, this.center.y - i, i * 2, i * 2);
        }
    }

    /**
     * Thread code to run.
     */
    public void run() {
        try {
            while (this.radius > 0) {
                for (TimerListener listener : this.listeners) {
                    listener.click();
                }
                this.radius--;
                Thread.sleep(SLEEP_TIME);
            }

            for (TimerListener listener : this.listeners) {
                listener.timeElapsed(this);
            }
        } catch (InterruptedException ie) {

        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components
    
}
